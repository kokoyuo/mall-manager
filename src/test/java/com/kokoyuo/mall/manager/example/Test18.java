package com.kokoyuo.mall.manager.example;

import java.util.Scanner;

/**
 * @author kokoyuo
 * Created on 2019/3/28.
 */
public class Test18 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a>b){
            System.out.println("第1个if");
            int d;
            d = b;
            b = a;
            a = d;
        }
        if(a>c){
            System.out.println("第2个if");
            int d;
            d = c;
            c = a;
            a = d;
        }
        if(a>b){
            System.out.println("第3个if");
            int d;
            d = b;
            b = a;
            a =d;
        }

        System.out.println(a+","+b+","+c);
    }


}
