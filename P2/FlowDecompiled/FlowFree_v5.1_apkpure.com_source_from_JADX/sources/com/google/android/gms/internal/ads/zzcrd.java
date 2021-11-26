package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrd implements zzeyl<String> {
    private final zzeyw<Context> zza;

    public zzcrd(zzeyw<Context> zzeyw) {
        this.zza = zzeyw;
    }

    /* renamed from: zza */
    public final String zzb() {
        String packageName = ((zzdsk) this.zza).zza().getPackageName();
        zzeyr.zzb(packageName);
        return packageName;
    }
}
