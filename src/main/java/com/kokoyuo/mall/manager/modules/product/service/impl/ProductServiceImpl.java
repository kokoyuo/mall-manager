package com.kokoyuo.mall.manager.modules.product.service.impl;

import com.kokoyuo.mall.manager.modules.product.dao.*;
import com.kokoyuo.mall.manager.modules.product.entity.ProductCate;
import com.kokoyuo.mall.manager.modules.product.entity.ProductCateAttr;
import com.kokoyuo.mall.manager.modules.product.entity.ProductInfo;
import com.kokoyuo.mall.manager.modules.product.entity.ProductSku;
import com.kokoyuo.mall.manager.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private ProductSkuRepository productSkuRepository;

    @Autowired
    private ProductCateRepository productCateRepository;

    @Autowired
    private ProductCateAttrRepository productCateAttrRepository;

    @Autowired
    private ProductInfoCateAttrRepository productInfoCateAttrRepository;

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

    @Override
    public ProductInfo getProductInfo(Integer productId) {
        return productInfoRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Map<String, Object>> getProductCatesByProductId(Integer productId) {
        return productInfoRepository.getProductCatesByProductId(productId);
    }

    @Override
    public List<ProductSku> getSkus(Integer productId) {
        return productSkuRepository.findByProductId(productId);
    }

    @Override
    public Page<ProductCate> getCatesPage(ProductCate productCate,Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnorePaths("id");
        Example<ProductCate> example = Example.of(productCate,matcher);
        return productCateRepository.findAll(example,pageable);
    }

    @Override
    public List<ProductCateAttr> getAttrListByCateId(Integer cateId) {
        return productCateAttrRepository.findByCateId(cateId);
    }

    @Override
    public ProductCate saveCate(ProductCate productCate) {
        return productCateRepository.save(productCate);
    }

    @Override
    public ProductCateAttr saveAttr(ProductCateAttr productCateAttr) {
        return productCateAttrRepository.save(productCateAttr);
    }

    @Override
    @Transactional
    public ProductInfo saveProductInfo(ProductInfo productInfo) {
        ProductInfo tempProductInfo = productInfoRepository.save(productInfo);

        productInfo.getSkus().forEach(sku -> {
            sku.setProductId(tempProductInfo.getId());
            saveProductSku(sku);
        });

        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public ProductSku saveProductSku(ProductSku productSku)
    {
        ProductSku tempSku = productSkuRepository.save(productSku);
        /*删除之前的cates*/
        productInfoCateAttrRepository.deleteBySkuId(productSku.getId());

        productSku.getCateAttrs().stream().forEach(cateAttr -> {
            cateAttr.setSkuId(tempSku.getId());
            cateAttr.setProductId(productSku.getProductId());
            productInfoCateAttrRepository.save(cateAttr);
        });
        return tempSku;
    }
}
