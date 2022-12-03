package com.wanikani.api.v2.request;

import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
public class ReviewsRequest extends CollectionRequest {
    @Singular
    private final List<Long> assignmentIds;
    @Singular
    private final List<Long> subjectIds;

    @Override
    public String getQueryString() {
        return super.queryString()
            .appendList("assignment_ids", assignmentIds)
            .appendList("subject_ids", subjectIds)
            .toString();
    }
}
