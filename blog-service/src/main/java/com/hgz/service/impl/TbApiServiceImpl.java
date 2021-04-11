package com.hgz.service.impl;

import com.hgz.entity.TbApi;
import com.hgz.mapper.TbApiMapper;
import com.hgz.service.TbApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbApiServiceImpl implements TbApiService {

    @Autowired
    private TbApiMapper tbApiMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tbApiMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TbApi record) {
        return tbApiMapper.insert(record);
    }

    @Override
    public int insertSelective(TbApi record) {
        return tbApiMapper.insertSelective(record);
    }

    @Override
    public TbApi selectByPrimaryKey(Integer id) {
        return tbApiMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbApi record) {
        return tbApiMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbApi record) {
        return tbApiMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbApi> page(TbApi tbApi) {
        return tbApiMapper.page(tbApi);
    }
}
