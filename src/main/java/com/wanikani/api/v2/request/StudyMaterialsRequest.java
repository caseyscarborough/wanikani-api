package com.wanikani.api.v2.request;

import com.wanikani.api.v2.model.SubjectType;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
public class StudyMaterialsRequest extends CollectionRequest {
    @Singular
    private final List<Long> subjectIds;
    @Singular
    private final List<SubjectType> subjectTypes;
    private final Boolean hidden;

    @Override
    public String getQueryString() {
        return super.queryString()
            .append("hidden", hidden)
            .appendList("subject_ids", subjectIds)
            .appendList("subject_types", subjectTypes, SubjectType::getName)
            .toString();
    }
}
