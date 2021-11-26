package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeez extends zzefa {
    final /* synthetic */ zzefb zza;
    private final Callable zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeez(zzefb zzefb, Callable callable, Executor executor) {
        super(zzefb, executor);
        this.zza = zzefb;
        Objects.requireNonNull(callable);
        this.zzc = callable;
    }

    /* access modifiers changed from: package-private */
    public final Object zza() throws Exception {
        return this.zzc.call();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj) {
        this.zza.zzh(obj);
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zzc.toString();
    }
}
