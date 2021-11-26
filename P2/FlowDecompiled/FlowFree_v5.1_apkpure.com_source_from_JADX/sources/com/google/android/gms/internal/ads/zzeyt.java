package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyt<T> {
    private final List<zzeyw<T>> zza;
    private final List<zzeyw<Collection<T>>> zzb;

    /* synthetic */ zzeyt(int i, int i2, zzeys zzeys) {
        this.zza = zzeyi.zza(i);
        this.zzb = zzeyi.zza(i2);
    }

    public final zzeyt<T> zza(zzeyw<? extends T> zzeyw) {
        this.zza.add(zzeyw);
        return this;
    }

    public final zzeyt<T> zzb(zzeyw<? extends Collection<? extends T>> zzeyw) {
        this.zzb.add(zzeyw);
        return this;
    }

    public final zzeyu<T> zzc() {
        return new zzeyu<>(this.zza, this.zzb, (zzeys) null);
    }
}
