package com.wanikani.api.v2.request;

public class SpacedRepetitionSystemsRequest implements Request {

    private final String queryString;

    public SpacedRepetitionSystemsRequest(String queryString) {
        this.queryString = queryString;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getQueryString() {
        return queryString;
    }

    public static class Builder extends CollectionBuilder<SpacedRepetitionSystemsRequest, Builder> {

        @Override
        public SpacedRepetitionSystemsRequest build() {
            StringBuilder queryString = super.queryString();
            return new SpacedRepetitionSystemsRequest(queryString.toString());
        }
    }
}
