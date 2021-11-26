package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzbhj extends zzbgm {
    public zzbhj(zzbgf zzbgf, zzug zzug, boolean z) {
        super(zzbgf, zzug, z);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzL(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbgf)) {
            zzbbk.zzi("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbgf zzbgf = (zzbgf) webView;
        zzayr zzayr = this.zza;
        if (zzayr != null) {
            zzayr.zze(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzy(str, map);
        }
        if (zzbgf.zzR() != null) {
            zzbgf.zzR().zzA();
        }
        if (zzbgf.zzP().zzg()) {
            str2 = (String) zzaaa.zzc().zzb(zzaeq.zzJ);
        } else if (zzbgf.zzW()) {
            str2 = (String) zzaaa.zzc().zzb(zzaeq.zzI);
        } else {
            str2 = (String) zzaaa.zzc().zzb(zzaeq.zzH);
        }
        zzs.zzc();
        return zzr.zzA(zzbgf.getContext(), zzbgf.zzt().zza, str2);
    }
}
