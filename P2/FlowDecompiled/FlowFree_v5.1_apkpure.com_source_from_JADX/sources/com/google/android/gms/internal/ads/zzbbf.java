package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzbbf implements zzbbi {
    private final int zza;
    private final Map zzb;

    zzbbf(int i, Map map) {
        this.zza = i;
        this.zzb = map;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzbbj.zzl(this.zza, this.zzb, jsonWriter);
    }
}
