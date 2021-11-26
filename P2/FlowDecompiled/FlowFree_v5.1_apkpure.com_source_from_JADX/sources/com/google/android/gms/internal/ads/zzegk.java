package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzegk extends zzefv {
    final /* synthetic */ zzegl zza;
    private final Callable zzb;

    zzegk(zzegl zzegl, Callable callable) {
        this.zza = zzegl;
        Objects.requireNonNull(callable);
        this.zzb = callable;
    }

    /* access modifiers changed from: package-private */
    public final Object zza() throws Exception {
        return this.zzb.call();
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd() {
        return this.zza.isDone();
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Object obj, Throwable th) {
        if (th == null) {
            this.zza.zzh(obj);
        } else {
            this.zza.zzi(th);
        }
    }
}
