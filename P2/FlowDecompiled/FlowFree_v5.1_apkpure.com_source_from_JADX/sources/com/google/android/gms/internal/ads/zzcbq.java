package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcbq implements zzeyl<zzcbp> {
    private final zzeyw<Set<zzcav<VideoController.VideoLifecycleCallbacks>>> zza;

    public zzcbq(zzeyw<Set<zzcav<VideoController.VideoLifecycleCallbacks>>> zzeyw) {
        this.zza = zzeyw;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcbp(((zzeyu) this.zza).zzb());
    }
}
