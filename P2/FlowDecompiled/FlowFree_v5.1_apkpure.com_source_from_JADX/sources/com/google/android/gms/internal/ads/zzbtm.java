package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbtm implements zzeyl<zzbtl> {
    private final zzeyw<zzdve> zza;
    private final zzeyw<zzbbq> zzb;
    private final zzeyw<ApplicationInfo> zzc;
    private final zzeyw<String> zzd;
    private final zzeyw<List<String>> zze;
    private final zzeyw<PackageInfo> zzf;
    private final zzeyw<zzefw<String>> zzg;
    private final zzeyw<zzg> zzh;
    private final zzeyw<String> zzi;
    private final zzeyw<zzdjc<Bundle>> zzj;

    public zzbtm(zzeyw<zzdve> zzeyw, zzeyw<zzbbq> zzeyw2, zzeyw<ApplicationInfo> zzeyw3, zzeyw<String> zzeyw4, zzeyw<List<String>> zzeyw5, zzeyw<PackageInfo> zzeyw6, zzeyw<zzefw<String>> zzeyw7, zzeyw<zzg> zzeyw8, zzeyw<String> zzeyw9, zzeyw<zzdjc<Bundle>> zzeyw10) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
        this.zzh = zzeyw8;
        this.zzi = zzeyw9;
        this.zzj = zzeyw10;
    }

    /* renamed from: zza */
    public final zzbtl zzb() {
        return new zzbtl(this.zza.zzb(), ((zzbir) this.zzb).zza(), ((zzcqx) this.zzc).zzb(), ((zzcrd) this.zzd).zzb(), zzaeq.zzc(), this.zzf.zzb(), zzeyk.zzc(this.zzg), ((zzdsj) this.zzh).zzb(), this.zzi.zzb(), ((zzdjd) this.zzj).zzb());
    }
}
