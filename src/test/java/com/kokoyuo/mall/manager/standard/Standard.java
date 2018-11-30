package com.kokoyuo.mall.manager.standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kokoyuo
 * Created on 2018/11/23.
 */
public class Standard {
    public static void main(String args[])
    {
        List<String> ss0 = Arrays.asList("1","2","3","4","5");
        /*ArrayList<String> ss = new ArrayList(ss0);
        ss.forEach(s -> System.out.println(s));

        ArrayList<String> ss2 = (ArrayList<String>) ss.subList(0,3);
        ss2.forEach(s -> System.out.println(s));*/

        ss0.add("6");
    }
}
