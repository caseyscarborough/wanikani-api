package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Reset implements Identifiable {

    private Long id;
    private ZonedDateTime createdAt;
    private ZonedDateTime confirmedAt;
    private Integer originalLevel;
    private Integer targetLevel;
}
