package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfx implements zzdiz<zzdfy> {
    private final zzefx zza;
    private final zzcll zzb;
    private final String zzc;
    private final zzdrg zzd;

    public zzdfx(zzefx zzefx, zzcll zzcll, zzdrg zzdrg, String str) {
        this.zza = zzefx;
        this.zzb = zzcll;
        this.zzd = zzdrg;
        this.zzc = str;
    }

    public final zzefw<zzdfy> zza() {
        return this.zza.zzb(new zzdfw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfy zzb() throws Exception {
        return new zzdfy(this.zzb.zzb(this.zzd.zzf, this.zzc), this.zzb.zzc());
    }
}
