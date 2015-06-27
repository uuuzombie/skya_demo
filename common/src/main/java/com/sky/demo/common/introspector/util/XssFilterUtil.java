package com.sky.demo.common.introspector.util;


import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.util.HtmlUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class XssFilterUtil {

    /**
     * XSS过滤
     * 通过反射获取Field
     * 通过BeanUtils类获取并过滤字符
     * @param bean
     * @param <T>
     * @throws java.lang.reflect.InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public static <T> void xssFilter(T bean) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Field[] fields = bean.getClass().getDeclaredFields();  //获取public、protected、private

        for (Field filed : fields) {
            if (filed.getType().equals(String.class)){

                String str = BeanUtils.getProperty(bean, filed.getName());
                BeanUtils.setProperty(bean, filed.getName(), HtmlUtils.htmlEscape(str));
            }
        }
    }
}
