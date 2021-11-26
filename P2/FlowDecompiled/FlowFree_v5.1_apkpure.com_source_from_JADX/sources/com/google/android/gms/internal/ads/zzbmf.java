package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmf implements zzbuy {
    private final zzdrx zza;

    public zzbmf(zzdrx zzdrx) {
        this.zza = zzdrx;
    }

    public final void zzb(Context context) {
        try {
            this.zza.zzj();
            if (context != null) {
                this.zza.zzp(context);
            }
        } catch (zzdrl e) {
            zzbbk.zzj("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    public final void zzbn(Context context) {
        try {
            this.zza.zzf();
        } catch (zzdrl e) {
            zzbbk.zzj("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }

    public final void zzbq(Context context) {
        try {
            this.zza.zzi();
        } catch (zzdrl e) {
            zzbbk.zzj("Cannot invoke onPause for the mediation adapter.", e);
        }
    }
}
