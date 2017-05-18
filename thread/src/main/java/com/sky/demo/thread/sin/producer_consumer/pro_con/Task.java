package com.sky.demo.thread.sin.producer_consumer.pro_con;

import com.google.common.base.Objects;

import java.util.UUID;

/**
 * Created by user on 17/5/18.
 */
public class Task {

    private String id;

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .toString();
    }
}
