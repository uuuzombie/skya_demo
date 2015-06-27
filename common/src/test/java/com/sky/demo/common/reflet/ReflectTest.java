package com.sky.demo.common.reflet;

import com.sky.demo.common.reflect.bean.User;
import com.sky.demo.common.reflect.bean.VipUser;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by rg on 15/6/27.
 */
public class ReflectTest {

    private User user;

    private static final String USER_PWD = "com.sky.demo.common.reflect.bean.User";
    private static final String VIP_USER_PWD = "com.sky.demo.common.reflect.bean.VipUser";

    @Before
    public void setUp(){
        user = new User();
        user.setId(1L);
    }

    @Test
    public void test_getClass(){
        Class<?> c1 = null;
        Class<?> c2 = null;
        Class<?> c3 = null;

        //三种方式，输出 包名+类名
        try {
            c1 = Class.forName(USER_PWD);

            System.out.println(c1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        c2 = new User().getClass();
        System.out.println(c2);

        c3 = User.class;
        System.out.println(c3);
    }

    @Test
    public void test_getInterface(){
        Class<?> c = null;

        try {
            c = Class.forName(USER_PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?>[] classes = c.getInterfaces();

        for (Class<?> aClass : classes) {
            System.out.println(aClass.getName());
        }

    }

    @Test
    public void test_getSuperclass(){

        Class<?> c = null;

        try {
            c = Class.forName(VIP_USER_PWD);
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> c2 = c.getSuperclass();
        System.out.println(c2);
    }

    @Test
    public void test_getConstructors(){
        Class<?> c = null;

        try {
            c = Class.forName(USER_PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor<?>[] constructors = c.getConstructors();

        User u = null;
        try {
            u = (User) constructors[1].newInstance(2L,"wang",33,"China");   //注意构造函数的顺序
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(u);
    }

    @Test
    public void test_getConstructor() throws NoSuchMethodException {
        Class<?> c = null;

        try {
            c = Class.forName(USER_PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor constructor = c.getConstructor(Long.class,String.class,Integer.class,String.class);

        User u = null;
        try {
            u = (User) constructor.newInstance(2L, "wang", 33, "China");   //注意构造函数的顺序
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(u);
    }

    @Test
    public void test_getFields(){

        //getFields()获得某个类的所有的公共（public）的字段，包括父类。
        Field[] fields = User.class.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

    }

    @Test
    public void test_getDeclaredFields(){

        //getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和protected，但是不包括父类的申明字段。
        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
    }

    @Test
    public void test_getMethods(){

        Method[] methods = User.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }

    @Test
    public void test_getDeclaredMethods(){

        Method[] declaredMethods = User.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
    }

    @Test
    public void test_VipUser_is_User_By_instanceof(){
        Object obj = new VipUser();

        if (obj instanceof User) {
            System.out.println("instanceof判断，是一个user");
        } else {
            System.out.println("instanceof判断，不是一个user");
        }
    }

    @Test
    public void test_VipUser_is_User_By_getClass(){
        Object obj = new VipUser();

        if (obj.getClass() == User.class) {         //getClass()用于判断对象的准确类型
            System.out.println("getClass判断，是一个user");
        } else {
            System.out.println("getClass判断，不是一个user");
        }
    }
}
