package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzact implements Runnable {
    private final zzacy zza;
    private final OnInitializationCompleteListener zzb;

    zzact(zzacy zzacy, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zza = zzacy;
        this.zzb = onInitializationCompleteListener;
    }

    public final void run() {
        this.zza.zzp(this.zzb);
    }
}
