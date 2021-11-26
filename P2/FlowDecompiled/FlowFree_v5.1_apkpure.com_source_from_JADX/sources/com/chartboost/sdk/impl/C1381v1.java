package com.chartboost.sdk.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C1275d;
import com.chartboost.sdk.C1277e;
import com.chartboost.sdk.C1279f;
import com.chartboost.sdk.C1284h;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C1228a;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1243c;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1381v1;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.v1 */
public class C1381v1 extends C1279f {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public long f3391A = 0;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f3392B = false;

    /* renamed from: C */
    int f3393C = 0;

    /* renamed from: D */
    int f3394D = 0;

    /* renamed from: E */
    private int f3395E = 0;

    /* renamed from: F */
    private int f3396F = 0;

    /* renamed from: G */
    private int f3397G = 0;

    /* renamed from: H */
    int f3398H = 0;

    /* renamed from: I */
    int f3399I = 0;

    /* renamed from: J */
    int f3400J = 0;

    /* renamed from: K */
    int f3401K = 0;

    /* renamed from: L */
    int f3402L = 0;

    /* renamed from: M */
    int f3403M = 0;

    /* renamed from: N */
    int f3404N = 0;

    /* renamed from: O */
    int f3405O = 0;

    /* renamed from: P */
    int f3406P = -1;

    /* renamed from: Q */
    private boolean f3407Q = true;

    /* renamed from: R */
    private int f3408R = -1;

    /* renamed from: S */
    private int f3409S = 0;

    /* renamed from: m */
    private final C1220g f3410m;

    /* renamed from: n */
    private final C1247g f3411n;

    /* renamed from: o */
    final C1277e f3412o;

    /* renamed from: p */
    String f3413p;

    /* renamed from: q */
    private String f3414q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public String f3415r = null;

    /* renamed from: s */
    private int f3416s = 1;

    /* renamed from: t */
    private int f3417t = 1;

    /* renamed from: u */
    private int f3418u = 1;

    /* renamed from: v */
    private int f3419v = 1;

    /* renamed from: w */
    private float f3420w = 0.0f;

    /* renamed from: x */
    private float f3421x = 0.0f;

    /* renamed from: y */
    private boolean f3422y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public long f3423z = 0;

    /* renamed from: com.chartboost.sdk.impl.v1$a */
    class C1382a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1385d f3424a;

        C1382a(C1385d dVar) {
            this.f3424a = dVar;
        }

        public void run() {
            if (this.f3424a.f3430i != null) {
                C1381v1.this.mo10634b("onForeground");
                this.f3424a.f3430i.onResume();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.v1$b */
    class C1383b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1385d f3426a;

        C1383b(C1385d dVar) {
            this.f3426a = dVar;
        }

        public void run() {
            if (this.f3426a.f3430i != null) {
                C1381v1.this.mo10634b("onBackground");
                this.f3426a.f3430i.onPause();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.v1$c */
    private class C1384c extends WebViewClient {

        /* renamed from: a */
        private Context f3428a;

        public C1384c(Context context) {
            this.f3428a = context;
        }

        /* renamed from: a */
        private void m3796a(String str) {
            C1266e.m3223e(new C1260a("show_webview_error", str, C1381v1.this.m3754q(), C1381v1.this.m3757v()));
            CBLogging.m2905b("CBWebViewProtocol", str);
            C1381v1.this.mo10331a(CBError.CBImpressionError.WEB_VIEW_CLIENT_RECEIVED_ERROR);
            boolean unused = C1381v1.this.f3392B = true;
            C1381v1 v1Var = C1381v1.this;
            v1Var.f3412o.mo10324e(v1Var.f3004g);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            boolean unused = C1381v1.this.f3392B = true;
            long unused2 = C1381v1.this.f3391A = System.currentTimeMillis();
            CBLogging.m2903a("CBWebViewProtocol", "Total web view load response time " + ((C1381v1.this.f3391A - C1381v1.this.f3423z) / 1000));
            Context context = webView.getContext();
            if (context != null) {
                C1381v1.this.mo10639d(context);
                C1381v1.this.mo10635c(context);
                C1381v1.this.mo10644p();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (Build.VERSION.SDK_INT >= 26) {
                PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
                if (currentWebViewPackage != null) {
                    CBLogging.m2903a("CBWebViewProtocol", "WebView version: " + currentWebViewPackage.versionName);
                    return;
                }
                m3796a(C1327i1.m3550d(this.f3428a).equalsIgnoreCase("watch") ? "No webview support." : "Device was not set up correctly.");
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            m3796a("Error loading " + str2 + ": " + str);
        }

        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error loading ");
            sb.append(webResourceRequest.getUrl().toString());
            sb.append(": ");
            sb.append(webResourceResponse == null ? "unknown error" : webResourceResponse.getReasonPhrase());
            CBLogging.m2903a("CBWebViewProtocol", sb.toString());
        }

        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String str;
            if (renderProcessGoneDetail.didCrash()) {
                str = "Webview crashed: " + renderProcessGoneDetail.toString();
            } else {
                str = "Webview killed, likely due to low memory";
            }
            m3796a(str);
            return true;
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceRequest.isForMainFrame()) {
                m3796a("Error loading " + webResourceRequest.getUrl().toString() + ": " + webResourceError.getDescription());
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.v1$d */
    public class C1385d extends C1279f.C1281b {

        /* renamed from: i */
        public C1378u1 f3430i;

        /* renamed from: j */
        public C1374t1 f3431j;

        /* renamed from: k */
        public RelativeLayout f3432k;

        /* renamed from: l */
        public RelativeLayout f3433l;

        public C1385d(Context context, String str) {
            super(context);
            setFocusable(false);
            C1284h a = C1284h.m3343a();
            this.f3432k = (RelativeLayout) a.mo10361a(new RelativeLayout(context));
            this.f3433l = (RelativeLayout) a.mo10361a(new RelativeLayout(context));
            this.f3430i = (C1378u1) a.mo10361a(new C1378u1(context));
            C1414j.m3870c(context);
            this.f3430i.setWebViewClient((WebViewClient) a.mo10361a(new C1384c(context)));
            C1374t1 t1Var = (C1374t1) a.mo10361a(new C1374t1(this.f3432k, this.f3433l, C1381v1.this, C1381v1.this.f2998a));
            this.f3431j = t1Var;
            this.f3430i.setWebChromeClient(t1Var);
            if (C1406x.m3823b().mo10695a(19)) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            this.f3430i.loadDataWithBaseURL(C1381v1.this.f3415r, str, "text/html", "utf-8", (String) null);
            this.f3432k.addView(this.f3430i);
            this.f3430i.getSettings().setSupportZoom(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.f3432k.setLayoutParams(layoutParams);
            this.f3430i.setLayoutParams(layoutParams);
            this.f3430i.setBackgroundColor(0);
            this.f3433l.setVisibility(8);
            this.f3433l.setLayoutParams(layoutParams);
            addView(this.f3432k);
            addView(this.f3433l);
            long unused = C1381v1.this.f3423z = System.currentTimeMillis();
            if (context instanceof Activity) {
                C1381v1.this.f3406P = ((Activity) context).getRequestedOrientation();
            } else {
                C1381v1.this.f3406P = -1;
            }
            C1381v1.this.f2998a.postDelayed(new Runnable() {
                public final void run() {
                    C1381v1.C1385d.this.m3797c();
                }
            }, 15000);
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m3797c() {
            if (!C1381v1.this.f3392B) {
                CBLogging.m2903a("CBWebViewProtocol", "Webview seems to be taking more time loading the html content, so closing the view.");
                C1266e.m3223e(new C1260a("show_timeout_error", "", C1381v1.this.m3754q(), C1381v1.this.m3757v()));
                C1381v1.this.mo10331a(CBError.CBImpressionError.WEB_VIEW_PAGE_LOAD_TIMEOUT);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10352a(int i, int i2) {
        }
    }

    public C1381v1(Context context, C1230c cVar, C1220g gVar, C1247g gVar2, SharedPreferences sharedPreferences, Handler handler, C1275d dVar, C1277e eVar) {
        super(context, cVar, handler, dVar);
        this.f3410m = gVar;
        this.f3411n = gVar2;
        this.f3412o = eVar;
    }

    /* renamed from: C */
    private void m3742C() {
        if (this.f3419v <= 1) {
            this.f3004g.mo10079F();
            this.f3419v++;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.f2737c;
     */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m3754q() {
        /*
            r1 = this;
            com.chartboost.sdk.Model.c r0 = r1.m3756u()
            if (r0 == 0) goto L_0x000d
            com.chartboost.sdk.impl.a r0 = r0.f2737c
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.f3036b
            return r0
        L_0x000d:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1381v1.m3754q():java.lang.String");
    }

    /* renamed from: t */
    private Map<String, List<String>> m3755t() {
        C1228a aVar;
        C1230c cVar = this.f3004g;
        if (cVar == null || (aVar = cVar.f2751q) == null) {
            return null;
        }
        return aVar.f2722o;
    }

    /* renamed from: u */
    private C1230c m3756u() {
        C1371s1 a;
        C1277e eVar = this.f3412o;
        if (eVar == null || (a = eVar.mo10318a()) == null) {
            return null;
        }
        return a.mo10604d();
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public String m3757v() {
        C1230c u = m3756u();
        return u != null ? u.f2747m : "";
    }

    /* renamed from: A */
    public void mo10623A() {
        if (this.f3418u <= 1) {
            this.f3004g.mo10098n();
            this.f3418u++;
        }
    }

    /* renamed from: B */
    public void mo10624B() {
        C1230c cVar;
        C1286a aVar;
        if (this.f3422y && (cVar = this.f3004g) != null && (aVar = cVar.f2737c) != null && aVar.f3035a == 1) {
            mo10623A();
        }
    }

    /* renamed from: D */
    public void mo10625D() {
        if (this.f3417t <= 1) {
            m3742C();
            this.f3417t++;
        }
    }

    /* renamed from: E */
    public void mo10626E() {
        C1230c cVar = this.f3004g;
        if (cVar.f2736b == 2 && !this.f3422y) {
            cVar.mo10081H();
            this.f3422y = true;
        }
        m3745a(this.f3004g);
    }

    /* renamed from: F */
    public void mo10627F() {
        if (this.f3416s <= 1) {
            this.f3004g.mo10106v();
            mo10623A();
            m3742C();
            this.f3416s++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void mo10628G() {
        Activity e = this.f2999b.mo10306e();
        if (e != null && !CBUtility.m2917a(e)) {
            int requestedOrientation = e.getRequestedOrientation();
            int i = this.f3406P;
            if (requestedOrientation != i) {
                e.setRequestedOrientation(i);
            }
            this.f3407Q = true;
            this.f3408R = -1;
        }
    }

    /* renamed from: a */
    public String mo10630a(int i) {
        return i != -1 ? i != 0 ? i != 1 ? "error" : "portrait" : "landscape" : "none";
    }

    /* renamed from: g */
    public void mo10641g(String str) {
        List<String> list;
        Map<String, List<String>> t = m3755t();
        if (t != null && !TextUtils.isEmpty(str) && (list = t.get(str)) != null) {
            for (String e : list) {
                m3752e(e);
            }
        }
    }

    /* renamed from: h */
    public void mo10642h(String str) {
        if (C1406x.m3823b().mo10696a((CharSequence) str)) {
            str = "Unknown Webview warning message";
        }
        CBLogging.m2909e("CBWebViewProtocol", "Webview warning occurred closing the webview" + str);
    }

    /* renamed from: j */
    public boolean mo10345j() {
        if (this.f3409S == 2 && this.f3004g.f2737c.f3035a == 1) {
            return true;
        }
        mo10336b();
        mo10329a();
        return true;
    }

    /* renamed from: k */
    public void mo10346k() {
        super.mo10346k();
        C1385d z = mo10344i();
        if (z != null && z.f3430i != null) {
            this.f2998a.post(new C1383b(z));
        }
    }

    /* renamed from: l */
    public void mo10347l() {
        super.mo10347l();
        C1385d z = mo10344i();
        if (z != null && z.f3430i != null) {
            this.f2998a.post(new C1382a(z));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r0.getResources().getConfiguration().orientation == 1) goto L_0x002c;
     */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10643o() {
        /*
            r3 = this;
            com.chartboost.sdk.d r0 = r3.f2999b
            android.app.Activity r0 = r0.mo10306e()
            if (r0 == 0) goto L_0x002f
            boolean r1 = com.chartboost.sdk.Libraries.CBUtility.m2917a((android.app.Activity) r0)
            if (r1 == 0) goto L_0x000f
            goto L_0x002f
        L_0x000f:
            int r1 = r3.f3408R
            r2 = 1
            if (r1 != r2) goto L_0x0015
            goto L_0x002c
        L_0x0015:
            if (r1 != 0) goto L_0x0018
            goto L_0x002b
        L_0x0018:
            boolean r1 = r3.f3407Q
            if (r1 == 0) goto L_0x001e
            r2 = -1
            goto L_0x002c
        L_0x001e:
            android.content.res.Resources r1 = r0.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            if (r1 != r2) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            r0.setRequestedOrientation(r2)
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1381v1.mo10643o():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo10644p() {
        C1385d z = mo10344i();
        if (z == null || !this.f3392B) {
            this.f3402L = this.f3398H;
            this.f3403M = this.f3399I;
            this.f3404N = this.f3400J;
            this.f3405O = this.f3401K;
            return;
        }
        int[] iArr = new int[2];
        z.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1] - this.f3397G;
        int width = z.getWidth();
        int height = z.getHeight();
        this.f3398H = i;
        this.f3399I = i2;
        int i3 = width + i;
        this.f3400J = i3;
        int i4 = height + i2;
        this.f3401K = i4;
        this.f3402L = i;
        this.f3403M = i2;
        this.f3404N = i3;
        this.f3405O = i4;
    }

    /* renamed from: r */
    public String mo10645r() {
        mo10644p();
        return C1217e.m2937a(C1217e.m2935a("x", (Object) Integer.valueOf(this.f3402L)), C1217e.m2935a("y", (Object) Integer.valueOf(this.f3403M)), C1217e.m2935a("width", (Object) Integer.valueOf(this.f3404N)), C1217e.m2935a("height", (Object) Integer.valueOf(this.f3405O))).toString();
    }

    /* renamed from: s */
    public String mo10646s() {
        mo10644p();
        return C1217e.m2937a(C1217e.m2935a("x", (Object) Integer.valueOf(this.f3398H)), C1217e.m2935a("y", (Object) Integer.valueOf(this.f3399I)), C1217e.m2935a("width", (Object) Integer.valueOf(this.f3400J)), C1217e.m2935a("height", (Object) Integer.valueOf(this.f3401K))).toString();
    }

    /* renamed from: w */
    public String mo10647w() {
        return C1217e.m2937a(C1217e.m2935a("width", (Object) Integer.valueOf(this.f3395E)), C1217e.m2935a("height", (Object) Integer.valueOf(this.f3396F))).toString();
    }

    /* renamed from: x */
    public String mo10648x() {
        return C1217e.m2937a(C1217e.m2935a("allowOrientationChange", (Object) Boolean.valueOf(this.f3407Q)), C1217e.m2935a("forceOrientation", (Object) mo10630a(this.f3408R))).toString();
    }

    /* renamed from: y */
    public String mo10649y() {
        return C1217e.m2937a(C1217e.m2935a("width", (Object) Integer.valueOf(this.f3393C)), C1217e.m2935a("height", (Object) Integer.valueOf(this.f3394D))).toString();
    }

    /* renamed from: z */
    public C1385d mo10344i() {
        return (C1385d) super.mo10344i();
    }

    /* renamed from: e */
    private void m3752e(String str) {
        if (str == null || str.isEmpty() || this.f3411n == null) {
            CBLogging.m2903a("CBWebViewProtocol", "###### Sending VAST Tracking Event Failed: " + str);
            return;
        }
        this.f3411n.mo10147a(new C1243c("GET", str, 2, (File) null));
        CBLogging.m2903a("CBWebViewProtocol", "###### Sending VAST Tracking Event: " + str);
    }

    /* renamed from: c */
    public void mo10636c(String str) {
        if (C1406x.m3823b().mo10696a((CharSequence) str)) {
            str = "Unknown Webview error";
        }
        CBLogging.m2905b("CBWebViewProtocol", "Webview error occurred closing the webview" + str);
        mo10331a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
        mo10329a();
    }

    /* renamed from: d */
    public int mo10638d(String str) {
        if (str.equals("portrait")) {
            return 1;
        }
        return str.equals("landscape") ? 0 : -1;
    }

    /* renamed from: f */
    public void mo10640f(String str) {
        CBLogging.m2903a("CBWebViewProtocol sendWebViewEvents", this.f3004g.mo10091d() + " message: " + str);
    }

    /* renamed from: b */
    public boolean mo10337b(JSONObject jSONObject) {
        File file = this.f3410m.mo10046a().f2680a;
        if (file == null) {
            CBLogging.m2905b("CBWebViewProtocol", "External Storage path is unavailable or media not mounted");
            mo10331a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
            return false;
        }
        this.f3415r = "file://" + file.getAbsolutePath() + "/";
        if (C1406x.m3823b().mo10696a((CharSequence) this.f3004g.f2751q.f2712e)) {
            CBLogging.m2905b("CBWebViewProtocol", "Invalid adId being passed in the response");
            mo10331a(CBError.CBImpressionError.ERROR_DISPLAYING_VIEW);
            return false;
        }
        String str = this.f3004g.f2750p;
        if (str == null) {
            CBLogging.m2905b("CBWebViewProtocol", "No html data found in memory");
            mo10331a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
            return false;
        }
        this.f3414q = str;
        return true;
    }

    /* renamed from: h */
    public float mo10343h() {
        return this.f3421x;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1279f.C1281b mo10328a(Context context) {
        return new C1385d(context, this.f3414q);
    }

    /* renamed from: a */
    public void mo10329a() {
        super.mo10329a();
        mo10628G();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10639d(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f3393C = displayMetrics.widthPixels;
        this.f3394D = displayMetrics.heightPixels;
    }

    /* renamed from: c */
    public void mo10637c(JSONObject jSONObject) {
        this.f3407Q = jSONObject.optBoolean("allowOrientationChange", this.f3407Q);
        this.f3408R = mo10638d(jSONObject.optString("forceOrientation", mo10630a(this.f3408R)));
        mo10643o();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo10629a(Window window) {
        return window.findViewById(16908290).getTop();
    }

    /* renamed from: g */
    public float mo10342g() {
        return this.f3420w;
    }

    /* renamed from: a */
    public void mo10631a(float f) {
        this.f3421x = f;
    }

    /* renamed from: a */
    private void m3745a(C1230c cVar) {
        if (cVar != null && cVar.f2737c.f3035a == 3) {
            C1275d dVar = this.f2999b;
            dVar.getClass();
            C1275d.C1276a aVar = new C1275d.C1276a(14);
            aVar.f2987c = cVar;
            this.f2998a.post(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10635c(Context context) {
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            this.f3397G = mo10629a(window);
            if (this.f3393C == 0 || this.f3394D == 0) {
                mo10639d(context);
            }
            int width = rect.width();
            int i = this.f3394D - this.f3397G;
            if (width != this.f3395E || i != this.f3396F) {
                this.f3395E = width;
                this.f3396F = i;
            }
        }
    }

    /* renamed from: b */
    public void mo10336b() {
        C1385d z = mo10344i();
        if (z != null) {
            if (z.f3430i != null) {
                CBLogging.m2903a("CBWebViewProtocol", "Destroying the webview object and cleaning up the references");
                z.f3430i.destroy();
                z.f3430i = null;
            }
            if (z.f3431j != null) {
                z.f3431j = null;
            }
            if (z.f3432k != null) {
                z.f3432k = null;
            }
            if (z.f3433l != null) {
                z.f3433l = null;
            }
        }
        super.mo10336b();
    }

    /* renamed from: b */
    public void mo10633b(int i) {
        this.f3409S = i;
    }

    /* renamed from: b */
    public void mo10632b(float f) {
        this.f3420w = f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10634b(String str) {
        try {
            C1385d z = mo10344i();
            if (z != null) {
                C1378u1 u1Var = z.f3430i;
                if (u1Var != null) {
                    String str2 = "javascript:Chartboost.EventHandler.handleNativeEvent(\"" + str + "\", \"\")";
                    CBLogging.m2903a("CBWebViewProtocol", "Calling native to javascript: " + str2);
                    u1Var.loadUrl(str2);
                    return;
                }
                C1266e.m3223e(new C1260a("show_webview_crash", "Webview is null", m3754q(), m3757v()));
                CBLogging.m2907c("CBWebViewProtocol", "Calling native to javascript webview is null");
            }
        } catch (Exception e) {
            C1266e.m3223e(new C1260a("show_webview_crash", "Cannot open url", m3754q(), m3757v()));
            CBLogging.m2907c("CBWebViewProtocol", "Calling native to javascript. Cannot open url: " + e.toString());
        }
    }
}
