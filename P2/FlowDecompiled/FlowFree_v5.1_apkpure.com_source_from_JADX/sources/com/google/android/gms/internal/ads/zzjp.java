package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzjp {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzjq zzb;

    public zzjp(Handler handler, zzjq zzjq) {
        Objects.requireNonNull(handler);
        this.zza = handler;
        this.zzb = zzjq;
    }

    public final void zza(zzkl zzkl) {
        this.zza.post(new zzjj(this, zzkl));
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.post(new zzjk(this, str, j, j2));
    }

    public final void zzc(zzit zzit) {
        this.zza.post(new zzjl(this, zzit));
    }

    public final void zzd(int i, long j, long j2) {
        this.zza.post(new zzjm(this, i, j, j2));
    }

    public final void zze(zzkl zzkl) {
        this.zza.post(new zzjn(this, zzkl));
    }

    public final void zzf(int i) {
        this.zza.post(new zzjo(this, i));
    }
}
