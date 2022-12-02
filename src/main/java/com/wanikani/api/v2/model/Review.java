package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Review implements Identifiable {

    private Long id;
    private ZonedDateTime createdAt;
    private Long assignmentId;
    private Integer subjectId;
    private Integer startingSrsStage;
    private String startingSrsStageName;
    private Integer endingSrsStage;
    private String endingSrsStageName;
    private Integer incorrectMeaningAnswers;
    private Integer incorrectReadingAnswers;
}
