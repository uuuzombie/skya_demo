package com.sky.demo.unit.extends_demo;

/**
 * Created by user on 17/5/24.
 * java继承中对构造函数是不继承的，只是调用（隐式或显式）
 *
 * 总结1：构造函数不能继承，只是调用而已。
 * 总结2：创建有参构造函数后，系统就不再有默认无参构造函数。
 *
 * 如果父类没有无参构造函数，创建子类时，如果不显示调用父类有参构造函数，系统会默认调用父类无参构造函数super();  编译报错
 */
public class ChildClass extends FatherClass {

    ChildClass b;

    public ChildClass() {
        System.out.println(3);
    }


    public ChildClass(String s) {  //系统会自动先调用父类的无参构造函数(super())
        System.out.println(4);
        this.s = s;
        b = new ChildClass();
    }

    //带参数构造函数中，等价于
//    public ChildClass(String s) {
//        super();      //必须是第1行，否则不能编译
//        System.out.println(4);
//        this.s = s;
//        b = new ChildClass();
//    }


    public static void main(String[] args) {
        ChildClass classB = new ChildClass("XX");   //注：会调用父类的无参构造函数！
    }

}
