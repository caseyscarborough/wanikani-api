package com.wanikani.api.v2.model;

import java.util.Date;
import java.util.List;

public class SummaryReview {

    private Date availableAt;
    private List<Integer> subjectIds;

    public Date getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(Date availableAt) {
        this.availableAt = availableAt;
    }

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<Integer> subjectIds) {
        this.subjectIds = subjectIds;
    }
}
