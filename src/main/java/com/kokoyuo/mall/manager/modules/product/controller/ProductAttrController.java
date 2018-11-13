package com.kokoyuo.mall.manager.modules.product.controller;

import com.alibaba.fastjson.JSONObject;
import com.kokoyuo.mall.manager.modules.product.entity.ProductCate;
import com.kokoyuo.mall.manager.modules.product.entity.ProductCateAttr;
import com.kokoyuo.mall.manager.modules.product.service.ProductService;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kokoyuo
 * Created on 2018/11/13.
 */
@Api(value = "产品分类属性接口",description = "产品分类属性接口")
@RequestMapping("/productattr")
@RestController
public class ProductAttrController {

    @Autowired
    private ProductService productService;

    @GetMapping("/cate/{id}")
    public Result getAttrByCateId(@PathVariable Integer id)
    {
        List<ProductCateAttr> attrList = productService.getAttrListByCateId(id);
        return Result.getDefaultSuccessResult(id);
    }

    @PostMapping
    public Result saveAttr(@RequestBody ProductCateAttr productCateAttr)
    {
        productService.saveAttr(productCateAttr);
        return Result.SUCCESS_INSTANCE;
    }

}
