package com.sky.demo.unit.param_transfer;

/**
 * Created by user on 17/5/24.
 */
public class ParamTransfer {


    public void aMethod(AClass aClass, int i) {
        i = 0;

//        aClass.i = 6;

        AClass bClass = new AClass();

        aClass = bClass;        //此步改变参数aClass所指向内容

        System.out.println(aClass.i + " " + i);

    }

    public static void main(String[] args) {

        ParamTransfer paramTransfer = new ParamTransfer();

        AClass aClass = new AClass();
        aClass.i = 5;
        int i = 10;

        paramTransfer.aMethod(aClass, i); //注：值传递

        System.out.println(aClass.i);
    }


}
