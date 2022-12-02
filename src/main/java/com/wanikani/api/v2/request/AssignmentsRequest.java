package com.wanikani.api.v2.request;

import com.wanikani.api.v2.model.SubjectType;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.wanikani.api.v2.request.QueryStringUtils.append;
import static com.wanikani.api.v2.request.QueryStringUtils.appendDate;
import static com.wanikani.api.v2.request.QueryStringUtils.appendList;
import static java.util.stream.Collectors.toList;

public class AssignmentsRequest implements Request {

    private final String queryString;

    public AssignmentsRequest(String queryString) {
        this.queryString = queryString;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getQueryString() {
        return queryString;
    }

    public static class Builder extends BaseBuilder<AssignmentsRequest, Builder> {

        private List<Integer> ids = new ArrayList<>();
        private List<Integer> subjectIds = new ArrayList<>();
        private List<String> subjectTypes = new ArrayList<>();
        private List<Integer> levels = new ArrayList<>();
        private List<Integer> srsStages = new ArrayList<>();
        private Boolean unlocked;
        private Boolean started;
        private Boolean passed;
        private Boolean burned;
        private Boolean resurrected;
        private Boolean hidden;
        private ZonedDateTime createdAt;
        private ZonedDateTime availableBefore;
        private ZonedDateTime availableAfter;
        private Long pageAfterId;

        public Builder ids(Integer... ids) {
            this.ids = Arrays.asList(ids);
            return this;
        }

        public Builder subjectIds(Integer... ids) {
            this.subjectIds = Arrays.asList(ids);
            return this;
        }

        public Builder levels(Integer... levels) {
            this.levels = Arrays.asList(levels);
            return this;
        }

        public Builder subjectTypes(List<SubjectType> subjectTypes) {
            this.subjectTypes = subjectTypes.stream().map(SubjectType::getName).collect(toList());
            return this;
        }

        public Builder subjectTypes(SubjectType... subjectTypes) {
            return subjectTypes(Arrays.asList(subjectTypes));
        }

        public Builder availableBefore(ZonedDateTime availableBefore) {
            this.availableBefore = availableBefore;
            return this;
        }

        public Builder availableBefore(Instant instant) {
            return availableBefore(instant.atZone(ZoneOffset.UTC));
        }

        public Builder availableAfter(ZonedDateTime availableAfter) {
            this.availableAfter = availableAfter;
            return this;
        }

        public Builder availableAfter(Instant instant) {
            return availableAfter(instant.atZone(ZoneOffset.UTC));
        }

        public Builder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(Instant instant) {
            return createdAt(instant.atZone(ZoneOffset.UTC));
        }

        public Builder pageAfterId(Long id) {
            this.pageAfterId = id;
            return this;
        }

        public Builder srsStages(List<Integer> srsStages) {
            this.srsStages = srsStages;
            return this;
        }

        public Builder srsStages(Integer... srsStages) {
            return srsStages(Arrays.asList(srsStages));
        }

        public Builder unlocked(Boolean unlocked) {
            this.unlocked = unlocked;
            return this;
        }

        public Builder started(Boolean started) {
            this.started = started;
            return this;
        }

        public Builder passed(Boolean passed) {
            this.passed = passed;
            return this;
        }

        public Builder burned(Boolean burned) {
            this.burned = burned;
            return this;
        }

        public Builder resurrected(Boolean resurrected) {
            this.resurrected = resurrected;
            return this;
        }

        public Builder hidden(Boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        @Override
        public AssignmentsRequest build() {
            StringBuilder queryString = super.queryString();
            appendList(queryString, "ids", ids);
            appendList(queryString, "subject_ids", subjectIds);
            appendList(queryString, "levels", levels);
            appendList(queryString, "subject_types", subjectTypes);
            appendDate(queryString, "created_at", createdAt);
            appendDate(queryString, "available_before", availableBefore);
            appendDate(queryString, "available_after", availableAfter);
            appendList(queryString, "srs_stages", srsStages);
            append(queryString, "page_after_id", pageAfterId);
            append(queryString, "unlocked", unlocked);
            append(queryString, "started", started);
            append(queryString, "passed", passed);
            append(queryString, "burned", burned);
            append(queryString, "resurrected", resurrected);
            append(queryString, "hidden", hidden);
            return new AssignmentsRequest(queryString.toString());
        }
    }
}
