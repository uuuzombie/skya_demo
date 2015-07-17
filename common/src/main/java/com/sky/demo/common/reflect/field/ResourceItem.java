package com.sky.demo.common.reflect.field;

import com.google.common.base.Objects;

import java.sql.Time;
import java.util.Date;

/**
 * Created by rg on 2015/7/16.
 */
public class ResourceItem {

    private int id;

    @RelationColumn("名称")
    private String name;

    @RelationColumn("大小")
    private int size;

    @RelationColumn("是否过期")
    private boolean expired;

    private Date createTime;

    @RelationColumn("执行时间")
    private Time exeTime;

    public ResourceItem() {
    }

    public ResourceItem(int id, String name, int size, boolean expired, Date createTime, Time exeTime) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.expired = expired;
        this.createTime = createTime;
        this.exeTime = exeTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Time getExeTime() {
        return exeTime;
    }

    public void setExeTime(Time exeTime) {
        this.exeTime = exeTime;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("size", size)
                .add("expired", expired)
                .add("createTime", createTime)
                .add("exeTime", exeTime)
                .toString();
    }
}
