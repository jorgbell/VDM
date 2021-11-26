package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzedp extends zzede<Map.Entry> {
    final /* synthetic */ zzedq zza;

    zzedp(zzedq zzedq) {
        this.zza = zzedq;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzecl.zzd(i, this.zza.zzc, "index");
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(this.zza.zzb[i2], this.zza.zzb[i2 + 1]);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
