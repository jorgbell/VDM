package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbsp implements zzeyl<zzcav<zzp>> {
    private final zzeyw<zzbyc> zza;
    private final zzeyw<Executor> zzb;

    public zzbsp(zzeyw<zzbyc> zzeyw, zzeyw<Executor> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcav(this.zza.zzb(), this.zzb.zzb());
    }
}
