package com.hgz.service;

import com.hgz.dto.PageDto;
import com.hgz.dto.TagDto;
import com.hgz.entity.TbTag;
import com.hgz.page.Pager;

import java.util.List;

public interface TbTagService {

    List<TbTag> findAll();

    Pager<TbTag> page(PageDto pagrDto);

    void insert(TagDto tagDto);

    void delete(List<Integer> id);
}
