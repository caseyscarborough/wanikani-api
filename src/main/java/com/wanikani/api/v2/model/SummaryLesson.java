package com.wanikani.api.v2.model;

import java.util.List;

public class SummaryLesson {

    private String availableAt;
    private List<Integer> subjectIds;

    public String getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(String availableAt) {
        this.availableAt = availableAt;
    }

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<Integer> subjectIds) {
        this.subjectIds = subjectIds;
    }
}
