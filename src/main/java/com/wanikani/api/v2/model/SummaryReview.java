package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class SummaryReview {

    private ZonedDateTime availableAt;
    private List<Integer> subjectIds;
}
