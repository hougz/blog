package com.hgz.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticlesDto {

    private List<CategoryDto> categoryDTOList;

    private List<TagDto> tagDTOList;
}
