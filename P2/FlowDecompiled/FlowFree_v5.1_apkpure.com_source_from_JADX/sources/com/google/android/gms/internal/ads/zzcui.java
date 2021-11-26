package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcui implements Callable {
    private final zzcug zza;

    private zzcui(zzcug zzcug) {
        this.zza = zzcug;
    }

    static Callable zza(zzcug zzcug) {
        return new zzcui(zzcug);
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
