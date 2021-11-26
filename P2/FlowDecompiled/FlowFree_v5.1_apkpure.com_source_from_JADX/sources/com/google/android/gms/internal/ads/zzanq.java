package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzanq implements Predicate {
    private final zzakp zza;

    zzanq(zzakp zzakp) {
        this.zza = zzakp;
    }

    public final boolean apply(Object obj) {
        zzakp zzakp = (zzakp) obj;
        return (zzakp instanceof zzans) && zzans.zzb((zzans) zzakp).equals(this.zza);
    }
}
