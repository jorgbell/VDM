package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
abstract class zzal {
    private static volatile Handler zzb;
    private final zzgk zza;
    private final Runnable zzc;
    /* access modifiers changed from: private */
    public volatile long zzd;

    zzal(zzgk zzgk) {
        Preconditions.checkNotNull(zzgk);
        this.zza = zzgk;
        this.zzc = new zzak(this, zzgk);
    }

    private final Handler zzf() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzal.class) {
            if (zzb == null) {
                zzb = new zzm(this.zza.zzax().getMainLooper());
            }
            handler = zzb;
        }
        return handler;
    }

    public abstract void zza();

    public final void zzb(long j) {
        zzd();
        if (j >= 0) {
            this.zzd = this.zza.zzay().currentTimeMillis();
            if (!zzf().postDelayed(this.zzc, j)) {
                this.zza.zzau().zzb().zzb("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzc() {
        return this.zzd != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzd() {
        this.zzd = 0;
        zzf().removeCallbacks(this.zzc);
    }
}
