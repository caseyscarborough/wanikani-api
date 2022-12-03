package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class LevelProgression implements Identifiable {

    private Long id;
    private ZonedDateTime createdAt;
    private ZonedDateTime unlockedAt;
    private ZonedDateTime startedAt;
    private ZonedDateTime passedAt;
    private ZonedDateTime completedAt;
    private ZonedDateTime abandonedAt;
    private int level;
}
