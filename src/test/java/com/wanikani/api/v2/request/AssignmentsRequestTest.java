package com.wanikani.api.v2.request;

import org.junit.Test;

import java.util.Date;

import static com.wanikani.api.v2.model.SubjectType.KANJI;
import static com.wanikani.api.v2.model.SubjectType.RADICAL;
import static org.junit.Assert.assertEquals;

public class AssignmentsRequestTest {

    @Test
    public void testQueryStringGeneration() {
        AssignmentsRequest request = AssignmentsRequest
            .builder()
            .subjectTypes(KANJI, RADICAL)
            .srsStages(1, 4, 5)
            .burned(false)
            .started(true)
            .updatedAfter(new Date(1543173732856L))
            .build();

        assertEquals("?subject_types=kanji,radical&updated_after=2018-11-25T19:22:12.856Z&srs_stages=1,4,5&started=true&burned=false", request.getQueryString());
    }
}
