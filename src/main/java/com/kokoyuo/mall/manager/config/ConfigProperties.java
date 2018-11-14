package com.kokoyuo.mall.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author kokoyuo
 * Created on 2018/11/14.
 */
@Component
public class ConfigProperties {

    @Value("${manager.folder.path}")
    private String folderPath;

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }
}
