package com.wanikani.api.v2.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class VoiceActor {

    private String description;
    @JsonDeserialize(using = Gender.Deserializer.class)
    private Gender gender;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
