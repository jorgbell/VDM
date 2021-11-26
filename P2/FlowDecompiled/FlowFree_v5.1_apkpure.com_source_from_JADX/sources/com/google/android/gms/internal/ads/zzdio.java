package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdio implements zzdiz<zzdip> {
    private final zzefx zza;
    private final Context zzb;
    private final zzbbq zzc;

    public zzdio(zzefx zzefx, Context context, zzbbq zzbbq) {
        this.zza = zzefx;
        this.zzb = context;
        this.zzc = zzbbq;
    }

    public final zzefw<zzdip> zza() {
        return this.zza.zzb(new zzdin(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdip zzb() throws Exception {
        int i;
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzb).isCallerInstantApp();
        zzs.zzc();
        boolean zzG = zzr.zzG(this.zzb);
        String str = this.zzc.zza;
        zzs.zze();
        boolean zzu = zzac.zzu();
        zzs.zzc();
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        if (applicationInfo == null) {
            i = 0;
        } else {
            i = applicationInfo.targetSdkVersion;
        }
        return new zzdip(isCallerInstantApp, zzG, str, zzu, i, DynamiteModule.getRemoteVersion(this.zzb, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzb, ModuleDescriptor.MODULE_ID));
    }
}
