package com.hgz.controller;

import com.hgz.dto.*;
import com.hgz.entity.TbArticle;
import com.hgz.entity.TbCategory;
import com.hgz.entity.TbTag;
import com.hgz.page.Pager;
import com.hgz.result.Result;
import com.hgz.result.ResultResponse;
import com.hgz.service.TbArticleService;
import com.hgz.service.TbCategoryService;
import com.hgz.service.TbTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "1.文章管理")
@RestController
@RequestMapping({"/admin/articles", "/articles/archives","/articles"})
public class ArticlesController {

    @Autowired
    private TbCategoryService tbCategoryService;

    @Autowired
    private TbTagService tbTagService;

    @Autowired
    private TbArticleService tbArticleService;

    @ApiOperation("文章添加")
    @PostMapping
    public Result<?> categoryList(@RequestBody ArticlesAddDto articlesAddDto) {
        tbArticleService.insert(articlesAddDto);
        return ResultResponse.makeOKRsp();
    }

    @ApiOperation("文章列表")
    @GetMapping
    public Result<?> page(ArticlesPageDto pageDto) {
        try {
            Pager<TbArticle> pager = tbArticleService.findAll(pageDto);
            return ResultResponse.makeOKRsp(pager);
        } catch (Exception e) {
            return ResultResponse.makeErrRsp("处理异常");
        }
    }

    @ApiOperation("分类列表")
    @GetMapping("/{id}")
    public Result<?> categoryList(@PathVariable Integer id) {
        TbArticle tbArticle = tbArticleService.findById(id);
        return ResultResponse.makeOKRsp(tbArticle);
    }


    @ApiOperation("分类列表")
    @GetMapping("/options")
    public Result<?> categoryList() {
        ArticlesDto articlesDto = new ArticlesDto();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<TbCategory> categoryList = tbCategoryService.findAll();
        for (int i = 0; i < categoryList.size(); i++) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(categoryList.get(i).getCategoryId());
            categoryDto.setCategoryName(categoryList.get(i).getCategoryName());
            categoryDtoList.add(categoryDto);
        }
        //标签
        List<TagDto> tagDtoList = new ArrayList<>();
        List<TbTag> tagList = tbTagService.findAll();
        for (TbTag tbTag : tagList) {
            TagDto tagDto = new TagDto();
            tagDto.setId(tbTag.getTagId());
            tagDto.setTagName(tbTag.getTagName());
            tagDtoList.add(tagDto);
        }
        articlesDto.setCategoryDTOList(categoryDtoList);
        articlesDto.setTagDTOList(tagDtoList);
        return ResultResponse.makeOKRsp(articlesDto);
    }

}
