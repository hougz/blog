package com.hgz.entity;

import java.util.Date;

public class TbTag {
    private Integer tagId;

    private String tagName;

    private Date createTime;

    private Date updateTime;

    public TbTag(Integer tagId, String tagName, Date createTime, Date updateTime) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbTag() {
        super();
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
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
}