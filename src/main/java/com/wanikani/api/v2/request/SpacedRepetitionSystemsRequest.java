package com.wanikani.api.v2.request;

import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
public class SpacedRepetitionSystemsRequest extends CollectionRequest {
    public String getQueryString() {
        return super.queryString().toString();
    }
}
