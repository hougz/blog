package com.hgz.entity;

import java.util.Date;
import java.util.List;

public class TbArticle {
    private Integer articleId;

    private String articleTitle;

    private String articleCover;

    private Integer categoryId;

    private Boolean isTop;

    private Boolean isDraft;

    private Date createTime;

    private Date updateTime;

    private String articleContent;

    private String categoryName;

    private List<TbTag> tagDTOList;

    public TbArticle() {
    }

    public TbArticle(Integer articleId, String articleTitle, String articleCover, Integer categoryId, Boolean isTop, Boolean isDraft, Date createTime, Date updateTime, String articleContent) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleCover = articleCover;
        this.categoryId = categoryId;
        this.isTop = isTop;
        this.isDraft = isDraft;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.articleContent = articleContent;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public Boolean getDraft() {
        return isDraft;
    }

    public void setDraft(Boolean draft) {
        isDraft = draft;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<TbTag> getTagDTOList() {
        return tagDTOList;
    }

    public void setTagDTOList(List<TbTag> tagDTOList) {
        this.tagDTOList = tagDTOList;
    }
}