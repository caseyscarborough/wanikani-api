package com.wanikani.api.v2.model;

import lombok.Data;

@Data
public class PronunciationAudioMetadata {
    private Gender gender;
    private String pronunciation;
    private int voiceActorId;
    private String voiceActorName;
    private int sourceId;
    private String voiceDescription;
}
