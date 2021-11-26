package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbvn;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzday<AdT, AdapterT, ListenerT extends zzbvn> implements zzeyl<zzdax<AdT, AdapterT, ListenerT>> {
    private final zzeyw<zzdve> zza;
    private final zzeyw<zzefx> zzb;
    private final zzeyw<zzcvy<AdapterT, ListenerT>> zzc;
    private final zzeyw<zzcwe<AdT, AdapterT, ListenerT>> zzd;

    public zzday(zzeyw<zzdve> zzeyw, zzeyw<zzefx> zzeyw2, zzeyw<zzcvy<AdapterT, ListenerT>> zzeyw3, zzeyw<zzcwe<AdT, AdapterT, ListenerT>> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    /* renamed from: zza */
    public final zzdax<AdT, AdapterT, ListenerT> zzb() {
        return new zzdax<>(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb());
    }
}
