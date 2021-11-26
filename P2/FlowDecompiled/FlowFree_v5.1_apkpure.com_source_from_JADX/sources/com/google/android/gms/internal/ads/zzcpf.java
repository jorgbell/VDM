package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcpf implements Runnable {
    private final zzbcb zzb;

    zzcpf(zzcpj zzcpj, zzbcb zzbcb) {
        this.zzb = zzbcb;
    }

    public final void run() {
        zzbcb zzbcb = this.zzb;
        String zzd = zzs.zzg().zzl().zzn().zzd();
        if (!TextUtils.isEmpty(zzd)) {
            zzbcb.zzc(zzd);
        } else {
            zzbcb.zzd(new Exception());
        }
    }
}
