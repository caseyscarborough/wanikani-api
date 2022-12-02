package com.wanikani.api.v2.request;

public class VoiceActorsRequest implements Request {

    private final String queryString;

    public VoiceActorsRequest(String queryString) {
        this.queryString = queryString;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getQueryString() {
        return queryString;
    }

    public static class Builder extends CollectionBuilder<VoiceActorsRequest, Builder> {

        @Override
        public VoiceActorsRequest build() {
            QueryString queryString = super.queryString();
            return new VoiceActorsRequest(queryString.toString());
        }
    }
}
