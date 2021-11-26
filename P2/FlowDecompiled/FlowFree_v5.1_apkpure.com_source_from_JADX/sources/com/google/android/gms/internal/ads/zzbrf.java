package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbrf implements zzp {
    private final zzbvk zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzbrf(zzbvk zzbvk) {
        this.zza = zzbvk;
    }

    public final void zzbJ() {
    }

    public final void zzbo() {
        this.zza.zzc();
    }

    public final void zzbr() {
    }

    public final void zzbs() {
    }

    public final void zzbt(int i) {
        this.zzb.set(true);
        this.zza.zza();
    }

    public final boolean zzf() {
        return this.zzb.get();
    }
}
