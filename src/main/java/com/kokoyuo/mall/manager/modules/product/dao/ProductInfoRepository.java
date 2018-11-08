package com.kokoyuo.mall.manager.modules.product.dao;

import com.kokoyuo.mall.manager.modules.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {
}
