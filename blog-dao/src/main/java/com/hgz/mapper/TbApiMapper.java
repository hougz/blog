package com.hgz.mapper;


import com.hgz.entity.TbApi;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbApiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbApi record);

    int insertSelective(TbApi record);

    TbApi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbApi record);

    int updateByPrimaryKey(TbApi record);

    List<TbApi> page(TbApi tbApi);
}