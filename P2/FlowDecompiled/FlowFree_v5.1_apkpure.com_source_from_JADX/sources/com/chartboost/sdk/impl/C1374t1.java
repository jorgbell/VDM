package com.chartboost.sdk.impl;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C1408x1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.t1 */
public class C1374t1 extends WebChromeClient implements C1408x1.C1409a {

    /* renamed from: a */
    private View f3375a;

    /* renamed from: b */
    private ViewGroup f3376b;

    /* renamed from: c */
    private boolean f3377c = false;

    /* renamed from: d */
    private FrameLayout f3378d;

    /* renamed from: e */
    private WebChromeClient.CustomViewCallback f3379e;

    /* renamed from: f */
    private C1375a f3380f;

    /* renamed from: g */
    private final C1381v1 f3381g;

    /* renamed from: h */
    private final Handler f3382h;

    /* renamed from: i */
    private C1408x1 f3383i;

    /* renamed from: j */
    private C1388w1 f3384j;

    /* renamed from: com.chartboost.sdk.impl.t1$a */
    public interface C1375a {
        /* renamed from: a */
        void mo10617a(boolean z);
    }

    public C1374t1(View view, ViewGroup viewGroup, C1381v1 v1Var, Handler handler) {
        this.f3375a = view;
        this.f3376b = viewGroup;
        this.f3381g = v1Var;
        this.f3382h = handler;
        this.f3384j = new C1388w1(this, v1Var);
        this.f3383i = new C1408x1();
    }

    /* renamed from: a */
    private void m3728a(String str) {
        C1408x1 x1Var = this.f3383i;
        if (x1Var != null) {
            x1Var.mo10702a(str, this);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String simpleName = C1374t1.class.getSimpleName();
        Log.d(simpleName, "Chartboost Webview:" + message + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
        m3728a(message);
        return true;
    }

    public void onHideCustomView() {
        if (this.f3377c) {
            this.f3376b.setVisibility(4);
            this.f3376b.removeView(this.f3378d);
            this.f3375a.setVisibility(0);
            WebChromeClient.CustomViewCallback customViewCallback = this.f3379e;
            if (customViewCallback != null && !customViewCallback.getClass().getName().contains(".chromium.")) {
                this.f3379e.onCustomViewHidden();
            }
            this.f3377c = false;
            this.f3378d = null;
            this.f3379e = null;
            C1375a aVar = this.f3380f;
            if (aVar != null) {
                aVar.mo10617a(false);
            }
        }
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jsPromptResult.confirm(mo10610a(jSONObject.getJSONObject("eventArgs"), jSONObject.getString("eventType")));
            return true;
        } catch (JSONException unused) {
            CBLogging.m2905b("CBWebChromeClient", "Exception caught parsing the function name from js to native");
            return true;
        }
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            this.f3377c = true;
            this.f3378d = (FrameLayout) view;
            this.f3379e = customViewCallback;
            this.f3375a.setVisibility(4);
            this.f3376b.addView(this.f3378d, new ViewGroup.LayoutParams(-1, -1));
            this.f3376b.setVisibility(0);
            C1375a aVar = this.f3380f;
            if (aVar != null) {
                aVar.mo10617a(true);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo10610a(org.json.JSONObject r5, java.lang.String r6) {
        /*
            r4 = this;
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            r0.mo10674a((org.json.JSONObject) r5)
            int r5 = r6.hashCode()
            r0 = 0
            switch(r5) {
                case -2012425132: goto L_0x0107;
                case -1757019252: goto L_0x00fd;
                case -1554056650: goto L_0x00f2;
                case -1263203643: goto L_0x00e7;
                case -1086137328: goto L_0x00dc;
                case -934326481: goto L_0x00d1;
                case -715147645: goto L_0x00c7;
                case -640720077: goto L_0x00bc;
                case 3529469: goto L_0x00b1;
                case 94750088: goto L_0x00a7;
                case 94756344: goto L_0x009c;
                case 95458899: goto L_0x0090;
                case 96784904: goto L_0x0084;
                case 133423073: goto L_0x0078;
                case 160987616: goto L_0x006d;
                case 550290366: goto L_0x0061;
                case 937504109: goto L_0x0056;
                case 939594121: goto L_0x004a;
                case 1000390722: goto L_0x003e;
                case 1082777163: goto L_0x0032;
                case 1124446108: goto L_0x0026;
                case 1270488759: goto L_0x001a;
                case 1880941391: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0111
        L_0x000f:
            java.lang.String r5 = "getMaxSize"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 1
            goto L_0x0112
        L_0x001a:
            java.lang.String r5 = "tracking"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 18
            goto L_0x0112
        L_0x0026:
            java.lang.String r5 = "warning"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 16
            goto L_0x0112
        L_0x0032:
            java.lang.String r5 = "totalVideoDuration"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 13
            goto L_0x0112
        L_0x003e:
            java.lang.String r5 = "videoReplay"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 11
            goto L_0x0112
        L_0x004a:
            java.lang.String r5 = "videoPaused"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 10
            goto L_0x0112
        L_0x0056:
            java.lang.String r5 = "getOrientationProperties"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 5
            goto L_0x0112
        L_0x0061:
            java.lang.String r5 = "rewardedVideoCompleted"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 22
            goto L_0x0112
        L_0x006d:
            java.lang.String r5 = "getParameters"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 0
            goto L_0x0112
        L_0x0078:
            java.lang.String r5 = "setOrientationProperties"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 20
            goto L_0x0112
        L_0x0084:
            java.lang.String r5 = "error"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 15
            goto L_0x0112
        L_0x0090:
            java.lang.String r5 = "debug"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 17
            goto L_0x0112
        L_0x009c:
            java.lang.String r5 = "close"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 7
            goto L_0x0112
        L_0x00a7:
            java.lang.String r5 = "click"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 6
            goto L_0x0112
        L_0x00b1:
            java.lang.String r5 = "show"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 14
            goto L_0x0112
        L_0x00bc:
            java.lang.String r5 = "videoPlaying"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 9
            goto L_0x0112
        L_0x00c7:
            java.lang.String r5 = "getScreenSize"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 2
            goto L_0x0112
        L_0x00d1:
            java.lang.String r5 = "reward"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 21
            goto L_0x0112
        L_0x00dc:
            java.lang.String r5 = "videoCompleted"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 8
            goto L_0x0112
        L_0x00e7:
            java.lang.String r5 = "openUrl"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 19
            goto L_0x0112
        L_0x00f2:
            java.lang.String r5 = "currentVideoDuration"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 12
            goto L_0x0112
        L_0x00fd:
            java.lang.String r5 = "getCurrentPosition"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 3
            goto L_0x0112
        L_0x0107:
            java.lang.String r5 = "getDefaultPosition"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0111
            r5 = 4
            goto L_0x0112
        L_0x0111:
            r5 = -1
        L_0x0112:
            java.lang.String r1 = " callback triggered."
            java.lang.String r2 = "CBWebChromeClient"
            java.lang.String r3 = "JavaScript to native "
            switch(r5) {
                case 0: goto L_0x02b4;
                case 1: goto L_0x0298;
                case 2: goto L_0x027c;
                case 3: goto L_0x0260;
                case 4: goto L_0x0244;
                case 5: goto L_0x0228;
                case 6: goto L_0x0207;
                case 7: goto L_0x01fd;
                case 8: goto L_0x01f3;
                case 9: goto L_0x01e9;
                case 10: goto L_0x01df;
                case 11: goto L_0x01d5;
                case 12: goto L_0x01cb;
                case 13: goto L_0x01c1;
                case 14: goto L_0x01b7;
                case 15: goto L_0x01a2;
                case 16: goto L_0x018c;
                case 17: goto L_0x0181;
                case 18: goto L_0x0176;
                case 19: goto L_0x016b;
                case 20: goto L_0x014b;
                case 21: goto L_0x0140;
                case 22: goto L_0x0135;
                default: goto L_0x011b;
            }
        L_0x011b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            java.lang.String r6 = " callback not recognized."
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r2, r5)
            java.lang.String r5 = "Function name not recognized."
            return r5
        L_0x0135:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3464s
            r5.post(r0)
            goto L_0x0210
        L_0x0140:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3465t
            r5.post(r0)
            goto L_0x0210
        L_0x014b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r2, r5)
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3463r
            r5.post(r0)
            goto L_0x0210
        L_0x016b:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3454i
            r5.post(r0)
            goto L_0x0210
        L_0x0176:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3457l
            r5.post(r0)
            goto L_0x0210
        L_0x0181:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3452g
            r5.post(r0)
            goto L_0x0210
        L_0x018c:
            java.lang.Class<com.chartboost.sdk.impl.u1> r5 = com.chartboost.sdk.impl.C1378u1.class
            java.lang.String r5 = r5.getName()
            java.lang.String r0 = "Javascript warning occurred"
            android.util.Log.d(r5, r0)
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3462q
            r5.post(r0)
            goto L_0x0210
        L_0x01a2:
            java.lang.Class<com.chartboost.sdk.impl.u1> r5 = com.chartboost.sdk.impl.C1378u1.class
            java.lang.String r5 = r5.getName()
            java.lang.String r0 = "Javascript Error occured"
            android.util.Log.d(r5, r0)
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3453h
            r5.post(r0)
            goto L_0x0210
        L_0x01b7:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3455j
            r5.post(r0)
            goto L_0x0210
        L_0x01c1:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3456k
            r5.post(r0)
            goto L_0x0210
        L_0x01cb:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3451f
            r5.post(r0)
            goto L_0x0210
        L_0x01d5:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3461p
            r5.post(r0)
            goto L_0x0210
        L_0x01df:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3459n
            r5.post(r0)
            goto L_0x0210
        L_0x01e9:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3460o
            r5.post(r0)
            goto L_0x0210
        L_0x01f3:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3458m
            r5.post(r0)
            goto L_0x0210
        L_0x01fd:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3450e
            r5.post(r0)
            goto L_0x0210
        L_0x0207:
            android.os.Handler r5 = r4.f3382h
            com.chartboost.sdk.impl.w1 r0 = r4.f3384j
            java.lang.Runnable r0 = r0.f3449d
            r5.post(r0)
        L_0x0210:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r2, r5)
            java.lang.String r5 = "Native function successfully called."
            return r5
        L_0x0228:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r2, r5)
            com.chartboost.sdk.impl.v1 r5 = r4.f3381g
            java.lang.String r5 = r5.mo10648x()
            return r5
        L_0x0244:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r2, r5)
            com.chartboost.sdk.impl.v1 r5 = r4.f3381g
            java.lang.String r5 = r5.mo10646s()
            return r5
        L_0x0260:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r2, r5)
            com.chartboost.sdk.impl.v1 r5 = r4.f3381g
            java.lang.String r5 = r5.mo10645r()
            return r5
        L_0x027c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r2, r5)
            com.chartboost.sdk.impl.v1 r5 = r4.f3381g
            java.lang.String r5 = r5.mo10649y()
            return r5
        L_0x0298:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r2, r5)
            com.chartboost.sdk.impl.v1 r5 = r4.f3381g
            java.lang.String r5 = r5.mo10647w()
            return r5
        L_0x02b4:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r2, r5)
            com.chartboost.sdk.impl.v1 r5 = r4.f3381g
            com.chartboost.sdk.Model.c r5 = r5.f3004g
            if (r5 == 0) goto L_0x0340
            com.chartboost.sdk.Model.a r5 = r5.f2751q
            if (r5 == 0) goto L_0x0340
            com.chartboost.sdk.Libraries.e$a[] r6 = new com.chartboost.sdk.Libraries.C1217e.C1218a[r0]
            org.json.JSONObject r6 = com.chartboost.sdk.Libraries.C1217e.m2937a(r6)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.f2711d
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x02e3:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02fd
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            com.chartboost.sdk.Libraries.C1217e.m2938a(r6, r2, r1)
            goto L_0x02e3
        L_0x02fd:
            java.util.Map<java.lang.String, com.chartboost.sdk.Model.b> r5 = r5.f2710c
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0307:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x033b
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()
            com.chartboost.sdk.Model.b r1 = (com.chartboost.sdk.Model.C1229b) r1
            java.lang.Object r0 = r0.getKey()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r1.f2728a
            r2.append(r3)
            java.lang.String r3 = "/"
            r2.append(r3)
            java.lang.String r1 = r1.f2729b
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.chartboost.sdk.Libraries.C1217e.m2938a(r6, r0, r1)
            goto L_0x0307
        L_0x033b:
            java.lang.String r5 = r6.toString()
            return r5
        L_0x0340:
            java.lang.String r5 = "{}"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1374t1.mo10610a(org.json.JSONObject, java.lang.String):java.lang.String");
    }

    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    /* renamed from: a */
    public void mo10611a(JSONObject jSONObject) {
        mo10610a(jSONObject, "error");
    }
}
