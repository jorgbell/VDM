package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdps extends zzdyp implements zzbvr, zzbui, zzbuf, zzbut, zzbwn, zzdoc {
    private final zzdsn zza;
    private final AtomicReference<zzdyp> zzb = new AtomicReference<>();
    private final AtomicReference<zzaxs> zzc = new AtomicReference<>();
    private final AtomicReference<zzaxo> zzd = new AtomicReference<>();
    private final AtomicReference<zzawy> zze = new AtomicReference<>();
    private final AtomicReference<zzaxt> zzf = new AtomicReference<>();
    private final AtomicReference<zzawt> zzg = new AtomicReference<>();
    private final AtomicReference<zzacd> zzh = new AtomicReference<>();
    private zzdps zzi = null;

    public zzdps(zzdsn zzdsn) {
        this.zza = zzdsn;
    }

    public final void zzb(zzaxs zzaxs) {
        this.zzc.set(zzaxs);
    }

    public final void zzd() {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzd();
            return;
        }
        this.zza.zzb();
        zzdnu.zza(this.zzd, zzdpq.zza);
        zzdnu.zza(this.zze, zzdpr.zza);
    }

    public final void zzi(zzym zzym) {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzi(zzym);
            return;
        }
        zzdnu.zza(this.zzd, new zzdpf(zzym));
        zzdnu.zza(this.zzd, new zzdpg(zzym));
    }

    public final void zzj(zzaxo zzaxo) {
        this.zzd.set(zzaxo);
    }

    public final void zzk(zzyz zzyz) {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzk(zzyz);
        } else {
            zzdnu.zza(this.zzh, new zzdpj(zzyz));
        }
    }

    public final void zzl() {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzl();
        } else {
            zzdnu.zza(this.zzb, zzdph.zza);
        }
    }

    public final void zzm(zzdyp zzdyp) {
        this.zzb.set(zzdyp);
    }

    public final void zzn(zzacd zzacd) {
        this.zzh.set(zzacd);
    }

    public final void zzo(zzdoc zzdoc) {
        this.zzi = (zzdps) zzdoc;
    }

    @Deprecated
    public final void zzp(zzawy zzawy) {
        this.zze.set(zzawy);
    }

    public final void zzq(zzaxt zzaxt) {
        this.zzf.set(zzaxt);
    }

    @Deprecated
    public final void zzr(zzawt zzawt) {
        this.zzg.set(zzawt);
    }

    public final void zze() {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zze();
        } else {
            zzdnu.zza(this.zze, zzdoy.zza);
        }
    }

    public final void zzg() {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzg();
        } else {
            zzdnu.zza(this.zze, zzdoz.zza);
        }
    }

    public final void zzh() {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzh();
        } else {
            zzdnu.zza(this.zze, zzdpe.zza);
        }
    }

    public final void zzbD() {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzbD();
            return;
        }
        zzdnu.zza(this.zzc, zzdox.zza);
        zzdnu.zza(this.zze, zzdpi.zza);
    }

    public final void zzc() {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzc();
            return;
        }
        zzdnu.zza(this.zzd, zzdpn.zza);
        zzdnu.zza(this.zze, zzdpo.zza);
        zzdnu.zza(this.zzd, zzdpp.zza);
    }

    public final void zzbC(zzym zzym) {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzbC(zzym);
            return;
        }
        int i = zzym.zza;
        zzdnu.zza(this.zzc, new zzdpk(zzym));
        zzdnu.zza(this.zzc, new zzdpl(i));
        zzdnu.zza(this.zze, new zzdpm(i));
    }

    public final void zzf(zzaws zzaws, String str, String str2) {
        zzdps zzdps = this.zzi;
        if (zzdps != null) {
            zzdps.zzf(zzaws, str, str2);
            return;
        }
        zzdnu.zza(this.zzd, new zzdpa(zzaws));
        zzdnu.zza(this.zzf, new zzdpb(zzaws, str, str2));
        zzdnu.zza(this.zze, new zzdpc(zzaws));
        zzdnu.zza(this.zzg, new zzdpd(zzaws, str, str2));
    }
}
