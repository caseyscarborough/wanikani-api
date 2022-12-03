package com.wanikani.api.v2.request;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@SuperBuilder(toBuilder = true)
@ToString
public abstract class BaseRequest implements Request {
    private final ZonedDateTime updatedAfter;

    protected QueryString queryString() {
        return new QueryString().append("updated_after", updatedAfter);
    }

    @SuppressWarnings("unused") // For lombok super builder
    static abstract class BaseRequestBuilder<C extends BaseRequest, B extends BaseRequestBuilder<C, B>> {
        public B updatedAfter(ZonedDateTime updatedAfter) {
            this.updatedAfter = updatedAfter;
            return self();
        }

        public B updatedAfter(Instant updatedAfter) {
            return updatedAfter(updatedAfter.atZone(ZoneOffset.UTC));
        }

        public B updatedAfter(OffsetDateTime updatedAfter) {
            return updatedAfter(updatedAfter.toZonedDateTime());
        }
    }
}
