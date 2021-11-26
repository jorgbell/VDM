package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeeh;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzeet<OutputT> extends zzeeh.zzi<OutputT> {
    private static final zzeeq zzaJ;
    private static final Logger zzaK = Logger.getLogger(zzeet.class.getName());
    private volatile int remaining;
    /* access modifiers changed from: private */
    public volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzeeq zzeeq;
        try {
            zzeeq = new zzeer(AtomicReferenceFieldUpdater.newUpdater(zzeet.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzeet.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzeeq = new zzees((zzeep) null);
        }
        zzaJ = zzeeq;
        if (th != null) {
            zzaK.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzeet(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int zzH(zzeet zzeet) {
        int i = zzeet.remaining - 1;
        zzeet.remaining = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> zzC() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzb(newSetFromMap);
        zzaJ.zza(this, (Set<Throwable>) null, newSetFromMap);
        return this.seenExceptions;
    }

    /* access modifiers changed from: package-private */
    public final int zzD() {
        return zzaJ.zzb(this);
    }

    /* access modifiers changed from: package-private */
    public final void zzE() {
        this.seenExceptions = null;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(Set<Throwable> set);
}
