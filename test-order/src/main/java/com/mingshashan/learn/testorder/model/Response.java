package com.mingshashan.learn.testorder.model;

import java.util.Date;

/**
 * Response
 *
 * @author xufj
 */
public class Response<T> {

    private boolean success = true;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date = new Date();
    private String code = "000000";
    private String message = "成功";
    private T data;

    public Response() {

    }

    public Response(T data) {
        this.data = data;
    }

    public static Response of(Object data) {
        return new Response(data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
