package com.mingshashan.learn.hello.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Book
 *
 * @author xufj
 */
public class Book {

    @JsonProperty("ZHENG_HE_ZHI_ID")
    private String id;
    @JsonProperty("ZHENG_HE_ZHI_NAME")
    private String name;
    @JsonProperty("ZHENG_HE_ZHI_AUTHOR")
    private String author;

    public Book(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
