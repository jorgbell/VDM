package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzegj extends zzefv<zzefw> {
    final /* synthetic */ zzegl zza;
    private final zzeeu zzb;

    zzegj(zzegl zzegl, zzeeu zzeeu) {
        this.zza = zzegl;
        Objects.requireNonNull(zzeeu);
        this.zzb = zzeeu;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzefw zza2 = this.zzb.zza();
        zzecl.zzc(zza2, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzb);
        return zza2;
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
    public final /* bridge */ /* synthetic */ void zzf(Object obj, Throwable th) {
        zzefw zzefw = (zzefw) obj;
        if (th == null) {
            this.zza.zzj(zzefw);
        } else {
            this.zza.zzi(th);
        }
    }
}
