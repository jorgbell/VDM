package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdep implements zzeyl<zzdeo> {
    private final zzeyw<Set<String>> zza;

    public zzdep(zzeyw<Set<String>> zzeyw) {
        this.zza = zzeyw;
    }

    public static zzdeo zza(Set<String> set) {
        return new zzdeo(set);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdeo(this.zza.zzb());
    }
}
