package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdxi implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;

    zzdxi(zzdxj zzdxj, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
    }

    public final void run() {
        this.zza.loadUrl(this.zzb);
    }
}
