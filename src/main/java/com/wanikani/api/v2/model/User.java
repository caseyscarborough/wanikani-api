package com.wanikani.api.v2.model;

import java.time.ZonedDateTime;

public class User {

    private String id;
    private String username;
    private Integer level;
    private ZonedDateTime startedAt;
    private boolean subscribed;
    private ZonedDateTime currentVacationStartedAt;
    private Integer maxLevelGrantedBySubscription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public ZonedDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(ZonedDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public ZonedDateTime getCurrentVacationStartedAt() {
        return currentVacationStartedAt;
    }

    public void setCurrentVacationStartedAt(ZonedDateTime currentVacationStartedAt) {
        this.currentVacationStartedAt = currentVacationStartedAt;
    }

    public Integer getMaxLevelGrantedBySubscription() {
        return maxLevelGrantedBySubscription;
    }

    public void setMaxLevelGrantedBySubscription(Integer maxLevelGrantedBySubscription) {
        this.maxLevelGrantedBySubscription = maxLevelGrantedBySubscription;
    }
}
