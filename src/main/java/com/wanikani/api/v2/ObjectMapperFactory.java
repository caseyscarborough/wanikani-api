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
import java.time.ZonedDateTime;

class ObjectMapperFactory {

    ObjectMapper getInstance() {
        SimpleModule dateModule = new SimpleModule();
        dateModule.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.registerModule(dateModule);
        return mapper;
    }

    private static class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
        @Override
        public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            return DateUtils.getApiDate(p.getValueAsString());
        }
    }
}
