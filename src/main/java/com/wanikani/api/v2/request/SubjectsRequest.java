package com.wanikani.api.v2.request;

import com.wanikani.api.v2.model.SubjectType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        private List<SubjectType> types = new ArrayList<>();
        private List<Integer> levels = new ArrayList<>();
        private Long pageAfterId = null;

        public Builder pageAfterId(Long pageAfterId) {
            this.pageAfterId = pageAfterId;
            return this;
        }

        public Builder addType(SubjectType type) {
            this.types.add(type);
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
            boolean firstParameterUsed = false;
            if (!types.isEmpty()) {
                queryString.append("?types=");
                for (SubjectType type : types) {
                    queryString.append(type.getName()).append(",");
                }
                queryString.deleteCharAt(queryString.length() - 1);
                firstParameterUsed = true;
            }

            if (!levels.isEmpty()) {
                queryString.append(firstParameterUsed ? "&" : "?");
                queryString.append("levels=");
                for (Integer level : levels) {
                    queryString.append(level).append(",");
                }
                queryString.deleteCharAt(queryString.length() - 1);
                firstParameterUsed = true;
            }

            if (pageAfterId != null) {
                queryString.append(firstParameterUsed ? "&" : "?");
                queryString.append("page_after_id=").append(pageAfterId);
                firstParameterUsed = true;
            }

            return new SubjectsRequest(queryString.toString());
        }
    }
}
