package com.example.demo.serializable;

import java.io.Serializable;

public class Employee implements Serializable {
    public String name;
    public String identify;

    public void mailCheck() {
        System.out.println("This is the " + this.identify + " of our company");
    }
}