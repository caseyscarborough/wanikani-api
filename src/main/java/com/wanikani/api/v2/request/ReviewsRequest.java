package com.wanikani.api.v2.request;

import com.wanikani.api.v2.util.DateUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.wanikani.api.v2.Constants.BASE_URL;

public class ReviewsRequest implements Request {

    private final String url;

    public ReviewsRequest(String url) {
        this.url = url;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUrl() {
        return url;
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
            StringBuilder url = new StringBuilder();
            url.append(BASE_URL).append("/reviews");
            boolean firstParameterUsed = false;
            if (!ids.isEmpty()) {
                url.append("?ids=");
                for (Integer id : ids) {
                    url.append(id).append(",");
                }
                url.deleteCharAt(url.length() - 1);
                firstParameterUsed = true;
            }

            if (!assignmentIds.isEmpty()) {
                url.append(firstParameterUsed ? "&" : "?");
                url.append("assignment_ids=");
                for (Integer id : assignmentIds) {
                    url.append(id).append(",");
                }
                url.deleteCharAt(url.length() - 1);
                firstParameterUsed = true;
            }

            if (!subjectIds.isEmpty()) {
                url.append(firstParameterUsed ? "&" : "?");
                url.append("subject_ids=");
                for (Integer id : subjectIds) {
                    url.append(id).append(",");
                }
                url.deleteCharAt(url.length() - 1);
                firstParameterUsed = true;
            }

            if (updatedAfter != null) {
                url.append(firstParameterUsed ? "&" : "?");
                url.append("updated_after=").append(DateUtils.getApiDate(updatedAfter));
                firstParameterUsed = true;
            }

            if (pageAfterId != null) {
                url.append(firstParameterUsed ? "&" : "?");
                url.append("page_after_id=").append(pageAfterId);
                firstParameterUsed = true;
            }

            return new ReviewsRequest(url.toString());
        }
    }
}
