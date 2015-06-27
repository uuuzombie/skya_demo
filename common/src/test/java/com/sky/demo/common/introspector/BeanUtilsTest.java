package com.sky.demo.common.introspector;


import com.sky.demo.common.compare.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

    private User user;

    @Before
    public void setUp(){
        user = new User();
        user.setId(1);
    }

    @Test
    public void test_BeanUtils_setProperty() throws InvocationTargetException, IllegalAccessException {

        System.out.println(user);

        String name = "wang";
        BeanUtils.setProperty(user, "name", name);
        System.out.println(user);

        Integer age = 11;
        BeanUtils.setProperty(user,"age",age);
        System.out.println(user);

        Integer id = 2;
        BeanUtils.setProperty(user,"id",id);
        System.out.println(user);
    }

    @Test
    public void test_BeanUtils_getProperty() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println(user);

        String str = BeanUtils.getProperty(user,"id");
        System.out.println(str);

        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            String name = BeanUtils.getProperty(user,field.getName());
            System.out.println(name);
        }


    }

}
