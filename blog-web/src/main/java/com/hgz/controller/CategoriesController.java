package com.hgz.controller;

import com.hgz.dto.CategoryDto;
import com.hgz.dto.PageDto;
import com.hgz.entity.TbCategory;
import com.hgz.page.Pager;
import com.hgz.result.Result;
import com.hgz.result.ResultResponse;
import com.hgz.service.TbCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "2.分类管理")
@RestController
@RequestMapping({"/admin/categories","/categories"})
public class CategoriesController {


    @Autowired
    private TbCategoryService tbCategoryService;

    @ApiOperation("分类列表")
    @GetMapping
    public Result<?> page(PageDto pageDto) {
        try {
            Pager<TbCategory> pager = tbCategoryService.page(pageDto);
            return ResultResponse.makeOKRsp(pager);
        } catch (Exception e) {
            return ResultResponse.makeErrRsp("处理异常");
        }
    }

    @ApiOperation("新增")
    @PostMapping
    public Result<?> add(@RequestBody CategoryDto categoryDto) {
        try {
            tbCategoryService.insert(categoryDto);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            return ResultResponse.makeErrRsp("处理异常");
        }
    }

    @ApiOperation("删除")
    @DeleteMapping
    public Result<?> delete(@RequestBody List<Integer> ids) {
        try {
            tbCategoryService.delete(ids);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            return ResultResponse.makeErrRsp("处理异常");
        }
    }

}
