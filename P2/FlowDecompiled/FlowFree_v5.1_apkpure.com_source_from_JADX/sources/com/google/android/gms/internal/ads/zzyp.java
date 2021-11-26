package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzyp<AdT> extends zzaaj {
    private final AdLoadCallback<AdT> zza;
    private final AdT zzb;

    public zzyp(AdLoadCallback<AdT> adLoadCallback, AdT adt) {
        this.zza = adLoadCallback;
        this.zzb = adt;
    }

    public final void zzb() {
        AdT adt;
        AdLoadCallback<AdT> adLoadCallback = this.zza;
        if (adLoadCallback != null && (adt = this.zzb) != null) {
            adLoadCallback.onAdLoaded(adt);
        }
    }

    public final void zzc(zzym zzym) {
        AdLoadCallback<AdT> adLoadCallback = this.zza;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzym.zzb());
        }
    }
}
