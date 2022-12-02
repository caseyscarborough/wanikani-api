package com.wanikani.api.v2.model;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Review implements Identifiable {

    private Long id;
    private ZonedDateTime createdAt;
    private Long assignmentId;
    private Integer subjectId;
    private Integer startingSrsStage;
    private String startingSrsStageName;
    private Integer endingSrsStage;
    private String endingSrsStageName;
    private Integer incorrectMeaningAnswers;
    private Integer incorrectReadingAnswers;

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

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getStartingSrsStage() {
        return startingSrsStage;
    }

    public void setStartingSrsStage(Integer startingSrsStage) {
        this.startingSrsStage = startingSrsStage;
    }

    public String getStartingSrsStageName() {
        return startingSrsStageName;
    }

    public void setStartingSrsStageName(String startingSrsStageName) {
        this.startingSrsStageName = startingSrsStageName;
    }

    public Integer getEndingSrsStage() {
        return endingSrsStage;
    }

    public void setEndingSrsStage(Integer endingSrsStage) {
        this.endingSrsStage = endingSrsStage;
    }

    public String getEndingSrsStageName() {
        return endingSrsStageName;
    }

    public void setEndingSrsStageName(String endingSrsStageName) {
        this.endingSrsStageName = endingSrsStageName;
    }

    public Integer getIncorrectMeaningAnswers() {
        return incorrectMeaningAnswers;
    }

    public void setIncorrectMeaningAnswers(Integer incorrectMeaningAnswers) {
        this.incorrectMeaningAnswers = incorrectMeaningAnswers;
    }

    public Integer getIncorrectReadingAnswers() {
        return incorrectReadingAnswers;
    }

    public void setIncorrectReadingAnswers(Integer incorrectReadingAnswers) {
        this.incorrectReadingAnswers = incorrectReadingAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
