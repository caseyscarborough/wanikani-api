package com.wanikani.api.v2;

import com.wanikani.api.v2.model.Assignment;
import com.wanikani.api.v2.model.SpacedRepetitionSystem;
import com.wanikani.api.v2.request.AssignmentsRequest;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaniKaniClientTest {

    private static final String API_KEY = System.getenv("WANIKANI_API_KEY");
    private WaniKaniClient client;

    @BeforeEach
    public void setUp() throws Exception {
        // Skip tests if the API key is not set
        Assumptions.assumeTrue(API_KEY != null);

        client = new WaniKaniClient(API_KEY);
    }

    @Test
    public void testAssignments() {
        ZonedDateTime time = Instant.ofEpochMilli(1667428225000L).atZone(ZoneOffset.UTC);
        System.out.println(time);
        AssignmentsRequest request = AssignmentsRequest.builder()
            .availableAfter(time)
            .build();
        final List<Assignment> assignments = client.getAssignments(request);
        System.out.println(assignments.size());
        for (Assignment assignment : assignments) {
            assertTrue(assignment.getAvailableAt().isAfter(time));
        }
    }

    @Test
    public void testSrsStages() {
        final List<SpacedRepetitionSystem> srsStages = client.getSpacedRepetitionSystems();
        assertFalse(srsStages.isEmpty());
    }
}
