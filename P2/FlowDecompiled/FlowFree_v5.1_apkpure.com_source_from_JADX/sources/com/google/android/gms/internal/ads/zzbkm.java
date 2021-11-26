package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zza;
import com.google.android.gms.ads.nonagon.signalgeneration.zzb;
import com.google.android.gms.ads.nonagon.signalgeneration.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbkm implements zza {
    final /* synthetic */ zzbko zza;
    private zzbtr zzb;
    private zzt zzc;

    /* synthetic */ zzbkm(zzbko zzbko, zzbjd zzbjd) {
        this.zza = zzbko;
    }

    public final zzb zza() {
        zzeyr.zzc(this.zzb, zzbtr.class);
        zzeyr.zzc(this.zzc, zzt.class);
        return new zzbkn(this.zza, this.zzc, new zzbrq(), new zzcnv(), this.zzb, new zzdsi(), (zzdol) null, (zzdnn) null, (zzbjd) null);
    }

    public final /* bridge */ /* synthetic */ zza zzb(zzt zzt) {
        this.zzc = zzt;
        return this;
    }

    public final /* bridge */ /* synthetic */ zza zzc(zzbtr zzbtr) {
        this.zzb = zzbtr;
        return this;
    }
}
