package com.hgz.entity;

public class TbApi {
    private Integer id;

    private Integer apiId;

    private String name;

    private String url;

    private String method;

    private Integer pid;

    private String description;

    private String sort;

    public TbApi(Integer id, Integer apiId, String name, String url, String method, Integer pid, String description, String sort) {
        this.id = id;
        this.apiId = apiId;
        this.name = name;
        this.url = url;
        this.method = method;
        this.pid = pid;
        this.description = description;
        this.sort = sort;
    }

    public TbApi() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }
}