package com.sky.demo.common.reflect.field;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by rg on 2015/7/16.
 */
public class FieldChangeInfo implements Serializable {

    private static final long serialVersionUID = -421899640427171026L;

    private String propertyName;
    private String propertyHeader;
    private Object from;
    private Object to;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyHeader() {
        return propertyHeader;
    }

    public void setPropertyHeader(String propertyHeader) {
        this.propertyHeader = propertyHeader;
    }

    public Object getFrom() {
        return from;
    }

    public void setFrom(Object from) {
        this.from = from;
    }

    public Object getTo() {
        return to;
    }

    public void setTo(Object to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("propertyName", propertyName)
                .add("propertyHeader", propertyHeader)
                .add("from", from)
                .add("to", to)
                .toString();
    }
}
