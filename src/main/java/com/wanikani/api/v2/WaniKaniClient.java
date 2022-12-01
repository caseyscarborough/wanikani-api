package com.wanikani.api.v2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wanikani.api.v2.model.*;
import com.wanikani.api.v2.request.AssignmentsRequest;
import com.wanikani.api.v2.request.ReviewStatisticsRequest;
import com.wanikani.api.v2.request.ReviewsRequest;
import com.wanikani.api.v2.request.SpacedRepetitionSystemsRequest;
import com.wanikani.api.v2.request.SubjectsRequest;

import java.util.List;

import static com.wanikani.api.v2.Constants.BASE_URL;

public class WaniKaniClient {

    private final HttpClient client;
    private final ResourceTransformer transformer;
    private final JsonUtils jsonUtils = new JsonUtils();

    public WaniKaniClient(String apiKey) {
        this.client = new HttpClient(apiKey);
        this.transformer = new ResourceTransformer();
    }

    public Summary getSummary() {
        String response = client.request(BASE_URL + "/summary");
        Resource<Summary> resource = jsonUtils.fromJson(response, new TypeReference<Resource<Summary>>() {
        });
        return transformer.getData(resource);
    }

    public User getUser() {
        String response = client.request(BASE_URL + "/user");
        Resource<User> resource = jsonUtils.fromJson(response, new TypeReference<Resource<User>>() {
        });
        return transformer.getData(resource);
    }

    public List<Assignment> getAssignments(AssignmentsRequest request) {
        String response = client.request(BASE_URL + "/assignments" + request.getQueryString());
        Resource<List<Resource<Assignment>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<Assignment>>>>() {
        });
        return transformer.getListData(resource);
    }

    public List<Subject> getSubjects(SubjectsRequest request) {
        String response = client.request(BASE_URL + "/subjects" + request.getQueryString());
        Resource<List<Resource<Subject>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<Subject>>>>() {
        });
        return transformer.getListData(resource);
    }

    public Subject getSubject(Integer id) {
        String response = client.request(BASE_URL + "/subjects/" + id);
        Resource<Subject> resource = jsonUtils.fromJson(response, new TypeReference<Resource<Subject>>() {
        });
        return transformer.getData(resource);
    }

    public List<Review> getReviews(ReviewsRequest request) {
        String response = client.request(BASE_URL + "/reviews" + request.getQueryString());
        Resource<List<Resource<Review>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<Review>>>>() {
        });
        return transformer.getListData(resource);
    }

    /**
     * Get all Spaced Repetition Systems matching the given query.
     * See <a href="https://docs.api.wanikani.com/20170710/#spaced-repetition-systems">WaniKani docs</a>
     */
    public List<SpacedRepetitionSystem> getSpacedRepetitionSystems(SpacedRepetitionSystemsRequest request) {
        String response = client.request(BASE_URL + "/spaced_repetition_systems" + request.getQueryString());
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
        String response = client.request(BASE_URL + "/resets");
        Resource<List<Resource<Reset>>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<Reset>>>>() {
        });
        return transformer.getListData(resource);
    }

    public List<LevelProgression> getLevelProgressions() {
        String response = client.request(BASE_URL + "/level_progressions");
        Resource<List<Resource<LevelProgression>>> resource =
                jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<LevelProgression>>>>() {
                });
        return transformer.getListData(resource);
    }

    public List<ReviewStatistic> getReviewStatistics(ReviewStatisticsRequest request) {
        String response = client.request(BASE_URL + "/review_statistics" + request.getQueryString());
        Resource<List<Resource<ReviewStatistic>>> resource =
                jsonUtils.fromJson(response, new TypeReference<Resource<List<Resource<ReviewStatistic>>>>() {
                });
        return transformer.getListData(resource);
    }
}
