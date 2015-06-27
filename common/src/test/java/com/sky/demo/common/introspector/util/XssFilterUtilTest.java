package com.sky.demo.common.introspector.util;


import com.sky.demo.common.compare.bean.User;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class XssFilterUtilTest {

    private User user;

    @Before
    public void setUp(){
        user = new User();
        user.setId(1);
        user.setName("<script>alert('xss')</script>");
        user.setAge(11);

    }

    @Test
    public void test_xssFilter() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        System.out.println(user);

        XssFilterUtil.xssFilter(user);
        System.out.println(user);

    }

}
