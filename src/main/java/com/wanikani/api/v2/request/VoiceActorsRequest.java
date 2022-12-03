package com.wanikani.api.v2.request;

import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
public class VoiceActorsRequest extends CollectionRequest {
    @Override
    public String getQueryString() {
        return queryString().toString();
    }
}
