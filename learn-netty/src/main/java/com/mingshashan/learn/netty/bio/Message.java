package com.mingshashan.learn.netty.bio;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = -971508193393193257L;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
