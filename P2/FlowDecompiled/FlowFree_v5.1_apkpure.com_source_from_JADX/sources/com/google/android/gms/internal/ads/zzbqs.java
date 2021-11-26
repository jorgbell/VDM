package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbqs {
    public final List<? extends zzefw<? extends zzbql>> zza;

    public zzbqs(zzbql zzbql) {
        this.zza = Collections.singletonList(zzefo.zza(zzbql));
    }

    public zzbqs(List<? extends zzefw<? extends zzbql>> list) {
        this.zza = list;
    }

    public static zzcvw<zzbqs> zza(zzcyl<? extends zzbql> zzcyl) {
        return new zzcvx(zzcyl, zzbqq.zza);
    }

    public static zzcvw<zzbqs> zzb(zzcvw<? extends zzbql> zzcvw) {
        return new zzcvx(zzcvw, zzbqr.zza);
    }
}
