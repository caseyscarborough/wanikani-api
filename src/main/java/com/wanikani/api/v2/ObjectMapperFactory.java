package com.wanikani.api.v2;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wanikani.api.v2.model.Gender;
import com.wanikani.api.v2.util.DateUtils;

import java.io.IOException;
import java.time.ZonedDateTime;

class ObjectMapperFactory {

    ObjectMapper getInstance() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        module.addDeserializer(Gender.class, new GenderDeserializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.registerModule(module);
        return mapper;
    }

    private static class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
        @Override
        public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            return DateUtils.getApiDate(p.getValueAsString());
        }
    }

    private static class GenderDeserializer extends JsonDeserializer<Gender> {
        @Override
        public Gender deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            return Gender.findByName(p.getValueAsString());
        }
    }
}
