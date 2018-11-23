package com.wanikani.api.v2.request;

import com.wanikani.api.v2.util.DateUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

    public static class Builder {
        private List<Integer> ids = new ArrayList<>();
        private List<Integer> assignmentIds = new ArrayList<>();
        private List<Integer> subjectIds = new ArrayList<>();
        private Long pageAfterId;
        private Date updatedAfter;

        public Builder ids(Integer... ids) {
            this.ids = Arrays.asList(ids);
            return this;
        }

        public Builder assignmentIds(Integer... ids) {
            this.assignmentIds = Arrays.asList(ids);
            return this;
        }

        public Builder subjectIds(Integer... ids) {
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
            boolean firstParameterUsed = false;
            if (!ids.isEmpty()) {
                queryString.append("?ids=");
                for (Integer id : ids) {
                    queryString.append(id).append(",");
                }
                queryString.deleteCharAt(queryString.length() - 1);
                firstParameterUsed = true;
            }

            if (!assignmentIds.isEmpty()) {
                queryString.append(firstParameterUsed ? "&" : "?");
                queryString.append("assignment_ids=");
                for (Integer id : assignmentIds) {
                    queryString.append(id).append(",");
                }
                queryString.deleteCharAt(queryString.length() - 1);
                firstParameterUsed = true;
            }

            if (!subjectIds.isEmpty()) {
                queryString.append(firstParameterUsed ? "&" : "?");
                queryString.append("subject_ids=");
                for (Integer id : subjectIds) {
                    queryString.append(id).append(",");
                }
                queryString.deleteCharAt(queryString.length() - 1);
                firstParameterUsed = true;
            }

            if (updatedAfter != null) {
                queryString.append(firstParameterUsed ? "&" : "?");
                queryString.append("updated_after=").append(DateUtils.getApiDate(updatedAfter));
                firstParameterUsed = true;
            }

            if (pageAfterId != null) {
                queryString.append(firstParameterUsed ? "&" : "?");
                queryString.append("page_after_id=").append(pageAfterId);
                firstParameterUsed = true;
            }

            return new ReviewsRequest(queryString.toString());
        }
    }
}
