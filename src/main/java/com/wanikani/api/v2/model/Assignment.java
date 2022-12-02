package com.wanikani.api.v2.model;

import java.time.LocalDateTime;

public class Assignment implements Identifiable {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime unlockedAt;
    private LocalDateTime startedAt;
    private LocalDateTime passedAt;
    private LocalDateTime burnedAt;
    private LocalDateTime availableAt;
    private LocalDateTime resurrectedAt;
    private Long subjectId;
    private String subjectType;
    private Integer srsStage;
    private String srsStageName;
    private Boolean passed;
    private Boolean resurrected;
    private Boolean hidden;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUnlockedAt() {
        return unlockedAt;
    }

    public void setUnlockedAt(LocalDateTime unlockedAt) {
        this.unlockedAt = unlockedAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getPassedAt() {
        return passedAt;
    }

    public void setPassedAt(LocalDateTime passedAt) {
        this.passedAt = passedAt;
    }

    public LocalDateTime getBurnedAt() {
        return burnedAt;
    }

    public void setBurnedAt(LocalDateTime burnedAt) {
        this.burnedAt = burnedAt;
    }

    public LocalDateTime getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(LocalDateTime availableAt) {
        this.availableAt = availableAt;
    }

    public LocalDateTime getResurrectedAt() {
        return resurrectedAt;
    }

    public void setResurrectedAt(LocalDateTime resurrectedAt) {
        this.resurrectedAt = resurrectedAt;
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

    public Integer getSrsStage() {
        return srsStage;
    }

    public void setSrsStage(Integer srsStage) {
        this.srsStage = srsStage;
    }

    public String getSrsStageName() {
        return srsStageName;
    }

    public void setSrsStageName(String srsStageName) {
        this.srsStageName = srsStageName;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public Boolean getResurrected() {
        return resurrected;
    }

    public void setResurrected(Boolean resurrected) {
        this.resurrected = resurrected;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
}
