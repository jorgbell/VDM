package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcum implements zzbvr, zzbui {
    private static final Object zza = new Object();
    private static int zzb;
    private final zzg zzc;
    private final zzcuv zzd;

    public zzcum(zzcuv zzcuv, zzg zzg) {
        this.zzd = zzcuv;
        this.zzc = zzg;
    }

    private final void zzb(boolean z) {
        int i;
        int intValue;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue() && !this.zzc.zzB()) {
            Object obj = zza;
            synchronized (obj) {
                i = zzb;
                intValue = ((Integer) zzaaa.zzc().zzb(zzaeq.zzep)).intValue();
            }
            if (i < intValue) {
                this.zzd.zza(z);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    public final void zzbC(zzym zzym) {
        zzb(false);
    }

    public final void zzbD() {
        zzb(true);
    }
}
