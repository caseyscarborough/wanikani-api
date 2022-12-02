package com.wanikani.api.v2.model;

import java.time.ZonedDateTime;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getMeaningCorrect() {
        return meaningCorrect;
    }

    public void setMeaningCorrect(Integer meaningCorrect) {
        this.meaningCorrect = meaningCorrect;
    }

    public Integer getMeaningIncorrect() {
        return meaningIncorrect;
    }

    public void setMeaningIncorrect(Integer meaningIncorrect) {
        this.meaningIncorrect = meaningIncorrect;
    }

    public Integer getMeaningMaxStreak() {
        return meaningMaxStreak;
    }

    public void setMeaningMaxStreak(Integer meaningMaxStreak) {
        this.meaningMaxStreak = meaningMaxStreak;
    }

    public Integer getMeaningCurrentStreak() {
        return meaningCurrentStreak;
    }

    public void setMeaningCurrentStreak(Integer meaningCurrentStreak) {
        this.meaningCurrentStreak = meaningCurrentStreak;
    }

    public Integer getReadingCorrect() {
        return readingCorrect;
    }

    public void setReadingCorrect(Integer readingCorrect) {
        this.readingCorrect = readingCorrect;
    }

    public Integer getReadingIncorrect() {
        return readingIncorrect;
    }

    public void setReadingIncorrect(Integer readingIncorrect) {
        this.readingIncorrect = readingIncorrect;
    }

    public Integer getReadingMaxStreak() {
        return readingMaxStreak;
    }

    public void setReadingMaxStreak(Integer readingMaxStreak) {
        this.readingMaxStreak = readingMaxStreak;
    }

    public Integer getReadingCurrentStreak() {
        return readingCurrentStreak;
    }

    public void setReadingCurrentStreak(Integer readingCurrentStreak) {
        this.readingCurrentStreak = readingCurrentStreak;
    }

    public Integer getPercentageCorrect() {
        return percentageCorrect;
    }

    public void setPercentageCorrect(Integer percentageCorrect) {
        this.percentageCorrect = percentageCorrect;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
}
