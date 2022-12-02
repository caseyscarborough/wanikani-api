package com.wanikani.api.v2.request;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.ZonedDateTime;
import java.util.List;

import static com.wanikani.api.v2.request.QueryStringUtils.append;
import static com.wanikani.api.v2.request.QueryStringUtils.appendDate;
import static com.wanikani.api.v2.request.QueryStringUtils.appendList;

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

    public static class Builder extends BaseBuilder<ReviewsRequest, Builder> {
        private List<Long> ids = new ArrayList<>();
        private List<Long> assignmentIds = new ArrayList<>();
        private List<Long> subjectIds = new ArrayList<>();
        private Long pageAfterId;

        public Builder ids(Long... ids) {
            this.ids = Arrays.asList(ids);
            return this;
        }

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

        public Builder pageAfterId(Long id) {
            this.pageAfterId = id;
            return this;
        }

        @Override
        public ReviewsRequest build() {
            StringBuilder queryString = super.queryString();
            appendList(queryString, "ids", ids);
            appendList(queryString, "assignment_ids", assignmentIds);
            appendList(queryString, "subject_ids", subjectIds);
            append(queryString, "page_after_id", pageAfterId);
            return new ReviewsRequest(queryString.toString());
        }
    }
}
