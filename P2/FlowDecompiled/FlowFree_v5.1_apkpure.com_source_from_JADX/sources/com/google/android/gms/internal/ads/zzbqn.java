package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbqn<AdT> implements zzbqo<AdT> {
    private final Map<String, zzcvw<AdT>> zza;

    zzbqn(Map<String, zzcvw<AdT>> map) {
        this.zza = map;
    }

    public final zzcvw<AdT> zza(int i, String str) {
        return this.zza.get(str);
    }
}
