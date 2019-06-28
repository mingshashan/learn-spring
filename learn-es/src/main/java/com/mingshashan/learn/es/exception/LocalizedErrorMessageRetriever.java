package com.mingshashan.learn.es.exception;

import com.mingshashan.learn.es.context.SpringApplicationContextHolder;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * LocalizedErrorMessageRetriever.
 *
 * @author jasonxu
 */
public class LocalizedErrorMessageRetriever {
    private static LocalizedErrorMessageRetriever INSTANCE = new LocalizedErrorMessageRetriever();

    private LocalizedErrorMessageRetriever() {
    }

    public static LocalizedErrorMessageRetriever getInstance() {
        return INSTANCE;
    }


    public String gettLocalizedErrorMessageByCurrentRequest(String code, String defaultMsg, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return getLocalizedErrorMessage(code, locale, defaultMsg, args);

    }

    public String getLocalizedErrorMessage(String code, Locale locale, String defaultMsg, Object... args) {
        try {
            String pattern = SpringApplicationContextHolder.getApplicationContext().getMessage(code, args, defaultMsg, locale);
            if (pattern == null || pattern.trim().length() == 0) {
                pattern = defaultMsg;
            }
            return MessageFormat.format(pattern, args);
        } catch (Throwable e) {
            e.printStackTrace();//打印异常，这类异常需要在开发期处理掉
            if (e instanceof NoSuchMessageException) {
                return MessageFormat.format(defaultMsg, args);
            }
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return " Find message with code '" + defaultMsg + "' error : " + sw.toString();
        }
    }

}
