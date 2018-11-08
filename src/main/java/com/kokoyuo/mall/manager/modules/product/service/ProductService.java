package com.kokoyuo.mall.manager.modules.product.service;

import com.kokoyuo.mall.manager.modules.product.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
public interface ProductService {
    Page<ProductInfo> getProductPage(ProductInfo productInfo, Pageable pageable);
}
