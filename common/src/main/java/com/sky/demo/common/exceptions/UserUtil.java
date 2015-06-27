package com.sky.demo.common.exceptions;

import com.google.common.base.Preconditions;
import com.sky.demo.common.compare.bean.User;

/**
 * Created by rg on 15/6/27.
 */
public class UserUtil {

    public static void readUser(User user) throws Exception{
        Preconditions.checkNotNull(user, "User is null");

        try {
            System.out.println(user);
        } catch (Exception e) {
            System.out.println("catch exception : " + e);
        } finally {
            System.out.println("finally output");  //Precondition抛异常后不会执行到finally方法内
        }

    }


    public static void processUser(User user) {
        try {
            if (user == null) {
                throw new Exception("user is null");
            }

        } catch (Exception e) {
            System.out.println("catch exception :" + e);        //output 1
        } finally {
            System.out.println("finally output");       //output 2
        }

        System.out.println("out");          //output 3
    }
}
