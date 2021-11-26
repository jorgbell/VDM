package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzcrj;
import com.google.android.gms.internal.ads.zzeev;
import com.google.android.gms.internal.ads.zzefo;
import com.google.android.gms.internal.ads.zzefw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzz implements zzeev<zzawc, zzab> {
    private final Executor zza;
    private final zzcrj zzb;

    public zzz(Executor executor, zzcrj zzcrj) {
        this.zza = executor;
        this.zzb = zzcrj;
    }

    public final /* bridge */ /* synthetic */ zzefw zza(Object obj) throws Exception {
        zzawc zzawc = (zzawc) obj;
        return zzefo.zzh(this.zzb.zza(zzawc), new zzy(zzawc), this.zza);
    }
}
