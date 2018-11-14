package com.kokoyuo.mall.manager.modules.sys.controller;

import com.kokoyuo.mall.manager.config.ConfigProperties;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import com.kokoyuo.mall.manager.modules.sys.pojo.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

    @Autowired
    private ConfigProperties properties;

    @PostMapping("/upload")
    @ApiImplicitParam("")
    public Result upload(@RequestParam MultipartFile file,HttpServletRequest request)
    {
        if(file == null)
            return new Result(new Status(201,"Please select a file to upload"));

        File serverFile = new File(request.getSession().getServletContext().getRealPath("/")+properties.getFolderPath()+ UUID.randomUUID()+file.getOriginalFilename());

        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Result.getDefaultSuccessResult(serverFile.getPath()+serverFile.getName());
    }
}
