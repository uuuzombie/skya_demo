package com.sky.demo.common.compare.util;

import com.sky.demo.common.compare.bean.User;

import java.util.Comparator;

/**
 * Created by rg on 15/6/27.
 */
public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge();
    }
}
