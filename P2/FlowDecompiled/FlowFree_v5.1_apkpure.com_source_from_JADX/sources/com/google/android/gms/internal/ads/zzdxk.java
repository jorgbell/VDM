package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxk {
    private static zzdxk zza;
    private float zzb = 0.0f;
    private zzdxb zze;
    private zzdxd zzf;

    public zzdxk(zzdxc zzdxc, zzdxa zzdxa) {
    }

    public static zzdxk zza() {
        if (zza == null) {
            zza = new zzdxk(new zzdxc(), new zzdxa());
        }
        return zza;
    }

    public final void zzb(Context context) {
        this.zze = new zzdxb(new Handler(), context, new zzdwz(), this, (byte[]) null);
    }

    public final void zzc() {
        zzdxf.zza().zzg(this);
        zzdxf.zza().zzc();
        if (zzdxf.zza().zze()) {
            zzdyg.zzb().zzc();
        }
        this.zze.zza();
    }

    public final void zzd() {
        zzdyg.zzb().zzd();
        zzdxf.zza().zzd();
        this.zze.zzb();
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzf == null) {
            this.zzf = zzdxd.zza();
        }
        for (zzdws zzh : this.zzf.zzf()) {
            zzh.zzh().zzj(f);
        }
    }

    public final float zzf() {
        return this.zzb;
    }
}
