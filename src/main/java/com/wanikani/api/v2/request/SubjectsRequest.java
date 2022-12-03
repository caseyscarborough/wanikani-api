package com.wanikani.api.v2.request;

import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
public class SubjectsRequest extends CollectionRequest {
    @Singular
    private final List<Integer> levels;
    @Singular
    private final List<String> types;
    @Singular
    private final List<String> slugs;
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
