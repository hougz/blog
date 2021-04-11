package com.hgz.dto;

import lombok.Data;

@Data
public class ArticlesAddDto {

    private Integer articleId;
    //文章标题
    private String articleTitle;
    //文章内容
    private String articleContent;
    //文章封面
    private String articleCover;
    //分类id
    private Integer categoryId;
    //标签
    private Integer[] tagIdList;
    //保存草稿
    private Integer isDraft;
    //是否置顶
    private Integer isTop;
}
