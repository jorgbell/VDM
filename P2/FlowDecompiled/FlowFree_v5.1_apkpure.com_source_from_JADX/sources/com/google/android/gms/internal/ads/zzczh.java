package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczh extends zzczc<zzcjw> {
    private final zzbid zza;
    private final zzbtq zzb;
    private final zzbzf zzc;

    public zzczh(zzbid zzbid, zzbtq zzbtq, zzbzf zzbzf) {
        this.zza = zzbid;
        this.zzb = zzbtq;
        this.zzc = zzbzf;
    }

    /* access modifiers changed from: protected */
    public final zzefw<zzcjw> zzc(zzdrg zzdrg, Bundle bundle) {
        zzcka zzs = this.zza.zzs();
        zzbtq zzbtq = this.zzb;
        zzbtq.zzb(zzdrg);
        zzbtq.zzc(bundle);
        zzs.zzb(zzbtq.zzd());
        zzs.zzc(this.zzc);
        zzbro<zzcjw> zzc2 = zzs.zza().zzc();
        return zzc2.zzc(zzc2.zzb());
    }
}
