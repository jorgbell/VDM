package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbvu implements zzeyl<zzbvt> {
    private final zzeyw<Set<zzcav<zzbvv>>> zza;

    public zzbvu(zzeyw<Set<zzcav<zzbvv>>> zzeyw) {
        this.zza = zzeyw;
    }

    public static zzbvt zzc(Set<zzcav<zzbvv>> set) {
        return new zzbvt(set);
    }

    /* renamed from: zza */
    public final zzbvt zzb() {
        return new zzbvt(((zzeyu) this.zza).zzb());
    }
}
