package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbdr implements Runnable {
    private final zzbdf zza;
    private boolean zzb = false;

    zzbdr(zzbdf zzbdf) {
        this.zza = zzbdf;
    }

    private final void zzc() {
        zzebq zzebq = zzr.zza;
        zzebq.removeCallbacks(this);
        zzebq.postDelayed(this, 250);
    }

    public final void run() {
        if (!this.zzb) {
            this.zza.zzD();
            zzc();
        }
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzD();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
