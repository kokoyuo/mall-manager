package com.kokoyuo.mall.manager.modules.product.dao;

import com.kokoyuo.mall.manager.modules.product.entity.ProductCate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kokoyuo
 * Created on 2018/11/13.
 */
public interface ProductCateRepository extends JpaRepository<ProductCate,Integer> {
}
