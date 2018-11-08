package com.kokoyuo.mall.manager.jdk8;

import java.util.Optional;

/**
 * @author kokoyuo
 * Created on 2018/10/31.
 */
public class User {
    private String name;

    private Optional<Country> country;

    public User(String name,String cou_name,String local) {
        if(cou_name==null&&local==null)
        {
            this.country = Optional.empty();
        }else
        {
            this.country = Optional.ofNullable(new Country(cou_name,local));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Country> getCountry() {
        return country;
    }

    public void setCountry(Optional<Country> country) {
        this.country = country;
    }
}
