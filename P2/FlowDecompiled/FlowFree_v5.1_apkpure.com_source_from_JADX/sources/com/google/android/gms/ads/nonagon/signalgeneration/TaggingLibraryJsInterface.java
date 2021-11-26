package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class TaggingLibraryJsInterface {
    private final Context zza;
    /* access modifiers changed from: private */
    public final WebView zzb;

    TaggingLibraryJsInterface(WebView webView) {
        this.zzb = webView;
        this.zza = webView.getContext();
    }

    @JavascriptInterface
    @TargetApi(21)
    public String getQueryInfo() {
        zzs.zzc();
        String uuid = UUID.randomUUID().toString();
        QueryInfo.generate(this.zza, AdFormat.BANNER, new AdRequest.Builder().build(), new zzac(this, uuid));
        return uuid;
    }
}
