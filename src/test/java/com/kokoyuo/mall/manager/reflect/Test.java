package com.kokoyuo.mall.manager.reflect;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author kokoyuo
 * Created on 2019/3/19.
 */
public class Test {
    public static void target(int i){
        new Exception("#"+i).printStackTrace();
    }

    public static void main(String [] args) throws Exception {
        /*Class<?> clazz = Class.forName("com.kokoyuo.mall.manager.reflect.Test");
        Method method = clazz.getMethod("target", int.class);
        method.invoke(null,0);*/
        int m = 7,n = 3,k =0;
        while((m--)>(n++))k++;
        System.out.println(k);

        int i = 0;
        Optional optional = Optional.ofNullable(null);
        System.out.println(optional.orElse(++i));
        System.out.println(optional.orElseGet(() -> {return 1;}));
    }
}
