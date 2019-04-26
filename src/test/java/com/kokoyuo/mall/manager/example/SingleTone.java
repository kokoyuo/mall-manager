package com.kokoyuo.mall.manager.example;

/**
 * @author kokoyuo
 * Created on 2019/3/28.
 */
public class SingleTone {

    private static volatile MPSort mpSort;

    public static MPSort getMpSingleInstance(){
        if(mpSort == null){
            synchronized(MPSort.class){
                if(mpSort==null){
                    mpSort = new MPSort();
                }
            }
        }
        return mpSort;
    }
}
