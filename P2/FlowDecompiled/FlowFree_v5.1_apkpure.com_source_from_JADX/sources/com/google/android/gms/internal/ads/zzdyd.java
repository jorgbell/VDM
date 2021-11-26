package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdyd implements Runnable {
    zzdyd() {
    }

    public final void run() {
        if (zzdyg.zzc != null) {
            zzdyg.zzc.post(zzdyg.zzj);
            zzdyg.zzc.postDelayed(zzdyg.zzk, 200);
        }
    }
}
