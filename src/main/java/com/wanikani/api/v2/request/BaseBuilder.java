package com.wanikani.api.v2.request;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

abstract class BaseBuilder<T, B extends BaseBuilder<T, B>> {

    ZonedDateTime updatedAfter;

    @SuppressWarnings("unchecked")
    public B updatedAfter(ZonedDateTime updatedAfter) {
        this.updatedAfter = updatedAfter;
        return (B) this;
    }

    public B updatedAfter(Instant updatedAfter) {
        return updatedAfter(updatedAfter.atZone(ZoneOffset.UTC));
    }

    public B updatedAfter(OffsetDateTime updatedAfter) {
        return updatedAfter(updatedAfter.toZonedDateTime());
    }

    QueryString queryString() {
        return new QueryString()
            .appendDate("updated_after", updatedAfter);
    }

    public abstract T build();
}
