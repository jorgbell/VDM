package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfg;
import com.google.android.gms.internal.ads.zzfh;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzo implements Callable<zzfh> {
    final /* synthetic */ zzr zza;

    zzo(zzr zzr) {
        this.zza = zzr;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return new zzfh(zzfg.zzv(this.zza.zza.zza, this.zza.zzd, false, 1));
    }
}
