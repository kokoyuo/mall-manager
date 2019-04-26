package com.kokoyuo.mall.manager.thinkinjava;

/**
 * @author kokoyuo
 * Created on 2019/2/14.
 */
class Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){
        return  input;
    }
}

public class Apply {
}
