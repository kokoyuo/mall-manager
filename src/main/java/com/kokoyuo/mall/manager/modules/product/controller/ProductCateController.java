package com.kokoyuo.mall.manager.modules.product.controller;

import com.kokoyuo.mall.manager.modules.product.entity.ProductCate;
import com.kokoyuo.mall.manager.modules.product.service.ProductService;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import io.swagger.annotations.Api;
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

    @GetMapping("/page/{current_page}/{page_size}")
    public Result get(@PathVariable Integer current_page,@PathVariable Integer page_size,
                      @RequestParam String cateName,@RequestParam Integer parentId)
    {
        ProductCate productCate = new ProductCate();
        productCate.setCateName(cateName);
        productCate.setParentId(parentId);

        Pageable pageable = PageRequest.of(current_page,page_size);

        Page<ProductCate> catePage = productService.getCatesPage(productCate,pageable);

        return Result.getDefaultSuccessResult(catePage);
    }

    @PostMapping
    public Result saveCate(@RequestBody ProductCate productCate)
    {
        productService.saveCate(productCate);
        return Result.SUCCESS_INSTANCE;
    }

}
