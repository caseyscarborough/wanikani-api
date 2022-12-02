package com.wanikani.api.v2.model;

import java.time.ZonedDateTime;
import java.util.List;

public class SummaryReview {

    private ZonedDateTime availableAt;
    private List<Integer> subjectIds;

    public ZonedDateTime getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(ZonedDateTime availableAt) {
        this.availableAt = availableAt;
    }

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<Integer> subjectIds) {
        this.subjectIds = subjectIds;
    }
}
