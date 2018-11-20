package com.kokoyuo.mall.manager.modules.product.controller;

import com.alibaba.fastjson.JSONObject;
import com.kokoyuo.mall.manager.modules.product.entity.ProductInfo;
import com.kokoyuo.mall.manager.modules.product.entity.ProductSku;
import com.kokoyuo.mall.manager.modules.product.service.ProductService;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import com.kokoyuo.mall.manager.modules.sys.pojo.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kokoyuo
 * Created on 2018/11/6.
 */
@Api(value = "产品相关接口",description = "产品相关接口")
@RequestMapping("/product")
@RestController
public class ProductInfoController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取产品列表信息",notes = "获取产品列表信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "current_page",paramType = "path",value = "当前页",dataType = "Integer"),
                    @ApiImplicitParam(name = "page_size",paramType = "path",value = "页面大小",dataType = "Integer"),
                    @ApiImplicitParam(name = "name",paramType = "query",value = "产品名",dataType = "String"),
                    @ApiImplicitParam(name = "fullName",paramType = "query",value = "产品全名",dataType = "String"),
                    @ApiImplicitParam(name = "isSale",paramType = "query",value = "是否上架",dataType = "Integer"),
                    @ApiImplicitParam(name = "sort",paramType = "query",value = "排序字段名",dataType = "String"),
            })
    @GetMapping("/page/{current_page}/{page_size}")
    public Result getProductList(@PathVariable Integer current_page, @PathVariable Integer page_size,
                                 @RequestParam(required = false) String name,@RequestParam(required = false) String fullName,
                                 @RequestParam(required = false) Integer isSale, @RequestParam(required = false) String sort)
    {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setName(name);
        productInfo.setFullName(fullName);
        productInfo.setIsSale(isSale);

        Pageable pageable = PageRequest.of(current_page,page_size, Sort.by(Sort.Direction.DESC,sort));

        Page<ProductInfo> page = productService.getProductPage(productInfo,pageable);
        return Result.getDefaultSuccessResult(page);
    }

    @ApiOperation(value = "获取单个产品组详情",notes = "获取单个产品组详情,包含其属性")
    @ApiImplicitParam(name = "id",paramType = "path",value = "商品id",dataType = "Integer")
    @GetMapping("/info/{id}")
    public Result getProductInfo(@PathVariable Integer id)
    {
        ProductInfo productInfo = productService.getProductInfo(id);

        if(productInfo==null)
            return new Result(new Status(201,"产品信息为空"));

        /*获取SKU 信息*/
        List<ProductSku> skus = productService.getSkus(id);

        /*转换成JSONOBJ*/
        List<JSONObject> skusObj = skus.parallelStream()
                .map(productSku -> JSONObject.parseObject(JSONObject.toJSONString(productSku)))
                .collect(Collectors.toList());

        /*获取产品属性信息*/
        List<Map<String,Object>> productCates = productService.getProductCatesByProductId(id);

        /*将属性按sku-id 分类*/
        Map<Object,List<Map<String,Object>>> productCatesGroup = productCates.parallelStream().collect(Collectors.groupingBy(o -> o.get("SKU_ID")));

        /*将sku 的属性组装到 skusObj*/
        skusObj.forEach(jsonObject -> jsonObject.put("cates",productCatesGroup.getOrDefault(jsonObject.getInteger("id"),null)));

        JSONObject proJo = JSONObject.parseObject(JSONObject.toJSONString(productInfo));
        proJo.put("skus",skusObj);

        return Result.getDefaultSuccessResult(proJo);
    }

    @PostMapping("")
    public Result saveProduct(@RequestBody ProductInfo productInfo)
    {
        productService.saveProductInfo(productInfo);
        return Result.SUCCESS_INSTANCE;
    }

}
