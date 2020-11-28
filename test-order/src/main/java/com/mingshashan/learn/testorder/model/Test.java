package com.mingshashan.learn.testorder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Test
 *
 * @author xufj
 */
public class Test {

    @JsonProperty(value = "class")
    private String zClass;

    public String getzClass() {
        return zClass;
    }

    public void setzClass(String zClass) {
        this.zClass = zClass;
    }

}
