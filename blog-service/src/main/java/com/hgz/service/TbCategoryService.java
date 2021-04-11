package com.hgz.service;

import com.hgz.dto.CategoryDto;
import com.hgz.dto.PageDto;
import com.hgz.entity.TbCategory;
import com.hgz.page.Pager;

import java.util.List;

public interface TbCategoryService {

    List<TbCategory> findAll();

    Pager<TbCategory> page(PageDto pagrDto);

    int insert(CategoryDto categoryDto);

    void delete(List<Integer> id);
}
