package com.mingshashan.learn.es.exception;

/**
 * CommonRuntimeException.
 * <br>
 * 通用异常类
 *
 * @author jasonxu
 */
public class CommonRuntimeException extends RuntimeException implements ErrorCodeMessageMapper {

    public static final String UNDEFINED_ERROR_CODE = ErrorCodeMessageMapper.UNDEFINED_ERROR_CODE;

    /**
     * code
     */
    private String errorCode;

    /**
     * message
     */
    private String errorMessage;

    /**
     * messgeArgs
     */
    private Object[] messgeArgs;

    /**
     * 可以指定http的异常状态码，不设置默认值，并不是所有异常都与http响应有关，需要时指定即可。
     */
    private HttpErrorStatus httpErrorCode;

    public CommonRuntimeException() {
        this((String) null);
    }

    public CommonRuntimeException(String message, Throwable cause) {
        this(UNDEFINED_ERROR_CODE, message, cause);
    }

    public CommonRuntimeException(Throwable cause) {
        this((String) null, cause);
    }

    public CommonRuntimeException(String errorMsg) {
        this(UNDEFINED_ERROR_CODE, errorMsg, (HttpErrorStatus) null);
    }

    public CommonRuntimeException(String errorCode, String errorMsg) {
        this(errorCode, errorMsg, (HttpErrorStatus) null);
    }

    public CommonRuntimeException(String errorCode, String errorMsg, Throwable cause) {
        this(errorCode, errorMsg, (HttpErrorStatus) null, cause);
    }

    public CommonRuntimeException(String errorCode, String errorMsg, HttpErrorStatus httpErrorCode) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMessage = errorMsg;
        this.httpErrorCode = httpErrorCode;
    }

    public CommonRuntimeException(String errorCode, String errorMsg, HttpErrorStatus httpErrorCode, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMsg;
        this.httpErrorCode = httpErrorCode;
    }

    /**
     * (non-Javadoc)
     *
     * @see com.mingshashan.learn.es.exception.ErrorCodeMessageMapper#getMessage()
     */
    @Override
    public String getMessage() {
        return this.errorMessage;
    }


    public String getMessageDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorCode: " + errorCode);
        sb.append(", ErrorMessage: " + errorMessage);
        if (this.httpErrorCode != null) {
            sb.append(", HttpStatus: " + this.httpErrorCode.codeValue());
            sb.append(", HttpMessage: " + this.httpErrorCode.defaultMessage());
        }
        return sb.toString();
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode The errorCode to set.
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * (non-Javadoc)
     *
     * @see com.mingshashan.learn.es.exception.ErrorCodeMessageMapper#getErrorMessage()
     */
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage The errorMessage to set.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * (non-Javadoc)
     *
     * @see com.mingshashan.learn.es.exception.ErrorCodeMessageMapper#getHttpErrorStatus()
     */
    @Override
    public HttpErrorStatus getHttpErrorStatus() {
        return httpErrorCode;
    }

    /**
     * @param httpErrorCode The httpErrorCode to set.
     */
    public void setHttpErrorStatus(HttpErrorStatus httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    @Override
    public Object[] getMessgeArgs() {
        return messgeArgs;
    }

    /**
     * @param messgeArgs The messgeArgs to set.
     */
    public void setMessgeArgs(Object[] messgeArgs) {
        this.messgeArgs = messgeArgs;
    }
}
