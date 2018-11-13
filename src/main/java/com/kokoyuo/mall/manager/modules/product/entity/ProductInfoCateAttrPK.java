package com.kokoyuo.mall.manager.modules.product.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/11/9.
 */
public class ProductInfoCateAttrPK implements Serializable {
    private int skuId;
    private int cateId;

    @Column(name = "SKU_ID")
    @Id
    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    @Column(name = "CATE_ID")
    @Id
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfoCateAttrPK that = (ProductInfoCateAttrPK) o;
        return skuId == that.skuId &&
                cateId == that.cateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuId, cateId);
    }
}
