package com.wanikani.api.v2.model;

import java.util.List;

public class Subject {
    private Long id;
    private Integer level;
    private String createdAt;
    private String characters;
    private List<CharacterImage> characterImages;
    private List<Meaning> meanings;
    private List<Reading> readings;
    private String slug;
    private String documentUrl;
    private SubjectType type;
    private String hiddenAt;
    private List<String> partsOfSpeech;
    private List<Integer> componentSubjectIds;
    private List<Integer> amalgamationSubjectIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public List<CharacterImage> getCharacterImages() {
        return characterImages;
    }

    public void setCharacterImages(List<CharacterImage> characterImages) {
        this.characterImages = characterImages;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public SubjectType getType() {
        return type;
    }

    public void setType(SubjectType type) {
        this.type = type;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    public String getHiddenAt() {
        return hiddenAt;
    }

    public void setHiddenAt(String hiddenAt) {
        this.hiddenAt = hiddenAt;
    }

    public List<String> getPartsOfSpeech() {
        return partsOfSpeech;
    }

    public void setPartsOfSpeech(List<String> partsOfSpeech) {
        this.partsOfSpeech = partsOfSpeech;
    }

    public List<Integer> getComponentSubjectIds() {
        return componentSubjectIds;
    }

    public void setComponentSubjectIds(List<Integer> componentSubjectIds) {
        this.componentSubjectIds = componentSubjectIds;
    }

    public List<Integer> getAmalgamationSubjectIds() {
        return amalgamationSubjectIds;
    }

    public void setAmalgamationSubjectIds(List<Integer> amalgamationSubjectIds) {
        this.amalgamationSubjectIds = amalgamationSubjectIds;
    }
}
