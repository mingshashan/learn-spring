package com.mingshashan.learn.kafka.model;

import javax.validation.constraints.NotNull;

/**
 * Book
 *
 * @author jasonxu
 */
public class Book {
    @NotNull
    private Long id;
    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
