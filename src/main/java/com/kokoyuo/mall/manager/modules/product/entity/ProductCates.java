package com.kokoyuo.mall.manager.modules.product.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kokoyuo
 * Created on 2018/11/8.
 */
public class ProductCates {
    public static void main(String[] args) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("data",null);
        getResult(map,String.class);
    }

    public static <T> T getResult(Map<String,Object> result,Class<T> t) throws Exception{
        if(result == null || result.size()<1){
            throw new Exception("解析参数出错");
        }
        return (T) result.get("data");
    }
}
