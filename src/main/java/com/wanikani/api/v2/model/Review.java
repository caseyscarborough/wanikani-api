package com.wanikani.api.v2.model;

import com.wanikani.api.v2.util.DateUtils;

import java.util.Date;
import java.util.Objects;

public class Review {

    private Long id;
    private Date createdAt;
    private Long assignmentId;
    private Integer subjectId;
    private Integer startingSrsStage;
    private String startingSrsStageName;
    private Integer endingSrsStage;
    private String endingSrsStageName;
    private Integer incorrectMeaningAnswers;
    private Integer incorrectReadingAnswers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        if (createdAt.contains("T")) {
            this.createdAt = DateUtils.getApiDate(createdAt);
        } else {
            this.createdAt = new Date(Long.parseLong(createdAt));
        }
    }

    public void setCreatedAt(Date createdAt) {
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
