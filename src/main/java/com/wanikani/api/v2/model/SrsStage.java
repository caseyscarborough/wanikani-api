package com.wanikani.api.v2.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class SrsStage {

    private Integer interval;
    private int position;
    @JsonDeserialize(using = IntervalUnit.Deserializer.class)
    private IntervalUnit intervalUnit;

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public IntervalUnit getIntervalUnit() {
        return intervalUnit;
    }

    public void setIntervalUnit(IntervalUnit intervalUnit) {
        this.intervalUnit = intervalUnit;
    }
}
