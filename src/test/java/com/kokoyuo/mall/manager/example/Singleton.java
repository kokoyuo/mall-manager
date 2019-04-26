package com.kokoyuo.mall.manager.example;

/**
 * @author kokoyuo
 * Created on 2019/3/29.
 */
public class Singleton {
    static class SingletonInstance{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.instance;
    }

    public static void getTest(){
        System.out.println("test");
    }

    public Singleton() {
        System.out.println("init");
    }
}
