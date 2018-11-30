package com.kokoyuo.mall.manager.modules.product.dao;

import com.kokoyuo.mall.manager.modules.product.entity.ProductInfoCateAttr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author kokoyuo
 * Created on 2018/11/20.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoCateAttrRepositoryTest {

    @Autowired ProductInfoCateAttrRepository repository;

    @Test
    public void testDelete()
    {
        ProductInfoCateAttr attr = new ProductInfoCateAttr();
        //attr.setProductId(2);
        attr.setSkuId(4);
        //attr.setCateId(2);
        //repository.delete(attr);
        repository.deleteBySkuId(4);
    }
}