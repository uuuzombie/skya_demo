package com.sky.demo.common.reflect.bean;

/**
 * Created by rg on 2016/6/16.
 */
public enum UserType {

    COMMON(1, "COMMON_USER"),
    VIP(2, "VIP_USER"),

    ;

    private int code;
    private String desc;

    UserType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static UserType getByCode(int code) {
        for (UserType userType : UserType.values()) {
            if (userType.getCode() == code) {
                return userType;
            }
        }
        return null;
    }

    public String getDisplayName() {
        return "";
    }
}
