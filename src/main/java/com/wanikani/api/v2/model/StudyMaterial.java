package com.wanikani.api.v2.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudyMaterial {

    private ZonedDateTime createdAt;
    private boolean hidden;
    private String meaningNote;
    private List<String> meaningSynonyms = new ArrayList<>();
    private String readingNote;
    private long subjectId;
    @JsonDeserialize(using = SubjectType.Deserializer.class)
    private SubjectType subjectType;
}
