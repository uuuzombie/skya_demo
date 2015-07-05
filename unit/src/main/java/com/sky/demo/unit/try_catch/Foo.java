package com.sky.demo.unit.try_catch;

public class Foo {

    public static void test1(){
        try{
            String user = "aaa";        //定义在try内，finally块看不到
            System.out.println("try :" + user);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            String user = "bbb";
            System.out.println("finally : " + user);
        }

    }

    public static void test2(){

        String user = "";       //定义在try块外，finally块可看到，(不能在finally内重复定义）
        try{
            user = "aaa";
            System.out.println("try :" + user);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            //user = "bbb";
            System.out.println("finally : " + user);
        }

    }
}
