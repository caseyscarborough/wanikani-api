package com.wanikani.api.v2.model;

import java.util.Arrays;

public enum SubjectType {

    RADICAL("radical"),
    KANJI("kanji"),
    VOCABULARY("vocabulary");

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

    public String getName() {
        return name;
    }
}
