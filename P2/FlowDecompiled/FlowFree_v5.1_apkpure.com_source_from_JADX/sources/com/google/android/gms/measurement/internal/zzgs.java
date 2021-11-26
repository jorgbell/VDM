package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final /* synthetic */ class zzgs implements Runnable {
    private final zzhr zza;
    private final Bundle zzb;

    zzgs(zzhr zzhr, Bundle bundle) {
        this.zza = zzhr;
        this.zzb = bundle;
    }

    public final void run() {
        this.zza.zzU(this.zzb);
    }
}
