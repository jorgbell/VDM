package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzefa<T> extends zzefv<T> {
    private final Executor zza;
    final /* synthetic */ zzefb zzb;

    zzefa(zzefb zzefb, Executor executor) {
        this.zzb = zzefb;
        Objects.requireNonNull(executor);
        this.zza = executor;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(T t);

    /* access modifiers changed from: package-private */
    public final boolean zzd() {
        return this.zzb.isDone();
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzi(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(T t, Throwable th) {
        zzefa unused = this.zzb.zza = null;
        if (th == null) {
            zzb(t);
        } else if (th instanceof ExecutionException) {
            this.zzb.zzi(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzb.cancel(false);
        } else {
            this.zzb.zzi(th);
        }
    }
}
