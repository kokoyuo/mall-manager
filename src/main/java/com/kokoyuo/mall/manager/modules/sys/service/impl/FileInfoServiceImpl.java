package com.kokoyuo.mall.manager.modules.sys.service.impl;

import com.kokoyuo.mall.manager.modules.sys.dao.FileInfoRepository;
import com.kokoyuo.mall.manager.modules.sys.entity.FileInfo;
import com.kokoyuo.mall.manager.modules.sys.service.FileInfoService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kokoyuo
 * Created on 2018/11/15.
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public FileInfo saveFileInfo(FileInfo fileInfo) {
        return fileInfoRepository.save(fileInfo);
    }
}
