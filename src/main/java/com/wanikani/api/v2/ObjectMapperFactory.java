package com.wanikani.api.v2;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wanikani.api.v2.util.DateUtils;

import java.io.IOException;
import java.time.LocalDateTime;

class ObjectMapperFactory {

    ObjectMapper getInstance() {
        SimpleModule dateModule = new SimpleModule();
        dateModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.registerModule(dateModule);
        return mapper;
    }

    private static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            return DateUtils.getApiDate(p.getValueAsString());
        }
    }
}
