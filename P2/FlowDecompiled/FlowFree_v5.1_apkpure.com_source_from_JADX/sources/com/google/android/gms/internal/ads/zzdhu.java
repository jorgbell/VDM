package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdhu implements zzeyl<zzdht> {
    private final zzeyw<ApplicationInfo> zza;
    private final zzeyw<PackageInfo> zzb;

    public zzdhu(zzeyw<ApplicationInfo> zzeyw, zzeyw<PackageInfo> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public static zzdht zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzdht(applicationInfo, packageInfo);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdht(((zzcqx) this.zza).zzb(), this.zzb.zzb());
    }
}
