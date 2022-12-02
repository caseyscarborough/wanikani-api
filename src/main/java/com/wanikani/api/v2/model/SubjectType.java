package com.wanikani.api.v2.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.Getter;

import java.io.IOException;
import java.util.Arrays;

public enum SubjectType {

    RADICAL("radical"),
    KANJI("kanji"),
    VOCABULARY("vocabulary");

    @Getter
    private final String name;

    SubjectType(String name) {
        this.name = name;
    }

    public static SubjectType findByName(String name) {
        return Arrays
            .stream(values())
            .filter(t -> t.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }

    public static class Deserializer extends JsonDeserializer<SubjectType> {
        @Override
        public SubjectType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return findByName(p.getValueAsString());
        }
    }
}
