package com.hgz.mapper;

import com.hgz.entity.TbArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(TbArticle record);

    int insertSelective(TbArticle record);

    TbArticle selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(TbArticle record);

    int updateByPrimaryKeyWithBLOBs(TbArticle record);

    int updateByPrimaryKey(TbArticle record);

    List<TbArticle> page(TbArticle tbArticle);
}