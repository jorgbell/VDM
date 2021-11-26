package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzajn extends zzait {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zza;

    public zzajn(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zza = onUnifiedNativeAdLoadedListener;
    }

    public final void zze(zzajd zzajd) {
        this.zza.onUnifiedNativeAdLoaded(new zzaje(zzajd));
    }
}
