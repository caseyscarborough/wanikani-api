package com.wanikani.api.v2.request;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudyMaterialsRequestTest {

    @Test
    public void testQueryString() {
        String utcTime = "2022-12-02T19:35:35Z";
        final Instant instant = Instant.ofEpochMilli(1670009735000L);
        final StudyMaterialsRequest requestOffset5 = StudyMaterialsRequest.builder()
            .updatedAfter(instant.atZone(ZoneOffset.ofHours(5)))
            .build();
        final StudyMaterialsRequest requestNoOffset = StudyMaterialsRequest.builder()
            .updatedAfter(instant.atZone(ZoneOffset.UTC))
            .build();
        final StudyMaterialsRequest requestOffsetMinus10 = StudyMaterialsRequest.builder()
            .updatedAfter(instant.atZone(ZoneOffset.ofHours(-10)))
            .build();
        assertEquals("?updated_after=" + utcTime, requestOffset5.getQueryString());
        assertEquals("?updated_after=" + utcTime, requestNoOffset.getQueryString());
        assertEquals("?updated_after=" + utcTime, requestOffsetMinus10.getQueryString());
    }
}
