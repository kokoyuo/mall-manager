package com.kokoyuo.mall.manager.modules.product.service;

import com.kokoyuo.mall.manager.modules.product.entity.ProductCate;
import com.kokoyuo.mall.manager.modules.product.entity.ProductCateAttr;
import com.kokoyuo.mall.manager.modules.product.entity.ProductInfo;
import com.kokoyuo.mall.manager.modules.product.entity.ProductSku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
public interface ProductService {
    Page<ProductInfo> getProductPage(ProductInfo productInfo, Pageable pageable);

    ProductInfo getProductInfo(Integer productId);

    List<Map<String,Object>> getProductCatesByProductId(Integer productId);

    List<ProductSku> getSkus(Integer productId);

    Page<ProductCate> getCatesPage(ProductCate productCate,Pageable pageable);

    List<ProductCateAttr> getAttrListByCateId(Integer cateId);

    ProductCate saveCate(ProductCate productCate);

    ProductCateAttr saveAttr(ProductCateAttr productCateAttr);

    ProductInfo saveProductInfo(ProductInfo productInfo);

    ProductSku saveProductSku(ProductSku productSku);
}