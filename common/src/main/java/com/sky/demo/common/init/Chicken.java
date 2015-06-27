package com.sky.demo.common.init;

/**
 * Created by rg on 15/6/27.
 */
public class Chicken extends Bird {

    public Chicken() {
        super();
        System.out.println("Constructor Chicken");
    }
    
    {
        System.out.println("Field Chicken");
    }

    static {
        System.out.println("Static Field Chicken");
    }
}
