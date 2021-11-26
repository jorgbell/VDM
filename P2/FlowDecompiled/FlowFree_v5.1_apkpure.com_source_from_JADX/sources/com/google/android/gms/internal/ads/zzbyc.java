package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbyc extends zzdyp implements zzbuf, zzyi, zzic, zzbwn, zzbux, zzbwc, zzp, zzbut {
    private final zzbya zza = new zzbya(this, (zzbxz) null);
    /* access modifiers changed from: private */
    @Nullable
    public zzdda zzb;
    /* access modifiers changed from: private */
    @Nullable
    public zzdde zzc;
    /* access modifiers changed from: private */
    @Nullable
    public zzdmm zzd;
    /* access modifiers changed from: private */
    @Nullable
    public zzdps zze;

    private static <T> void zzq(T t, zzbyb<T> zzbyb) {
        if (t != null) {
            zzbyb.zza(t);
        }
    }

    public final void onAdClicked() {
        zzq(this.zzb, zzbxa.zza);
        zzq(this.zzc, zzbxb.zza);
    }

    public final void zzK() {
        zzq(this.zzd, zzbxh.zza);
    }

    public final void zza(String str, String str2) {
        zzq(this.zzb, new zzbxc(str, str2));
    }

    public final void zzbJ() {
        zzq(this.zzd, zzbxq.zza);
    }

    public final void zzbo() {
        zzq(this.zzd, zzbxm.zza);
    }

    public final void zzbp() {
        zzq(this.zzb, zzbxg.zza);
    }

    public final void zzbr() {
        zzq(this.zzd, zzbxo.zza);
    }

    public final void zzbs() {
        zzq(this.zzd, zzbxp.zza);
    }

    public final void zzbt(int i) {
        zzq(this.zzd, new zzbxn(i));
    }

    public final void zzc() {
        zzq(this.zzb, zzbwx.zza);
        zzq(this.zze, zzbxi.zza);
    }

    public final void zzd() {
        zzq(this.zzb, zzbxr.zza);
        zzq(this.zze, zzbxs.zza);
    }

    public final void zze() {
        zzq(this.zzb, zzbxt.zza);
        zzq(this.zze, zzbxu.zza);
    }

    public final void zzf(zzaws zzaws, String str, String str2) {
        zzq(this.zzb, new zzbxx(zzaws, str, str2));
        zzq(this.zze, new zzbxy(zzaws, str, str2));
    }

    public final void zzg() {
        zzq(this.zzb, zzbxv.zza);
        zzq(this.zze, zzbxw.zza);
    }

    public final void zzh() {
        zzq(this.zzb, zzbwy.zza);
        zzq(this.zze, zzbwz.zza);
    }

    public final void zzi(zzym zzym) {
        zzq(this.zze, new zzbxk(zzym));
        zzq(this.zzb, new zzbxl(zzym));
    }

    public final zzbya zzj() {
        return this.zza;
    }

    public final void zzk(zzyz zzyz) {
        zzq(this.zzb, new zzbxd(zzyz));
        zzq(this.zze, new zzbxe(zzyz));
        zzq(this.zzd, new zzbxf(zzyz));
    }

    public final void zzl() {
        zzq(this.zze, zzbxj.zza);
    }
}
