package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcfu implements Runnable {
    private final zzcfw zza;
    private final ViewGroup zzb;

    zzcfu(zzcfw zzcfw, ViewGroup viewGroup) {
        this.zza = zzcfw;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zze(this.zzb);
    }
}
