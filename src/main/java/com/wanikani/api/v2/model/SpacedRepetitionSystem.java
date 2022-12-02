package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class SpacedRepetitionSystem {
    private ZonedDateTime createdAt;
    private String name;
    private String description;
    private int unlockingStagePosition;
    private int startingStagePosition;
    private int passingStagePosition;
    private int burningStagePosition;
    private List<SrsStage> stages = new ArrayList<>();
}
