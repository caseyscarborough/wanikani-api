package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Assignment implements Identifiable {

    private Long id;
    private ZonedDateTime createdAt;
    private ZonedDateTime unlockedAt;
    private ZonedDateTime startedAt;
    private ZonedDateTime passedAt;
    private ZonedDateTime burnedAt;
    private ZonedDateTime availableAt;
    private ZonedDateTime resurrectedAt;
    private Long subjectId;
    private String subjectType;
    private Integer srsStage;
    private String srsStageName;
    private Boolean passed;
    private Boolean resurrected;
    private Boolean hidden;
}
