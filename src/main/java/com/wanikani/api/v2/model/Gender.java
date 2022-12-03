package com.wanikani.api.v2.model;

import lombok.Getter;

import java.util.Arrays;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    @Getter
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
}
