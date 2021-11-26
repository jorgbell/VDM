package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrg implements zzeyl<String> {
    public static zzcrg zza() {
        return zzcrf.zza;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzs.zzc();
        String uuid = UUID.randomUUID().toString();
        zzeyr.zzb(uuid);
        return uuid;
    }
}
