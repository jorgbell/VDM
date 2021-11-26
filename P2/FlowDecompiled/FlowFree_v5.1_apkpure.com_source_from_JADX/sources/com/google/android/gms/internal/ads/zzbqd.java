package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbqd implements zzbvr, zzri {
    private final zzdqo zza;
    private final zzbuv zzb;
    private final zzbwa zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzbqd(zzdqo zzdqo, zzbuv zzbuv, zzbwa zzbwa) {
        this.zza = zzdqo;
        this.zzb = zzbuv;
        this.zzc = zzbwa;
    }

    private final void zzb() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final synchronized void zzbD() {
        if (this.zza.zze != 1) {
            zzb();
        }
    }

    public final void zzc(zzrh zzrh) {
        if (this.zza.zze == 1 && zzrh.zzj) {
            zzb();
        }
        if (zzrh.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }
}
