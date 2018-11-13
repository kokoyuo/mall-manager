package com.kokoyuo.mall.manager.modules.product.dao;

import com.kokoyuo.mall.manager.modules.product.entity.ProductSku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kokoyuo
 * Created on 2018/11/12.
 */
public interface ProductSkuRepository extends JpaRepository<ProductSku,Integer> {
    List<ProductSku> findByProductId(Integer productId);
}
