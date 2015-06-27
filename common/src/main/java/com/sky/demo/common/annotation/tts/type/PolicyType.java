package com.sky.demo.common.annotation.tts.type;

/**
 * Created by rg on 2014/8/2.
 */
public enum PolicyType {

    ALL(0,"ALL"),
    SELF(1,"SELF"),
    E_POLICY(2,"E"),
    OTA_ONE_WAY_POLICY(3,"OTA_ONE_WAY_POLICY"),
    OTA_ONE_WAY_TRANS_POLICY(4,"OTA_ONE_WAY_TRANS_POLICY"),
    OTA_MULTI_TRANS_POLICY(5,"OTA_ONE_WAY_TRANS_POLICY"),

    TUAN_ONE_WAY_POLICY(6,"TUAN_ONE_WAY_POLICY"),
    TUAN_ONE_WAY_TRANS_POLICY(7,"TUAN_ONE_WAY_TRANS_POLICY"),

    SSS(8,"SSS"),
    GTT(9,"GTT"),

    ;

    private int val;
    private String name;

    PolicyType(int val, String name) {
        this.val = val;
        this.name = name;
    }
}
