package com.sky.demo.collections.model;

import com.google.common.base.Objects;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rg on 2014/7/15.
 */
public class User {

    Integer id;
    String name;

    Map<String,String> relation;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        relation = Collections.synchronizedMap(new HashMap<String, String>());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getRelation() {
        return relation;
    }

    public void setRelation(Map<String, String> relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("relation", relation)
                .toString();
    }
}
