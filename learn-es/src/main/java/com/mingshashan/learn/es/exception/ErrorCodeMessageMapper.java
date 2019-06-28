package com.mingshashan.learn.es.exception;

/**
 * ErrorCodeMessageMapper
 *
 * @author jasonxu
 */
public interface ErrorCodeMessageMapper {


    public static final String UNDEFINED_ERROR_CODE = "code.undefined";

    String getMessage();


    /**
     * @return Returns the errorCode.
     */
    String getErrorCode();

    /**
     * @return Returns the errorMessage.
     */
    String getErrorMessage();

    /**
     * @return Returns the httpErrorCode.
     */
    HttpErrorStatus getHttpErrorStatus();

    /**
     * @return Returns the messgeArgs.
     */
    Object[] getMessgeArgs();


    default String getRequestLocalizedMessage() {
        String localMsg = LocalizedErrorMessageRetriever.getInstance().gettLocalizedErrorMessageByCurrentRequest(getErrorCode(), getErrorMessage(), getMessgeArgs());
        return localMsg != null ? localMsg : this.getErrorMessage();
    }

}