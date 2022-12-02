package com.wanikani.api.v2.model;

import java.time.ZonedDateTime;

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

    public ZonedDateTime getUnlockedAt() {
        return unlockedAt;
    }

    public void setUnlockedAt(ZonedDateTime unlockedAt) {
        this.unlockedAt = unlockedAt;
    }

    public ZonedDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(ZonedDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public ZonedDateTime getPassedAt() {
        return passedAt;
    }

    public void setPassedAt(ZonedDateTime passedAt) {
        this.passedAt = passedAt;
    }

    public ZonedDateTime getBurnedAt() {
        return burnedAt;
    }

    public void setBurnedAt(ZonedDateTime burnedAt) {
        this.burnedAt = burnedAt;
    }

    public ZonedDateTime getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(ZonedDateTime availableAt) {
        this.availableAt = availableAt;
    }

    public ZonedDateTime getResurrectedAt() {
        return resurrectedAt;
    }

    public void setResurrectedAt(ZonedDateTime resurrectedAt) {
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
