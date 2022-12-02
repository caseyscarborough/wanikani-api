package com.wanikani.api.v2.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class VoiceActor {

    private String description;
    @JsonDeserialize(using = Gender.Deserializer.class)
    private Gender gender;
    private String name;
}
