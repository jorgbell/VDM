package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdbd implements zzf {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzbud zzb;
    private final zzbuv zzc;
    private final zzcba zzd;
    private final zzcax zze;
    private final zzbmv zzf;

    zzdbd(zzbud zzbud, zzbuv zzbuv, zzcba zzcba, zzcax zzcax, zzbmv zzbmv) {
        this.zzb = zzbud;
        this.zzc = zzbuv;
        this.zzd = zzcba;
        this.zze = zzcax;
        this.zzf = zzbmv;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzbp();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
