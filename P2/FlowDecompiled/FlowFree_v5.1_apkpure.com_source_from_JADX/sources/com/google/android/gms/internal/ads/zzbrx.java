package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbrx implements zzbvr, zzyi, zzbww, zzbux, zzbuf, zzbyz {
    private final Clock zza;
    private final zzbaq zzb;

    public zzbrx(Clock clock, zzbaq zzbaq) {
        this.zza = clock;
        this.zzb = zzbaq;
    }

    public final void onAdClicked() {
        this.zzb.zze();
    }

    public final void zzbD() {
        this.zzb.zzg(true);
    }

    public final void zzbp() {
        this.zzb.zzd();
    }

    public final void zzc() {
    }

    public final void zzd() {
        this.zzb.zzf();
    }

    public final void zze() {
    }

    public final void zzf(zzaws zzaws, String str, String str2) {
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi(zzys zzys) {
        this.zzb.zza(zzys);
    }

    public final void zzj(zzawc zzawc) {
    }

    public final void zzk(zzvd zzvd) {
        this.zzb.zzb();
    }

    public final void zzl(zzvd zzvd) {
    }

    public final void zzm(zzvd zzvd) {
    }

    public final void zzn(boolean z) {
    }

    public final void zzo(boolean z) {
    }

    public final void zzp() {
    }

    public final void zzq(zzdra zzdra) {
        this.zzb.zzc(this.zza.elapsedRealtime());
    }

    public final String zzr() {
        return this.zzb.zzi();
    }
}
