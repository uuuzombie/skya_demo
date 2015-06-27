package com.sky.demo.common.annotation.tts.type;

/**
 * Created by rg on 2014/8/2.
 */
public enum PassengerType {

    ALL(0,"ALL"),
    ADULT(1,"ADULT"),
    STUDENT(2,"STUDENT");

    private int val;
    private String name;

    PassengerType(int val, String name) {
        this.val = val;
        this.name = name;
    }
}
