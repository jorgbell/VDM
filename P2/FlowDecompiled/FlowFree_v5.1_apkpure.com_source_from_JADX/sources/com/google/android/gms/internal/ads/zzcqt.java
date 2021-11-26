package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcqt implements Callable {
    private final zzfh zza;
    private final Context zzb;

    zzcqt(zzfh zzfh, Context context) {
        this.zza = zzfh;
        this.zzb = context;
    }

    public final Object call() {
        zzfh zzfh = this.zza;
        return zzfh.zzb().zzl(this.zzb);
    }
}
