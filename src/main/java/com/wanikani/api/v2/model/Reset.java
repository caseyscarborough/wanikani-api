package com.wanikani.api.v2.model;

public class Reset implements Identifiable {

    private Long id;
    private String createdAt;
    private String confirmedAt;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(String confirmedAt) {
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
