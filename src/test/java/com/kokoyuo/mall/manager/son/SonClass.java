package com.kokoyuo.mall.manager.son;

import com.kokoyuo.mall.manager.sub.SubClass;

/**
 * @author kokoyuo
 * Created on 2018/10/17.
 */
public class SonClass extends SubClass {
    public static void main(String [] args)
    {
        SubClass sc = new SonClass();
        ((SonClass) sc).tt();
    }

    void tt()
    {
        findPro();
    }
}
