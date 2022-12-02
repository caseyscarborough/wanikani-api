package com.wanikani.api.v2.model;

import lombok.Data;

@Data
public class Reading {

    private String type;
    private boolean primary;
    private String reading;
    private boolean acceptedAnswer;
}
