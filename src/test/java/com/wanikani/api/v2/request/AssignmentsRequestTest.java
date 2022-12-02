package com.wanikani.api.v2.request;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static com.wanikani.api.v2.model.SubjectType.KANJI;
import static com.wanikani.api.v2.model.SubjectType.RADICAL;
import static org.junit.Assert.assertEquals;

public class AssignmentsRequestTest {

    @Test
    public void testQueryStringGeneration() {
        // Sunday, November 25, 2018 7:22:12 PM UTC
        ZonedDateTime updatedAfter = Instant.ofEpochMilli(1543173732856L).atZone(ZoneOffset.UTC);
        AssignmentsRequest request = AssignmentsRequest
            .builder()
            .subjectTypes(KANJI, RADICAL)
            .srsStages(1, 4, 5)
            .burned(false)
            .started(true)
            .updatedAfter(updatedAfter)
            .build();
        assertEquals("?updated_after=2018-11-25T19:22:12.856Z&subject_types=kanji,radical&srs_stages=1,4,5&started=true&burned=false", request.getQueryString());
    }
}
