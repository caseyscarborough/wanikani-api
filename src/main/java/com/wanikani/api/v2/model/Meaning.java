package com.wanikani.api.v2.model;

import lombok.Data;

@Data
public class Meaning {

    private String meaning;
    private boolean primary;
    private boolean acceptedAnswer;
}
