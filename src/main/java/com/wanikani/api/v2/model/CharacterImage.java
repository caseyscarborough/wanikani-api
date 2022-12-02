package com.wanikani.api.v2.model;

import lombok.Data;

@Data
public class CharacterImage {

    private String contentType;
    private String url;
    private Metadata metadata;
}
