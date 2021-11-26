package com.chartboost.sdk.impl;

import android.content.ActivityNotFoundException;
import android.util.Log;
import com.chartboost.sdk.Libraries.CBLogging;
import com.mopub.mobileads.VastIconXmlManager;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.w1 */
public class C1388w1 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1374t1 f3446a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1381v1 f3447b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public JSONObject f3448c;

    /* renamed from: d */
    Runnable f3449d = new C1397i();

    /* renamed from: e */
    Runnable f3450e = new C1398j();

    /* renamed from: f */
    Runnable f3451f = new C1399k();

    /* renamed from: g */
    Runnable f3452g = new C1400l();

    /* renamed from: h */
    Runnable f3453h = new C1401m();

    /* renamed from: i */
    Runnable f3454i = new C1402n();

    /* renamed from: j */
    Runnable f3455j = new C1403o();

    /* renamed from: k */
    Runnable f3456k = new C1404p();

    /* renamed from: l */
    Runnable f3457l = new C1405q();

    /* renamed from: m */
    Runnable f3458m = new C1389a();

    /* renamed from: n */
    Runnable f3459n = new C1390b();

    /* renamed from: o */
    Runnable f3460o = new C1391c();

    /* renamed from: p */
    Runnable f3461p = new C1392d();

    /* renamed from: q */
    Runnable f3462q = new C1393e();

    /* renamed from: r */
    Runnable f3463r = new C1394f();

    /* renamed from: s */
    Runnable f3464s = new C1395g();

    /* renamed from: t */
    Runnable f3465t = new C1396h();

    /* renamed from: com.chartboost.sdk.impl.w1$a */
    class C1389a implements Runnable {
        C1389a() {
        }

        public void run() {
            if (C1388w1.this.f3446a != null) {
                C1388w1.this.f3446a.onHideCustomView();
            } else {
                CBLogging.m2905b("NativeBridgeCommand", "Video completed command error - client");
            }
            if (C1388w1.this.f3447b != null) {
                C1388w1.this.f3447b.mo10633b(1);
                C1388w1.this.f3447b.mo10627F();
                return;
            }
            CBLogging.m2905b("NativeBridgeCommand", "Video completed command error - protocol");
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$b */
    class C1390b implements Runnable {
        C1390b() {
        }

        public void run() {
            if (C1388w1.this.f3447b != null) {
                try {
                    String string = C1388w1.this.f3448c.getString(MediationMetaData.KEY_NAME);
                    if (!C1406x.m3823b().mo10696a((CharSequence) string)) {
                        C1388w1.this.f3447b.f3413p = string;
                    }
                } catch (Exception unused) {
                    CBLogging.m2905b("NativeBridgeCommand", "Cannot find video file name");
                    if (C1388w1.this.f3447b != null) {
                        C1388w1.this.f3447b.mo10642h("Parsing exception unknown field for video pause");
                    }
                }
                C1388w1.this.f3447b.mo10633b(3);
                return;
            }
            CBLogging.m2905b("NativeBridgeCommand", "Video paused command error");
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$c */
    class C1391c implements Runnable {
        C1391c() {
        }

        public void run() {
            if (C1388w1.this.f3447b != null) {
                try {
                    String string = C1388w1.this.f3448c.getString(MediationMetaData.KEY_NAME);
                    if (!C1406x.m3823b().mo10696a((CharSequence) string)) {
                        C1388w1.this.f3447b.f3413p = string;
                    }
                } catch (Exception unused) {
                    CBLogging.m2905b("NativeBridgeCommand", "Cannot find video file name");
                    C1388w1.this.f3447b.mo10642h("Parsing exception unknown field for video play");
                }
                C1388w1.this.f3447b.mo10633b(2);
                return;
            }
            CBLogging.m2905b("NativeBridgeCommand", "Video playing command error");
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$d */
    class C1392d implements Runnable {
        C1392d() {
        }

        public void run() {
            if (C1388w1.this.f3447b != null) {
                try {
                    String string = C1388w1.this.f3448c.getString(MediationMetaData.KEY_NAME);
                    if (!C1406x.m3823b().mo10696a((CharSequence) string)) {
                        C1388w1.this.f3447b.f3413p = string;
                    }
                } catch (Exception unused) {
                    CBLogging.m2905b("NativeBridgeCommand", "Cannot find video file name");
                    C1388w1.this.f3447b.mo10642h("Parsing exception unknown field for video replay");
                }
            } else {
                CBLogging.m2905b("NativeBridgeCommand", "Video replay command error");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$e */
    class C1393e implements Runnable {
        C1393e() {
        }

        public void run() {
            try {
                String string = C1388w1.this.f3448c.getString("message");
                String name = C1378u1.class.getName();
                Log.d(name, "JS->Native Warning message: " + string);
                C1388w1.this.f3447b.mo10642h(string);
            } catch (Exception unused) {
                CBLogging.m2905b("NativeBridgeCommand", "Warning message is empty");
                if (C1388w1.this.f3447b != null) {
                    C1388w1.this.f3447b.mo10642h("");
                }
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$f */
    class C1394f implements Runnable {
        C1394f() {
        }

        public void run() {
            try {
                C1388w1.this.f3447b.mo10637c(C1388w1.this.f3448c);
            } catch (Exception unused) {
                CBLogging.m2905b("NativeBridgeCommand", "Invalid set orientation command");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$g */
    class C1395g implements Runnable {
        C1395g() {
        }

        public void run() {
            try {
                C1388w1.this.f3447b.mo10625D();
            } catch (Exception unused) {
                CBLogging.m2905b("NativeBridgeCommand", "Invalid rewarded video completed command");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$h */
    class C1396h implements Runnable {
        C1396h() {
        }

        public void run() {
            try {
                C1388w1.this.f3447b.mo10623A();
            } catch (Exception unused) {
                CBLogging.m2905b("NativeBridgeCommand", "Invalid rewarded command");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$i */
    class C1397i implements Runnable {
        C1397i() {
        }

        public void run() {
            if (C1388w1.this.f3447b != null) {
                C1388w1.this.f3447b.mo10335a((JSONObject) null);
            } else {
                CBLogging.m2905b("NativeBridgeCommand", "Click command error");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$j */
    class C1398j implements Runnable {
        C1398j() {
        }

        public void run() {
            if (C1388w1.this.f3447b != null) {
                C1388w1.this.f3447b.mo10329a();
            } else {
                CBLogging.m2905b("NativeBridgeCommand", "Close command error");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$k */
    class C1399k implements Runnable {
        C1399k() {
        }

        public void run() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("######### JS->Native Video current player duration");
                float f = ((float) C1388w1.this.f3448c.getDouble(VastIconXmlManager.DURATION)) * 1000.0f;
                sb.append(f);
                CBLogging.m2903a("NativeBridgeCommand", sb.toString());
                C1388w1.this.f3447b.mo10631a(f);
            } catch (Exception unused) {
                if (C1388w1.this.f3447b != null) {
                    C1388w1.this.f3447b.mo10642h("Parsing exception unknown field for current player duration");
                }
                CBLogging.m2905b("NativeBridgeCommand", "Cannot find duration parameter for the video");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$l */
    class C1400l implements Runnable {
        C1400l() {
        }

        public void run() {
            try {
                C1381v1 a = C1388w1.this.f3447b;
                C1388w1 w1Var = C1388w1.this;
                a.mo10640f(w1Var.m3819a(w1Var.f3448c, "JS->Native Debug message: "));
            } catch (Exception unused) {
                CBLogging.m2905b("NativeBridgeCommand", "Exception occured while parsing the message for webview debug track event");
                if (C1388w1.this.f3447b != null) {
                    C1388w1.this.f3447b.mo10640f("Exception occured while parsing the message for webview debug track event");
                }
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$m */
    class C1401m implements Runnable {
        C1401m() {
        }

        public void run() {
            try {
                C1388w1.this.f3447b.mo10624B();
                C1381v1 a = C1388w1.this.f3447b;
                C1388w1 w1Var = C1388w1.this;
                a.mo10636c(w1Var.m3819a(w1Var.f3448c, "JS->Native Error message: "));
            } catch (Exception unused) {
                CBLogging.m2905b("NativeBridgeCommand", "Error message is empty");
                if (C1388w1.this.f3447b != null) {
                    C1388w1.this.f3447b.mo10636c("");
                }
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$n */
    class C1402n implements Runnable {
        C1402n() {
        }

        public void run() {
            try {
                String string = C1388w1.this.f3448c.getString("url");
                if (!string.startsWith("http://") && !string.startsWith("https://")) {
                    string = "http://" + string;
                }
                C1388w1.this.f3447b.mo10332a(string, (JSONObject) null);
            } catch (ActivityNotFoundException e) {
                CBLogging.m2905b("NativeBridgeCommand", "ActivityNotFoundException occured when opening a url in a browser: " + e.toString());
            } catch (Exception e2) {
                CBLogging.m2905b("NativeBridgeCommand", "Exception while opening a browser view with MRAID url: " + e2.toString());
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$o */
    class C1403o implements Runnable {
        C1403o() {
        }

        public void run() {
            if (C1388w1.this.f3447b != null) {
                C1388w1.this.f3447b.mo10626E();
            } else {
                CBLogging.m2905b("NativeBridgeCommand", "Show command error");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$p */
    class C1404p implements Runnable {
        C1404p() {
        }

        public void run() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("######### JS->Native Video total player duration");
                float f = ((float) C1388w1.this.f3448c.getDouble(VastIconXmlManager.DURATION)) * 1000.0f;
                sb.append(f);
                CBLogging.m2903a("NativeBridgeCommand", sb.toString());
                C1388w1.this.f3447b.mo10632b(f);
            } catch (Exception unused) {
                if (C1388w1.this.f3447b != null) {
                    C1388w1.this.f3447b.mo10642h("Parsing exception unknown field for total player duration");
                }
                CBLogging.m2905b("NativeBridgeCommand", "Cannot find duration parameter for the video");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w1$q */
    class C1405q implements Runnable {
        C1405q() {
        }

        public void run() {
            try {
                String string = C1388w1.this.f3448c.getString("event");
                C1388w1.this.f3447b.mo10641g(string);
                String name = C1378u1.class.getName();
                Log.d(name, "JS->Native Track VAST event message: " + string);
            } catch (Exception unused) {
                CBLogging.m2905b("NativeBridgeCommand", "Exception occured while parsing the message for webview tracking VAST events");
            }
        }
    }

    C1388w1(C1374t1 t1Var, C1381v1 v1Var) {
        this.f3446a = t1Var;
        this.f3447b = v1Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10674a(JSONObject jSONObject) {
        this.f3448c = jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m3819a(JSONObject jSONObject, String str) throws JSONException {
        String string = jSONObject.getString("message");
        String name = C1378u1.class.getName();
        Log.d(name, str + string);
        return string;
    }
}
