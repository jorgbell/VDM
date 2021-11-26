package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbtl {
    private final zzdve zza;
    private final zzbbq zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List<String> zze;
    private final PackageInfo zzf;
    private final zzeyf<zzefw<String>> zzg;
    private final String zzh;
    private final zzdjc<Bundle> zzi;

    public zzbtl(zzdve zzdve, zzbbq zzbbq, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, zzeyf<zzefw<String>> zzeyf, zzg zzg2, String str2, zzdjc<Bundle> zzdjc) {
        this.zza = zzdve;
        this.zzb = zzbbq;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzeyf;
        this.zzh = str2;
        this.zzi = zzdjc;
    }

    public final zzefw<Bundle> zza() {
        zzdve zzdve = this.zza;
        return zzdup.zza(this.zzi.zza(new Bundle()), zzduy.SIGNALS, zzdve).zzi();
    }

    public final zzefw<zzawc> zzb() {
        zzefw<Bundle> zza2 = zza();
        return this.zza.zzb(zzduy.REQUEST_PARCEL, zza2, this.zzg.zzb()).zza(new zzbtk(this, zza2)).zzi();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzawc zzc(zzefw zzefw) throws Exception {
        return new zzawc((Bundle) zzefw.get(), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (String) this.zzg.zzb().get(), this.zzh, (zzdsy) null, (String) null);
    }
}
