package com.iab.omid.library.mopub.p042b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.mopub.p044d.C2390c;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.b.e */
public class C2378e {

    /* renamed from: a */
    private static C2378e f5378a = new C2378e();

    private C2378e() {
    }

    /* renamed from: a */
    public static C2378e m5529a() {
        return f5378a;
    }

    /* renamed from: a */
    public void mo24039a(WebView webView) {
        mo24044a(webView, "finishSession", new Object[0]);
    }

    /* renamed from: a */
    public void mo24040a(WebView webView, float f) {
        mo24044a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo24041a(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            mo24048a(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }

    /* renamed from: a */
    public void mo24042a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            mo24044a(webView, "publishMediaEvent", str, jSONObject);
            return;
        }
        mo24044a(webView, "publishMediaEvent", str);
    }

    /* renamed from: a */
    public void mo24043a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        mo24044a(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24044a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            mo24047a(sb, objArr);
            sb.append(")}");
            mo24045a(webView, sb);
            return;
        }
        C2390c.m5591a("The WebView is null for " + str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24045a(final WebView webView, StringBuilder sb) {
        final String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new Runnable(this) {
                public void run() {
                    webView.loadUrl(sb2);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo24046a(WebView webView, JSONObject jSONObject) {
        mo24044a(webView, "init", jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24047a(StringBuilder sb, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append('\"');
                } else {
                    if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append('\"');
                            sb.append(obj2);
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(",");
                }
                sb.append('\"');
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
    }

    /* renamed from: a */
    public boolean mo24048a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    /* renamed from: b */
    public void mo24049b(WebView webView) {
        mo24044a(webView, "publishImpressionEvent", new Object[0]);
    }

    /* renamed from: b */
    public void mo24050b(WebView webView, String str) {
        mo24044a(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: b */
    public void mo24051b(WebView webView, JSONObject jSONObject) {
        mo24044a(webView, "publishLoadedEvent", jSONObject);
    }

    /* renamed from: c */
    public void mo24052c(WebView webView) {
        mo24044a(webView, "publishLoadedEvent", new Object[0]);
    }

    /* renamed from: c */
    public void mo24053c(WebView webView, String str) {
        mo24044a(webView, "setState", str);
    }
}
