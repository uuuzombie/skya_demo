package com.sky.demo.common.annotation.tts.service;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sky.demo.common.annotation.tts.anno.DimensionInterface;
import com.sky.demo.common.annotation.tts.anno.TTS;
import com.sky.demo.common.annotation.tts.bean.Dimensions;
import com.sky.demo.common.annotation.tts.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by rg on 15/6/27.
 */
public class HandleService {

    private static final Logger logger = LoggerFactory.getLogger(HandleService.class);

    private static HandleService INSTANCE = new HandleService();

    private HandleService(){}

    public static HandleService getInstance(){
        return INSTANCE;
    }

    private Map<Class<?>, Set<Object>> handlerMap = Maps.newHashMap();


    public void addHandlerMap(Class<?> theInterface,Class<?> theClass){
        try {
            Set<Object> classSet = handlerMap.get(theInterface);

            if (classSet == null) {
                classSet = Sets.newHashSet();
                handlerMap.put(theInterface,classSet);
            }

            Object instance = SpringUtil.getCtx().getBean(theClass);
            if (instance != null) {
                classSet.add(instance);
            } else {
                logger.info("class " + theClass + "no spring bean");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }

    }

    public void addDimensionHandler(Class<?> aClass){
        TTS anno = aClass.getClass().getAnnotation(TTS.class);

        if (null == anno) {
            return;
        }

        Class<?>[] interfaces = getInterface(aClass);
        if (null == interfaces || interfaces.length == 0) {
            return ;
        }

        for (Class<?> anInterface : interfaces) {
            if (null != anInterface.getAnnotation(DimensionInterface.class)){
                addHandlerMap(anInterface,aClass);
                break;
            }
        }

    }

    private Class<?>[] getInterface(Class<?> aClass){
        Class<?> parent = null;

        do {
            parent = aClass.getSuperclass();
            if (parent.getClass().getName().equals("java.lang.Object")){
                return aClass.getInterfaces();
            } else {
                aClass = aClass.getSuperclass();
            }


        }while(parent != null);

        return null;
    }

    public void call(Class<?> theInterface,Dimensions dimensions,Object param) {

        try {
            call(theInterface,dimensions,"process",param);
        } catch (Exception e) {
            logger.error("exception",e);
        }
    }

    public void call(Class<?> theInterface,Dimensions dimensions,String methodName,Object param) throws Exception{

        Set<Object> classSet = handlerMap.get(theInterface);
    }
}
