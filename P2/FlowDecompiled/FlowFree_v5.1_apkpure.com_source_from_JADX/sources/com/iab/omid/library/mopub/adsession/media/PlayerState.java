package com.iab.omid.library.mopub.adsession.media;

import com.mopub.common.AdType;

public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN(AdType.FULLSCREEN);
    
    private final String playerState;

    private PlayerState(String str) {
        this.playerState = str;
    }

    public String toString() {
        return this.playerState;
    }
}
