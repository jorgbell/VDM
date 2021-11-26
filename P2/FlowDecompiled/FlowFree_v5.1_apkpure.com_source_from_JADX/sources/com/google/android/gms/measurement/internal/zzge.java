package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzge implements Callable<List<zzkn>> {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgh zzb;

    zzge(zzgh zzgh, String str) {
        this.zzb = zzgh;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzH();
        return this.zzb.zza.zzi().zzl(this.zza);
    }
}
