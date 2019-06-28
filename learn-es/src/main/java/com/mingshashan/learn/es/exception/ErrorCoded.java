package com.mingshashan.learn.es.exception;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * 异常码接口，供异常枚举继承实现
 *
 * @author jasonxu
 */
public interface ErrorCoded {

    String codeValue();

    String defaultMessage();

    default CommonRuntimeException exception(Object... args) {
        CommonRuntimeException commonRuntimeException = new CommonRuntimeException(this.codeValue(), message(args));
        commonRuntimeException.setMessgeArgs(args);
        return commonRuntimeException;
    }

    default CommonRuntimeException exception(HttpErrorStatus httpErrorStatus, Object... args) {
        CommonRuntimeException commonRuntimeException = new CommonRuntimeException(this.codeValue(), message(args), httpErrorStatus);
        commonRuntimeException.setMessgeArgs(args);
        return commonRuntimeException;
    }

    default CommonRuntimeException exception(Throwable cause, Object... args) {
        CommonRuntimeException commonRuntimeException = new CommonRuntimeException(this.codeValue(), message(args), cause);
        commonRuntimeException.setMessgeArgs(args);
        return commonRuntimeException;
    }

    default CommonRuntimeException exception(Throwable cause, HttpErrorStatus httpErrorStatus, Object... args) {
        CommonRuntimeException commonRuntimeException = new CommonRuntimeException(this.codeValue(), message(args), httpErrorStatus, cause);
        commonRuntimeException.setMessgeArgs(args);
        return commonRuntimeException;
    }

    default <T extends CommonRuntimeException> T exception(Class<T> clazz, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, String.class);
            T newInstance = constructor.newInstance(this.codeValue(), message(args));
            newInstance.setMessgeArgs(args);
            return newInstance;
        } catch (Exception e) {
            throw new CommonRuntimeException(e);
        }
    }

    default <T extends CommonRuntimeException> T exception(Class<T> clazz, HttpErrorStatus httpErrorStatus, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, String.class, HttpErrorStatus.class);
            T newInstance = constructor.newInstance(this.codeValue(), message(args), httpErrorStatus);
            newInstance.setMessgeArgs(args);
            return newInstance;
        } catch (Exception e) {
            throw new CommonRuntimeException(e);
        }
    }

    default <T extends CommonRuntimeException> T exception(Class<T> clazz, Throwable cause, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, String.class, Throwable.class);
            T newInstance = constructor.newInstance(this.codeValue(), message(args));
            newInstance.setMessgeArgs(args);
            return newInstance;
        } catch (Exception e) {
            throw new CommonRuntimeException(e);
        }
    }

    default <T extends CommonRuntimeException> T exception(Class<T> clazz, HttpErrorStatus httpErrorStatus, Throwable cause, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, String.class, HttpErrorStatus.class, Throwable.class);
            T newInstance = constructor.newInstance(this.codeValue(), message(args), httpErrorStatus, cause);
            newInstance.setMessgeArgs(args);
            return newInstance;
        } catch (Exception e) {
            throw new CommonRuntimeException(e);
        }
    }

    default String message(Object... args) {
//		Locale locale = Locale.getDefault(); //读取JVM 默认设置的locale信息，后端异常Message方言。UI端需要国际化可以用ErrorCode自行加载资源文件
//		return LocalizedErrorMessageRetriever.getInstance().getLocalizedErrorMessage(this.codeValue(), locale, this.defaultMessage(), args);
        return MessageFormat.format(this.defaultMessage(), args);
    }

    default String message(Locale locale, Object... args) {
        locale = locale == null ? Locale.getDefault() : locale;
        return LocalizedErrorMessageRetriever.getInstance().getLocalizedErrorMessage(this.codeValue(), locale, this.defaultMessage(), args);
    }
}
