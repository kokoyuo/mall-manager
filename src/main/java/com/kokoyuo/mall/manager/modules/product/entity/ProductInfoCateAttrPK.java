package com.kokoyuo.mall.manager.modules.product.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/11/5.
 */
public class ProductInfoCateAttrPK implements Serializable {
    private int productId;
    private int cateId;
    private int attrId;

    @Column(name = "PRODUCT_ID")
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "CATE_ID")
    @Id
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Column(name = "ATTR_ID")
    @Id
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
        ProductInfoCateAttrPK that = (ProductInfoCateAttrPK) o;
        return productId == that.productId &&
                cateId == that.cateId &&
                attrId == that.attrId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, cateId, attrId);
    }
}
