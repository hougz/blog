package com.hgz.mapper;

import com.hgz.entity.TbArticleTag;

import java.util.List;

public interface TbArticleTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbArticleTag record);

    int insertSelective(TbArticleTag record);

    TbArticleTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbArticleTag record);

    int updateByPrimaryKey(TbArticleTag record);

    List<TbArticleTag> byArticleId(int articleId);

    void deleteByarticleId(Integer articleId);
}