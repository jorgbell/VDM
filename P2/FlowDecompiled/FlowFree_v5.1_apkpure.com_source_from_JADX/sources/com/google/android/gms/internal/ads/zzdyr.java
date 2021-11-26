package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdyr implements Callable {
    private final Context zza;

    zzdyr(Context context) {
        this.zza = context;
    }

    public final Object call() {
        return new zzeba(this.zza, "GLAS", (String) null);
    }
}
