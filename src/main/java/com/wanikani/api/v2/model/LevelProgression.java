package com.wanikani.api.v2.model;

import java.time.ZonedDateTime;

public class LevelProgression implements Identifiable {

    private Long id;
    private ZonedDateTime createdAt;
    private ZonedDateTime unlockedAt;
    private ZonedDateTime startedAt;
    private ZonedDateTime passedAt;
    private ZonedDateTime completedAt;
    private ZonedDateTime abandonedAt;
    private Integer level;

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

    public ZonedDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(ZonedDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public ZonedDateTime getAbandonedAt() {
        return abandonedAt;
    }

    public void setAbandonedAt(ZonedDateTime abandonedAt) {
        this.abandonedAt = abandonedAt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
