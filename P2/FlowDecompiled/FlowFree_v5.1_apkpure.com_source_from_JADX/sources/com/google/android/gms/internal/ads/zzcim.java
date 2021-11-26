package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcim implements zzeyl<zzcik> {
    private final zzeyw<Executor> zza;
    private final zzeyw<zzbnf> zzb;
    private final zzeyw<zzcax> zzc;

    public zzcim(zzeyw<Executor> zzeyw, zzeyw<zzbnf> zzeyw2, zzeyw<zzcax> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcik(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
