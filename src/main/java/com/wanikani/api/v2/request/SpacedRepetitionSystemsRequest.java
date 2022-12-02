package com.wanikani.api.v2.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.wanikani.api.v2.request.QueryStringUtils.appendDate;
import static com.wanikani.api.v2.request.QueryStringUtils.appendList;

public class SpacedRepetitionSystemsRequest implements Request {

    private final String queryString;

    public SpacedRepetitionSystemsRequest(String queryString) {
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
        private LocalDateTime updatedAfter;

        public Builder ids(List<Long> ids) {
            this.ids = ids;
            return this;
        }

        public Builder ids(long... ids) {
            return ids(Arrays.stream(ids).boxed().collect(Collectors.toList()));
        }

        public Builder updatedAfter(LocalDateTime updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }

        public SpacedRepetitionSystemsRequest build() {
            StringBuilder queryString = new StringBuilder();
            appendDate(queryString, "updated_after", updatedAfter);
            appendList(queryString, "ids", ids);
            return new SpacedRepetitionSystemsRequest(queryString.toString());
        }
    }
}
