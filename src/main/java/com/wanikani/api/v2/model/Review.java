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
    private Integer endingSrsStage;
    private Integer incorrectMeaningAnswers;
    private Integer incorrectReadingAnswers;
    private Long spacedRepetitionSystemId;
}
