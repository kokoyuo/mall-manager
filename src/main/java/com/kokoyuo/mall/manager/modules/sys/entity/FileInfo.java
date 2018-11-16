package com.kokoyuo.mall.manager.modules.sys.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author kokoyuo
 * Created on 2018/11/15.
 */
@Entity
@Table(name = "file_info", schema = "mall")
public class FileInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fileDesc;
    private String area;
    private String filePath;
    private String fileName;
    private String filePostfix;
    private Timestamp createDate;
    private Timestamp modifyDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "file_desc")
    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    @Basic
    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "file_path")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_postfix")
    public String getFilePostfix() {
        return filePostfix;
    }

    public void setFilePostfix(String filePostfix) {
        this.filePostfix = filePostfix;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileInfo fileInfo = (FileInfo) o;
        return id == fileInfo.id &&
                Objects.equals(fileDesc, fileInfo.fileDesc) &&
                Objects.equals(area, fileInfo.area) &&
                Objects.equals(filePath, fileInfo.filePath) &&
                Objects.equals(fileName, fileInfo.fileName) &&
                Objects.equals(filePostfix, fileInfo.filePostfix) &&
                Objects.equals(createDate, fileInfo.createDate) &&
                Objects.equals(modifyDate, fileInfo.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileDesc, area, filePath, fileName, filePostfix, createDate, modifyDate);
    }
}
