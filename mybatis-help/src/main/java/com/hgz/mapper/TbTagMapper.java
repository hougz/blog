package com.hgz.mapper;

import com.hgz.entity.TbTag;

public interface TbTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(TbTag record);

    int insertSelective(TbTag record);

    TbTag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(TbTag record);

    int updateByPrimaryKey(TbTag record);
}