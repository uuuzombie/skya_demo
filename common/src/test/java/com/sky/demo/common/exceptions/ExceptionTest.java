package com.sky.demo.common.exceptions;

import com.sky.demo.common.compare.bean.User;
import org.junit.Test;

/**
 * Created by rg on 15/6/27.
 */
public class ExceptionTest {


    @Test
    public void test_readUser() throws Exception {
        User user = null;
        UserUtil.readUser(user);
    }

    @Test
    public void test_processUser(){
        User user = null;
        UserUtil.processUser(user);
    }

    @Test
    public void test_no_catch(){

        try {
            System.out.println("start");
            throw new NullPointerException();

        }finally {
            System.out.println("finally");      //finally 会输出
        }
    }
}
