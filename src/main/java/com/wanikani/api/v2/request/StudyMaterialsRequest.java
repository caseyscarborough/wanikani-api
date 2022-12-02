package com.wanikani.api.v2.request;

import com.wanikani.api.v2.model.SubjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudyMaterialsRequest implements Request {

    private final String queryString;

    public StudyMaterialsRequest(String queryString) {
        this.queryString = queryString;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getQueryString() {
        return queryString;
    }

    public static class Builder extends CollectionBuilder<StudyMaterialsRequest, Builder> {
        private Boolean hidden;
        private List<Long> subjectIds = new ArrayList<>();
        private List<String> subjectTypes = new ArrayList<>();

        public Builder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public Builder subjectIds(List<Long> subjectIds) {
            this.subjectIds = subjectIds;
            return this;
        }

        public Builder subjectIds(long... ids) {
            return subjectIds(Arrays.stream(ids).boxed().collect(Collectors.toList()));
        }

        public Builder subjectTypes(List<SubjectType> subjectTypes) {
            this.subjectTypes = subjectTypes.stream().map(SubjectType::getName).collect(Collectors.toList());
            return this;
        }

        public Builder subjectTypes(SubjectType... subjectTypes) {
            return subjectTypes(Arrays.stream(subjectTypes).collect(Collectors.toList()));
        }

        @Override
        public StudyMaterialsRequest build() {
            QueryString queryString = super.queryString()
                .append( "hidden", hidden)
                .appendList( "subject_ids", subjectIds)
                .appendList( "subject_types", subjectTypes);
            return new StudyMaterialsRequest(queryString.toString());
        }
    }
}
