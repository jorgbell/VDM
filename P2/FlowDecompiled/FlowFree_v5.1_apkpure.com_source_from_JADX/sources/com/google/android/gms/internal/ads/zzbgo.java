package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbgo implements zzect {
    private final Context zza;
    private final zzbhv zzb;
    private final String zzc;
    private final boolean zzd;
    private final boolean zze;
    private final zzfh zzf;
    private final zzafp zzg;
    private final zzbbq zzh;
    private final zzl zzi;
    private final zza zzj;
    private final zzug zzk;
    private final zzdqo zzl;
    private final zzdqr zzm;

    zzbgo(Context context, zzbhv zzbhv, String str, boolean z, boolean z2, zzfh zzfh, zzafp zzafp, zzbbq zzbbq, zzaff zzaff, zzl zzl2, zza zza2, zzug zzug, zzdqo zzdqo, zzdqr zzdqr) {
        this.zza = context;
        this.zzb = zzbhv;
        this.zzc = str;
        this.zzd = z;
        this.zze = z2;
        this.zzf = zzfh;
        this.zzg = zzafp;
        this.zzh = zzbbq;
        this.zzi = zzl2;
        this.zzj = zza2;
        this.zzk = zzug;
        this.zzl = zzdqo;
        this.zzm = zzdqr;
    }

    public final Object zza() {
        Context context = this.zza;
        zzbhv zzbhv = this.zzb;
        String str = this.zzc;
        boolean z = this.zzd;
        boolean z2 = this.zze;
        zzfh zzfh = this.zzf;
        zzafp zzafp = this.zzg;
        zzbbq zzbbq = this.zzh;
        zzl zzl2 = this.zzi;
        zza zza2 = this.zzj;
        zzug zzug = this.zzk;
        zzdqo zzdqo = this.zzl;
        zzdqr zzdqr = this.zzm;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = zzbgy.zza;
            zzbgu zzbgu = new zzbgu(new zzbgy(new zzbhu(context), zzbhv, str, z, z2, zzfh, zzafp, zzbbq, (zzaff) null, zzl2, zza2, zzug, zzdqo, zzdqr));
            zzbgu.setWebViewClient(zzs.zze().zzl(zzbgu, zzug, z2));
            zzbgu.setWebChromeClient(new zzbge(zzbgu));
            return zzbgu;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
