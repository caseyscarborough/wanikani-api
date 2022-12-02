package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ReviewStatistic implements Identifiable {
    private Long id;
    private ZonedDateTime createdAt;
    private Long subjectId;
    private String subjectType;
    private Integer meaningCorrect;
    private Integer meaningIncorrect;
    private Integer meaningMaxStreak;
    private Integer meaningCurrentStreak;
    private Integer readingCorrect;
    private Integer readingIncorrect;
    private Integer readingMaxStreak;
    private Integer readingCurrentStreak;
    private Integer percentageCorrect;
    private Boolean hidden;
}
