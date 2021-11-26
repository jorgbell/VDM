package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcza extends zzczc<zzbqs> {
    private final zzbid zza;
    private final zzcdg zzb;
    private final zzbtq zzc;
    private final zzbzf zzd;

    public zzcza(zzbid zzbid, zzcdg zzcdg, zzbtq zzbtq, zzbzf zzbzf) {
        this.zza = zzbid;
        this.zzb = zzcdg;
        this.zzc = zzbtq;
        this.zzd = zzbzf;
    }

    /* access modifiers changed from: protected */
    public final zzefw<zzbqs> zzc(zzdrg zzdrg, Bundle bundle) {
        zzcdk zzr = this.zza.zzr();
        zzbtq zzbtq = this.zzc;
        zzbtq.zzb(zzdrg);
        zzbtq.zzc(bundle);
        zzr.zzd(zzbtq.zzd());
        zzr.zze(this.zzd);
        zzr.zzc(this.zzb);
        zzr.zzb(new zzboj((ViewGroup) null));
        zzbro<zzbqs> zza2 = zzr.zza().zza();
        return zza2.zzc(zza2.zzb());
    }
}
