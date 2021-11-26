package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczf extends zzczc<zzcbs> {
    private final zzbid zza;
    private final zzbtq zzb;
    private final zzdbl zzc;
    private final zzbzf zzd;

    public zzczf(zzbid zzbid, zzbtq zzbtq, zzdbl zzdbl, zzbzf zzbzf) {
        this.zza = zzbid;
        this.zzb = zzbtq;
        this.zzc = zzdbl;
        this.zzd = zzbzf;
    }

    /* access modifiers changed from: protected */
    public final zzefw<zzcbs> zzc(zzdrg zzdrg, Bundle bundle) {
        zzcco zzp = this.zza.zzp();
        zzbtq zzbtq = this.zzb;
        zzbtq.zzb(zzdrg);
        zzbtq.zzc(bundle);
        zzp.zzc(zzbtq.zzd());
        zzp.zzd(this.zzd);
        zzp.zzb(this.zzc);
        zzbro<zzcbs> zzb2 = zzp.zza().zzb();
        return zzb2.zzc(zzb2.zzb());
    }
}
