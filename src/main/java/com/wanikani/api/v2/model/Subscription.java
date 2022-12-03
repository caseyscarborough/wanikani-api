package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Subscription {
    private int maxLevelGranted;
    private boolean active;
    private ZonedDateTime periodEndsAt;
    private String type;
}
