package com.sky.demo.common.serialize.bean;


import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class User implements Serializable {

    //如果不设置UID，则更改field后，反序列化以前的流文件会出问题
    private static final long serialVersionUID = -3121834090093014772L;

    private String name;
    private int age;
    private long phone;

    //private List<User> friends;

    //private String address;

    //private Address address;

    private Map<String,Address> uToA;


    public User() {
    }

    public User(String name, int age, long phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public User(String name, int age, long phone, List<User> friends) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        //this.friends = friends;
    }

    public User(String name, int age, long phone, String address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        //this.address = address;
    }

    public User(String name, int age, long phone, Address address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        //this.address = address;
    }

    public User(String name, int age, long phone, Map<String, Address> uToA) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.uToA = uToA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

//    public List<User> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(List<User> friends) {
//        this.friends = friends;
//    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }


//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public Map<String, Address> getuToA() {
        return uToA;
    }

    public void setuToA(Map<String, Address> uToA) {
        this.uToA = uToA;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("age", age)
                .add("phone", phone)
                .add("uToA", uToA)
                .toString();
    }
}
