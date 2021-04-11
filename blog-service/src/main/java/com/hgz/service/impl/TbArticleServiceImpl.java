package com.hgz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hgz.dto.ArticlesAddDto;
import com.hgz.dto.ArticlesPageDto;
import com.hgz.dto.PageDto;
import com.hgz.entity.TbArticle;
import com.hgz.entity.TbArticleTag;
import com.hgz.entity.TbCategory;
import com.hgz.entity.TbTag;
import com.hgz.mapper.TbArticleMapper;
import com.hgz.mapper.TbArticleTagMapper;
import com.hgz.mapper.TbCategoryMapper;
import com.hgz.mapper.TbTagMapper;
import com.hgz.page.Pager;
import com.hgz.service.TbArticleService;
import com.hgz.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TbArticleServiceImpl implements TbArticleService {

    @Autowired
    private TbArticleMapper tbArticleMapper;

    @Autowired
    private TbArticleTagMapper tbArticleTagMapper;

    @Autowired
    private TbCategoryMapper tbCategoryMapper;

    @Autowired
    private TbTagMapper tbTagMapper;


    @Override
    public void insert(ArticlesAddDto articlesAddDto) {
        try {
            TbArticle tbArticle = new TbArticle();
            if (!StringUtils.isEmpty(articlesAddDto.getArticleContent()))
                tbArticle.setArticleContent(articlesAddDto.getArticleContent());
            if (!StringUtils.isEmpty(articlesAddDto.getArticleTitle()))
                tbArticle.setArticleTitle(articlesAddDto.getArticleTitle());
            if (!StringUtils.isEmpty(articlesAddDto.getCategoryId()))
                tbArticle.setCategoryId(articlesAddDto.getCategoryId());
            if (!StringUtils.isEmpty(articlesAddDto.getIsDraft()))
                tbArticle.setDraft(articlesAddDto.getIsDraft() == 1 ? true : false);
            if (!StringUtils.isEmpty(articlesAddDto.getIsTop()))
                tbArticle.setTop(articlesAddDto.getIsTop() == 1 ? true : false);
            tbArticle.setUpdateTime(new Date());
            if (StringUtils.isEmpty(articlesAddDto.getArticleId())) {
                tbArticle.setCreateTime(new Date());
                //新增
                tbArticleMapper.insert(tbArticle);
                Integer articleId = tbArticle.getArticleId();
                tbArticle.setArticleId(articleId);
            } else {
                //更新操作
                tbArticle.setArticleId(articlesAddDto.getArticleId());
                tbArticleMapper.updateByPrimaryKeySelective(tbArticle);
                tbArticleTagMapper.deleteByarticleId(tbArticle.getArticleId());
            }
            //标签维护
            Integer[] tagIdList = articlesAddDto.getTagIdList();
            for (Integer integer : tagIdList) {
                TbArticleTag tbArticleTag = new TbArticleTag();
                tbArticleTag.setTagId(integer);
                tbArticleTag.setArticleId(tbArticle.getArticleId());
                tbArticleTagMapper.insert(tbArticleTag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pager<TbArticle> findAll(ArticlesPageDto pageDto) {
        try {
            Page<TbArticle> page = PageHelper.startPage(pageDto.getCurrent(), pageDto.getSize() == null ? 20 : pageDto.getSize());
            TbArticle tbArticle = new TbArticle();
            if (pageDto.getArticleTitle() != null) tbArticle.setArticleTitle(pageDto.getArticleTitle());
            if (pageDto.getIsDraft() != null) tbArticle.setDraft(pageDto.getIsDraft() == 1 ? true : false);
            List<TbArticle> list = tbArticleMapper.page(tbArticle);
            Pager pager = PageUtils.pageConver(page);
            List<TbArticle> result = page.getResult();
            for (int i = 0; i < result.size(); i++) {
                TbArticle tbArticle1 = result.get(i);
                //获取分类
                TbCategory tbCategory = tbCategoryMapper.selectByPrimaryKey(tbArticle1.getCategoryId());
                tbArticle1.setCategoryName(tbCategory.getCategoryName());
                //获取标签
                List<TbArticleTag> tbArticleTags = tbArticleTagMapper.byArticleId(tbArticle1.getArticleId());
                List<TbTag> listTag = new ArrayList<>();
                for (TbArticleTag a : tbArticleTags) {
                    TbTag tbTag = tbTagMapper.selectByPrimaryKey(a.getTagId());
                    listTag.add(tbTag);
                }
                tbArticle1.setTagDTOList(listTag);
            }
            return PageUtils.pageConver(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TbArticle findById(Integer id) {
        TbArticle tbArticle = tbArticleMapper.selectByPrimaryKey(id);
        //获取分类
        TbCategory tbCategory = tbCategoryMapper.selectByPrimaryKey(tbArticle.getCategoryId());
        tbArticle.setCategoryName(tbCategory.getCategoryName());
        //获取标签
        List<TbArticleTag> tbArticleTags = tbArticleTagMapper.byArticleId(tbArticle.getArticleId());
        List<TbTag> listTag = new ArrayList<>();
        for (TbArticleTag a : tbArticleTags) {
            TbTag tbTag = tbTagMapper.selectByPrimaryKey(a.getTagId());
            listTag.add(tbTag);
        }
        tbArticle.setTagDTOList(listTag);
        return tbArticle;
    }
}
