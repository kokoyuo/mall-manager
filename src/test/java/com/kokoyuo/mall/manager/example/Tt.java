package com.kokoyuo.mall.manager.example;

/**
 * @author kokoyuo
 * Created on 2018/11/12.
 */

    class ConstClass {
        static {
            System.out.println("ConstClass init");
        }
        public static final String HELLOWORLD = "hello world";
    }

    public class Tt {
        public static void main(String[] args) {
            System.out.println(ConstClass.HELLOWORLD);// 调用类常量
        }
    }

