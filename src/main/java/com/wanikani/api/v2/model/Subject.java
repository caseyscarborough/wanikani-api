package com.wanikani.api.v2.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

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
    private String readingMnemonic;
    private String readingHint;
    private String meaningMnemonic;
    private String meaningHint;
    private SubjectType type;
    private ZonedDateTime hiddenAt;
    private List<String> partsOfSpeech;
    private List<Long> componentSubjectIds;
    private List<Long> amalgamationSubjectIds;
    private List<Long> visuallySimilarSubjectIds;
    private List<PronunciationAudio> pronunciationAudios;
    private List<ContextSentence> contextSentences;
    private List<AuxiliaryMeaning> auxiliaryMeanings;
    private Integer lessonPosition;
    private Long spacedRepetitionSystemId;
}
