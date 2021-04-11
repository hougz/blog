package com.hgz.service;

import com.hgz.entity.TbApi;

import java.util.List;

public interface TbApiService {

    int deleteByPrimaryKey(Integer id);

    int insert(TbApi record);

    int insertSelective(TbApi record);

    TbApi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbApi record);

    int updateByPrimaryKey(TbApi record);

    List<TbApi> page(TbApi tbApi);

}
