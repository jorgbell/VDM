package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzctl implements zzeyl<zzctk> {
    private final zzeyw<Context> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzawo> zzc;
    private final zzeyw<zzblo> zzd;
    private final zzeyw<zzawn> zze;
    private final zzeyw<HashMap<String, zzcth>> zzf;
    private final zzeyw<zzctp> zzg;

    public zzctl(zzeyw<Context> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzawo> zzeyw3, zzeyw<zzblo> zzeyw4, zzeyw<zzawn> zzeyw5, zzeyw<HashMap<String, zzcth>> zzeyw6, zzeyw<zzctp> zzeyw7) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzctk(((zzbii) this.zza).zza(), this.zzb.zzb(), new zzawo(), ((zzbio) this.zzd).zzb(), ((zzbiz) this.zze).zzb(), this.zzf.zzb(), new zzctp(), (zzctp) null);
    }
}
