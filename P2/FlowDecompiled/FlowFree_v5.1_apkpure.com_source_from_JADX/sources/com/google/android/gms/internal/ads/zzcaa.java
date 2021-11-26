package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcaa implements zzeyl<zzczk> {
    private final zzbzf zza;
    private final zzeyw<Clock> zzb;
    private final zzeyw<zzczl> zzc;
    private final zzeyw<zzcwb> zzd;

    public zzcaa(zzbzf zzbzf, zzeyw<Clock> zzeyw, zzeyw<zzczl> zzeyw2, zzeyw<zzcwb> zzeyw3) {
        this.zza = zzbzf;
        this.zzb = zzeyw;
        this.zzc = zzeyw2;
        this.zzd = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzczk zzp = this.zza.zzp(this.zzb.zzb(), ((zzczm) this.zzc).zzb(), this.zzd.zzb());
        zzeyr.zzb(zzp);
        return zzp;
    }
}
