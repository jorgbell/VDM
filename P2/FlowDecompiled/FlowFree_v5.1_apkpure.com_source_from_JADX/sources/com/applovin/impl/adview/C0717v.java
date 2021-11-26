package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.v */
public class C0717v extends WebViewClient {

    /* renamed from: a */
    private final C1107r f705a;

    /* renamed from: b */
    private WeakReference<C0718a> f706b;

    /* renamed from: com.applovin.impl.adview.v$a */
    public interface C0718a {
        /* renamed from: a */
        void mo8042a(C0716u uVar);

        /* renamed from: b */
        void mo8043b(C0716u uVar);

        /* renamed from: c */
        void mo8044c(C0716u uVar);
    }

    public C0717v(C1062k kVar) {
        this.f705a = kVar.mo9411z();
    }

    /* renamed from: a */
    private void m814a(WebView webView, String str) {
        C1107r rVar = this.f705a;
        rVar.mo9586c("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof C0716u)) {
            C0716u uVar = (C0716u) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            C0718a aVar = (C0718a) this.f706b.get();
            if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && aVar != null) {
                if ("/track_click".equals(path)) {
                    aVar.mo8042a(uVar);
                } else if ("/close_ad".equals(path)) {
                    aVar.mo8043b(uVar);
                } else if ("/skip_ad".equals(path)) {
                    aVar.mo8044c(uVar);
                } else {
                    C1107r rVar2 = this.f705a;
                    rVar2.mo9587d("WebViewButtonClient", "Unknown URL: " + str);
                    C1107r rVar3 = this.f705a;
                    rVar3.mo9587d("WebViewButtonClient", "Path: " + path);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo8300a(WeakReference<C0718a> weakReference) {
        this.f706b = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m814a(webView, str);
        return true;
    }
}
