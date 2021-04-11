package com.hgz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hgz.entity.TbUser;
import com.hgz.mapper.TbUserMapper;
import com.hgz.page.Pager;
import com.hgz.service.TbUserService;
import com.hgz.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public Pager<TbUser> findAll(int pageNum, int pageSize) {
        Page<TbUser> page = PageHelper.startPage(pageNum, pageSize);
        List<TbUser> list = tbUserMapper.findAll();
        return PageUtils.pageConver(page);
    }

    @Override
    public TbUser findById(int id) {
        return tbUserMapper.findById(id);
    }

    @Override
    public void insert(TbUser tbUser) {
        tbUserMapper.insert(tbUser);
    }

    @Override
    public void delete(int id) {
        tbUserMapper.delete(id);
    }

    @Override
    public void update(int id) {
        tbUserMapper.update(id);
    }

    @Override
    public TbUser findByName(String userName, String password) {
        return tbUserMapper.findByName(userName, password);
    }
}
