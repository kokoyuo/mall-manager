package com.kokoyuo.mall.manager.modules.sys.controller;

import com.kokoyuo.mall.manager.config.ConfigProperties;
import com.kokoyuo.mall.manager.modules.sys.entity.FileInfo;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import com.kokoyuo.mall.manager.modules.sys.pojo.Status;
import com.kokoyuo.mall.manager.modules.sys.service.FileInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author kokoyuo
 * Created on 2018/11/14.
 */
@Api(value = "文件处理接口",description = "文件处理接口")
@RestController
@RequestMapping("/file")
public class FileController {


    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private ConfigProperties properties;

    @Autowired
    private FileInfoService fileInfoService;

    @ApiOperation(value = "上传文件到服务器")
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public Result upload(@ApiParam(value = "文件",required = true) MultipartFile file,
                         @ApiParam(value = "文件描述") @RequestParam String desc,
                         HttpServletRequest request)
    {
        if(file == null)
            return new Result(new Status(201,"Please select a file to upload"));

        if(file.getOriginalFilename() == null)
            return new Result(new Status(204,"Please select a file to upload"));

        String fileName = file.getOriginalFilename();
        String postfixName = fileName.substring(fileName.lastIndexOf("."));
        String fileLocal = request.getSession().getServletContext().getRealPath("/")+properties.getFolderPath()+ UUID.randomUUID()+postfixName;
        /*获取当前域名及项目位置*/
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

        File serverFile = new File(fileLocal);
        File serverFileParent = serverFile.getParentFile();
        if(!serverFileParent.exists())
        {
            if(!serverFileParent.mkdirs())
                return new Result(new Status(203,"创建上传路径失败"));
        }

        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new Result(new Status(202,"上传文件失败["+e.getMessage()+"]"));
        }

        FileInfo fileInfo = new FileInfo();
        fileInfo.setArea(basePath);
        fileInfo.setFileDesc(desc);
        fileInfo.setFilePath(properties.getFolderPath());
        fileInfo.setFilePostfix(postfixName);
        fileInfo.setFileName(serverFile.getName());

        FileInfo returnFile = fileInfoService.saveFileInfo(fileInfo);

        return Result.getDefaultSuccessResult(returnFile);
    }
}
