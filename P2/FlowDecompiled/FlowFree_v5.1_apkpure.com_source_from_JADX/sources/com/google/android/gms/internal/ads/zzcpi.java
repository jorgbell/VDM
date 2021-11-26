package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcpi extends zzamm {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzbcb zzd;
    final /* synthetic */ zzcpj zze;

    zzcpi(zzcpj zzcpj, Object obj, String str, long j, zzbcb zzbcb) {
        this.zze = zzcpj;
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzbcb;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zze.zzu(this.zzb, true, "", (int) (zzs.zzj().elapsedRealtime() - this.zzc));
            this.zze.zzl.zzb(this.zzb);
            this.zze.zzo.zzb(this.zzb);
            this.zzd.zzc(Boolean.TRUE);
        }
    }

    public final void zzf(String str) {
        synchronized (this.zza) {
            this.zze.zzu(this.zzb, false, str, (int) (zzs.zzj().elapsedRealtime() - this.zzc));
            this.zze.zzl.zzc(this.zzb, "error");
            this.zze.zzo.zzc(this.zzb, "error");
            this.zzd.zzc(Boolean.FALSE);
        }
    }
}
