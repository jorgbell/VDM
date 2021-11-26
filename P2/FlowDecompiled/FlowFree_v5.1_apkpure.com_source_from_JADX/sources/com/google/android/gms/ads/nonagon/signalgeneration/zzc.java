package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzc implements Callable {
    private final zzp zza;
    private final List zzb;
    private final IObjectWrapper zzc;

    zzc(zzp zzp, List list, IObjectWrapper iObjectWrapper) {
        this.zza = zzp;
        this.zzb = list;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzo(this.zzb, this.zzc);
    }
}
