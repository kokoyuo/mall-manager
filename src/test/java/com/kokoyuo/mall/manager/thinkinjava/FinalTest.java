package com.kokoyuo.mall.manager.thinkinjava;

/**
 * @author kokoyuo
 * Created on 2019/2/13.
 */
public class FinalTest {
    public static final int[] SHU_ZU = {1,2,3,4,5};

    public static void main(String args[])
    {
        System.out.println("未修改前---------------------");

        for (int i:SHU_ZU) {
            System.out.println(i);
        }

        for (int i = 0; i < SHU_ZU.length; i++) {
            SHU_ZU[i] = SHU_ZU[i]*100;
        }

        System.out.println("修改后---------------------");

        for (int i:SHU_ZU) {
            System.out.println(i);
        }
    }
}
