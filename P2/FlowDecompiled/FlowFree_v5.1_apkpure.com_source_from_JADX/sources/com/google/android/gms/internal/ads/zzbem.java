package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbem implements Runnable {
    private final zzbdp zza;
    private final Map zzb;

    zzbem(zzbdp zzbdp, Map map) {
        this.zza = zzbdp;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zze("onGcacheInfoEvent", this.zzb);
    }
}
