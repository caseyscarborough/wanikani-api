package com.wanikani.api.v2;

import com.wanikani.api.v2.model.Assignment;
import com.wanikani.api.v2.model.LevelProgression;
import com.wanikani.api.v2.model.PronunciationAudio;
import com.wanikani.api.v2.model.Reading;
import com.wanikani.api.v2.model.Reset;
import com.wanikani.api.v2.model.Review;
import com.wanikani.api.v2.model.ReviewStatistic;
import com.wanikani.api.v2.model.SpacedRepetitionSystem;
import com.wanikani.api.v2.model.StudyMaterial;
import com.wanikani.api.v2.model.Subject;
import com.wanikani.api.v2.model.SubjectType;
import com.wanikani.api.v2.model.Summary;
import com.wanikani.api.v2.model.User;
import com.wanikani.api.v2.model.VoiceActor;
import com.wanikani.api.v2.request.AssignmentsRequest;
import com.wanikani.api.v2.request.ReviewStatisticsRequest;
import com.wanikani.api.v2.request.ReviewsRequest;
import com.wanikani.api.v2.request.SubjectsRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @Test
    void testResets() {
        final List<Reset> resets = client.getResets();
        for (Reset reset : resets) {
            assertNotNull(reset.getId());
            assertNotNull(reset.getCreatedAt());
            assertNotNull(reset.getOriginalLevel());
            assertNotNull(reset.getTargetLevel());
        }
    }

    @Test
    void getLevelProgressions() {
        final List<LevelProgression> progressions = client.getLevelProgressions();
        for (LevelProgression progression : progressions) {
            assertTrue(progression.getLevel() > 0);
            assertNotNull(progression.getId());
        }
    }

    @Test
    void testReviewStatistics() {
        final List<ReviewStatistic> stats = client.getReviewStatistics(ReviewStatisticsRequest.builder().build());
        for (ReviewStatistic stat : stats) {
            assertNotNull(stat.getId());
            assertNotNull(stat.getCreatedAt());
            assertNotNull(stat.getSubjectType());
        }
    }

    @Test
    void testSubject() {
        final Subject subject = client.getSubject(18);
        assertNotNull(subject.getCharacters());
        assertNotNull(subject.getDocumentUrl());
        assertNotNull(subject.getCreatedAt());
        assertNotNull(subject.getId());
        assertNotNull(subject.getSlug());
        assertNotNull(subject.getLevel());
        assertNotNull(subject.getType());
    }

    @Test
    void testReviews() {
        final List<Review> reviews = client.getReviews(ReviewsRequest.builder().build());
        assertFalse(reviews.isEmpty());
        for (Review review : reviews) {
            assertNotNull(review.getId());
            assertNotNull(review.getSubjectId());
        }
    }

    @Test
    void testSubjects() {
        SubjectsRequest request = SubjectsRequest.builder()
            .ids(18, 9021, 9085, 9091, 9065, 9022, 9142, 9143, 9041, 9094, 9083, 9063, 9044, 9087, 9151, 9080, 9161, 9075, 9071, 9027, 9036, 9145, 1630, 5911, 5918, 5900)
            .build();
        final List<Subject> subjects = client.getSubjects(request);
        assertFalse(subjects.isEmpty());
        for (Subject subject : subjects) {
            assertNotNull(subject.getCharacters());
            assertNotNull(subject.getDocumentUrl());
            assertNotNull(subject.getCreatedAt());
            assertNotNull(subject.getId());
            assertNotNull(subject.getSlug());
            assertNotNull(subject.getLevel());
            assertNotNull(subject.getType());
            assertFalse(subject.getMeanings().isEmpty());
            if (subject.getType() != SubjectType.RADICAL) {
                assertFalse(subject.getReadings().isEmpty());
                for (Reading reading : subject.getReadings()) {
                    assertNotNull(reading.getReading());
                }
            }
            if (subject.getType() == SubjectType.VOCABULARY) {
                assertFalse(subject.getPartsOfSpeech().isEmpty());
                for (PronunciationAudio audio : subject.getPronunciationAudios()) {
                    assertNotNull(audio.getUrl());
                    assertNotNull(audio.getContentType());
                    assertNotNull(audio.getMetadata());
                    assertNotNull(audio.getMetadata().getGender());
                    assertNotNull(audio.getMetadata().getPronunciation());
                }
            }
        }
    }

    @Test
    void getSummary() {
        final Summary summary = client.getSummary();
        assertFalse(summary.getLessons().isEmpty());
        assertFalse(summary.getReviews().isEmpty());
        assertNotNull(summary.getNextReviewsAt());
    }

    @Test
    void getUser() {
        final User user = client.getUser();
        assertNotNull(user.getId());
        assertNotNull(user.getUsername());
        assertNotNull(user.getLevel());
        assertNotNull(user.getStartedAt());
        assertNotNull(user.getPreferences());
        assertNotNull(user.getSubscription());
        assertTrue(user.getSubscription().getMaxLevelGranted() > 0);
        assertTrue(user.getPreferences().getDefaultVoiceActorId() > 0);
    }

    @Test
    void testStudyMaterials() {
        final List<StudyMaterial> studyMaterials = client.getStudyMaterials();
        assertFalse(studyMaterials.isEmpty());
        for (StudyMaterial studyMaterial : studyMaterials) {
            assertNotEquals(0L, studyMaterial.getSubjectId());
            assertNotNull(studyMaterial.getSubjectType());
            assertNotNull(studyMaterial.getCreatedAt());
        }
    }

    @Test
    void testVoiceActors() {
        final List<VoiceActor> voiceActors = client.getVoiceActors();
        assertFalse(voiceActors.isEmpty());
        for (VoiceActor voiceActor : voiceActors) {
            assertNotNull(voiceActor.getDescription());
            assertNotNull(voiceActor.getGender());
            assertNotNull(voiceActor.getName());
        }
    }
}
