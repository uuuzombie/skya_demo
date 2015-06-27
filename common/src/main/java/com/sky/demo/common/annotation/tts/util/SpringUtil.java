package com.sky.demo.common.annotation.tts.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by rg on 15/6/27.
 */
public class SpringUtil implements ApplicationContextAware{

    private static ApplicationContext ctx;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public static ApplicationContext getCtx() {
        return ctx;
    }
}
