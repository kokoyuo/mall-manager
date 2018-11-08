package com.kokoyuo.mall.manager.modules.product.service.impl;

import com.kokoyuo.mall.manager.modules.product.dao.ProductInfoRepository;
import com.kokoyuo.mall.manager.modules.product.entity.ProductInfo;
import com.kokoyuo.mall.manager.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public Page<ProductInfo> getProductPage(ProductInfo productInfo, Pageable pageable)
    {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnorePaths("id");
        Example<ProductInfo> example = Example.of(productInfo,matcher);
        return productInfoRepository.findAll(example,pageable);
    }
}
