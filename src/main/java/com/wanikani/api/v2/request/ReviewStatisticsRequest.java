package com.wanikani.api.v2.request;

import com.wanikani.api.v2.model.SubjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.wanikani.api.v2.request.QueryStringUtils.append;
import static com.wanikani.api.v2.request.QueryStringUtils.appendDate;
import static com.wanikani.api.v2.request.QueryStringUtils.appendList;
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

    public static class Builder {
        private List<Long> ids = new ArrayList<>();
        private List<Long> subjectIds = new ArrayList<>();
        private List<String> subjectTypes = new ArrayList<>();
        private Integer percentagesGreaterThan;
        private Integer percentagesLessThan;
        private Boolean hidden;
        private Date updatedAfter;
        private Long pageAfterId = null;

        public Builder pageAfterId(Long pageAfterId) {
            this.pageAfterId = pageAfterId;
            return this;
        }

        public Builder ids(List<Long> ids) {
            this.ids = ids;
            return this;
        }

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

        public Builder updatedAfter(Date updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }

        public ReviewStatisticsRequest build() {
            StringBuilder queryString = new StringBuilder();
            appendDate(queryString, "updated_after", updatedAfter);
            appendList(queryString, "ids", ids);
            appendList(queryString, "subject_ids", subjectIds);
            appendList(queryString, "subject_types", subjectTypes);
            append(queryString, "page_after_id", pageAfterId);
            append(queryString, "percentages_greater_than", percentagesGreaterThan);
            append(queryString, "percentages_less_than", percentagesLessThan);
            append(queryString, "hidden", hidden);
            return new ReviewStatisticsRequest(queryString.toString());
        }
    }
}
