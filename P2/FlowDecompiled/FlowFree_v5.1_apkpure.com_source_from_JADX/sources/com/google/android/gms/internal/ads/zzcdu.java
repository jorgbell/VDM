package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcdu implements zzakp<Object> {
    private final WeakReference<zzcdx> zza;

    /* synthetic */ zzcdu(zzcdx zzcdx, zzcdt zzcdt) {
        this.zza = new WeakReference<>(zzcdx);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzcdx zzcdx = (zzcdx) this.zza.get();
        if (zzcdx != null && "_ac".equals(map.get("eventName"))) {
            zzcdx.zzh.onAdClicked();
        }
    }
}
