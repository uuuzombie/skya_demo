package com.sky.demo.common.introspector.util;


import com.sky.demo.common.compare.bean.User;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanInfoUtil {

    public static void setProperty(User user,String filedName,Object obj) throws Exception {

        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(filedName,User.class);

        Method method = propertyDescriptor.getWriteMethod();
        method.invoke(user,obj);
    }

    public static Object getProperty(User user,String filedName) throws Exception{

        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(filedName,User.class);

        Method method = propertyDescriptor.getReadMethod();

        Object obj = method.invoke(user);

        return obj;
    }

    public static void setPropertyByIntrospector(User user,String filedName,Object obj) throws Exception {

        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        if (propertyDescriptors != null && propertyDescriptors.length > 0){
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (propertyDescriptor.getName().equals(filedName)){
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(user,obj);
                    break;
                }
            }
        }
    }

    public static Object getPropertyByIntrospector(User user,String filedName) throws Exception{
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        if (propertyDescriptors != null && propertyDescriptors.length > 0){
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (propertyDescriptor.getName().equals(filedName)){
                    Method method = propertyDescriptor.getReadMethod();
                    Object obj = method.invoke(user);
                    return obj;
                }
            }
        }
        return null;
    }
}
