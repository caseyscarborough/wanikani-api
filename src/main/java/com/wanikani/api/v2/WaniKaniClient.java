package com.wanikani.api.v2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wanikani.api.v2.converter.ResourceTransformer;
import com.wanikani.api.v2.http.HttpClient;
import com.wanikani.api.v2.model.*;
import com.wanikani.api.v2.request.ReviewsRequest;
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

    public List<SrsStage> getSrsStages() {
        String response = client.request(BASE_URL + "/srs_stages");
        Resource<List<SrsStage>> resource = jsonUtils.fromJson(response, new TypeReference<Resource<List<SrsStage>>>() {
        });
        return transformer.getData(resource);
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
}
