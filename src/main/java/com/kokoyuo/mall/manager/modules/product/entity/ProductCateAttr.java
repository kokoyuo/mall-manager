package com.kokoyuo.mall.manager.modules.product.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/11/5.
 */
@Entity
@Table(name = "product_cate_attr", schema = "mall")
public class ProductCateAttr {
    private int id;
    private Integer cateId;
    private String attrName;
    private String attrDesc;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CATE_ID")
    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "ATTR_NAME")
    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Basic
    @Column(name = "ATTR_DESC")
    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCateAttr that = (ProductCateAttr) o;
        return id == that.id &&
                Objects.equals(cateId, that.cateId) &&
                Objects.equals(attrName, that.attrName) &&
                Objects.equals(attrDesc, that.attrDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cateId, attrName, attrDesc);
    }
}
