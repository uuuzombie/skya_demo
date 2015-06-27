package com.sky.demo.common.annotation.meta.apply;

import com.sky.demo.common.annotation.meta.anno.MyAnno;

import java.lang.reflect.Method;

/**
 * Created by rg on 15/6/27.
 */
public class Meta {

    @MyAnno(name="Annotation Example", val = 10)
    public static void myMeth(){
        Meta meta = new Meta();
        try{
            Class clazz = meta.getClass();
            Method method = clazz.getMethod("myMeth");

            MyAnno myAnno = method.getAnnotation(MyAnno.class);

            System.out.println(myAnno.name() + ":" + myAnno.val());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @MyAnno(name = "Two Parameters",val = 20)
    public static void myMeth(String str, int i){
        Meta meta = new Meta();
        try{
            Class clazz = meta.getClass();
            Method method = clazz.getMethod("myMeth",String.class,int.class);

            MyAnno myAnno = method.getAnnotation(MyAnno.class);

            System.out.println(myAnno.name() + ":" + myAnno.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
