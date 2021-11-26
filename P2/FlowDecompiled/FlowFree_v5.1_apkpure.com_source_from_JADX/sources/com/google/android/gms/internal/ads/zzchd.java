package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzchd implements zzeyl<zzcav<VideoController.VideoLifecycleCallbacks>> {
    private final zzeyw<zzcjr> zzb;
    private final zzeyw<Executor> zzc;

    public zzchd(zzcgw zzcgw, zzeyw<zzcjr> zzeyw, zzeyw<Executor> zzeyw2) {
        this.zzb = zzeyw;
        this.zzc = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcav(((zzcjs) this.zzb).zzb(), this.zzc.zzb());
    }
}
