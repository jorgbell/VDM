package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcky implements zzbuy {
    private final zzbgf zza;

    zzcky(zzbgf zzbgf) {
        this.zza = zzbgf;
    }

    public final void zzb(Context context) {
        zzbgf zzbgf = this.zza;
        if (zzbgf != null) {
            zzbgf.onResume();
        }
    }

    public final void zzbn(Context context) {
        zzbgf zzbgf = this.zza;
        if (zzbgf != null) {
            zzbgf.destroy();
        }
    }

    public final void zzbq(Context context) {
        zzbgf zzbgf = this.zza;
        if (zzbgf != null) {
            zzbgf.onPause();
        }
    }
}
