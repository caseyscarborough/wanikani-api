package com.wanikani.api.v2.model;

import java.util.Date;
import java.util.List;

import static com.wanikani.api.v2.util.DateUtils.getApiDate;

public class SummaryReview {

    private String availableAt;
    private List<Integer> subjectIds;

    public Date getAvailableAt() {
        return getApiDate(availableAt);
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
