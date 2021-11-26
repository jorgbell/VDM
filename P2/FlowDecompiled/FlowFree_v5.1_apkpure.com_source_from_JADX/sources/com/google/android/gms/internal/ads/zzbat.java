package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbat extends zzb {
    final /* synthetic */ zzbav zza;

    zzbat(zzbav zzbav) {
        this.zza = zzbav;
    }

    public final void zza() {
        zzaet zzaet = new zzaet(this.zza.zze, this.zza.zzf.zza);
        synchronized (this.zza.zza) {
            try {
                zzs.zzl();
                zzaew.zza(this.zza.zzg, zzaet);
            } catch (IllegalArgumentException e) {
                zzbbk.zzj("Cannot config CSI reporter.", e);
            }
        }
    }
}
