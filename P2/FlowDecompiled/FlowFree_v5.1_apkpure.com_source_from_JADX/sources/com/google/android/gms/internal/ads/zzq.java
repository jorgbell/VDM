package com.google.android.gms.internal.ads;

import com.mopub.volley.DefaultRetryPolicy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzq {
    private int zza = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
    private int zzb;

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final void zzc(zzal zzal) throws zzal {
        int i = this.zzb + 1;
        this.zzb = i;
        int i2 = this.zza;
        this.zza = i2 + ((int) ((float) i2));
        if (i > 1) {
            throw zzal;
        }
    }
}
