package com.google.android.gms.internal.ads;

import com.mopub.volley.BuildConfig;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzdwv {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED(BuildConfig.VERSION_NAME),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");
    
    private final String zzi;

    private zzdwv(String str) {
        this.zzi = str;
    }

    public final String toString() {
        return this.zzi;
    }
}
