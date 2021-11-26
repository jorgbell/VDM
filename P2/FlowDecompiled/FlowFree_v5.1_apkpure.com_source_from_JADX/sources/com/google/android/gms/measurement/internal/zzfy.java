package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzfy implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgh zzb;

    zzfy(zzgh zzgh, zzp zzp) {
        this.zzb = zzgh;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzH();
        zzki zzw = this.zzb.zza;
        zzp zzp = this.zza;
        zzw.zzav().zzg();
        zzw.zzr();
        Preconditions.checkNotEmpty(zzp.zza);
        zzw.zzU(zzp);
    }
}
