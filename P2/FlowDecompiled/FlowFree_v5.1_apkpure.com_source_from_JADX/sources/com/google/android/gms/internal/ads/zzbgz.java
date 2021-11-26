package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbgz implements Runnable {
    private final zzbhb zza;
    private final Map zzb;

    zzbgz(zzbhb zzbhb, Map map) {
        this.zza = zzbhb;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzu(this.zzb);
    }
}
