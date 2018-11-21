package com.kokoyuo.mall.manager.shiro;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/10/26.
 */
@Entity
@Table(name = "manager_role_info", schema = "mall")
public class ManagerRoleInfo {
    private int id;
    private String roleCode;
    private String roleName;
    private String createBy;
    @ApiModelProperty(dataType = "java.util.Date")
    private Timestamp createDate;
    private String modifiedBy;
    @ApiModelProperty(dataType = "java.util.Date")
    private Timestamp modifiedDate;
    private Integer sortno;
    private Integer state;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_code")
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    @Column(name = "modified_by")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "modified_date")
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Basic
    @Column(name = "sortno")
    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerRoleInfo that = (ManagerRoleInfo) o;
        return id == that.id &&
                Objects.equals(roleCode, that.roleCode) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifiedBy, that.modifiedBy) &&
                Objects.equals(modifiedDate, that.modifiedDate) &&
                Objects.equals(sortno, that.sortno) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleCode, roleName, createBy, createDate, modifiedBy, modifiedDate, sortno, state);
    }
}
