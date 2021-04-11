package com.hgz.dto;

import lombok.Data;

@Data
public class ArticlesPageDto {

//current=1&size=10&isDelete=0&isDraft=0
    private Integer size;

    private Integer current;

   private Integer isDelete;

    private Integer isDraft;

    private String articleTitle;
}
