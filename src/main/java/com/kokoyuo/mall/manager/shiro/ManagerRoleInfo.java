package com.kokoyuo.mall.manager.shiro;

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
    private Timestamp createDate;
    private String modifiedBy;
    private Timestamp modifiedDate;
    private Integer sortno;
    private Integer state;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_CODE")
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "CREATE_BY")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "CREATE_DATE")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "MODIFIED_BY")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "MODIFIED_DATE")
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Basic
    @Column(name = "SORTNO")
    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    @Basic
    @Column(name = "STATE")
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
