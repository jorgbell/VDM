package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzegl<V> extends zzefe<V> implements RunnableFuture<V> {
    private volatile zzefv<?> zza;

    zzegl(zzeeu<V> zzeeu) {
        this.zza = new zzegj(this, zzeeu);
    }

    static <V> zzegl<V> zza(Runnable runnable, @NullableDecl V v) {
        return new zzegl<>(Executors.callable(runnable, v));
    }

    public final void run() {
        zzefv<?> zzefv = this.zza;
        if (zzefv != null) {
            zzefv.run();
        }
        this.zza = null;
    }

    /* access modifiers changed from: protected */
    public final String zzc() {
        zzefv<?> zzefv = this.zza;
        if (zzefv == null) {
            return super.zzc();
        }
        String valueOf = String.valueOf(zzefv);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
        sb.append("task=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        zzefv<?> zzefv;
        if (zzg() && (zzefv = this.zza) != null) {
            zzefv.zzg();
        }
        this.zza = null;
    }

    zzegl(Callable<V> callable) {
        this.zza = new zzegk(this, callable);
    }
}
