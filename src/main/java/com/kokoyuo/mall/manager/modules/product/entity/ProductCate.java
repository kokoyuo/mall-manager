package com.kokoyuo.mall.manager.modules.product.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/11/5.
 */
@Entity
@Table(name = "product_cate", schema = "mall")
public class ProductCate {
    private int id;
    private Integer parentId;
    private String cateName;
    private String cateDesc;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "cate_name")
    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Basic
    @Column(name = "cate_desc")
    public String getCateDesc() {
        return cateDesc;
    }

    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCate that = (ProductCate) o;
        return id == that.id &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(cateName, that.cateName) &&
                Objects.equals(cateDesc, that.cateDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, cateName, cateDesc);
    }
}
