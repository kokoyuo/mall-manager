package com.kokoyuo.mall.manager.modules.product.controller;

import com.kokoyuo.mall.manager.modules.product.entity.ProductCate;
import com.kokoyuo.mall.manager.modules.product.service.ProductService;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import com.kokoyuo.mall.manager.modules.sys.pojo.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
@Api(value = "产品分类接口",description = "产品分类接口")
@RequestMapping("/productcate")
@RestController
public class ProductCateController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取类别信息",notes = "获取类别信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "current_page",paramType = "path",value = "当前页",dataType = "Integer"),
                    @ApiImplicitParam(name = "page_size",paramType = "path",value = "页面大小",dataType = "Integer"),
                    @ApiImplicitParam(name = "cateName",paramType = "query",value = "类别名",dataType = "String"),
                    @ApiImplicitParam(name = "parentId",paramType = "query",value = "父类ID",dataType = "Integer"),
            })
    @GetMapping("/page/{current_page}/{page_size}")
    public Result get(@PathVariable Integer current_page,@PathVariable Integer page_size,
                      @RequestParam(required = false) String cateName,@RequestParam(required = false) Integer parentId)
    {
        ProductCate productCate = new ProductCate();
        productCate.setCateName(cateName);
        productCate.setParentId(parentId);

        Pageable pageable = PageRequest.of(current_page,page_size);

        Page<ProductCate> catePage = productService.getCatesPage(productCate,pageable);

        return Result.getDefaultSuccessResult(catePage);
    }

    @ApiOperation(value = "类别修改接口",notes = "带ID为修改，不带ID创建")
    @PostMapping("")
    public Result saveCate(@RequestBody ProductCate productCate)
    {
        if(StringUtils.isBlank(productCate.getCateName()))
            return new Result(new Status(201,"分类名不可以为空"));
        ProductCate cate = productService.saveCate(productCate);
        return Result.getDefaultSuccessResult(cate);
    }

}
