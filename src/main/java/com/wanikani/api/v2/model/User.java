package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class User {

    private String id;
    private String username;
    private Integer level;
    private String profileUrl;
    private ZonedDateTime startedAt;
    private ZonedDateTime currentVacationStartedAt;
    private Preferences preferences;
    private Subscription subscription;
}
