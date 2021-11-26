package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.internal.ads.zzbhh;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzbhq;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbhg<WebViewT extends zzbhh & zzbho & zzbhq> {
    private final zzbhf zza;
    private final WebViewT zzb;

    public zzbhg(WebViewT webviewt, zzbhf zzbhf) {
        this.zza = zzbhf;
        this.zzb = webviewt;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        zzfh zzU = this.zzb.zzU();
        if (zzU == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzex zzb2 = zzU.zzb();
        if (zzb2 == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzb.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            Context context = this.zzb.getContext();
            WebViewT webviewt = this.zzb;
            return zzb2.zzh(context, str, (View) webviewt, webviewt.zzj());
        }
    }

    @JavascriptInterface
    public void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzbbk.zzi("URL is empty, ignoring message");
        } else {
            zzr.zza.post(new zzbhe(this, str));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zza.zza(Uri.parse(str));
    }
}
