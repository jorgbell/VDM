package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzazp implements Callable {
    private final zzazt zza;
    private final Context zzb;

    zzazp(zzazt zzazt, Context context) {
        this.zza = zzazt;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzt(this.zzb);
    }
}
