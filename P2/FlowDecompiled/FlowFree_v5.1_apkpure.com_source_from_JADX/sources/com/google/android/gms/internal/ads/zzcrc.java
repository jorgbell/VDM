package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrc implements zzeyl<PackageInfo> {
    private final zzeyw<Context> zza;
    private final zzeyw<ApplicationInfo> zzb;

    public zzcrc(zzeyw<Context> zzeyw, zzeyw<ApplicationInfo> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return Wrappers.packageManager(this.zza.zzb()).getPackageInfo(((zzcqx) this.zzb).zzb().packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
