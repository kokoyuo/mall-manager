package com.kokoyuo.mall.manager.modules.product.controller;

import com.kokoyuo.mall.manager.modules.product.service.ProductService;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
@RequestMapping("/productcate")
@RestController
public class ProductCateController {

    @Autowired
    private ProductService productService;

    @PostMapping("/page/{current_page}/{page_size}")
    public Result get(@PathVariable Integer current_page,@PathVariable Integer page_size,
                      @RequestParam String cateName,@RequestParam Integer parentId)
    {

        return Result.SUCCESS_INSTANCE;
    }
}
