package com.google.android.gms.internal.ads;

import com.mopub.common.AdType;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzdwr {
    HTML(AdType.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");
    
    private final String zzd;

    private zzdwr(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
