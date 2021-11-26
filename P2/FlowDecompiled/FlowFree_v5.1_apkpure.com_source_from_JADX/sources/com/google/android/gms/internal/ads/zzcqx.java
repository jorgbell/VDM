package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcqx implements zzeyl<ApplicationInfo> {
    private final zzeyw<Context> zza;

    public zzcqx(zzeyw<Context> zzeyw) {
        this.zza = zzeyw;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = this.zza.zzb().getApplicationInfo();
        zzeyr.zzb(applicationInfo);
        return applicationInfo;
    }
}
