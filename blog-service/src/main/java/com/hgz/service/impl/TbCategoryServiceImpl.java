package com.hgz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hgz.dto.CategoryDto;
import com.hgz.dto.PageDto;
import com.hgz.entity.TbCategory;
import com.hgz.mapper.TbCategoryMapper;
import com.hgz.page.Pager;
import com.hgz.service.TbCategoryService;
import com.hgz.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbCategoryServiceImpl implements TbCategoryService {

    @Autowired
    private TbCategoryMapper tbCategoryMapper;

    /**
     * 获取所有分类
     *
     * @return
     */
    @Override
    public List<TbCategory> findAll() {
        return tbCategoryMapper.findAll();
    }

    @Override
    public Pager<TbCategory> page(PageDto pagrDto) {
        if (pagrDto.getCurrent() == null) pagrDto.setCurrent(1);
        if (pagrDto.getSize() == null) pagrDto.setSize(50);
        Page<Object> page = PageHelper.startPage(pagrDto.getCurrent(), pagrDto.getSize());
        List<TbCategory> list = tbCategoryMapper.page(pagrDto.getKeywords());
        return PageUtils.pageConver(page);
    }

    @Override
    public int insert(CategoryDto categoryDto) {
        Integer i;
        if (categoryDto.getId() != null && categoryDto.getId() == 0) {
            //表示添加
            TbCategory tbCategory = new TbCategory();
            tbCategory.setCategoryName(categoryDto.getCategoryName());
            tbCategory.setCreateTime(new Date());
            tbCategory.setUpdateTime(new Date());
            i = tbCategoryMapper.insert(tbCategory);
        } else {
            //修改
            TbCategory tbCategory = new TbCategory();
            tbCategory.setCategoryId(categoryDto.getCategoryId());
            tbCategory.setCategoryName(categoryDto.getCategoryName());
            tbCategory.setUpdateTime(new Date());
            i = tbCategoryMapper.updateByPrimaryKeySelective(tbCategory);
        }
        return i;
    }

    @Override
    public void delete(List<Integer> ids) {
        for (int i = 0; i < ids.size(); i++) {
            tbCategoryMapper.deleteByPrimaryKey(ids.get(i));
        }
    }
}
