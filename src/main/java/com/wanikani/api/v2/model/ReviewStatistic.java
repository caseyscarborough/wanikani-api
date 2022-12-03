package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ReviewStatistic implements Identifiable {
    private Long id;
    private ZonedDateTime createdAt;
    private Long subjectId;
    private String subjectType;
    private int meaningCorrect;
    private int meaningIncorrect;
    private int meaningMaxStreak;
    private int meaningCurrentStreak;
    private int readingCorrect;
    private int readingIncorrect;
    private int readingMaxStreak;
    private int readingCurrentStreak;
    private int percentageCorrect;
    private boolean hidden;
}
