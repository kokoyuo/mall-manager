package com.kokoyuo.mall.manager.modules.product.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/11/9.
 */
@Entity
@Table(name = "product_info_cate_attr", schema = "mall")
@IdClass(ProductInfoCateAttrPK.class)
public class ProductInfoCateAttr {
    private Integer productId;
    private Integer skuId;
    private Integer cateId;
    private Integer attrId;

    @Basic
    @Column(name = "product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "sku_id")
    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    @Id
    @Column(name = "cate_id")
    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "attr_id")
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfoCateAttr that = (ProductInfoCateAttr) o;
        return productId.equals(that.productId) &&
                skuId.equals(that.skuId) &&
                cateId.equals(that.cateId) &&
                attrId.equals(that.attrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, skuId, cateId, attrId);
    }
}
