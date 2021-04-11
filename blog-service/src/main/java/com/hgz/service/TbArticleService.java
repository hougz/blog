package com.hgz.service;

import com.hgz.dto.ArticlesAddDto;
import com.hgz.dto.ArticlesPageDto;
import com.hgz.entity.TbArticle;
import com.hgz.page.Pager;

public interface TbArticleService {


    void insert(ArticlesAddDto articlesAddDto);

    Pager<TbArticle> findAll(ArticlesPageDto pageDto);

    TbArticle findById(Integer id);
}
