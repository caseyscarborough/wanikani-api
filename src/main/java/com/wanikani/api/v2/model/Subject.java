package com.wanikani.api.v2.model;

import java.util.List;
import java.util.Objects;

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
    private List<Long> componentSubjectIds;
    private List<Long> amalgamationSubjectIds;

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

    public List<Long> getComponentSubjectIds() {
        return componentSubjectIds;
    }

    public void setComponentSubjectIds(List<Long> componentSubjectIds) {
        this.componentSubjectIds = componentSubjectIds;
    }

    public List<Long> getAmalgamationSubjectIds() {
        return amalgamationSubjectIds;
    }

    public void setAmalgamationSubjectIds(List<Long> amalgamationSubjectIds) {
        this.amalgamationSubjectIds = amalgamationSubjectIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
