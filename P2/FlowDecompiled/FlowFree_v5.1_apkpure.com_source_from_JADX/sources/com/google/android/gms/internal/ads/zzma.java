package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzma {
    public final zzmj zza = new zzmj();
    public final zzld zzb;
    public zzmh zzc;
    public zzlx zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public zzlc zzh;
    public zzmi zzi;

    public zzma(zzld zzld) {
        this.zzb = zzld;
    }

    public final void zzb() {
        zzmj zzmj = this.zza;
        zzmj.zzd = 0;
        zzmj.zzr = 0;
        zzmj.zzl = false;
        zzmj.zzq = false;
        zzmj.zzn = null;
        this.zze = 0;
        this.zzg = 0;
        this.zzf = 0;
        this.zzh = null;
        this.zzi = null;
    }

    public final void zza(zzmh zzmh, zzlx zzlx) {
        Objects.requireNonNull(zzmh);
        this.zzc = zzmh;
        Objects.requireNonNull(zzlx);
        this.zzd = zzlx;
        this.zzb.zza(zzmh.zzf);
        zzb();
    }
}
