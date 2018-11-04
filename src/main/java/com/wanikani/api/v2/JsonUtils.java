package com.wanikani.api.v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanikani.api.v2.exception.WaniKaniException;
import com.wanikani.api.v2.json.ObjectMapperFactory;

import java.io.IOException;

class JsonUtils {

    private final ObjectMapper mapper = new ObjectMapperFactory().getInstance();

    public String toJson(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new WaniKaniException("Could not serialize object to JSON", e);
        }
    }

    public <T> T fromJson(String json, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (IOException e) {
            throw new WaniKaniException("Could not deserialize object from JSON", e);
        }
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new WaniKaniException("Could not deserialize object from JSON", e);
        }
    }
}
