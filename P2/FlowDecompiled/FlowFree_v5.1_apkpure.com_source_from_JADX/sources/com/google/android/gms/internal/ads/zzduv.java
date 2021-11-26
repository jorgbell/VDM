package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzduv<O> {
    final /* synthetic */ zzduw zza;
    private final Object zzb;
    private final String zzc;
    private final zzefw<?> zzd;
    private final List<zzefw<?>> zze;
    private final zzefw<O> zzf;

    private zzduv(zzduw zzduw, zzduw zzduw2, String str, zzefw zzefw, List<zzefw> list, zzefw<O> zzefw2) {
        this.zza = zzduw;
        this.zzb = zzduw2;
        this.zzc = str;
        this.zzd = zzefw;
        this.zze = list;
        this.zzf = zzefw2;
    }

    /* synthetic */ zzduv(zzduw zzduw, Object obj, String str, zzefw zzefw, List list, zzefw zzefw2, zzdul zzdul) {
        this(zzduw, obj, (String) null, zzefw, list, zzefw2);
    }

    public final zzduv<O> zza(String str) {
        return new zzduv(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final <O2> zzduv<O2> zzb(zzdui<O, O2> zzdui) {
        return zzc(new zzduq(zzdui));
    }

    public final <O2> zzduv<O2> zzc(zzeev<O, O2> zzeev) {
        return zzd(zzeev, this.zza.zzb);
    }

    public final <O2> zzduv<O2> zzd(zzeev<O, O2> zzeev, Executor executor) {
        return new zzduv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzefo.zzh(this.zzf, zzeev, executor));
    }

    public final <O2> zzduv<O2> zze(zzefw<O2> zzefw) {
        return zzd(new zzdur(zzefw), zzbbw.zzf);
    }

    public final <T extends Throwable> zzduv<O> zzf(Class<T> cls, zzdui<T, O> zzdui) {
        return zzg(cls, new zzdus(zzdui));
    }

    public final <T extends Throwable> zzduv<O> zzg(Class<T> cls, zzeev<T, O> zzeev) {
        zzduw zzduw = this.zza;
        return new zzduv(zzduw, this.zzb, this.zzc, this.zzd, this.zze, zzefo.zzf(this.zzf, cls, zzeev, zzduw.zzb));
    }

    public final zzduv<O> zzh(long j, TimeUnit timeUnit) {
        zzduw zzduw = this.zza;
        return new zzduv(zzduw, this.zzb, this.zzc, this.zzd, this.zze, zzefo.zzg(this.zzf, j, timeUnit, zzduw.zzc));
    }

    public final zzduk zzi() {
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzc(obj);
        }
        zzduk zzduk = new zzduk(obj, str, this.zzf);
        this.zza.zzd.zza(zzduk);
        zzefw<?> zzefw = this.zzd;
        zzdut zzdut = new zzdut(this, zzduk);
        zzefx zzefx = zzbbw.zzf;
        zzefw.zze(zzdut, zzefx);
        zzefo.zzo(zzduk, new zzduu(this, zzduk), zzefx);
        return zzduk;
    }

    public final zzduv<O> zzj(Object obj) {
        return this.zza.zza(obj, zzi());
    }
}
