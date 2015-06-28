package com.sky.demo.common.serialize.bean;


import org.apache.commons.lang.builder.ToStringBuilder;

public class DetailAddress extends Address { //implements Serializable

    //父类实现了Serializable，子类不需要实现Serializable
    //private static final long serialVersionUID = -3976530530838826057L;
    private String code;

    public DetailAddress(String country, String city, String code) {
        super(country, city);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .toString();
    }
}
