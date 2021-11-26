package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbwq implements Runnable {
    private final WeakReference<zzbwr> zza;

    /* synthetic */ zzbwq(zzbwr zzbwr, zzbwp zzbwp) {
        this.zza = new WeakReference<>(zzbwr);
    }

    public final void run() {
        zzbwr zzbwr = (zzbwr) this.zza.get();
        if (zzbwr != null) {
            zzbwr.zzr(zzbwo.zza);
        }
    }
}
