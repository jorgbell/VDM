package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdez implements zzdiz<zzdfa> {
    private final zzefx zza;
    private final zzdrg zzb;
    private final zzbbq zzc;
    private final zzbaz zzd;

    public zzdez(zzefx zzefx, zzdrg zzdrg, zzbbq zzbbq, zzbaz zzbaz) {
        this.zza = zzefx;
        this.zzb = zzdrg;
        this.zzc = zzbbq;
        this.zzd = zzbaz;
    }

    public final zzefw<zzdfa> zza() {
        return this.zza.zzb(new zzdey(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfa zzb() throws Exception {
        return new zzdfa(this.zzb.zzj, this.zzc, this.zzd.zzi());
    }
}
