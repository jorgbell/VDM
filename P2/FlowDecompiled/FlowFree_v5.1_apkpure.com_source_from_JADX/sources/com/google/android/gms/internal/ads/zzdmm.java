package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdmm implements zzbui, zzbwc, zzdoc, zzp, zzbwn {
    private final zzdsn zza;
    private final AtomicReference<zzte> zzb = new AtomicReference<>();
    private final AtomicReference<zztf> zzc = new AtomicReference<>();
    private final AtomicReference<zzti> zzd = new AtomicReference<>();
    private final AtomicReference<zzbwc> zze = new AtomicReference<>();
    private final AtomicReference<zzp> zzf = new AtomicReference<>();
    private final AtomicReference<zzacd> zzg = new AtomicReference<>();
    private zzdmm zzh = null;

    public zzdmm(zzdsn zzdsn) {
        this.zza = zzdsn;
    }

    public static zzdmm zzf(zzdmm zzdmm) {
        zzdmm zzdmm2 = new zzdmm(zzdmm.zza);
        zzdmm2.zzh = zzdmm;
        return zzdmm2;
    }

    public final void zzK() {
        zzdmm zzdmm = this.zzh;
        if (zzdmm != null) {
            zzdmm.zzK();
        } else {
            zzdnu.zza(this.zze, zzdmi.zza);
        }
    }

    public final void zzbJ() {
    }

    public final void zzbo() {
        zzdmm zzdmm = this.zzh;
        if (zzdmm != null) {
            zzdmm.zzbo();
            return;
        }
        zzdnu.zza(this.zzf, zzdmj.zza);
        zzdnu.zza(this.zzd, zzdmk.zza);
        zzdnu.zza(this.zzd, zzdml.zza);
    }

    public final void zzbr() {
        zzdmm zzdmm = this.zzh;
        if (zzdmm != null) {
            zzdmm.zzbr();
        } else {
            zzdnu.zza(this.zzf, zzdmc.zza);
        }
    }

    public final void zzbs() {
    }

    public final void zzbt(int i) {
        zzdmm zzdmm = this.zzh;
        if (zzdmm != null) {
            zzdmm.zzbt(i);
        } else {
            zzdnu.zza(this.zzf, new zzdmb(i));
        }
    }

    public final void zzg(zzte zzte) {
        this.zzb.set(zzte);
    }

    public final void zzh(zzti zzti) {
        this.zzd.set(zzti);
    }

    public final void zzi(zzbwc zzbwc) {
        this.zze.set(zzbwc);
    }

    public final void zzj(zzp zzp) {
        this.zzf.set(zzp);
    }

    public final void zzk(zzyz zzyz) {
        zzdmm zzdmm = this.zzh;
        if (zzdmm != null) {
            zzdmm.zzk(zzyz);
        } else {
            zzdnu.zza(this.zzg, new zzdma(zzyz));
        }
    }

    public final void zzl(zzacd zzacd) {
        this.zzg.set(zzacd);
    }

    public final void zzn() {
        zzdmm zzdmm = this.zzh;
        if (zzdmm != null) {
            zzdmm.zzn();
            return;
        }
        this.zza.zzb();
        zzdnu.zza(this.zzc, zzdmg.zza);
        zzdnu.zza(this.zzd, zzdmh.zza);
    }

    public final void zzo(zzdoc zzdoc) {
        this.zzh = (zzdmm) zzdoc;
    }

    public final void zzp(zztf zztf) {
        this.zzc.set(zztf);
    }

    public final void zzm(zztb zztb) {
        zzdmm zzdmm = this.zzh;
        if (zzdmm != null) {
            zzdmm.zzm(zztb);
        } else {
            zzdnu.zza(this.zzb, new zzdmd(zztb));
        }
    }

    public final void zzbC(zzym zzym) {
        zzdmm zzdmm = this.zzh;
        if (zzdmm != null) {
            zzdmm.zzbC(zzym);
            return;
        }
        zzdnu.zza(this.zzb, new zzdme(zzym));
        zzdnu.zza(this.zzb, new zzdmf(zzym));
    }
}
