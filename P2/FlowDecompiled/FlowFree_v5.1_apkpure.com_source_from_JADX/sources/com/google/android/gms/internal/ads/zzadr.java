package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzadr extends zzacc {
    private final OnPaidEventListener zza;

    public zzadr(OnPaidEventListener onPaidEventListener) {
        this.zza = onPaidEventListener;
    }

    public final void zze(zzyz zzyz) {
        if (this.zza != null) {
            this.zza.onPaidEvent(AdValue.zza(zzyz.zzb, zzyz.zzc, zzyz.zzd));
        }
    }
}
