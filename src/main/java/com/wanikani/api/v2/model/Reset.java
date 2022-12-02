package com.wanikani.api.v2.model;

import java.time.ZonedDateTime;

public class Reset implements Identifiable {

    private Long id;
    private ZonedDateTime createdAt;
    private ZonedDateTime confirmedAt;
    private Integer originalLevel;
    private Integer targetLevel;

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

    public ZonedDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(ZonedDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public Integer getOriginalLevel() {
        return originalLevel;
    }

    public void setOriginalLevel(Integer originalLevel) {
        this.originalLevel = originalLevel;
    }

    public Integer getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(Integer targetLevel) {
        this.targetLevel = targetLevel;
    }
}
