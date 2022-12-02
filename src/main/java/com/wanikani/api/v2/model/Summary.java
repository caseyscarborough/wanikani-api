package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class Summary {

    private ZonedDateTime nextReviewsAt;
    private List<SummaryReview> reviews;
    private List<SummaryLesson> lessons;
}
