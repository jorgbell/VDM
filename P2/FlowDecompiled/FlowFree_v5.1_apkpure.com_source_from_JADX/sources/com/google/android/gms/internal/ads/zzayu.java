package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzayu {
    private final Clock zza;
    private final zzg zzb;
    private final zzazt zzc;

    zzayu(Clock clock, zzg zzg, zzazt zzazt) {
        this.zza = clock;
        this.zzb = zzg;
        this.zzc = zzazt;
    }

    public final void zza(int i, long j) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzak)).booleanValue()) {
            if (j - this.zzb.zzD() < 0) {
                zze.zza("Receiving npa decision in the past, ignoring.");
                return;
            }
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzal)).booleanValue()) {
                this.zzb.zzC(-1);
                this.zzb.zzE(j);
            } else {
                this.zzb.zzC(i);
                this.zzb.zzE(j);
            }
            zzb();
        }
    }

    public final void zzb() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzal)).booleanValue()) {
            this.zzc.zza();
        }
    }
}
