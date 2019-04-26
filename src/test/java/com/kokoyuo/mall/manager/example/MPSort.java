package com.kokoyuo.mall.manager.example;

/**
 * @author kokoyuo
 * Created on 2019/3/28.
 */
public class MPSort {
    public static void main(String[] args){
        int[] ii= {12,34,34,56,23,65,45};
        sort(ii);
        for (int i:ii) {
            System.out.println(i);
        }
    }

    public static void sort(int[] ns){
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < (ns.length - i -1); j++) {
                if(ns[j] > ns[j+1]){
                    int temp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = ns[j];
                }
            }
        }
    }
}
