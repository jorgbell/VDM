package com.iab.omid.library.mopub.adsession;

import com.mopub.common.AdType;

public enum AdSessionContextType {
    HTML(AdType.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");
    
    private final String typeString;

    private AdSessionContextType(String str) {
        this.typeString = str;
    }

    public String toString() {
        return this.typeString;
    }
}
