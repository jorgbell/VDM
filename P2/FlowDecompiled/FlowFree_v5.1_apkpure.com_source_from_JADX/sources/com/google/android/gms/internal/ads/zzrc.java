package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzrc {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzrd zzb;

    public zzrc(Handler handler, zzrd zzrd) {
        Objects.requireNonNull(handler);
        this.zza = handler;
        this.zzb = zzrd;
    }

    public final void zza(zzkl zzkl) {
        this.zza.post(new zzqv(this, zzkl));
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.post(new zzqw(this, str, j, j2));
    }

    public final void zzc(zzit zzit) {
        this.zza.post(new zzqx(this, zzit));
    }

    public final void zzd(int i, long j) {
        this.zza.post(new zzqy(this, i, j));
    }

    public final void zze(int i, int i2, int i3, float f) {
        this.zza.post(new zzqz(this, i, i2, i3, f));
    }

    public final void zzf(Surface surface) {
        this.zza.post(new zzra(this, surface));
    }

    public final void zzg(zzkl zzkl) {
        this.zza.post(new zzrb(this, zzkl));
    }
}
