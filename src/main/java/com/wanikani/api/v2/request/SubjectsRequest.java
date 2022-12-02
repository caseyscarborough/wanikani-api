package com.wanikani.api.v2.request;

import com.wanikani.api.v2.model.SubjectType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static com.wanikani.api.v2.request.QueryStringUtils.append;
import static com.wanikani.api.v2.request.QueryStringUtils.appendDate;
import static com.wanikani.api.v2.request.QueryStringUtils.appendList;
import static java.util.stream.Collectors.toList;

public class SubjectsRequest implements Request {

    private final String queryString;

    public SubjectsRequest(String queryString) {
        this.queryString = queryString;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getQueryString() {
        return queryString;
    }

    public static class Builder {
        private List<String> types = new ArrayList<>();
        private final List<Integer> levels = new ArrayList<>();
        private List<String> slugs = new ArrayList<>();
        private Boolean hidden;
        private Date updatedAfter;
        private Long pageAfterId;

        public Builder slugs(List<String> slugs) {
            this.slugs = slugs;
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

        public Builder pageAfterId(Long pageAfterId) {
            this.pageAfterId = pageAfterId;
            return this;
        }

        public Builder types(List<SubjectType> types) {
            this.types = types.stream().map(SubjectType::getName).collect(toList());
            return this;
        }

        public Builder addType(SubjectType type) {
            this.types.add(type.getName());
            return this;
        }

        public Builder levels(int... levels) {
            for (int level : levels) {
                this.levels.add(level);
            }
            return this;
        }

        public Builder levels(IntStream stream) {
            return this.levels(stream.toArray());
        }

        public SubjectsRequest build() {
            StringBuilder queryString = new StringBuilder();
            appendList(queryString, "types", types);
            appendList(queryString, "levels", levels);
            append(queryString, "page_after_id", pageAfterId);
            appendList(queryString, "slugs", slugs);
            append(queryString, "hidden", hidden);
            appendDate(queryString, "updated_after", updatedAfter);
            return new SubjectsRequest(queryString.toString());
        }
    }
}
