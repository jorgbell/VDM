package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdry<T> {
    @GuardedBy("this")
    private final Deque<zzefw<T>> zza = new LinkedBlockingDeque();
    private final Callable<T> zzb;
    private final zzefx zzc;

    public zzdry(Callable<T> callable, zzefx zzefx) {
        this.zzb = callable;
        this.zzc = zzefx;
    }

    public final synchronized void zza(int i) {
        int size = i - this.zza.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }

    public final synchronized zzefw<T> zzb() {
        zza(1);
        return this.zza.poll();
    }

    public final synchronized void zzc(zzefw<T> zzefw) {
        this.zza.addFirst(zzefw);
    }
}
