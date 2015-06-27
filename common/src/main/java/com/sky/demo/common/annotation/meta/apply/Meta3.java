package com.sky.demo.common.annotation.meta.apply;

import com.sky.demo.common.annotation.meta.anno.MyAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by rg on 15/6/27.
 */
public class Meta3 {

    @MyAnno()
    public static void myMeth(){
        Meta3 meta3 = new Meta3();
//        try{
//            Class clazz = meta3.getClass();
//            Method method = clazz.getMethod("myMeth");
//
//            MyAnno myAnno = method.getAnnotation(MyAnno.class);
//            System.out.println(myAnno.name() + ":" + myAnno.val());
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
        try{
            Annotation[] annotations = meta3.getClass().getAnnotations();

            System.out.println("All annotation for Meta3:");
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            Method method = meta3.getClass().getMethod("myMeth");
            annotations = method.getAnnotations();

            System.out.println("All annotation for myMeth:");
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
