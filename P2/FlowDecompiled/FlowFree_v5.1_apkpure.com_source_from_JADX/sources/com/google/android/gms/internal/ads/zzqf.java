package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzqf implements zzpy {
    private boolean zza;
    private long zzb;
    private long zzc;
    private zzix zzd = zzix.zza;

    public final long zzN() {
        long j;
        long j2 = this.zzb;
        if (!this.zza) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzc;
        zzix zzix = this.zzd;
        if (zzix.zzb == 1.0f) {
            j = zzie.zzb(elapsedRealtime);
        } else {
            j = zzix.zza(elapsedRealtime);
        }
        return j2 + j;
    }

    public final zzix zzO(zzix zzix) {
        if (this.zza) {
            zzc(zzN());
        }
        this.zzd = zzix;
        return zzix;
    }

    public final zzix zzP() {
        throw null;
    }

    public final void zza() {
        if (!this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
            this.zza = true;
        }
    }

    public final void zzb() {
        if (this.zza) {
            zzc(zzN());
            this.zza = false;
        }
    }

    public final void zzc(long j) {
        this.zzb = j;
        if (this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
        }
    }

    public final void zzd(zzpy zzpy) {
        zzc(zzpy.zzN());
        this.zzd = zzpy.zzP();
    }
}
