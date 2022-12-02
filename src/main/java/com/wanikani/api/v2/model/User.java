package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class User {

    private String id;
    private String username;
    private Integer level;
    private ZonedDateTime startedAt;
    private boolean subscribed;
    private ZonedDateTime currentVacationStartedAt;
    private Integer maxLevelGrantedBySubscription;
}
