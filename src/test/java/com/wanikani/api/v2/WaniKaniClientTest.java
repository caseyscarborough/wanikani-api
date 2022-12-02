package com.wanikani.api.v2;

import com.wanikani.api.v2.model.Assignment;
import com.wanikani.api.v2.model.SpacedRepetitionSystem;
import com.wanikani.api.v2.request.AssignmentsRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WaniKaniClientTest {

    private static final String API_KEY = System.getenv("WANIKANI_API_KEY");
    private WaniKaniClient client;

    @BeforeEach
    void setUp() throws Exception {
        client = new WaniKaniClient(new MockHttpClient(API_KEY));
    }

    @Test
    void testAssignments() {
        ZonedDateTime time = Instant.ofEpochMilli(1667428225000L).atZone(ZoneOffset.UTC);
        System.out.println(time);
        AssignmentsRequest request = AssignmentsRequest.builder().availableAfter(time).build();
        final List<Assignment> assignments = client.getAssignments(request);
        assertEquals(500, assignments.size());
        for (Assignment assignment : assignments) {
            assertTrue(assignment.getAvailableAt().isAfter(time));
        }
    }

    @Test
    void testSrsStages() {
        final List<SpacedRepetitionSystem> srsStages = client.getSpacedRepetitionSystems();
        assertEquals(2, srsStages.size());
        for (SpacedRepetitionSystem srsStage : srsStages) {
            assertFalse(srsStage.getStages().isEmpty());
        }
    }
}
