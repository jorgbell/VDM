package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzrw extends zzaba {
    private final AppEventListener zza;

    public zzrw(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    public final void zzb(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }
}
