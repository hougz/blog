package com.hgz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hgz.dto.PageDto;
import com.hgz.dto.TagDto;
import com.hgz.entity.TbTag;
import com.hgz.mapper.TbTagMapper;
import com.hgz.page.Pager;
import com.hgz.service.TbTagService;
import com.hgz.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbTagServiceImpl implements TbTagService {

    @Autowired
    private TbTagMapper tbTagMapper;

    /**
     * 标签列表
     *
     * @return
     */
    @Override
    public List<TbTag> findAll() {
        return tbTagMapper.findAll();
    }

    @Override
    public Pager<TbTag> page(PageDto tagDto) {
        if (tagDto.getCurrent() == null) tagDto.setCurrent(1);
        if (tagDto.getSize() == null) tagDto.setSize(50);
        Page<Object> page = PageHelper.startPage(tagDto.getCurrent(), tagDto.getSize());
        tbTagMapper.page(tagDto.getKeywords());
        return PageUtils.pageConver(page);
    }

    @Override
    public void insert(TagDto tagDto) {
        if (tagDto.getTagId() == null) {
            //新增
            TbTag tbTag = new TbTag();
            tbTag.setTagName(tagDto.getTagName());
            tbTag.setCreateTime(new Date());
            tbTag.setUpdateTime(new Date());
            tbTagMapper.insert(tbTag);
        } else {
            //修改
            TbTag tbTag = new TbTag();
            tbTag.setTagName(tagDto.getTagName());
            tbTag.setTagId(tagDto.getTagId());
            tbTag.setUpdateTime(new Date());
            tbTagMapper.updateByPrimaryKeySelective(tbTag);
        }
    }

    @Override
    public void delete(List<Integer> ids) {
        for (Integer id : ids) {
            tbTagMapper.deleteByPrimaryKey(id);
        }
    }
}
