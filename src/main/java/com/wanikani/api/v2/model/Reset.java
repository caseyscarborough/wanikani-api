package com.wanikani.api.v2.model;

import java.util.Date;

public class Reset implements Identifiable {

    private Long id;
    private Date createdAt;
    private Date confirmedAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
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
