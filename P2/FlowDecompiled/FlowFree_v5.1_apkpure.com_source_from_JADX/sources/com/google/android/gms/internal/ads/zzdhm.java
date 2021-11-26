package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdhm implements zzeyl<zzdhk> {
    private final zzeyw<zzefx> zza;
    private final zzeyw<zzdrg> zzb;
    private final zzeyw<PackageInfo> zzc;
    private final zzeyw<zzg> zzd;

    public zzdhm(zzeyw<zzefx> zzeyw, zzeyw<zzdrg> zzeyw2, zzeyw<PackageInfo> zzeyw3, zzeyw<zzg> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdhk(zzefx, ((zzbtw) this.zzb).zza(), this.zzc.zzb(), ((zzdsj) this.zzd).zzb());
    }
}
