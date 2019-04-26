package com.kokoyuo.mall.manager.example;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author kokoyuo
 * Created on 2019/2/15.
 */
public class ThreadLocalTest {
    public static void main(String[] args){


        //

        BigDecimal bd = new BigDecimal("464654654654654.230");
        System.out.println(bd.toString());

        Optional<String> os = Optional.ofNullable(null);

        System.out.println(os.orElseGet(() -> {return null;}));

        List<String> ls =null;

        ls.sort((o1, o2) -> {return -1;});
        A a = new A();
        print(a);
        Aplus ap = new Aplus();
        print(ap);

        System.out.println(JSONObject.toJSONString(a));
    }

    public static void print(A a){
        a.print();
    }
}
