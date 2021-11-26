package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbnv extends zzbql {
    private final View zzc;
    private final zzbgf zzd;
    private final zzdqp zze;
    private final int zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final zzbnn zzi;
    private zztf zzj;

    zzbnv(zzbqk zzbqk, View view, zzbgf zzbgf, zzdqp zzdqp, int i, boolean z, boolean z2, zzbnn zzbnn) {
        super(zzbqk);
        this.zzc = view;
        this.zzd = zzbgf;
        this.zze = zzdqp;
        this.zzf = i;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = zzbnn;
    }

    public final zzdqp zza() {
        return zzdrk.zza(this.zzb.zzq, this.zze);
    }

    public final View zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzd.zzR() != null && this.zzd.zzR().zzc();
    }

    public final boolean zzg() {
        return this.zzd.zzT();
    }

    public final void zzh(zzsv zzsv) {
        this.zzd.zzax(zzsv);
    }

    public final void zzi(long j, int i) {
        this.zzi.zza(j, i);
    }

    public final void zzj(zztf zztf) {
        this.zzj = zztf;
    }

    public final zztf zzk() {
        return this.zzj;
    }
}
