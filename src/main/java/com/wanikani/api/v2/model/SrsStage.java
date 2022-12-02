package com.wanikani.api.v2.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class SrsStage {

    private Integer interval;
    private int position;
    @JsonDeserialize(using = IntervalUnit.Deserializer.class)
    private IntervalUnit intervalUnit;
}
