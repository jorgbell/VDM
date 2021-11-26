package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final /* synthetic */ class zzfq implements Runnable {
    private final zzgh zza;
    private final String zzb;
    private final Bundle zzc;

    zzfq(zzgh zzgh, String str, Bundle bundle) {
        this.zza = zzgh;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zzv(this.zzb, this.zzc);
    }
}
