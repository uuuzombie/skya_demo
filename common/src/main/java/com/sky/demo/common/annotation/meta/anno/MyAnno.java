package com.sky.demo.common.annotation.meta.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by rg on 15/6/27.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String name() default "testing";
    int val() default 100;
}
