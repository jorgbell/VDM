package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzees extends zzeeq {
    /* synthetic */ zzees(zzeep zzeep) {
        super((zzeep) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeet zzeet, Set<Throwable> set, Set<Throwable> set2) {
        synchronized (zzeet) {
            if (zzeet.seenExceptions == null) {
                Set unused = zzeet.seenExceptions = set2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzb(zzeet zzeet) {
        int zzH;
        synchronized (zzeet) {
            zzH = zzeet.zzH(zzeet);
        }
        return zzH;
    }
}
