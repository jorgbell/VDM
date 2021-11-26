package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfe implements zzdiz<zzdiy<Bundle>> {
    private final Executor zza;
    private final zzbav zzb;

    zzdfe(Executor executor, zzbav zzbav) {
        this.zza = executor;
        this.zzb = zzbav;
    }

    public final zzefw<zzdiy<Bundle>> zza() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbG)).booleanValue()) {
            return zzefo.zza(null);
        }
        return zzefo.zzi(this.zzb.zzn(), zzdfc.zza, this.zza);
    }
}
