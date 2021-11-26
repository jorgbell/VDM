package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzasy implements Runnable {
    final /* synthetic */ AdOverlayInfoParcel zza;
    final /* synthetic */ zzasz zzb;

    zzasy(zzasz zzasz, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzb = zzasz;
        this.zza = adOverlayInfoParcel;
    }

    public final void run() {
        zzs.zzb();
        zzn.zza(this.zzb.zza, this.zza, true);
    }
}
