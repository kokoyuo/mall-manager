package com.kokoyuo.mall.manager.modules.product.controller;

import com.alibaba.fastjson.JSONObject;
import com.kokoyuo.mall.manager.modules.product.entity.ProductCate;
import com.kokoyuo.mall.manager.modules.product.entity.ProductCateAttr;
import com.kokoyuo.mall.manager.modules.product.service.ProductService;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import com.kokoyuo.mall.manager.modules.sys.pojo.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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

    @ApiOperation(value = "根据cateId获取商品属性值",notes = "根据cateId获取商品属性值")
    @ApiImplicitParam(name = "id",paramType = "path",value = "分类ID",dataType = "Integer")
    @GetMapping("/cate/{id}")
    public Result getAttrByCateId(@PathVariable Integer id)
    {
        List<ProductCateAttr> attrList = productService.getAttrListByCateId(id);
        return Result.getDefaultSuccessResult(id);
    }

    @ApiOperation(value = "保存属性值",notes = "当id为空时为新增")
    @PostMapping("")
    public Result saveAttr(@RequestBody ProductCateAttr productCateAttr)
    {
        if(productCateAttr.getCateId()==null)
            return new Result(new Status(201,"cateId 不能为空"));
        if(StringUtils.isBlank(productCateAttr.getAttrName()))
            return new Result(new Status(202,"attrName 不能为空"));
        productService.saveAttr(productCateAttr);
        return Result.SUCCESS_INSTANCE;
    }

}
