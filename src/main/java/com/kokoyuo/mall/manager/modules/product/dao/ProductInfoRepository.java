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
    @Query(value = " select ica.PRODUCT_ID,ica.SKU_ID,ica.CATE_ID,ica.ATTR_ID,pc.PARENT_ID, " +
            " pc.CATE_NAME,pca.ATTR_NAME " +
            " from product_info_cate_attr ica " +
            " LEFT JOIN product_cate pc " +
            " ON ica.CATE_ID = pc.ID " +
            " LEFT JOIN product_cate_attr pca " +
            " ON ica.ATTR_ID = pca.ID " +
            " where ica.PRODUCT_ID = :productId ",nativeQuery = true)
    List<Map<String,Object>> getProductCatesByProductId(@Param(value = "productId") Integer productId);
}
