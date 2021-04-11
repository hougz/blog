package com.hgz.mapper;

import com.hgz.entity.TbTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(TbTag record);

    int insertSelective(TbTag record);

    TbTag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(TbTag record);

    int updateByPrimaryKey(TbTag record);

    List<TbTag> findAll();

    List<TbTag> page(String tagName);
}