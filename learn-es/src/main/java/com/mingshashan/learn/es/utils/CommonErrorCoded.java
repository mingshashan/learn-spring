package com.mingshashan.learn.es.utils;

import com.mingshashan.learn.es.exception.ErrorCoded;

/**
 * CommonErrorCoded
 *
 * @author jasonxu
 */
public enum CommonErrorCoded implements ErrorCoded {
    BOOK_PARAMETER_EMPTY("005001", "Book parameter is empty."),
    BOOK_ID_ERROR("005002", "Book parameter id is error, id = {0}"),
    BOOK_NOT_EXIST("005003", "Book does not exist, id = {0}");

    private String codeValue;

    private String defaultMessage;

    private CommonErrorCoded(String codeValue, String defaultMessage) {
        this.codeValue = codeValue;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String codeValue() {
        return codeValue;
    }

    @Override
    public String defaultMessage() {
        return defaultMessage;
    }
}
