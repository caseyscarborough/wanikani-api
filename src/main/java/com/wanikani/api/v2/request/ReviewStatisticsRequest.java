package com.wanikani.api.v2.request;

import com.wanikani.api.v2.model.SubjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReviewStatisticsRequest implements Request {

    private final String queryString;

    public ReviewStatisticsRequest(String queryString) {
        this.queryString = queryString;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getQueryString() {
        return queryString;
    }

    public static class Builder extends CollectionBuilder<ReviewStatisticsRequest, Builder> {
        private List<Long> subjectIds = new ArrayList<>();
        private List<String> subjectTypes = new ArrayList<>();
        private Integer percentagesGreaterThan;
        private Integer percentagesLessThan;
        private Boolean hidden;

        public Builder subjectIds(List<Long> subjectIds) {
            this.subjectIds = subjectIds;
            return this;
        }

        public Builder subjectTypes(List<SubjectType> subjectTypes) {
            this.subjectTypes = subjectTypes.stream().map(SubjectType::getName).collect(toList());
            return this;
        }

        public Builder subjectTypes(SubjectType... subjectTypes) {
            return subjectTypes(Arrays.asList(subjectTypes));
        }

        public Builder percentagesGreaterThan(Integer percentagesGreaterThan) {
            this.percentagesGreaterThan = percentagesGreaterThan;
            return this;
        }

        public Builder percentagesLessThan(Integer percentagesLessThan) {
            this.percentagesLessThan = percentagesLessThan;
            return this;
        }

        public Builder hidden(Boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        @Override
        public ReviewStatisticsRequest build() {
            QueryString queryString = super.queryString()
                .appendList( "subject_ids", subjectIds)
                .appendList( "subject_types", subjectTypes)
                .append( "percentages_greater_than", percentagesGreaterThan)
                .append( "percentages_less_than", percentagesLessThan)
                .append( "hidden", hidden);
            return new ReviewStatisticsRequest(queryString.toString());
        }
    }
}
