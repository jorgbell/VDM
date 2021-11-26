package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxt extends zzdxq {
    /* access modifiers changed from: private */
    public WebView zza;
    private Long zzb = null;
    private final Map<String, zzdwy> zzc;

    public zzdxt(Map<String, zzdwy> map, String str) {
        this.zzc = map;
    }

    public final void zza() {
        WebView webView = new WebView(zzdxh.zza().zzb());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        zzc(this.zza);
        WebView webView2 = this.zza;
        if (webView2 != null && !TextUtils.isEmpty((CharSequence) null)) {
            webView2.loadUrl("null".length() != 0 ? "javascript: ".concat("null") : new String("javascript: "));
        }
        Iterator<String> it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
        } else {
            zzdwy zzdwy = this.zzc.get(it.next());
            throw null;
        }
    }

    public final void zzb() {
        long j;
        super.zzb();
        if (this.zzb == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzdxs(this), Math.max(4000 - j, 2000));
        this.zza = null;
    }

    public final void zzh(zzdws zzdws, zzdwq zzdwq) {
        JSONObject jSONObject = new JSONObject();
        Map<String, zzdwy> zzf = zzdwq.zzf();
        for (String next : zzf.keySet()) {
            zzdxu.zzc(jSONObject, next, zzf.get(next));
        }
        zzi(zzdws, zzdwq, jSONObject);
    }
}
