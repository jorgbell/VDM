package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcvd implements Callable {
    private final zzcvk zza;

    zzcvd(zzcvk zzcvk) {
        this.zza = zzcvk;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
