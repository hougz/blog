package com.hgz.controller;

import com.hgz.dto.CategoryDto;
import com.hgz.dto.PageDto;
import com.hgz.dto.TagDto;
import com.hgz.entity.TbTag;
import com.hgz.page.Pager;
import com.hgz.result.Result;
import com.hgz.result.ResultResponse;
import com.hgz.service.TbTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "3.标签管理")
@RestController
@RequestMapping({"/admin/tags","/tags"})
public class TagController {

    @Autowired
    private TbTagService tbTagService;

    @ApiOperation("标签列表")
    @GetMapping
    public Result<?> page(PageDto pageDto) {
        try {
            Pager<TbTag> pager = tbTagService.page(pageDto);
            return ResultResponse.makeOKRsp(pager);
        } catch (Exception e) {
            return ResultResponse.makeErrRsp("处理异常");
        }
    }

    @ApiOperation("新增")
    @PostMapping
    public Result<?> add(@RequestBody TagDto tagDto) {
        try {
            tbTagService.insert(tagDto);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            return ResultResponse.makeErrRsp("处理异常");
        }
    }

    @ApiOperation("删除")
    @DeleteMapping
    public Result<?> delete(@RequestBody List<Integer> ids) {
        try {
            tbTagService.delete(ids);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            return ResultResponse.makeErrRsp("处理异常");
        }
    }
}
