package com.wanikani.api.v2.model;

import java.time.LocalDateTime;
import java.util.List;

public class SummaryLesson {

    private LocalDateTime availableAt;
    private List<Integer> subjectIds;

    public LocalDateTime getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(LocalDateTime availableAt) {
        this.availableAt = availableAt;
    }

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<Integer> subjectIds) {
        this.subjectIds = subjectIds;
    }
}
