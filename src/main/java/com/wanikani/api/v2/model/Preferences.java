package com.wanikani.api.v2.model;

import lombok.Data;

@Data
public class Preferences {
    private int defaultVoiceActorId;
    private String reviewsPresentationOrder;
    private boolean reviewsDisplaySrsIndicator;
    private boolean reviewsAutoplayAudio;
    private int lessonsBatchSize;
    private boolean extraStudyAutoplayAudio;
    private String lessonsPresentationOrder;
    private boolean lessonsAutoplayAudio;
}
