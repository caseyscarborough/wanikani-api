package com.wanikani.api.v2.model;

public class SrsStage {

    private Integer srsStage;
    private String srsStageName;
    private Long interval;
    private Long acceleratedInterval;

    public Integer getSrsStage() {
        return srsStage;
    }

    public void setSrsStage(Integer srsStage) {
        this.srsStage = srsStage;
    }

    public String getSrsStageName() {
        return srsStageName;
    }

    public void setSrsStageName(String srsStageName) {
        this.srsStageName = srsStageName;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public Long getAcceleratedInterval() {
        return acceleratedInterval;
    }

    public void setAcceleratedInterval(Long acceleratedInterval) {
        this.acceleratedInterval = acceleratedInterval;
    }
}
