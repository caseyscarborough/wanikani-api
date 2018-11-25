package com.wanikani.api.v2.model;

import java.util.Date;

public class LevelProgression implements Identifiable {

    private Long id;
    private Date createdAt;
    private Date unlockedAt;
    private Date startedAt;
    private Date passedAt;
    private Date completedAt;
    private Date abandonedAt;
    private Integer level;

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

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public Date getAbandonedAt() {
        return abandonedAt;
    }

    public void setAbandonedAt(Date abandonedAt) {
        this.abandonedAt = abandonedAt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
