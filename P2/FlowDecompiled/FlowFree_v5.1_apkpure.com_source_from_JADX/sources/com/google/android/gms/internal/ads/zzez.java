package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzez implements Runnable {
    zzez() {
    }

    public final void run() {
        try {
            zzff.zzw.zzd();
            zzff.zzw.zze();
        } catch (Exception e) {
            zzff.zzy.zzd(AdError.INTERNAL_ERROR_CODE, -1, e);
        }
    }
}
