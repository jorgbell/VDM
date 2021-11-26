package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbgn implements zzeev {
    private final Context zza;
    private final zzfh zzb;
    private final zzbbq zzc;
    private final zza zzd;
    private final String zze;

    zzbgn(Context context, zzfh zzfh, zzbbq zzbbq, zza zza2, String str) {
        this.zza = context;
        this.zzb = zzfh;
        this.zzc = zzbbq;
        this.zzd = zza2;
        this.zze = str;
    }

    public final zzefw zza(Object obj) {
        Context context = this.zza;
        zzfh zzfh = this.zzb;
        zzbbq zzbbq = this.zzc;
        zza zza2 = this.zzd;
        String str = this.zze;
        zzs.zzd();
        zzbgf zza3 = zzbgr.zza(context, zzbhv.zzb(), "", false, false, zzfh, (zzafp) null, zzbbq, (zzaff) null, (zzl) null, zza2, zzug.zza(), (zzdqo) null, (zzdqr) null);
        zzbca zza4 = zzbca.zza(zza3);
        zza3.zzR().zzw(new zzbgp(zza4));
        zza3.loadUrl(str);
        return zza4;
    }
}
