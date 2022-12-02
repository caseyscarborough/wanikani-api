package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Resource<T> {

    private Long id;
    private String object;
    private String url;
    private ZonedDateTime dataUpdatedAt;
    private Integer totalCount;
    private Pages pages;
    private T data;
}
