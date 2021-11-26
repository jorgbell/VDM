package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbgg implements Runnable {
    private final zzbgm zza;
    private final View zzb;
    private final zzayr zzc;
    private final int zzd;

    zzbgg(zzbgm zzbgm, View view, zzayr zzayr, int i) {
        this.zza = zzbgm;
        this.zzb = view;
        this.zzc = zzayr;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzH(this.zzb, this.zzc, this.zzd);
    }
}
