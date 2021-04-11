package com.hgz.mapper;

import com.hgz.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbUserMapper {

    TbUser findById(int id);

    TbUser findByName(@Param("name") String name, @Param("password") String password);

    List<TbUser> findAll();

    void insert(TbUser tbUser);

    void delete(int id);

    void update(int id);
}
