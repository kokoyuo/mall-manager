package com.kokoyuo.mall.manager.jdk8;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author kokoyuo
 * Created on 2018/10/31.
 */
public class MyFlatMapTest {
    public static void main(String [] args)
    {
        User userFall = new User("name",null,null);
        System.out.println(new Country("1","2"));
        Consumer<Country> cs = x -> System.out.println("111");
        Country ccc = new Country("ccccou","cccloc");
        Country c = Optional.ofNullable(userFall).flatMap(user -> user.getCountry()).orElseGet(() -> new Country("1","sdasd"));
                //.getAddress().orElse(new Address("3")).getLocal());
                //.flatMap(country -> country.getAddress()).map(address -> address.getLocal()).orElse("111"));

        User userNull = new User("name","cou_name","local");
        System.out.println(Optional.ofNullable(userNull).flatMap(user -> user.getCountry()).flatMap(country -> country.getAddress()).map(address -> address.getLocal()));
    }
}
