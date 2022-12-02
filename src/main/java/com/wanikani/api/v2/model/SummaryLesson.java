package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class SummaryLesson {

    private ZonedDateTime availableAt;
    private List<Integer> subjectIds;
}
