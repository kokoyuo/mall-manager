package com.kokoyuo.mall.manager.modules.product.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author kokoyuo
 * Created on 2018/11/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void getProductInfo() {
        List<Map<String,Object>> maps = productInfoRepository.getProductInfo(1);
        maps.forEach(stringObjectMap -> stringObjectMap.forEach((x,y) -> System.out.println(y)));
    }
}