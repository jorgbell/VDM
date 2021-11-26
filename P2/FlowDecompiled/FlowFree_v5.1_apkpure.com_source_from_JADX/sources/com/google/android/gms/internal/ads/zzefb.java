package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzefb<V> extends zzeeo<Object, V> {
    /* access modifiers changed from: private */
    public zzefa<?> zza;

    zzefb(zzedb<? extends zzefw<?>> zzedb, boolean z, Executor executor, Callable<V> callable) {
        super(zzedb, z, false);
        this.zza = new zzeez(this, callable, executor);
        zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzB(int i) {
        super.zzB(i);
        if (i == 1) {
            this.zza = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzf() {
        zzefa<?> zzefa = this.zza;
        if (zzefa != null) {
            zzefa.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzw(int i, @NullableDecl Object obj) {
    }

    /* access modifiers changed from: package-private */
    public final void zzx() {
        zzefa<?> zzefa = this.zza;
        if (zzefa != null) {
            zzefa.zze();
        }
    }
}
