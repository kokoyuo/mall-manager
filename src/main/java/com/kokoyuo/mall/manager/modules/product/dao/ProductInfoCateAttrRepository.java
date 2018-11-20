package com.kokoyuo.mall.manager.modules.product.dao;

import com.kokoyuo.mall.manager.modules.product.entity.ProductInfoCateAttr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

/**
 * @author kokoyuo
 * Created on 2018/11/20.
 */
public interface ProductInfoCateAttrRepository extends JpaRepository<ProductInfoCateAttr,Integer> {
    @Transactional
    @Modifying
    void deleteBySkuId(Integer id);

    @Transactional
    @Modifying
    void deleteByProductId(Integer id);
}
