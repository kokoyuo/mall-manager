package com.kokoyuo.mall.manager.jdk8;

import java.util.Optional;

/**
 * @author kokoyuo
 * Created on 2018/10/31.
 */
public class Country {
    private String cou_name;

    private Optional<Address> address;

    public Country(String cou_name, String local) {
        /*if(cou_name==null && local==null)
            return;*/
        this.cou_name = cou_name;
        this.address = Optional.ofNullable(new Address(local));
    }

    public Country() {

    }

    public String getCou_name() {
        return cou_name;
    }

    public void setCou_name(String cou_name) {
        this.cou_name = cou_name;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cou_name='" + cou_name + '\'' +
                ", address=" + address.orElse(new Address("null")).getLocal() +
                '}';
    }
}
