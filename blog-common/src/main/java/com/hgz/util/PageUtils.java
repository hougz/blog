package com.hgz.util;

import com.github.pagehelper.Page;
import com.hgz.page.Pager;

/**
 * 分页工具
 */
public class PageUtils {

    public static Pager pageConver(Page page) {
        Pager pager = new Pager();
        pager.setCount(page.getTotal());
        pager.setCurrent(page.getPageNum());
        pager.setSize(page.getPageSize());
        pager.setRecordList(page.getResult());
        return pager;
    }

}
