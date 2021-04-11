package com.hgz.page;

import lombok.Data;

import java.util.List;
@Data
public class Pager<T> {

    private int current;//分页起始页
    private int size;//每页记录数
    private long count;//总记录条数
    private List<T> recordList;//返回的记录集合


}
