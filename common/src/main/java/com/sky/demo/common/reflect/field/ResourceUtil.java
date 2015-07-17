package com.sky.demo.common.reflect.field;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by rg on 2015/7/16.
 */
public class ResourceUtil {

    public static <T> List<FieldChangeInfo> getResourceChangeInfo(T originalItem, T updatedItem, Class<T> clazz) {
        List<FieldChangeInfo> changeInfos = Lists.newArrayList();

        try {
            for (Field field : clazz.getDeclaredFields()) {
                RelationColumn revisionColumn = field.getAnnotation(RelationColumn.class);
                if (revisionColumn != null) {
                    field.setAccessible(true);

                    Object originalValue = field.get(originalItem);
                    Object updatedValue = field.get(updatedItem);
                    if (originalValue == null && updatedValue == null) {
                        continue;
                    }

                    if (originalValue == null || !originalValue.equals(updatedValue)) {
                        FieldChangeInfo info = new FieldChangeInfo();
                        info.setPropertyName(field.getName());
                        info.setPropertyHeader(revisionColumn.value());
                        info.setFrom(originalValue);
                        info.setTo(updatedValue);

                        changeInfos.add(info);
                    }
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return changeInfos;
    }
}
