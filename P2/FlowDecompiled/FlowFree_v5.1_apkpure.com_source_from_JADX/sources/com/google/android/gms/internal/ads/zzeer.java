package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeer extends zzeeq {
    final AtomicReferenceFieldUpdater<zzeet, Set<Throwable>> zza;
    final AtomicIntegerFieldUpdater<zzeet> zzb;

    zzeer(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super((zzeep) null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeet zzeet, Set<Throwable> set, Set<Throwable> set2) {
        this.zza.compareAndSet(zzeet, (Object) null, set2);
    }

    /* access modifiers changed from: package-private */
    public final int zzb(zzeet zzeet) {
        return this.zzb.decrementAndGet(zzeet);
    }
}
