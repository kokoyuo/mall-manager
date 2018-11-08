package com.kokoyuo.mall.manager.modules.product.controller;

import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
@RequestMapping("/productcate")
@RestController
public class ProductCateController {

    @PostMapping("/")
    public Result get()
    {
        return Result.SUCCESS_INSTANCE;
    }
}
