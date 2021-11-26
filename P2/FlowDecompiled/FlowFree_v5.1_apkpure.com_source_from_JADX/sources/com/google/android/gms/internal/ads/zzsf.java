package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzsf implements Runnable {
    final ValueCallback<String> zza = new zzse(this);
    final /* synthetic */ zzrx zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzsh zze;

    zzsf(zzsh zzsh, zzrx zzrx, WebView webView, boolean z) {
        this.zze = zzsh;
        this.zzb = zzrx;
        this.zzc = webView;
        this.zzd = z;
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                ((zzse) this.zza).onReceiveValue("");
            }
        }
    }
}
