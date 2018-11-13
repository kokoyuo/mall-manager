package com.kokoyuo.mall.manager.jdk8;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.kokoyuo.mall.manager.modules.product.entity.ProductSku;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author kokoyuo
 * Created on 2018/11/12.
 */
public class StreamTest {
    public static void main(String []args)
    {
        Map<String,String> map1 = new HashMap<>();
        map1.put("name","lxw");
        map1.put("sex","nan");
        map1.put("age","18");

        Map<String,String> map2 = new HashMap<>();
        map2.put("name","xienan");
        map2.put("sex","nv");
        map2.put("age","16");

        Map<String,String> map3 = new HashMap<>();
        map3.put("name","wanhao");
        map3.put("sex","nv");
        map3.put("age","16");

        map1.entrySet().iterator().next().getKey();

        List<Map<String,String>> maps = Arrays.asList(map1,map2,map3);

        Map<String,Map<String,String>> map = new HashMap<>();

        Map<String,List<Map<String,String>>> ms = maps.parallelStream().collect(Collectors.groupingBy(o -> o.get("sex")));

        for (String key:ms.keySet()) {
            map.put(key,ms.get(key).parallelStream().collect(Collectors.toConcurrentMap(o -> o.get("name"), o -> o.get("age"))));
        }

        /*for (Iterator<Map.Entry<String,List<Map<String,String>>>> it = ms.entrySet().iterator(); it.hasNext();) {
            it.next().getValue().parallelStream().collect(Collectors.toConcurrentMap(o -> o.get(""),o -> o.get("")));
        }*/

       /* for (ms. ls = ;) {

        }*/
        //ms.get("nv").parallelStream().collect(Collectors.toConcurrentMap(o -> o.get(""), o -> o.get("")));


        System.out.println(JSONObject.toJSONString(map));

        //Map map = maps.parallelStream().collect(Collectors.toConcurrentMap(o -> o.get("name"),o -> o.get("age")));

        //map.forEach((o, o2) -> System.out.println(o+"->"+o2));
    }
}
