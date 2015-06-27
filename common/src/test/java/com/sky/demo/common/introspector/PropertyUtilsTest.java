package com.sky.demo.common.introspector;


import com.sky.demo.common.compare.bean.User;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PropertyUtilsTest {

    private User user;

    @Before
    public void setUp(){
        user = new User();
        user.setId(1);
    }

    @Test
    public void test_PropertyUtils_setProperty() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        System.out.println(user);

        String name = "wang";
        PropertyUtils.setProperty(user,"name",name);
        System.out.println(user);

        Integer age = 12;
        PropertyUtils.setProperty(user, "age", age);
        System.out.println(user);

//        Integer id = 2;
//        PropertyUtils.setProperty(user,"id",id);
//        System.out.println(user);
    }

    @Test
    public void test_PropertyUtils_getProperty() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Object obj = PropertyUtils.getProperty(user,"id");
        System.out.println(obj.toString());

        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            Object name = PropertyUtils.getProperty(user,field.getName());
            if (name != null) {
                System.out.println(name.toString());
            }

        }
    }
}
