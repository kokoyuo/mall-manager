package com.kokoyuo.mall.manager.modules.product.dao;

import com.kokoyuo.mall.manager.modules.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {
    @Query(value = " select ica.product_id,ica.sku_id,ica.cate_id,ica.attr_id,pc.parent_id, " +
            " pc.cate_name,pca.attr_name " +
            " from product_info_cate_attr ica " +
            " left join product_cate pc " +
            " on ica.cate_id = pc.id " +
            " left join product_cate_attr pca " +
            " on ica.attr_id = pca.id " +
            " where ica.product_id = :productId ",nativeQuery = true)
    List<Map<String,Object>> getProductCatesByProductId(@Param(value = "productId") Integer productId);
}
