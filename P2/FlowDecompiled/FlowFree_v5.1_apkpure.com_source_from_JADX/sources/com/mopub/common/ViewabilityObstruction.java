package com.mopub.common;

import com.iab.omid.library.mopub.adsession.FriendlyObstructionPurpose;

public enum ViewabilityObstruction {
    VIDEO_CONTROLS(FriendlyObstructionPurpose.VIDEO_CONTROLS),
    CLOSE_BUTTON(FriendlyObstructionPurpose.CLOSE_AD),
    CTA_BUTTON(r4),
    SKIP_BUTTON(r4),
    INDUSTRY_ICON(r4),
    COUNTDOWN_TIMER(r4),
    OVERLAY(r4),
    BLUR(r4),
    PROGRESS_BAR(r4),
    NOT_VISIBLE(FriendlyObstructionPurpose.NOT_VISIBLE),
    OTHER(r4);
    
    FriendlyObstructionPurpose value;

    private ViewabilityObstruction(FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.value = friendlyObstructionPurpose;
    }
}
