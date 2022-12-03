package com.wanikani.api.v2.request;

import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
public abstract class CollectionRequest extends BaseRequest {
    @Singular
    private final List<Long> ids;
    private final Long pageAfterId;

    protected QueryString queryString() {
        return super.queryString()
            .appendList("ids", ids)
            .append("page_after_id", pageAfterId);
    }

    public abstract CollectionRequestBuilder<?, ?> toBuilder();
}