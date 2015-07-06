package com.sky.demo.unit.web_mock;


import com.google.common.base.Objects;

public class User {

    String name;

    Integer i;

    public User() {
    }

    public User(String name, Integer i) {
        this.name = name;
        this.i = i;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("i", i)
                .toString();
    }
}
