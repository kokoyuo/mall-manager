package com.kokoyuo.mall.manager.reflect;

import java.lang.reflect.Method;

/**
 * @author kokoyuo
 * Created on 2019/3/20.
 */
public class TestInt {
    public static final void target(int i){}

    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("com.kokoyuo.mall.manager.reflect.TestInt");
        Method method = clazz.getMethod("target",int.class);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000 ; i++) {
            if(i % 100_000_000 == 0){
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null,128);
        }
    }
}
