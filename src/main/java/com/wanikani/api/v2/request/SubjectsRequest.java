package com.wanikani.api.v2.request;

import com.wanikani.api.v2.model.SubjectType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.wanikani.api.v2.Constants.BASE_URL;

public class SubjectsRequest implements Request {

    private final String url;

    public SubjectsRequest(String url) {
        this.url = url;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUrl() {
        return url;
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
            StringBuilder url = new StringBuilder();
            url.append(BASE_URL).append("/subjects");
            boolean firstParameterUsed = false;
            if (!types.isEmpty()) {
                url.append("?types=");
                for (SubjectType type : types) {
                    url.append(type.getName()).append(",");
                }
                url.deleteCharAt(url.length() - 1);
                firstParameterUsed = true;
            }

            if (!levels.isEmpty()) {
                url.append(firstParameterUsed ? "&" : "?");
                url.append("levels=");
                for (Integer level : levels) {
                    url.append(level).append(",");
                }
                url.deleteCharAt(url.length() - 1);
                firstParameterUsed = true;
            }

            if (pageAfterId != null) {
                url.append(firstParameterUsed ? "&" : "?");
                url.append("page_after_id=").append(pageAfterId);
                firstParameterUsed = true;
            }

            return new SubjectsRequest(url.toString());
        }
    }
}
