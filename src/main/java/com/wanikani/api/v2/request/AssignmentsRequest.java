package com.wanikani.api.v2.request;

import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.List;

@SuperBuilder(toBuilder = true)
public class AssignmentsRequest extends CollectionRequest {
    @Singular
    private final List<Integer> subjectIds;
    @Singular
    private final List<String> subjectTypes;
    @Singular
    private final List<Integer> levels;
    @Singular
    private final List<Integer> srsStages;
    private final Boolean unlocked;
    private final Boolean started;
    private final Boolean passed;
    private final Boolean burned;
    private final Boolean resurrected;
    private final Boolean hidden;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime availableBefore;
    private final ZonedDateTime availableAfter;

    @Override
    public String getQueryString() {
        return super.queryString()
            .appendList("subject_ids", subjectIds)
            .appendList("levels", levels)
            .appendList("subject_types", subjectTypes)
            .appendDate("created_at", createdAt)
            .appendDate("available_before", availableBefore)
            .appendDate("available_after", availableAfter)
            .appendList("srs_stages", srsStages)
            .append("unlocked", unlocked)
            .append("started", started)
            .append("passed", passed)
            .append("burned", burned)
            .append("resurrected", resurrected)
            .append( "hidden", hidden)
            .toString();
    }
}
