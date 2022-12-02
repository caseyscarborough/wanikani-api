package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects

@Data
public class Subject implements Identifiable {

    private Long id;
    private Integer level;
    private ZonedDateTime createdAt;
    private String characters;
    private List<CharacterImage> characterImages;
    private List<Meaning> meanings;
    private List<Reading> readings;
    private String slug;
    private String documentUrl;
    private SubjectType type;
    private ZonedDateTime hiddenAt;
    private List<String> partsOfSpeech;
    private List<Long> componentSubjectIds;
    private List<Long> amalgamationSubjectIds;
}
