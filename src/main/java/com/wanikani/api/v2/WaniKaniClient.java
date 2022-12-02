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
        String response = client.get("/summary");
        Resource<Summary> resource = jsonUtils.fromJson(response, new TypeReference<Resource<Summary>>() {
        });
        return transformer.getData(resource);
    }

    public User getUser() {
        String response = client.get("/user");
        Resource<User> resource = jsonUtils.fromJson(response, new TypeReference<Resource<User>>() {
        });
        return transformer.getData(resource);
    }

    public List<Assignment> getAssignments(AssignmentsRequest request) {
        String response = client.get("/assignments" + request.getQueryString());
        Resource<List<Resource<Assignment>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<Assignment>>>>() {
        });
        return transformer.getListData(resource);
    }

    public List<Subject> getSubjects(SubjectsRequest request) {
        String response = client.get("/subjects" + request.getQueryString());
        Resource<List<Resource<Subject>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<Subject>>>>() {
        });
        return transformer.getListData(resource);
    }

    public Subject getSubject(Integer id) {
        String response = client.get("/subjects/" + id);
        Resource<Subject> resource = jsonUtils.fromJson(response, new TypeReference<Resource<Subject>>() {
        });
        return transformer.getData(resource);
    }

    public List<Review> getReviews(ReviewsRequest request) {
        String response = client.get("/reviews" + request.getQueryString());
        Resource<List<Resource<Review>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<Review>>>>() {
        });
        return transformer.getListData(resource);
    }

    /**
     * Get all Spaced Repetition Systems matching the given query.
     * See <a href="https://docs.api.wanikani.com/20170710/#spaced-repetition-systems">WaniKani docs</a>
     */
    public List<SpacedRepetitionSystem> getSpacedRepetitionSystems(SpacedRepetitionSystemsRequest request) {
        String response = client.get("/spaced_repetition_systems" + request.getQueryString());
        Resource<List<Resource<SpacedRepetitionSystem>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<SpacedRepetitionSystem>>>>() {
        });
        return transformer.getListData(resource);
    }

    /**
     * Convenience method that gets all Spaced Repetition Systems.
     */
    public List<SpacedRepetitionSystem> getSpacedRepetitionSystems() {
        return getSpacedRepetitionSystems(SpacedRepetitionSystemsRequest.builder().build());
    }

    public List<Reset> getResets() {
        String response = client.get("/resets");
        Resource<List<Resource<Reset>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<Reset>>>>() {
        });
        return transformer.getListData(resource);
    }

    public List<LevelProgression> getLevelProgressions() {
        String response = client.get("/level_progressions");
        Resource<List<Resource<LevelProgression>>> resource =
            jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<LevelProgression>>>>() {
            });
        return transformer.getListData(resource);
    }

    public List<ReviewStatistic> getReviewStatistics(ReviewStatisticsRequest request) {
        String response = client.get("/review_statistics" + request.getQueryString());
        Resource<List<Resource<ReviewStatistic>>> resource =
            jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<ReviewStatistic>>>>() {
            });
        return transformer.getListData(resource);
    }

    /**
     * Get all Voice Actors matching the given query.
     * See <a href="https://docs.api.wanikani.com/20170710/#voice-actors">WaniKani docs</a>
     */
    public List<VoiceActor> getVoiceActors(VoiceActorsRequest request) {
        String response = client.get("/voice_actors" + request.getQueryString());
        Resource<List<Resource<VoiceActor>>> resource =
            jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<VoiceActor>>>>() {
            });
        return transformer.getListData(resource);
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
        String response = client.get("/study_materials" + request.getQueryString());
        Resource<List<Resource<StudyMaterial>>> resource =
            jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<StudyMaterial>>>>() {
            });
        return transformer.getListData(resource);
    }

    /**
     * Convenience method that gets all Study Materials.
     */
    public List<StudyMaterial> getStudyMaterials() {
        return getStudyMaterials(StudyMaterialsRequest.builder().build());
    }
}
