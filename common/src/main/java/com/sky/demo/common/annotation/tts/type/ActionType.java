package com.sky.demo.common.annotation.tts.type;

/**
 * Created by rg on 2014/8/2.
 */
public enum ActionType {

    ALL(0,"ALL"),
    WWW(1,"WWW"),
    WIFI(2,"WIFI"),
    OPEN(3,"OPEN");

    private int val;
    private String name;

    ActionType(int val, String name) {
        this.val = val;
        this.name = name;
    }
}
