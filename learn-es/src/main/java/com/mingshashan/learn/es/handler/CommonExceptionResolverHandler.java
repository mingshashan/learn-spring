package com.mingshashan.learn.es.handler;


import com.mingshashan.learn.es.exception.ErrorCodeMessageMapper;
import com.mingshashan.learn.es.exception.HttpErrorStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 提供的统一异常处理类
 *
 * @author jasonxu
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonExceptionResolverHandler extends DefaultErrorAttributes {

    private static Logger logger = LoggerFactory.getLogger(CommonExceptionResolverHandler.class);

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.boot.web.servlet.error.DefaultErrorAttributes#getErrorAttributes(org.springframework.web.context.request.WebRequest, boolean)
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        Throwable t = super.getError(webRequest);
        String errorCode = ErrorCodeMessageMapper.UNDEFINED_ERROR_CODE;
        if (t instanceof ErrorCodeMessageMapper) {
            ErrorCodeMessageMapper ex = (ErrorCodeMessageMapper) t;
            errorCode = ex.getErrorCode();
            HttpErrorStatus code = ex.getHttpErrorStatus();
            if (code != null) {
                //指定异常返回的 http status ，覆盖spring缺省异常梳理的属性设置
                errorAttributes.put("status", code.value());
                errorAttributes.put("error", code.getReasonPhrase());
                webRequest.setAttribute("javax.servlet.error.status_code", code.value(), RequestAttributes.SCOPE_REQUEST);
            }
            // 根据request locale返回适合的消息
            errorAttributes.put("message", ex.getRequestLocalizedMessage());

        }
        //在spring 默认异常返回body里面添加自定义错误码
        errorAttributes.put("code", errorCode);

        if (t != null) {
            logException(t);
        } else {
            logger.error("Received error status : {} ", errorAttributes);
        }
        return errorAttributes;
    }


    private void logException(Throwable t) {
        t.printStackTrace();
        logger.error("Received error , stack : \n", t);
    }

}
