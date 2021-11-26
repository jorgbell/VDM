package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzgc implements Callable<byte[]> {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgh zzc;

    zzgc(zzgh zzgh, zzas zzas, String str) {
        this.zzc = zzgh;
        this.zza = zzas;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzc.zza.zzH();
        this.zzc.zza.zzl().zzg();
        zzfp.zzP();
        throw null;
    }
}
