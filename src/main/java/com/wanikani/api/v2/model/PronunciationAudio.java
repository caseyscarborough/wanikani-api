package com.wanikani.api.v2.model;

import lombok.Data;

@Data
public class PronunciationAudio {
    private PronunciationAudioMetadata metadata;
    private String contentType;
    private String url;
}
