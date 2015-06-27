package com.sky.demo.common.introspector.util;


import com.sky.demo.common.compare.bean.User;
import org.junit.Before;
import org.junit.Test;

public class BeanInfoUtilTest {

    private User user;

    @Before
    public void setUp(){
        user = new User();
        user.setId(1);
    }

    @Test
    public void test_setProperty() throws Exception {

        System.out.println(user);

        String userName = "wang";
        BeanInfoUtil.setProperty(user, "name", userName);
        System.out.println(user);

        Integer age = 11;
        BeanInfoUtil.setProperty(user,"age",age);
        System.out.println(user);
    }

    @Test
    public void test_getProperty() throws Exception {

        Object obj = BeanInfoUtil.getProperty(user,"id");

        System.out.println(obj.toString());

    }

    @Test
    public void test_setPropertyByIntrospector() throws Exception {

        System.out.println(user);

        String userName = "zhang";
        BeanInfoUtil.setPropertyByIntrospector(user,"name",userName);
        System.out.println(user);

        Integer age = 12;
        BeanInfoUtil.setPropertyByIntrospector(user,"age",age);
        System.out.println(user);
    }

    @Test
    public void test_getPropertyByIntrospector() throws Exception {
        Object obj = BeanInfoUtil.getPropertyByIntrospector(user,"id");

        System.out.println(obj.toString());
    }

}
