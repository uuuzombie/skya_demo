package com.sky.demo.common.enums;

/**
 * Created by rg on 15/6/27.
 */
public enum Color {

    RED(1,"红色"),
    GREEN(2,"绿色"),
    BLUE(3,"蓝色"),
    YELLOW(4,"黄色");

    private int code;
    private String name;

    Color(int code,String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Color getColorByCode(int code) {
        for (Color color : Color.values()) {
            if(color.getCode() == code) {
                return color;
            }
        }
        return null;
    }

    public static Color getColorByName(String name ) {
        for (Color color : Color.values()) {
            if (color.getName().equals(name)) {
                return color;
            }
        }
        return null;
    }

}
