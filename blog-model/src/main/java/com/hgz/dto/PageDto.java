package com.hgz.dto;

import lombok.Data;

@Data
public class PageDto {

    private Integer size;

    private Integer current;

    private String keywords;
}
