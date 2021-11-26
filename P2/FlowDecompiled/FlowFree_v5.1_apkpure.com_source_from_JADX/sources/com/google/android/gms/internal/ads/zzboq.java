package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzboq implements zzeyl<zzbop> {
    private final zzeyw<zzbqk> zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<zzdqp> zzc;
    private final zzeyw<View> zzd;
    private final zzeyw<zzbgf> zze;
    private final zzeyw<zzbqj> zzf;
    private final zzeyw<zzcfi> zzg;
    private final zzeyw<zzcba> zzh;
    private final zzeyw<zzdcd> zzi;
    private final zzeyw<Executor> zzj;

    public zzboq(zzeyw<zzbqk> zzeyw, zzeyw<Context> zzeyw2, zzeyw<zzdqp> zzeyw3, zzeyw<View> zzeyw4, zzeyw<zzbgf> zzeyw5, zzeyw<zzbqj> zzeyw6, zzeyw<zzcfi> zzeyw7, zzeyw<zzcba> zzeyw8, zzeyw<zzdcd> zzeyw9, zzeyw<Executor> zzeyw10) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
        this.zzh = zzeyw8;
        this.zzi = zzeyw9;
        this.zzj = zzeyw10;
    }

    public static zzbop zzc(zzbqk zzbqk, Context context, zzdqp zzdqp, View view, zzbgf zzbgf, zzbqj zzbqj, zzcfi zzcfi, zzcba zzcba, zzeyf<zzdcd> zzeyf, Executor executor) {
        return new zzbop(zzbqk, context, zzdqp, view, zzbgf, zzbqj, zzcfi, zzcba, zzeyf, executor);
    }

    /* renamed from: zza */
    public final zzbop zzb() {
        return new zzbop(((zzbsf) this.zza).zzb(), this.zzb.zzb(), ((zzbow) this.zzc).zza(), ((zzbov) this.zzd).zza(), ((zzbph) this.zze).zza(), ((zzbox) this.zzf).zza(), ((zzcdj) this.zzg).zza(), this.zzh.zzb(), zzeyk.zzc(this.zzi), this.zzj.zzb());
    }
}
