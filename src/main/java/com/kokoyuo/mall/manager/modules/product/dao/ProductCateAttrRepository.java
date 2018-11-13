package com.kokoyuo.mall.manager.modules.product.dao;

import com.kokoyuo.mall.manager.modules.product.entity.ProductCateAttr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kokoyuo
 * Created on 2018/11/13.
 */
public interface ProductCateAttrRepository extends JpaRepository<ProductCateAttr,Integer>
{
    List<ProductCateAttr> findByCateId(Integer cateId);
}
