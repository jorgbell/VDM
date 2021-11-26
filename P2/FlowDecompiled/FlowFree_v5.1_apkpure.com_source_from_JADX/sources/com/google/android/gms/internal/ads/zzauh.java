package com.google.android.gms.internal.ads;

import com.mopub.volley.BuildConfig;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public enum zzauh {
    BEGIN_TO_RENDER("beginToRender"),
    DEFINED_BY_JAVASCRIPT("definedByJavascript"),
    ONE_PIXEL("onePixel"),
    UNSPECIFIED(BuildConfig.VERSION_NAME);
    
    private final String zze;

    private zzauh(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
