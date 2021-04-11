package com.hgz.service;

import com.hgz.entity.TbUser;
import com.hgz.page.Pager;

public interface TbUserService {

    Pager<TbUser> findAll(int pageNum, int pageSize);

    TbUser findById(int id);

    void insert(TbUser tbUser);

    void delete(int id);

    void update(int id);

    TbUser findByName(String userName, String password);

}
