package com.wanikani.api.v2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wanikani.api.v2.model.Assignment;
import com.wanikani.api.v2.model.LevelProgression;
import com.wanikani.api.v2.model.Reset;
import com.wanikani.api.v2.model.Resource;
import com.wanikani.api.v2.model.Review;
import com.wanikani.api.v2.model.ReviewStatistic;
import com.wanikani.api.v2.model.SpacedRepetitionSystem;
import com.wanikani.api.v2.model.StudyMaterial;
import com.wanikani.api.v2.model.Subject;
import com.wanikani.api.v2.model.Summary;
import com.wanikani.api.v2.model.User;
import com.wanikani.api.v2.model.VoiceActor;
import com.wanikani.api.v2.request.AssignmentsRequest;
import com.wanikani.api.v2.request.ReviewStatisticsRequest;
import com.wanikani.api.v2.request.ReviewsRequest;
import com.wanikani.api.v2.request.SpacedRepetitionSystemsRequest;
import com.wanikani.api.v2.request.StudyMaterialsRequest;
import com.wanikani.api.v2.request.SubjectsRequest;
import com.wanikani.api.v2.request.VoiceActorsRequest;

import java.util.List;

public class WaniKaniClient {

    private final HttpClient client;
    private final ResourceTransformer transformer;
    private final JsonUtils jsonUtils = new JsonUtils();

    public WaniKaniClient(String apiKey) {
        this(new HttpClient(apiKey));
    }

    WaniKaniClient(HttpClient client) {
        this.client = client;
        this.transformer = new ResourceTransformer();
    }

    public Summary getSummary() {
        return getObject("/summary", new TypeReference<Resource<Summary>>() {});
    }

    public User getUser() {
        return getObject("/user", new TypeReference<Resource<User>>() {});
    }

    public List<Assignment> getAssignments(AssignmentsRequest request) {
        return getCollection(
            "/assignments" + request.getQueryString(),
            new TypeReference<Resource<List<Resource<Assignment>>>>() {}
        );
    }

    public List<Subject> getSubjects(SubjectsRequest request) {
        return getCollection(
            "/subjects" + request.getQueryString(),
            new TypeReference<Resource<List<Resource<Subject>>>>() {}
        );
    }

    public Subject getSubject(Integer id) {
        return getObject("/subjects/" + id, new TypeReference<Resource<Subject>>() {});
    }

    public List<Review> getReviews(ReviewsRequest request) {
        return getCollection(
            "/reviews" + request.getQueryString(),
            new TypeReference<Resource<List<Resource<Review>>>>() {}
        );
    }

    /**
     * Get all Spaced Repetition Systems matching the given query.
     * See <a href="https://docs.api.wanikani.com/20170710/#spaced-repetition-systems">WaniKani docs</a>
     */
    public List<SpacedRepetitionSystem> getSpacedRepetitionSystems(SpacedRepetitionSystemsRequest request) {
        return getCollection(
            "/spaced_repetition_systems" + request.getQueryString(),
            new TypeReference<Resource<List<Resource<SpacedRepetitionSystem>>>>() {}
        );
    }

    /**
     * Convenience method that gets all Spaced Repetition Systems.
     */
    public List<SpacedRepetitionSystem> getSpacedRepetitionSystems() {
        return getSpacedRepetitionSystems(SpacedRepetitionSystemsRequest.builder().build());
    }

    public List<Reset> getResets() {
        return getCollection(
            "/resets",
            new TypeReference<Resource<List<Resource<Reset>>>>() {}
        );
    }

    public List<LevelProgression> getLevelProgressions() {
        return getCollection(
            "/level_progressions",
            new TypeReference<Resource<List<Resource<LevelProgression>>>>() {}
        );
    }

    public List<ReviewStatistic> getReviewStatistics(ReviewStatisticsRequest request) {
        return getCollection(
            "/review_statistics" + request.getQueryString(),
            new TypeReference<Resource<List<Resource<ReviewStatistic>>>>() {}
        );
    }

    /**
     * Get all Voice Actors matching the given query.
     * See <a href="https://docs.api.wanikani.com/20170710/#voice-actors">WaniKani docs</a>
     */
    public List<VoiceActor> getVoiceActors(VoiceActorsRequest request) {
        return getCollection(
            "/voice_actors" + request.getQueryString(),
            new TypeReference<Resource<List<Resource<VoiceActor>>>>() {}
        );
    }

    /**
     * Convenience method that gets all Voice Actors.
     */
    public List<VoiceActor> getVoiceActors() {
        return getVoiceActors(VoiceActorsRequest.builder().build());
    }

    /**
     * Get all Study Materials matching the given query.
     * See <a href="https://docs.api.wanikani.com/20170710/#study-materials">WaniKani docs</a>
     */
    public List<StudyMaterial> getStudyMaterials(StudyMaterialsRequest request) {
        return getCollection(
            "/study_materials" + request.getQueryString(),
            new TypeReference<Resource<List<Resource<StudyMaterial>>>>() {}
        );
    }

    /**
     * Convenience method that gets all Study Materials.
     */
    public List<StudyMaterial> getStudyMaterials() {
        return getStudyMaterials(StudyMaterialsRequest.builder().build());
    }

    private <T> T getObject(final String path, TypeReference<Resource<T>> reference) {
        String response = client.get(path);
        Resource<T> resource = jsonUtils.fromJson(response, reference);
        return transformer.getData(resource);
    }

    private <T> List<T> getCollection(final String path, TypeReference<Resource<List<Resource<T>>>> reference) {
        String response = client.get(path);
        Resource<List<Resource<T>>> resource = jsonUtils.fromJson(response, reference);
        return transformer.getListData(resource);
    }
}
