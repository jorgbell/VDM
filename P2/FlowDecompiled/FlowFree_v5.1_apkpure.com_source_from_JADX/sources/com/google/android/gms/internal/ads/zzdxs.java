package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdxs implements Runnable {
    final /* synthetic */ zzdxt zza;
    private final WebView zzb;

    zzdxs(zzdxt zzdxt) {
        this.zza = zzdxt;
        this.zzb = zzdxt.zza;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
