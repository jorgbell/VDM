package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.adview.C0638d;
import com.applovin.impl.mediation.C0862f;
import com.applovin.impl.mediation.C0867g;
import com.applovin.impl.mediation.C0868h;
import com.applovin.impl.mediation.C0911j;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.debugger.C0790a;
import com.applovin.impl.mediation.debugger.p028ui.testmode.C0860b;
import com.applovin.impl.mediation.p021a.C0737e;
import com.applovin.impl.mediation.p023c.C0787b;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.network.C1087c;
import com.applovin.impl.sdk.network.C1090e;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.p035a.C0929e;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0966c;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p037c.C0968e;
import com.applovin.impl.sdk.p038d.C0975c;
import com.applovin.impl.sdk.p038d.C0983f;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.p038d.C0987h;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1004h;
import com.applovin.impl.sdk.p039e.C1017n;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1154n;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1159q;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserSegment;
import com.applovin.sdk.AppLovinUserService;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.k */
public class C1062k {

    /* renamed from: a */
    protected static Context f2161a;

    /* renamed from: A */
    private C1170v f2162A;

    /* renamed from: B */
    private C0923a f2163B;

    /* renamed from: C */
    private C1104q f2164C;

    /* renamed from: D */
    private C1111u f2165D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public C1087c f2166E;

    /* renamed from: F */
    private C1047g f2167F;

    /* renamed from: G */
    private C1154n f2168G;

    /* renamed from: H */
    private C1044f f2169H;

    /* renamed from: I */
    private C1078n f2170I;

    /* renamed from: J */
    private C1067l f2171J;

    /* renamed from: K */
    private PostbackServiceImpl f2172K;

    /* renamed from: L */
    private C1090e f2173L;

    /* renamed from: M */
    private C0868h f2174M;

    /* renamed from: N */
    private C0867g f2175N;

    /* renamed from: O */
    private MediationServiceImpl f2176O;

    /* renamed from: P */
    private C0911j f2177P;

    /* renamed from: Q */
    private C0790a f2178Q;

    /* renamed from: R */
    private C1109s f2179R;

    /* renamed from: S */
    private C0862f f2180S;

    /* renamed from: T */
    private C0860b f2181T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public final Object f2182U = new Object();

    /* renamed from: V */
    private final AtomicBoolean f2183V = new AtomicBoolean(true);

    /* renamed from: W */
    private boolean f2184W = false;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public boolean f2185X = false;

    /* renamed from: Y */
    private boolean f2186Y = false;

    /* renamed from: Z */
    private boolean f2187Z = false;

    /* renamed from: aa */
    private boolean f2188aa = false;

    /* renamed from: ab */
    private boolean f2189ab = false;

    /* renamed from: ac */
    private int f2190ac = 0;

    /* renamed from: ad */
    private AppLovinSdk.SdkInitializationListener f2191ad;

    /* renamed from: ae */
    private AppLovinSdk.SdkInitializationListener f2192ae;
    /* access modifiers changed from: private */

    /* renamed from: af */
    public AppLovinSdkConfiguration f2193af;

    /* renamed from: b */
    protected C0966c f2194b;

    /* renamed from: c */
    private String f2195c;

    /* renamed from: d */
    private WeakReference<Activity> f2196d;

    /* renamed from: e */
    private long f2197e;

    /* renamed from: f */
    private AppLovinSdkSettings f2198f;

    /* renamed from: g */
    private AppLovinUserSegment f2199g;

    /* renamed from: h */
    private String f2200h;

    /* renamed from: i */
    private AppLovinAdServiceImpl f2201i;

    /* renamed from: j */
    private EventServiceImpl f2202j;

    /* renamed from: k */
    private UserServiceImpl f2203k;

    /* renamed from: l */
    private VariableServiceImpl f2204l;

    /* renamed from: m */
    private AppLovinSdk f2205m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C1107r f2206n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1020o f2207o;

    /* renamed from: p */
    private C1081a f2208p;

    /* renamed from: q */
    private C0987h f2209q;

    /* renamed from: r */
    private C1073m f2210r;

    /* renamed from: s */
    private C0968e f2211s;

    /* renamed from: t */
    private C0983f f2212t;

    /* renamed from: u */
    private C1056j f2213u;

    /* renamed from: v */
    private C1159q f2214v;

    /* renamed from: w */
    private C0963c f2215w;

    /* renamed from: x */
    private C1103p f2216x;

    /* renamed from: y */
    private C0929e f2217y;

    /* renamed from: z */
    private C0975c f2218z;

    /* renamed from: K */
    public static Context m2110K() {
        return f2161a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2113a(JSONObject jSONObject) {
        for (String i : C1123j.m2574a(jSONObject, "error_messages", Collections.emptyList(), this)) {
            C1107r.m2484i("AppLovinSdk", i);
        }
    }

    /* renamed from: an */
    private void m2114an() {
        this.f2166E.mo9495a((C1087c.C1088a) new C1087c.C1088a() {
            /* renamed from: a */
            public void mo9414a() {
                C1062k.this.f2206n.mo9586c("AppLovinSdk", "Connected to internet - re-initializing SDK");
                synchronized (C1062k.this.f2182U) {
                    if (!C1062k.this.f2185X) {
                        C1062k.this.mo9382b();
                    }
                }
                C1062k.this.f2166E.mo9496b(this);
            }

            /* renamed from: b */
            public void mo9415b() {
            }
        });
    }

    /* renamed from: A */
    public C0868h mo9325A() {
        return this.f2174M;
    }

    /* renamed from: B */
    public C0867g mo9326B() {
        return this.f2175N;
    }

    /* renamed from: C */
    public MediationServiceImpl mo9327C() {
        return this.f2176O;
    }

    /* renamed from: D */
    public C1109s mo9328D() {
        return this.f2179R;
    }

    /* renamed from: E */
    public C0790a mo9329E() {
        return this.f2178Q;
    }

    /* renamed from: F */
    public C0911j mo9330F() {
        return this.f2177P;
    }

    /* renamed from: G */
    public C0862f mo9331G() {
        return this.f2180S;
    }

    /* renamed from: H */
    public C0860b mo9332H() {
        return this.f2181T;
    }

    /* renamed from: I */
    public C0966c mo9333I() {
        return this.f2194b;
    }

    /* renamed from: J */
    public Context mo9334J() {
        return f2161a;
    }

    /* renamed from: L */
    public Activity mo9335L() {
        WeakReference<Activity> weakReference = this.f2196d;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* renamed from: M */
    public long mo9336M() {
        return this.f2197e;
    }

    /* renamed from: N */
    public boolean mo9337N() {
        return this.f2188aa;
    }

    /* renamed from: O */
    public boolean mo9338O() {
        return this.f2189ab;
    }

    /* renamed from: P */
    public C1081a mo9339P() {
        return this.f2208p;
    }

    /* renamed from: Q */
    public C1020o mo9340Q() {
        return this.f2207o;
    }

    /* renamed from: R */
    public C0987h mo9341R() {
        return this.f2209q;
    }

    /* renamed from: S */
    public C1090e mo9342S() {
        return this.f2173L;
    }

    /* renamed from: T */
    public C1073m mo9343T() {
        return this.f2210r;
    }

    /* renamed from: U */
    public C0983f mo9344U() {
        return this.f2212t;
    }

    /* renamed from: V */
    public C1056j mo9345V() {
        return this.f2213u;
    }

    /* renamed from: W */
    public PostbackServiceImpl mo9346W() {
        return this.f2172K;
    }

    /* renamed from: X */
    public AppLovinSdk mo9347X() {
        return this.f2205m;
    }

    /* renamed from: Y */
    public C0963c mo9348Y() {
        return this.f2215w;
    }

    /* renamed from: Z */
    public C1103p mo9349Z() {
        return this.f2216x;
    }

    /* renamed from: a */
    public <T> T mo9350a(C0965b<T> bVar) {
        return this.f2194b.mo9121a(bVar);
    }

    /* renamed from: a */
    public <T> T mo9351a(C0967d<T> dVar) {
        return mo9379b(dVar, (Object) null);
    }

    /* renamed from: a */
    public <T> T mo9352a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        return C0968e.m1766a(str, t, cls, sharedPreferences);
    }

    /* renamed from: a */
    public void mo9353a() {
        synchronized (this.f2182U) {
            if (!this.f2185X && !this.f2186Y) {
                mo9382b();
            }
        }
    }

    /* renamed from: a */
    public void mo9354a(long j) {
        this.f2213u.mo9318a(j);
    }

    /* renamed from: a */
    public void mo9355a(SharedPreferences sharedPreferences) {
        this.f2211s.mo9133a(sharedPreferences);
    }

    /* renamed from: a */
    public void mo9356a(C0737e eVar) {
        if (!this.f2207o.mo9269a()) {
            List<String> b = mo9381b(C0964a.f1542a);
            if (b.size() > 0 && this.f2175N.mo8745c().containsAll(b)) {
                this.f2206n.mo9584b("AppLovinSdk", "All required adapters initialized");
                this.f2207o.mo9272d();
                mo9394j();
            }
        }
    }

    /* renamed from: a */
    public <T> void mo9357a(C0967d<T> dVar, T t) {
        this.f2211s.mo9135a(dVar, t);
    }

    /* renamed from: a */
    public <T> void mo9358a(C0967d<T> dVar, T t, SharedPreferences sharedPreferences) {
        this.f2211s.mo9136a(dVar, t, sharedPreferences);
    }

    /* renamed from: a */
    public void mo9359a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!mo9388d()) {
            this.f2191ad = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            sdkInitializationListener.onSdkInitialized(this.f2193af);
        }
    }

    /* renamed from: a */
    public void mo9360a(AppLovinSdk appLovinSdk) {
        this.f2205m = appLovinSdk;
    }

    /* renamed from: a */
    public void mo9361a(String str) {
        C1107r.m2481f("AppLovinSdk", "Setting plugin version: " + str);
        this.f2194b.mo9123a((C0965b<?>) C0965b.f1779du, (Object) str);
        this.f2194b.mo9122a();
    }

    /* renamed from: a */
    public <T> void mo9362a(String str, T t, SharedPreferences.Editor editor) {
        this.f2211s.mo9137a(str, t, editor);
    }

    /* renamed from: a */
    public void mo9363a(boolean z) {
        synchronized (this.f2182U) {
            this.f2185X = false;
            this.f2186Y = z;
        }
        if (this.f2194b != null && this.f2207o != null) {
            List<String> b = mo9381b(C0964a.f1542a);
            if (b.isEmpty()) {
                this.f2207o.mo9272d();
                mo9394j();
                return;
            }
            long longValue = ((Long) mo9350a(C0964a.f1543b)).longValue();
            C1042y yVar = new C1042y(this, true, new Runnable() {
                public void run() {
                    if (!C1062k.this.f2207o.mo9269a()) {
                        C1062k.this.f2206n.mo9584b("AppLovinSdk", "Timing out adapters init...");
                        C1062k.this.f2207o.mo9272d();
                        C1062k.this.mo9394j();
                    }
                }
            });
            C1107r rVar = this.f2206n;
            rVar.mo9584b("AppLovinSdk", "Waiting for required adapters to init: " + b + " - timing out in " + longValue + "ms...");
            this.f2207o.mo9268a((C0989a) yVar, C1020o.C1022a.MEDIATION_TIMEOUT, longValue, true);
        }
    }

    /* renamed from: a */
    public void mo9364a(boolean z, String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        C0968e eVar;
        String str2;
        this.f2195c = str;
        this.f2197e = System.currentTimeMillis();
        this.f2198f = appLovinSdkSettings;
        this.f2199g = new C0988e();
        this.f2193af = new SdkConfigurationImpl(this);
        f2161a = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f2196d = new WeakReference<>((Activity) context);
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f2211s = new C0968e(this);
        C0966c cVar = new C0966c(this);
        this.f2194b = cVar;
        cVar.mo9126b();
        this.f2206n = new C1107r(this);
        C0983f fVar = new C0983f(this);
        this.f2212t = fVar;
        fVar.mo9195b();
        this.f2216x = new C1103p(this);
        this.f2215w = new C0963c(this);
        this.f2217y = new C0929e(this);
        this.f2202j = new EventServiceImpl(this);
        this.f2203k = new UserServiceImpl(this);
        this.f2204l = new VariableServiceImpl(this);
        this.f2218z = new C0975c(this);
        this.f2207o = new C1020o(this);
        this.f2208p = new C1081a(this);
        this.f2209q = new C0987h(this);
        this.f2163B = new C0923a(context);
        this.f2210r = new C1073m(this);
        this.f2201i = new AppLovinAdServiceImpl(this);
        this.f2162A = new C1170v(this);
        this.f2164C = new C1104q(this);
        this.f2172K = new PostbackServiceImpl(this);
        this.f2173L = new C1090e(this);
        this.f2174M = new C0868h(this);
        this.f2175N = new C0867g(this);
        this.f2176O = new MediationServiceImpl(this);
        this.f2179R = new C1109s(this);
        this.f2178Q = new C0790a(this);
        this.f2177P = new C0911j();
        this.f2180S = new C0862f(this);
        this.f2213u = new C1056j(this);
        this.f2165D = new C1111u(this);
        this.f2168G = new C1154n(this);
        this.f2169H = new C1044f(this);
        this.f2170I = new C1078n(this);
        this.f2181T = new C0860b(this);
        this.f2171J = new C1067l(this);
        this.f2167F = new C1047g(this);
        this.f2214v = new C1159q(this);
        if (appLovinSdkSettings.isExceptionHandlerEnabled() && ((Boolean) mo9350a(C0965b.f1613al)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        C0965b bVar = C0965b.f1759da;
        if (((Boolean) mo9350a(bVar)).booleanValue()) {
            this.f2166E = new C1087c(context);
        }
        if (TextUtils.isEmpty(str)) {
            this.f2187Z = true;
            C1107r.m2484i("AppLovinSdk", "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            C1107r.m2484i("AppLovinSdk", "Called with an invalid SDK key from: " + Log.getStackTraceString(new Throwable("")));
        }
        if (str.length() != 86 && C1160r.m2756e(context)) {
            C1107r.m2484i("AppLovinSdk", "Please double-check that you entered your SDK key correctly (" + str + ") : " + Log.getStackTraceString(new Throwable("")));
        }
        if (C1160r.m2764i()) {
            C1107r.m2484i("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!C1160r.m2750c(this)) {
            C1107r.m2484i("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (!mo9410y()) {
            if (C1160r.m2729a(context)) {
                appLovinSdkSettings.setVerboseLogging(true);
            }
            mo9333I().mo9123a((C0965b<?>) C0965b.f1573Y, (Object) Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled()));
            mo9333I().mo9122a();
            Class<C0638d> cls = C0638d.class;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            C0968e eVar2 = this.f2211s;
            C0967d dVar = C0967d.f1846a;
            if (TextUtils.isEmpty((String) eVar2.mo9140b(dVar, null, defaultSharedPreferences))) {
                this.f2188aa = true;
                eVar = this.f2211s;
                str2 = Boolean.toString(true);
            } else {
                eVar = this.f2211s;
                str2 = Boolean.toString(false);
            }
            eVar.mo9136a(dVar, str2, defaultSharedPreferences);
            C0968e eVar3 = this.f2211s;
            C0967d dVar2 = C0967d.f1847b;
            if (((Boolean) eVar3.mo9139b(dVar2, Boolean.FALSE)).booleanValue()) {
                this.f2206n.mo9584b("AppLovinSdk", "Initializing SDK for non-maiden launch");
                this.f2189ab = true;
            } else {
                this.f2206n.mo9584b("AppLovinSdk", "Initializing SDK for maiden launch");
                this.f2211s.mo9135a(dVar2, Boolean.TRUE);
            }
            C0968e eVar4 = this.f2211s;
            C0967d dVar3 = C0967d.f1848c;
            String str3 = (String) eVar4.mo9139b(dVar3, null);
            if (!C1155o.m2673b(str3) || AppLovinSdk.VERSION_CODE > C1160r.m2757f(str3)) {
                this.f2211s.mo9135a(dVar3, AppLovinSdk.VERSION);
            }
            boolean a = C1120h.m2544a(mo9334J());
            if (!((Boolean) mo9350a(C0965b.f1760db)).booleanValue() || a) {
                mo9382b();
            }
            if (((Boolean) mo9350a(bVar)).booleanValue() && !a) {
                this.f2206n.mo9586c("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                m2114an();
            }
        } else {
            mo9363a(false);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    public boolean mo9365a(C0965b<String> bVar, MaxAdFormat maxAdFormat) {
        return mo9385c(bVar).contains(maxAdFormat);
    }

    /* renamed from: aa */
    public C0929e mo9366aa() {
        return this.f2217y;
    }

    /* renamed from: ab */
    public C0975c mo9367ab() {
        return this.f2218z;
    }

    /* renamed from: ac */
    public C1170v mo9368ac() {
        return this.f2162A;
    }

    /* renamed from: ad */
    public C1104q mo9369ad() {
        return this.f2164C;
    }

    /* renamed from: ae */
    public C0923a mo9370ae() {
        return this.f2163B;
    }

    /* renamed from: af */
    public C1111u mo9371af() {
        return this.f2165D;
    }

    /* renamed from: ag */
    public C1047g mo9372ag() {
        return this.f2167F;
    }

    /* renamed from: ah */
    public C1154n mo9373ah() {
        return this.f2168G;
    }

    /* renamed from: ai */
    public C1044f mo9374ai() {
        return this.f2169H;
    }

    /* renamed from: aj */
    public AppLovinBroadcastManager mo9375aj() {
        return AppLovinBroadcastManager.getInstance(f2161a);
    }

    /* renamed from: ak */
    public C1078n mo9376ak() {
        return this.f2170I;
    }

    /* renamed from: al */
    public C1067l mo9377al() {
        return this.f2171J;
    }

    /* renamed from: am */
    public Activity mo9378am() {
        Activity L = mo9335L();
        if (L != null) {
            return L;
        }
        Activity a = mo9370ae().mo8944a();
        if (a != null) {
            return a;
        }
        return null;
    }

    /* renamed from: b */
    public <T> T mo9379b(C0967d<T> dVar, T t) {
        return this.f2211s.mo9139b(dVar, t);
    }

    /* renamed from: b */
    public <T> T mo9380b(C0967d<T> dVar, T t, SharedPreferences sharedPreferences) {
        return this.f2211s.mo9140b(dVar, t, sharedPreferences);
    }

    /* renamed from: b */
    public List<String> mo9381b(C0965b<String> bVar) {
        return this.f2194b.mo9125b(bVar);
    }

    /* renamed from: b */
    public void mo9382b() {
        synchronized (this.f2182U) {
            if (this.f2184W) {
                mo9363a(true);
            } else {
                this.f2185X = true;
                mo9340Q().mo9271c();
                int i = this.f2190ac + 1;
                this.f2190ac = i;
                mo9340Q().mo9266a((C0989a) new C1004h(i, this, new C1004h.C1006a() {
                    /* renamed from: a */
                    public void mo9249a(JSONObject jSONObject) {
                        boolean z = jSONObject.length() > 0;
                        C1120h.m2549d(jSONObject, C1062k.this);
                        C1120h.m2548c(jSONObject, C1062k.this);
                        C1120h.m2551e(jSONObject, C1062k.this);
                        C1120h.m2541a(jSONObject, z, C1062k.this);
                        C0787b.m1103a(jSONObject, C1062k.this);
                        C0787b.m1105b(jSONObject, C1062k.this);
                        C1062k.this.mo9329E().mo8554a(C1123j.m2568a(jSONObject, "smd", Boolean.FALSE, C1062k.this).booleanValue());
                        C1120h.m2557h(jSONObject, C1062k.this);
                        C1120h.m2553f(jSONObject, C1062k.this);
                        C1062k.this.mo9332H().mo8727a(jSONObject);
                        C1062k.this.m2113a(jSONObject);
                        C1062k.this.mo9340Q().mo9265a((C0989a) new C1017n(C1062k.this));
                        C1120h.m2555g(jSONObject, C1062k.this);
                    }
                }), C1020o.C1022a.MAIN);
            }
        }
    }

    /* renamed from: b */
    public <T> void mo9383b(C0967d<T> dVar) {
        this.f2211s.mo9134a(dVar);
    }

    /* renamed from: b */
    public void mo9384b(String str) {
        C1107r rVar = this.f2206n;
        rVar.mo9584b("AppLovinSdk", "Setting user id: " + str);
        this.f2214v.mo9667a(str);
    }

    /* renamed from: c */
    public List<MaxAdFormat> mo9385c(C0965b<String> bVar) {
        return this.f2194b.mo9127c(bVar);
    }

    /* renamed from: c */
    public void mo9386c(String str) {
        this.f2200h = str;
        mo9383b(C0967d.f1843A);
    }

    /* renamed from: c */
    public boolean mo9387c() {
        boolean z;
        synchronized (this.f2182U) {
            z = this.f2185X;
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo9388d() {
        boolean z;
        synchronized (this.f2182U) {
            z = this.f2186Y;
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo9389e() {
        return "HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(mo9409x());
    }

    /* renamed from: f */
    public boolean mo9390f() {
        return C1155o.m2671a(mo9403s(), AppLovinMediationProvider.MAX);
    }

    /* renamed from: g */
    public boolean mo9391g() {
        return C1160r.m2753d("com.unity3d.player.UnityPlayerActivity");
    }

    /* renamed from: h */
    public void mo9392h() {
        String str = (String) this.f2211s.mo9139b(C0967d.f1848c, null);
        if (C1155o.m2673b(str) && AppLovinSdk.VERSION_CODE < C1160r.m2757f(str)) {
            C1107r.m2484i("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
        }
    }

    /* renamed from: i */
    public void mo9393i() {
        this.f2167F.mo9302a(new Bundle(), "privacy_setting_updated");
    }

    /* renamed from: j */
    public void mo9394j() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener = this.f2191ad;
        if (sdkInitializationListener != null) {
            if (mo9388d()) {
                this.f2191ad = null;
                this.f2192ae = null;
            } else if (this.f2192ae != sdkInitializationListener) {
                if (((Boolean) mo9350a(C0965b.f1608ag)).booleanValue()) {
                    this.f2191ad = null;
                } else {
                    this.f2192ae = sdkInitializationListener;
                }
            } else {
                return;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1062k.this.f2206n.mo9584b("AppLovinSdk", "Calling back publisher's initialization completion handler...");
                    sdkInitializationListener.onSdkInitialized(C1062k.this.f2193af);
                }
            }, Math.max(0, ((Long) mo9350a(C0965b.f1609ah)).longValue()));
        }
    }

    /* renamed from: k */
    public void mo9395k() {
        C1107r.m2484i("AppLovinSdk", "Resetting SDK state...");
        C0987h hVar = this.f2209q;
        C0986g gVar = C0986g.f1960g;
        long b = hVar.mo9202b(gVar);
        this.f2194b.mo9128c();
        this.f2194b.mo9122a();
        this.f2209q.mo9201a();
        this.f2218z.mo9160b();
        this.f2209q.mo9204b(gVar, b + 1);
        if (this.f2183V.compareAndSet(true, false)) {
            mo9382b();
        } else {
            this.f2183V.set(true);
        }
    }

    /* renamed from: l */
    public void mo9396l() {
        this.f2178Q.mo8556c();
    }

    /* renamed from: m */
    public String mo9397m() {
        return this.f2214v.mo9666a();
    }

    /* renamed from: n */
    public String mo9398n() {
        return this.f2214v.mo9668b();
    }

    /* renamed from: o */
    public String mo9399o() {
        return this.f2214v.mo9669c();
    }

    /* renamed from: p */
    public AppLovinSdkSettings mo9400p() {
        return this.f2198f;
    }

    /* renamed from: q */
    public AppLovinUserSegment mo9401q() {
        return this.f2199g;
    }

    /* renamed from: r */
    public AppLovinSdkConfiguration mo9402r() {
        return this.f2193af;
    }

    /* renamed from: s */
    public String mo9403s() {
        String str = (String) mo9351a(C0967d.f1843A);
        return C1155o.m2673b(str) ? str : this.f2200h;
    }

    /* renamed from: t */
    public AppLovinAdServiceImpl mo9404t() {
        return this.f2201i;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f2195c + '\'' + ", enabled=" + this.f2186Y + ", isFirstSession=" + this.f2188aa + '}';
    }

    /* renamed from: u */
    public AppLovinEventService mo9406u() {
        return this.f2202j;
    }

    /* renamed from: v */
    public AppLovinUserService mo9407v() {
        return this.f2203k;
    }

    /* renamed from: w */
    public VariableServiceImpl mo9408w() {
        return this.f2204l;
    }

    /* renamed from: x */
    public String mo9409x() {
        return this.f2195c;
    }

    /* renamed from: y */
    public boolean mo9410y() {
        return this.f2187Z;
    }

    /* renamed from: z */
    public C1107r mo9411z() {
        return this.f2206n;
    }
}
