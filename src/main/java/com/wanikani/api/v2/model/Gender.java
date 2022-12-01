package com.wanikani.api.v2.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Arrays;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public static Gender findByName(String name) {
        return Arrays
            .stream(values())
            .filter(t -> t.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }

    public String getName() {
        return name;
    }

    public static class Deserializer extends JsonDeserializer<Gender> {
        @Override
        public Gender deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return findByName(p.getValueAsString());
        }
    }
}
