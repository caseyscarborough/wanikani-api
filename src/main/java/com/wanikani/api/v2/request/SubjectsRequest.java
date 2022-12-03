package com.wanikani.api.v2.request;

import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder(toBuilder = true)
public class SubjectsRequest extends CollectionRequest {
    @Singular
    private final List<Integer> levels = new ArrayList<>();
    @Singular
    private final List<String> types = new ArrayList<>();
    @Singular
    private final List<String> slugs = new ArrayList<>();
    private final Boolean hidden;

    @Override
    public String getQueryString() {
        return super.queryString()
            .appendList("types", types)
            .appendList("levels", levels)
            .appendList("slugs", slugs)
            .append("hidden", hidden)
            .toString();
    }
}
