package com.wanikani.api.v2.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewsRequest implements Request {

    private final String queryString;

    public ReviewsRequest(String queryString) {
        this.queryString = queryString;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getQueryString() {
        return queryString;
    }

    public static class Builder extends CollectionBuilder<ReviewsRequest, Builder> {
        private List<Long> assignmentIds = new ArrayList<>();
        private List<Long> subjectIds = new ArrayList<>();

        public Builder assignmentIds(Long... ids) {
            this.assignmentIds = Arrays.asList(ids);
            return this;
        }

        public Builder subjectIds(List<Long> ids) {
            this.subjectIds = new ArrayList<>(ids);
            return this;
        }

        public Builder subjectIds(Long... ids) {
            return subjectIds(Arrays.asList(ids));
        }

        @Override
        public ReviewsRequest build() {
            QueryString queryString = super.queryString()
                .appendList( "assignment_ids", assignmentIds)
                .appendList( "subject_ids", subjectIds);
            return new ReviewsRequest(queryString.toString());
        }
    }
}
