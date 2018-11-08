package com.kokoyuo.mall.manager.modules.product.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/11/5.
 */
@Entity
@Table(name = "product_info_cate_attr", schema = "mall")
@IdClass(ProductInfoCateAttrPK.class)
public class ProductInfoCateAttr {
    private int productId;
    private int cateId;
    private int attrId;

    @Id
    @Column(name = "PRODUCT_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "CATE_ID")
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Id
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
                cateId == that.cateId &&
                attrId == that.attrId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, cateId, attrId);
    }
}
