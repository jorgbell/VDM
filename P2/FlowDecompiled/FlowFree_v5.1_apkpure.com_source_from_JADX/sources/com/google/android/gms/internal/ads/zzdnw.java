package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbto;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdnw<RequestComponentT extends zzbto<AdT>, AdT> implements zzdof<RequestComponentT, AdT> {
    private final zzdof<RequestComponentT, AdT> zza;
    @GuardedBy("this")
    private RequestComponentT zzb;

    public zzdnw(zzdof<RequestComponentT, AdT> zzdof) {
        this.zza = zzdof;
    }

    /* renamed from: zza */
    public final synchronized RequestComponentT zzc() {
        return this.zzb;
    }

    public final synchronized zzefw<AdT> zzb(zzdog zzdog, zzdoe<RequestComponentT> zzdoe) {
        if (zzdog.zza != null) {
            RequestComponentT requestcomponentt = (zzbto) zzdoe.zza(zzdog.zzb).zzf();
            this.zzb = requestcomponentt;
            zzbro zzc = requestcomponentt.zzc();
            return zzc.zzc(zzc.zza(zzefo.zza(zzdog.zza)));
        }
        zzefw<AdT> zzb2 = this.zza.zzb(zzdog, zzdoe);
        this.zzb = ((zzdnv) this.zza).zzc();
        return zzb2;
    }
}
