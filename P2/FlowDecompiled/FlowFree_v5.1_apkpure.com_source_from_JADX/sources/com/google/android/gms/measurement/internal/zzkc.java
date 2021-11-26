package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzkc implements zzep {
    final /* synthetic */ String zza;
    final /* synthetic */ zzki zzb;

    zzkc(zzki zzki, String str) {
        this.zzb = zzki;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zzD(i, th, bArr, this.zza);
    }
}
