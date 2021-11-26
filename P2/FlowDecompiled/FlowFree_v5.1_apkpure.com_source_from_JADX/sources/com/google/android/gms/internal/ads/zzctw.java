package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzctw implements zzcaj {
    private boolean zza = false;
    private boolean zzb = false;
    private final String zzc;
    private final zzdvo zzd;
    private final zzg zze;

    public zzctw(String str, zzdvo zzdvo) {
        this.zzc = str;
        this.zzd = zzdvo;
        this.zze = zzs.zzg().zzl();
    }

    private final zzdvn zzf(String str) {
        String str2;
        if (this.zze.zzB()) {
            str2 = "";
        } else {
            str2 = this.zzc;
        }
        zzdvn zza2 = zzdvn.zza(str);
        zza2.zzc("tms", Long.toString(zzs.zzj().elapsedRealtime(), 10));
        zza2.zzc("tid", str2);
        return zza2;
    }

    public final void zza(String str) {
        zzdvo zzdvo = this.zzd;
        zzdvn zzf = zzf("adapter_init_started");
        zzf.zzc("ancn", str);
        zzdvo.zza(zzf);
    }

    public final void zzb(String str) {
        zzdvo zzdvo = this.zzd;
        zzdvn zzf = zzf("adapter_init_finished");
        zzf.zzc("ancn", str);
        zzdvo.zza(zzf);
    }

    public final void zzc(String str, String str2) {
        zzdvo zzdvo = this.zzd;
        zzdvn zzf = zzf("adapter_init_finished");
        zzf.zzc("ancn", str);
        zzf.zzc("rqe", str2);
        zzdvo.zza(zzf);
    }

    public final synchronized void zzd() {
        if (!this.zza) {
            this.zzd.zza(zzf("init_started"));
            this.zza = true;
        }
    }

    public final synchronized void zze() {
        if (!this.zzb) {
            this.zzd.zza(zzf("init_finished"));
            this.zzb = true;
        }
    }
}
