package com.wanikani.api.v2.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.wanikani.api.v2.request.QueryStringUtils.*;

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

    public static class Builder {
        private List<Long> ids = new ArrayList<>();
        private List<Long> assignmentIds = new ArrayList<>();
        private List<Long> subjectIds = new ArrayList<>();
        private Long pageAfterId;
        private Date updatedAfter;

        public Builder ids(Long... ids) {
            this.ids = Arrays.asList(ids);
            return this;
        }

        public Builder assignmentIds(Long... ids) {
            this.assignmentIds = Arrays.asList(ids);
            return this;
        }

        public Builder subjectIds(Long... ids) {
            this.subjectIds = Arrays.asList(ids);
            return this;
        }

        public Builder updatedAfter(Date updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }

        public Builder pageAfterId(Long id) {
            this.pageAfterId = id;
            return this;
        }

        public ReviewsRequest build() {
            StringBuilder queryString = new StringBuilder();
            appendList(queryString, "ids", ids);
            appendList(queryString, "assignment_ids", assignmentIds);
            appendList(queryString, "subject_ids", subjectIds);
            appendDate(queryString, "updated_after", updatedAfter);
            append(queryString, "page_after_id", pageAfterId);
            return new ReviewsRequest(queryString.toString());
        }
    }
}
