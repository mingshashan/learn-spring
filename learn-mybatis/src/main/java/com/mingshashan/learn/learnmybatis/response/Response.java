package com.mingshashan.learn.learnmybatis.response;

public class Response<T> {

    private final static String CODE_SUCCESS = "200";
    private final static String MESSAGE_SUCCESS = "OK";

    private T data;
    private String message;
    private String code;

    public static Response ok() {
        return new Response();
    }

    public Response() {
        this(null, MESSAGE_SUCCESS, CODE_SUCCESS);
    }


    public static <T> Response ok(T data) {
        return new Response(data);
    }

    public Response(T data) {
        this(data, MESSAGE_SUCCESS, CODE_SUCCESS);
    }

    public Response(T data, String message) {
        this(data, message, CODE_SUCCESS);
    }

    public Response(T data, String message, String code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }
}
