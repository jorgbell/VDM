package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzefm<V> implements Runnable {
    final Future<V> zza;
    final zzefk<? super V> zzb;

    zzefm(Future<V> future, zzefk<? super V> zzefk) {
        this.zza = future;
        this.zzb = zzefk;
    }

    public final void run() {
        Throwable zza2;
        Future<V> future = this.zza;
        if (!(future instanceof zzego) || (zza2 = zzegp.zza((zzego) future)) == null) {
            try {
                this.zzb.zzb(zzefo.zzp(this.zza));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzb.zza(e2);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzecf zza2 = zzecg.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
