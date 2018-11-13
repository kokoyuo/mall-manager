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
    private int productId;
    private int skuId;
    private int cateId;
    private int attrId;

    @Basic
    @Column(name = "PRODUCT_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "SKU_ID")
    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    @Id
    @Column(name = "CATE_ID")
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "ATTR_ID")
    public int getAttrId() {
        return attrId;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfoCateAttr that = (ProductInfoCateAttr) o;
        return productId == that.productId &&
                skuId == that.skuId &&
                cateId == that.cateId &&
                attrId == that.attrId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, skuId, cateId, attrId);
    }
}
