package com.sky.demo.common.reflect.field;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by rg on 2015/7/16.
 */
public class ResourceUtil {

    private static final Logger logger = LoggerFactory.getLogger(ResourceUtil.class);

    public static <T> List<FieldChangeInfo> getResourceChangeInfo(T originItem, T updatedItem, Class<T> clazz) {
        List<FieldChangeInfo> changeInfos = Lists.newArrayList();

        getChangeInfo(originItem, updatedItem, clazz, changeInfos);

        return changeInfos;
    }

    public static <T> void getChangeInfo(Object originalItem, Object updatedItem, Class<T> clazz, List<FieldChangeInfo> changeInfos) {

        try {
            //处理 super class
            Class superClazz = clazz.getSuperclass();
            if (superClazz != Object.class) {
                getChangeInfo(originalItem, updatedItem, superClazz, changeInfos);
            }

            for (Field field : clazz.getDeclaredFields()) {
                //处理RelationColumn注解
                processRelationColumn(originalItem, updatedItem, changeInfos, field);

                //处理Relation注解
                processRelation(originalItem, updatedItem, changeInfos, field);
            }
        } catch (IllegalAccessException e) {
            logger.error("process error", e);
        }
    }

    /**
     * 处理RelationColumn注解
     * @param originalItem
     * @param updatedItem
     * @param changeInfos
     * @param field
     * @param <T>
     * @throws IllegalAccessException
     */
    private static <T> void processRelationColumn(Object originalItem, Object updatedItem, List<FieldChangeInfo> changeInfos, Field field) throws IllegalAccessException {
        RelationColumn relationColumn = field.getAnnotation(RelationColumn.class);
        if (relationColumn != null) {
            field.setAccessible(true);

            Object originalValue = originalItem == null ? null : field.get(originalItem);
            Object updatedValue = originalItem == null ? null : field.get(updatedItem);

            Object obj = originalValue != null ? originalValue : updatedValue;
            if (obj != null) {
                Class<?> enumClass = relationColumn.enumClass();

                if (obj instanceof List) {
                    originalValue = getObjectValueOfList(originalValue, enumClass);
                    updatedValue = getObjectValueOfList(updatedValue, enumClass);
                } else if (obj instanceof Array) {
                    originalValue = getObjectValueOfArray(originalValue, enumClass);
                    updatedValue = getObjectValueOfArray(updatedValue, enumClass);
                } else if (obj instanceof Enum) {
                    Class<?> clazz = obj.getClass();
                    originalValue = getObjectValueOfEnum(originalValue, clazz);
                    updatedValue = getObjectValueOfEnum(updatedValue, clazz);
                } else {
                    originalValue = getObjectValue(originalValue, enumClass);
                    updatedValue = getObjectValue(updatedValue, enumClass);
                }
            }

            if ((originalValue == null && updatedValue != null) || (originalValue != null && !originalValue.equals(updatedValue))) {

                FieldChangeInfo info = new FieldChangeInfo();
                info.setPropertyName(field.getName());
                info.setPropertyHeader(relationColumn.value());
                //当@RelationColumn中，isShield == true
                if (relationColumn.isShield()) {
                    info.setFrom("******");
                    info.setTo("******");
                } else {
                    info.setFrom(originalValue);
                    info.setTo(updatedValue);
                }

                changeInfos.add(info);
            }
        }
    }

    /**
     * 处理Relation注解
     * @param originalItem
     * @param updatedItem
     * @param changeInfos
     * @param field
     * @param <T>
     * @throws IllegalAccessException
     */
    private static <T> void processRelation(Object originalItem, Object updatedItem, List<FieldChangeInfo> changeInfos, Field field) throws IllegalAccessException {
        Relation relation = field.getAnnotation(Relation.class);
        if (relation != null) {
            field.setAccessible(true);

            Object value = null;
            Object originValue = originalItem == null ? null : field.get(originalItem);
            Object updatedValue = updatedItem == null ? null : field.get(updatedItem);

            value = originValue == null ? originValue : updatedValue;
            if (value != null) {
                getChangeInfo(originValue, updatedValue, value.getClass(), changeInfos);    //recursive
            }
        }
    }


    private static Object getObjectValue(Object value) {
        value = value == null ? "" : value.toString();
        return value;
    }

    private static Object getObjectValue(Object value, Class<?> enumClass) {
        Object result = null;
        if (value == null) {
            result = "";
        } else if (containEnumClass(enumClass)) {
            Object enumType = getEnumType(value, enumClass);
            result = getObjectValueOfEnum(enumType, enumClass);
        } else {
            result = value.toString();
        }
        return result;
    }

    private static Object getObjectValueOfList(Object value, Class<?> enumClass) {
        List<String> list = Lists.newArrayList();
        if (value != null && value instanceof List && ((List) value).size() > 0) {
            String str = null;
            Class<?> cla = ((List) value).get(0).getClass();
            for (int i = 0, length = ((List) value).size(); i < length; ++i) {
                if (cla.isEnum()) {
                    str = (String) getObjectValueOfEnum(((List) value).get(i), cla);
                } else if (containEnumClass(enumClass)) {
                    Object enumType = getEnumType(((List) value).get(i), enumClass);
                    str = (String) getObjectValueOfEnum(enumType, enumClass);
                } else {
                    str = (String) getObjectValue(((List) value).get(i));
                }
            }
            list.add(str);
        }

        String result = Joiner.on(",").skipNulls().join(list);
        return result;
    }

    private static Object getObjectValueOfArray(Object value, Class<?> enumClass) {
        List<Object> list = Lists.newArrayList(Arrays.asList(value));
        return getObjectValueOfList(list, enumClass);
    }

    private static Object getObjectValueOfEnum(Object value, Class<?> clazz) {
        Object result = null;
        if (value == null) {
            result = "";
        } else {
            Method getDisplayName = null;
            try {
                getDisplayName = clazz.getDeclaredMethod("getDisplayName");
                if (getDisplayName != null) {
                    result = getDisplayName.invoke(value);
                }
            } catch (NoSuchMethodException e) {
                logger.error("no such method getDisplayName", e);
            } catch (InvocationTargetException e) {
                logger.error("invoke getDisplayName error", e);
            } catch (IllegalAccessException e) {
                logger.error("invoke getDisplayName error", e);
            }

            result = getObjectValue(result);
        }
        return result;
    }




    private static boolean containEnumClass(Class<?> enumClass) {
        return enumClass != null && enumClass.isEnum();
    }

    private static Object getEnumType(Object value, Class<?> enumClass) {
        Object enumType = null;
        if (value != null && containEnumClass(enumClass)) {

            Method get = null;
            try {
                get = enumClass.getDeclaredMethod("get", int.class);
                if (get != null) {
                    enumType = get.invoke(enumClass, value);
                }
            } catch (NoSuchMethodException e) {
                logger.error("no such method getDisplayName", e);
            } catch (InvocationTargetException e) {
                logger.error("invoke getDisplayName error", e);
            } catch (IllegalAccessException e) {
                logger.error("invoke getDisplayName error", e);
            }
        }
        return enumType;
    }



}
