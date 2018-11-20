package com.kokoyuo.mall.manager.modules.product.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/11/9.
 */
@Entity
@Table(name = "product_sku", schema = "mall")
public class ProductSku {
    private int id;
    private Integer productId;
    private String name;
    private String fullName;
    private BigDecimal price;
    private BigDecimal cost;
    private String image;
    private Integer isSale;
    private String introduction;
    private Timestamp createDate;
    private Timestamp modifyDate;

    private List<ProductInfoCateAttr> cateAttrs;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "is_sale")
    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

    @Basic
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modify_date")
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Transient
    public List<ProductInfoCateAttr> getCateAttrs() {
        return cateAttrs;
    }

    public void setCateAttrs(List<ProductInfoCateAttr> cateAttrs) {
        this.cateAttrs = cateAttrs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSku that = (ProductSku) o;
        return id == that.id &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(image, that.image) &&
                Objects.equals(isSale, that.isSale) &&
                Objects.equals(introduction, that.introduction) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(cateAttrs, that.cateAttrs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, name, fullName, price, cost, image, isSale, introduction, createDate, modifyDate,cateAttrs);
    }
}
