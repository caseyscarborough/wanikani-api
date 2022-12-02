package com.wanikani.api.v2.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class StudyMaterial {

    private LocalDateTime createdAt;
    private boolean hidden;
    private String meaningNote;
    private List<String> meaningSynonyms = new ArrayList<>();
    private String readingNote;
    private long subjectId;
    @JsonDeserialize(using = SubjectType.Deserializer.class)
    private SubjectType subjectType;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getMeaningNote() {
        return meaningNote;
    }

    public void setMeaningNote(String meaningNote) {
        this.meaningNote = meaningNote;
    }

    public List<String> getMeaningSynonyms() {
        return meaningSynonyms;
    }

    public void setMeaningSynonyms(List<String> meaningSynonyms) {
        this.meaningSynonyms = meaningSynonyms;
    }

    public String getReadingNote() {
        return readingNote;
    }

    public void setReadingNote(String readingNote) {
        this.readingNote = readingNote;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }
}
