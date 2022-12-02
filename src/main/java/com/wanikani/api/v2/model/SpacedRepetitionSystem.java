package com.wanikani.api.v2.model;

import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.util.List;

public class SpacedRepetitionSystem {
    private ZonedDateTime createdAt;
    private String name;
    private String description;
    private int unlockingStagePosition;
    private int startingStagePosition;
    private int passingStagePosition;
    private int burningStagePosition;
    private List<SrsStage> stages = new ArrayList<>();

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnlockingStagePosition() {
        return unlockingStagePosition;
    }

    public void setUnlockingStagePosition(int unlockingStagePosition) {
        this.unlockingStagePosition = unlockingStagePosition;
    }

    public int getStartingStagePosition() {
        return startingStagePosition;
    }

    public void setStartingStagePosition(int startingStagePosition) {
        this.startingStagePosition = startingStagePosition;
    }

    public int getPassingStagePosition() {
        return passingStagePosition;
    }

    public void setPassingStagePosition(int passingStagePosition) {
        this.passingStagePosition = passingStagePosition;
    }

    public int getBurningStagePosition() {
        return burningStagePosition;
    }

    public void setBurningStagePosition(int burningStagePosition) {
        this.burningStagePosition = burningStagePosition;
    }

    public List<SrsStage> getStages() {
        return stages;
    }

    public void setStages(List<SrsStage> stages) {
        this.stages = stages;
    }
}
