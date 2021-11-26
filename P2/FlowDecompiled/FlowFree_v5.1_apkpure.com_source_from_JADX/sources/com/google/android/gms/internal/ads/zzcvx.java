package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcvx<DelegateT, AdapterT> implements zzcvw<AdapterT> {
    public final zzcvw<DelegateT> zza;
    private final zzecb<DelegateT, AdapterT> zzb;

    public zzcvx(zzcvw<DelegateT> zzcvw, zzecb<DelegateT, AdapterT> zzecb) {
        this.zza = zzcvw;
        this.zzb = zzecb;
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        return this.zza.zza(zzdra, zzdqo);
    }

    public final zzefw<AdapterT> zzb(zzdra zzdra, zzdqo zzdqo) {
        return zzefo.zzi(this.zza.zzb(zzdra, zzdqo), this.zzb, zzbbw.zza);
    }
}
