package com.wanikani.api.v2.model;

import java.util.Date;

public class Assignment implements Identifiable {

    private Long id;
    private Date createdAt;
    private Date unlockedAt;
    private Date startedAt;
    private Date passedAt;
    private Date burnedAt;
    private Date availableAt;
    private Date resurrectedAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUnlockedAt() {
        return unlockedAt;
    }

    public void setUnlockedAt(Date unlockedAt) {
        this.unlockedAt = unlockedAt;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getPassedAt() {
        return passedAt;
    }

    public void setPassedAt(Date passedAt) {
        this.passedAt = passedAt;
    }

    public Date getBurnedAt() {
        return burnedAt;
    }

    public void setBurnedAt(Date burnedAt) {
        this.burnedAt = burnedAt;
    }

    public Date getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(Date availableAt) {
        this.availableAt = availableAt;
    }

    public Date getResurrectedAt() {
        return resurrectedAt;
    }

    public void setResurrectedAt(Date resurrectedAt) {
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
