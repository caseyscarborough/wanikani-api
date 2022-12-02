package com.wanikani.api.v2.model;

import java.time.LocalDateTime;

public class Resource<T> {

    private Long id;
    private String object;
    private String url;
    private LocalDateTime dataUpdatedAt;
    private Integer totalCount;
    private Pages pages;
    private T data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDataUpdatedAt() {
        return dataUpdatedAt;
    }

    public void setDataUpdatedAt(LocalDateTime dataUpdatedAt) {
        this.dataUpdatedAt = dataUpdatedAt;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
