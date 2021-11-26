package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcjo;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzl implements Runnable {
    private final zzp zza;
    private final zzcjo[] zzb;

    zzl(zzp zzp, zzcjo[] zzcjoArr) {
        this.zza = zzp;
        this.zzb = zzcjoArr;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
