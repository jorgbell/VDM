package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfa implements zzdiy<Bundle> {
    private final zzzd zza;
    private final zzbbq zzb;
    private final boolean zzc;

    public zzdfa(zzzd zzzd, zzbbq zzbbq, boolean z) {
        this.zza = zzzd;
        this.zzb = zzbbq;
        this.zzc = z;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzc >= ((Integer) zzaaa.zzc().zzb(zzaeq.zzdu)).intValue()) {
            bundle.putString("app_open_version", "2");
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdv)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        zzzd zzzd = this.zza;
        if (zzzd != null) {
            int i = zzzd.zza;
            if (i == 1) {
                bundle.putString("avo", "p");
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
