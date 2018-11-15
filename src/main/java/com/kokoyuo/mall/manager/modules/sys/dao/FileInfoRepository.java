package com.kokoyuo.mall.manager.modules.sys.dao;

import com.kokoyuo.mall.manager.modules.sys.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kokoyuo
 * Created on 2018/11/15.
 */
public interface FileInfoRepository extends JpaRepository<FileInfo,Integer> {
}
