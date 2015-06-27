package com.sky.demo.common.annotation.meta.apply;

import com.sky.demo.common.annotation.meta.anno.MyAnno;
import com.sky.demo.common.annotation.meta.anno.What;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by rg on 15/6/27.
 */
@What(desc = "meta2 desc")
@MyAnno(name = "meta2 name",val = 10)
public class Meta2 {

    @MyAnno(name = "Test",val = 100)
    public static void myMeth(){
        Meta2 meta2 = new Meta2();
        try{
            Annotation[] annotations = meta2.getClass().getAnnotations();

            System.out.println("All annotation for Meta2:");
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            Method method = meta2.getClass().getMethod("myMeth");
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
