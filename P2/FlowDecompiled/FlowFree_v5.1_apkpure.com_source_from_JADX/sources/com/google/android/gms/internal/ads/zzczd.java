package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczd extends zzczc<zzbom> {
    private final zzbid zza;
    private final zzbtq zzb;
    private final zzdbl zzc;
    private final zzbzf zzd;
    private final zzcdg zze;
    private final zzbwr zzf;
    private final ViewGroup zzg;

    public zzczd(zzbid zzbid, zzbtq zzbtq, zzdbl zzdbl, zzbzf zzbzf, zzcdg zzcdg, zzbwr zzbwr, ViewGroup viewGroup) {
        this.zza = zzbid;
        this.zzb = zzbtq;
        this.zzc = zzdbl;
        this.zzd = zzbzf;
        this.zze = zzcdg;
        this.zzf = zzbwr;
        this.zzg = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final zzefw<zzbom> zzc(zzdrg zzdrg, Bundle bundle) {
        zzbpi zzk = this.zza.zzk();
        zzbtq zzbtq = this.zzb;
        zzbtq.zzb(zzdrg);
        zzbtq.zzc(bundle);
        zzk.zzj(zzbtq.zzd());
        zzk.zzk(this.zzd);
        zzk.zze(this.zzc);
        zzk.zzb(this.zze);
        zzk.zzd(new zzbqf(this.zzf));
        zzk.zzc(new zzboj(this.zzg));
        zzbro<zzbom> zzb2 = zzk.zza().zzb();
        return zzb2.zzc(zzb2.zzb());
    }
}
