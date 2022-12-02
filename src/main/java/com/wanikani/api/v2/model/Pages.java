package com.wanikani.api.v2.model;

import lombok.Data;

@Data
public class Pages {

    private String nextUrl;
    private String previousUrl;
    private Integer perPage;
}
