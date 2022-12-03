package com.wanikani.api.v2.request;

import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
public class ReviewStatisticsRequest extends CollectionRequest {
    @Singular
    private List<Long> subjectIds;
    @Singular
    private List<String> subjectTypes;
    private Integer percentagesGreaterThan;
    private Integer percentagesLessThan;
    private Boolean hidden;

    @Override
    public String getQueryString() {
        return super.queryString()
            .appendList("subject_ids", subjectIds)
            .appendList("subject_types", subjectTypes)
            .append("percentages_greater_than", percentagesGreaterThan)
            .append("percentages_less_than", percentagesLessThan)
            .append("hidden", hidden)
            .toString();
    }
}
