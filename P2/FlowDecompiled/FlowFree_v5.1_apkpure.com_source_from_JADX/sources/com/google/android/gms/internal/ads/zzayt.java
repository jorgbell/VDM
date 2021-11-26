package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzayt implements zzeyl<zzays> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzg> zzb;
    private final zzeyw<zzazt> zzc;

    public zzayt(zzeyw<Context> zzeyw, zzeyw<zzg> zzeyw2, zzeyw<zzazt> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzays(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
