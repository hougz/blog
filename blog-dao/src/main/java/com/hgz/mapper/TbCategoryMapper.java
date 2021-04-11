package com.hgz.mapper;
import com.hgz.entity.TbCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TbCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(TbCategory record);

    int insertSelective(TbCategory record);

    TbCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(TbCategory record);

    int updateByPrimaryKey(TbCategory record);

    List<TbCategory> findAll();

    List<TbCategory> page(String catgoryName);
}