package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdkx implements zzeyl<zzdkv> {
    private final zzeyw<zzaun> zza;
    private final zzeyw<ScheduledExecutorService> zzb;
    private final zzeyw<Context> zzc;

    public zzdkx(zzeyw<zzaun> zzeyw, zzeyw<ScheduledExecutorService> zzeyw2, zzeyw<Context> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkv(new zzaun(), this.zzb.zzb(), ((zzbii) this.zzc).zza(), (byte[]) null);
    }
}
