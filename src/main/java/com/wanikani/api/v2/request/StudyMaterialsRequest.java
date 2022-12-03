package com.wanikani.api.v2.request;

import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
public class StudyMaterialsRequest extends CollectionRequest {
    @Singular
    private List<Long> subjectIds;
    @Singular
    private List<String> subjectTypes;
    private Boolean hidden;

    @Override
    public String getQueryString() {
        return super.queryString()
            .append( "hidden", hidden)
            .appendList( "subject_ids", subjectIds)
            .appendList( "subject_types", subjectTypes)
            .toString();
    }
}
