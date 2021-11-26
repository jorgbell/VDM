package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdkv implements zzdiz<zzdkw> {
    final ScheduledExecutorService zza;

    public zzdkv(zzaun zzaun, ScheduledExecutorService scheduledExecutorService, Context context, byte[] bArr) {
        this.zza = scheduledExecutorService;
    }

    public final zzefw<zzdkw> zza() {
        return zzefo.zzi(zzefo.zzg(zzefo.zza(new Bundle()), ((Long) zzaaa.zzc().zzb(zzaeq.zzcn)).longValue(), TimeUnit.MILLISECONDS, this.zza), zzdku.zza, zzbbw.zza);
    }
}
