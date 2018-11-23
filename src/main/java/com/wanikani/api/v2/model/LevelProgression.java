package com.wanikani.api.v2.model;

public class LevelProgression implements Identifiable {

    private Long id;
    private String createdAt;
    private String unlockedAt;
    private String startedAt;
    private String passedAt;
    private String completedAt;
    private String abandonedAt;
    private Integer level;

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

    public String getUnlockedAt() {
        return unlockedAt;
    }

    public void setUnlockedAt(String unlockedAt) {
        this.unlockedAt = unlockedAt;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getPassedAt() {
        return passedAt;
    }

    public void setPassedAt(String passedAt) {
        this.passedAt = passedAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public String getAbandonedAt() {
        return abandonedAt;
    }

    public void setAbandonedAt(String abandonedAt) {
        this.abandonedAt = abandonedAt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
