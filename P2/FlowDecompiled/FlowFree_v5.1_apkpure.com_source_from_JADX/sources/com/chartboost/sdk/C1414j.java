package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.webkit.WebSettings;
import com.chartboost.sdk.Banner.C1205a;
import com.chartboost.sdk.Libraries.C1215d;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.C1224j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Model.C1239i;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.Networking.C1248h;
import com.chartboost.sdk.Networking.C1249i;
import com.chartboost.sdk.Networking.C1252j;
import com.chartboost.sdk.Networking.C1255m;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1264c;
import com.chartboost.sdk.Tracking.C1265d;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.Tracking.C1268g;
import com.chartboost.sdk.impl.C1286a;
import com.chartboost.sdk.impl.C1289a1;
import com.chartboost.sdk.impl.C1292b1;
import com.chartboost.sdk.impl.C1295c1;
import com.chartboost.sdk.impl.C1296d;
import com.chartboost.sdk.impl.C1298d1;
import com.chartboost.sdk.impl.C1304f1;
import com.chartboost.sdk.impl.C1305g;
import com.chartboost.sdk.impl.C1342m1;
import com.chartboost.sdk.impl.C1344n;
import com.chartboost.sdk.impl.C1348o;
import com.chartboost.sdk.impl.C1357p0;
import com.chartboost.sdk.impl.C1387w0;
import com.chartboost.sdk.impl.C1406x;
import com.chartboost.sdk.impl.C1407x0;
import com.chartboost.sdk.impl.C1411y0;
import com.chartboost.sdk.impl.C1413z0;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.j */
public class C1414j {

    /* renamed from: G */
    private static C1414j f3490G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public static C1387w0 f3491H;

    /* renamed from: A */
    public final AtomicReference<C1236h> f3492A;

    /* renamed from: B */
    public final Handler f3493B;

    /* renamed from: C */
    public final C1275d f3494C;

    /* renamed from: D */
    public final C1249i f3495D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public Runnable f3496E;

    /* renamed from: F */
    private final C1357p0.C1358a f3497F = new C1415a();

    /* renamed from: a */
    private final C1406x f3498a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f3499b;

    /* renamed from: c */
    final C1220g f3500c;

    /* renamed from: d */
    final C1248h f3501d;

    /* renamed from: e */
    final C1224j f3502e;

    /* renamed from: f */
    final C1277e f3503f;

    /* renamed from: g */
    final C1252j f3504g;

    /* renamed from: h */
    final C1344n f3505h;

    /* renamed from: i */
    final C1268g f3506i;

    /* renamed from: j */
    final C1266e f3507j;

    /* renamed from: k */
    final C1304f1 f3508k;

    /* renamed from: l */
    public C1273b f3509l = new C1273b();

    /* renamed from: m */
    final SharedPreferences f3510m;

    /* renamed from: n */
    public C1348o f3511n;

    /* renamed from: o */
    boolean f3512o = false;

    /* renamed from: p */
    boolean f3513p = true;

    /* renamed from: q */
    public final Executor f3514q;

    /* renamed from: r */
    public final C1215d f3515r;

    /* renamed from: s */
    public final C1305g f3516s;

    /* renamed from: t */
    public final C1286a f3517t;

    /* renamed from: u */
    public final C1305g f3518u;

    /* renamed from: v */
    public final C1286a f3519v;

    /* renamed from: w */
    public final C1247g f3520w;

    /* renamed from: x */
    public final C1234g f3521x;

    /* renamed from: y */
    public final C1305g f3522y;

    /* renamed from: z */
    public final C1286a f3523z;

    /* renamed from: com.chartboost.sdk.j$a */
    class C1415a implements C1357p0.C1358a {
        C1415a() {
        }

        /* renamed from: a */
        public void mo10427a(C1357p0 p0Var, JSONObject jSONObject) {
            C1414j jVar = C1414j.this;
            jVar.mo10709a(jVar.f3496E, jSONObject);
        }

        /* renamed from: a */
        public void mo10426a(C1357p0 p0Var, CBError cBError) {
            C1266e.m3223e(new C1264c("config_request_error", cBError != null ? cBError.getErrorDesc() : "Config failure", "", ""));
            C1414j jVar = C1414j.this;
            jVar.mo10708a(jVar.f3496E);
        }
    }

    /* renamed from: com.chartboost.sdk.j$b */
    public class C1416b implements Runnable {

        /* renamed from: a */
        final int f3525a;

        /* renamed from: b */
        String f3526b = null;

        /* renamed from: c */
        boolean f3527c = false;

        /* renamed from: d */
        boolean f3528d = false;

        /* renamed from: e */
        ChartboostBanner f3529e = null;

        /* renamed from: com.chartboost.sdk.j$b$a */
        class C1417a implements C1357p0.C1358a {
            C1417a(C1416b bVar) {
            }

            /* renamed from: a */
            public void mo10426a(C1357p0 p0Var, CBError cBError) {
                C1266e.m3223e(new C1264c("install_request_error", cBError != null ? cBError.getErrorDesc() : "Install failure", "", ""));
            }

            /* renamed from: a */
            public void mo10427a(C1357p0 p0Var, JSONObject jSONObject) {
            }
        }

        C1416b(int i) {
            this.f3525a = i;
        }

        /* renamed from: a */
        private void m3895a() {
            String c;
            AtomicReference<C1236h> atomicReference = C1414j.this.f3492A;
            if (atomicReference != null && atomicReference.get() != null && (c = C1414j.this.f3492A.get().mo10131c()) != null) {
                CBLogging.m2909e("Sdk", c);
            }
        }

        /* renamed from: b */
        private void m3896b() {
            C1284h a = C1284h.m3343a();
            Context b = C1414j.this.f3499b;
            C1296d a2 = C1296d.m3390a(this.f3529e);
            C1414j jVar = C1414j.this;
            C1414j jVar2 = jVar;
            C1205a aVar = r2;
            C1205a aVar2 = new C1205a(b, a2, (ScheduledExecutorService) jVar.f3514q, jVar.f3505h, jVar.f3500c, jVar.f3520w, jVar.f3501d, jVar.f3521x, jVar.f3492A, jVar.f3510m, jVar.f3502e, jVar.f3493B, jVar2.f3494C, jVar2.f3495D, jVar2.f3503f, jVar2.f3504g, jVar2.f3506i);
            C1205a aVar3 = (C1205a) a.mo10361a(aVar);
            aVar3.mo9937a(this.f3529e);
            Executor executor = C1414j.this.f3514q;
            aVar3.getClass();
            executor.execute(new C1305g.C1307b(0, (String) null, (C1312h) null, (CBError.CBImpressionError) null));
            C1414j.this.f3509l.mo10289a(this.f3529e.getLocation(), aVar3);
        }

        /* renamed from: c */
        private void m3897c() {
            C1348o oVar = C1414j.this.f3511n;
            if (oVar != null) {
                oVar.mo10531b();
            }
        }

        /* renamed from: d */
        private void m3898d() {
            m3897c();
        }

        public void run() {
            AtomicReference<C1236h> atomicReference;
            try {
                switch (this.f3525a) {
                    case 1:
                        C1418k.f3544n = this.f3527c;
                        return;
                    case 2:
                        boolean z = this.f3528d;
                        C1418k.f3546p = z;
                        if (!z || !C1414j.m3874l()) {
                            C1414j.this.f3511n.mo10530a();
                            return;
                        } else {
                            C1414j.this.f3511n.mo10531b();
                            return;
                        }
                    case 3:
                        m3895a();
                        if (!(C1414j.f3491H == null || (atomicReference = C1414j.this.f3492A) == null || atomicReference.get() == null)) {
                            C1414j.f3491H.mo10668a(C1414j.this.f3492A.get().f2832z);
                        }
                        C1357p0 p0Var = new C1357p0("https://live.chartboost.com", "/api/install", C1414j.this.f3521x, 2, new C1417a(this));
                        p0Var.f3342m = true;
                        C1414j.this.f3520w.mo10147a(p0Var);
                        C1414j jVar = C1414j.this;
                        Executor executor = jVar.f3514q;
                        C1305g gVar = jVar.f3516s;
                        gVar.getClass();
                        executor.execute(new C1305g.C1307b(0, (String) null, (C1312h) null, (CBError.CBImpressionError) null));
                        C1414j jVar2 = C1414j.this;
                        Executor executor2 = jVar2.f3514q;
                        C1305g gVar2 = jVar2.f3518u;
                        gVar2.getClass();
                        executor2.execute(new C1305g.C1307b(0, (String) null, (C1312h) null, (CBError.CBImpressionError) null));
                        C1414j jVar3 = C1414j.this;
                        Executor executor3 = jVar3.f3514q;
                        C1305g gVar3 = jVar3.f3522y;
                        gVar3.getClass();
                        executor3.execute(new C1305g.C1307b(0, (String) null, (C1312h) null, (CBError.CBImpressionError) null));
                        m3898d();
                        C1414j.this.f3513p = false;
                        return;
                    case 4:
                        C1414j.this.f3511n.mo10531b();
                        return;
                    case 5:
                        C1272a aVar = C1418k.f3534d;
                        if (aVar != null) {
                            aVar.didFailToLoadMoreApps(this.f3526b, CBError.CBImpressionError.END_POINT_DISABLED);
                            return;
                        }
                        return;
                    case 6:
                        m3896b();
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                CBLogging.m2905b("Sdk", "Sdk command: " + this.f3525a + " : " + e.toString());
            }
            CBLogging.m2905b("Sdk", "Sdk command: " + this.f3525a + " : " + e.toString());
        }
    }

    C1414j(Context context, String str, String str2, C1406x xVar, ScheduledExecutorService scheduledExecutorService, Handler handler, Executor executor) {
        JSONObject jSONObject;
        Context context2 = context;
        ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService;
        Handler handler2 = handler;
        C1284h a = C1284h.m3343a();
        this.f3499b = context2;
        this.f3515r = (C1215d) a.mo10361a(new C1215d());
        C1248h hVar = (C1248h) a.mo10361a(new C1248h(context2));
        this.f3501d = hVar;
        C1224j jVar = (C1224j) a.mo10361a(new C1224j());
        this.f3502e = jVar;
        this.f3520w = (C1247g) a.mo10361a(new C1247g(scheduledExecutorService, (C1255m) a.mo10361a(new C1255m()), hVar, jVar, handler, executor));
        SharedPreferences b = m3865b(context);
        this.f3506i = (C1268g) a.mo10361a(new C1268g(b));
        try {
            jSONObject = new JSONObject(b.getString("config", "{}"));
        } catch (Exception e) {
            CBLogging.m2905b("Sdk", "Unable to process config");
            e.printStackTrace();
            jSONObject = new JSONObject();
        }
        AtomicReference<C1236h> atomicReference = new AtomicReference<>((Object) null);
        if (!C1274c.m3272a(atomicReference, jSONObject)) {
            atomicReference.set(new C1236h(new JSONObject()));
        }
        C1236h hVar2 = atomicReference.get();
        hVar2 = hVar2 == null ? new C1236h(new JSONObject()) : hVar2;
        this.f3498a = xVar;
        this.f3514q = scheduledExecutorService2;
        this.f3492A = atomicReference;
        this.f3510m = b;
        this.f3493B = handler2;
        C1220g gVar = new C1220g(context2, atomicReference);
        this.f3500c = gVar;
        if (!hVar2.f2823q) {
            C1418k.f3547q = "";
        } else {
            m3870c(context);
        }
        C1304f1 f1Var = (C1304f1) a.mo10361a(new C1304f1());
        this.f3508k = f1Var;
        C1387w0 w0Var = (C1387w0) a.mo10361a(m3860a(context));
        f3491H = w0Var;
        w0Var.mo10668a(hVar2.f2832z);
        C1215d dVar = this.f3515r;
        C1248h hVar3 = this.f3501d;
        C1224j jVar2 = this.f3502e;
        C1224j jVar3 = jVar2;
        C1236h hVar4 = hVar2;
        C1234g gVar2 = r8;
        AtomicReference<C1236h> atomicReference2 = atomicReference;
        C1304f1 f1Var2 = f1Var;
        C1220g gVar3 = gVar;
        C1234g gVar4 = new C1234g(context, str, dVar, hVar3, atomicReference2, b, jVar3, f1Var2, this.f3506i, f3491H);
        C1234g gVar5 = (C1234g) a.mo10361a(gVar2);
        this.f3521x = gVar5;
        C1344n nVar = (C1344n) a.mo10361a(new C1344n(scheduledExecutorService, gVar3, this.f3520w, this.f3501d, atomicReference2, this.f3502e));
        C1344n nVar2 = nVar;
        C1344n nVar3 = nVar;
        this.f3505h = nVar;
        C1277e eVar = (C1277e) a.mo10361a(new C1277e((C1342m1) C1284h.m3343a().mo10361a(new C1342m1(handler2)), nVar, atomicReference, handler2));
        this.f3503f = eVar;
        C1249i iVar = (C1249i) a.mo10361a(new C1249i(scheduledExecutorService2, this.f3520w, this.f3501d, handler2));
        C1249i iVar2 = iVar;
        C1249i iVar3 = iVar;
        C1249i iVar4 = iVar;
        this.f3495D = iVar;
        SharedPreferences sharedPreferences = b;
        C1284h hVar5 = a;
        C1275d dVar2 = (C1275d) hVar5.mo10361a(new C1275d(context, this.f3501d, this, handler, eVar));
        C1275d dVar3 = dVar2;
        C1275d dVar4 = dVar2;
        C1275d dVar5 = dVar2;
        this.f3494C = dVar2;
        C1220g gVar6 = gVar3;
        C1252j jVar4 = (C1252j) hVar5.mo10361a(new C1252j(gVar6));
        C1252j jVar5 = jVar4;
        C1252j jVar6 = jVar4;
        C1252j jVar7 = jVar4;
        this.f3504g = jVar4;
        C1286a b2 = C1286a.m3351b();
        C1286a aVar = b2;
        this.f3517t = b2;
        C1286a c = C1286a.m3352c();
        C1286a aVar2 = c;
        this.f3519v = c;
        C1286a d = C1286a.m3353d();
        this.f3523z = d;
        C1284h hVar6 = hVar5;
        C1344n nVar4 = nVar;
        this.f3516s = (C1305g) hVar6.mo10361a(new C1305g(context, aVar, scheduledExecutorService, nVar, gVar6, this.f3520w, this.f3501d, gVar5, atomicReference, sharedPreferences, this.f3502e, handler, dVar5, iVar4, eVar, jVar7, this.f3506i));
        this.f3518u = (C1305g) hVar6.mo10361a(new C1305g(context, aVar2, scheduledExecutorService, nVar3, gVar6, this.f3520w, this.f3501d, gVar5, atomicReference, sharedPreferences, this.f3502e, handler, dVar4, iVar3, eVar, jVar6, this.f3506i));
        Context context3 = context;
        this.f3522y = (C1305g) hVar6.mo10361a(new C1305g(context3, d, scheduledExecutorService, nVar2, gVar6, this.f3520w, this.f3501d, gVar5, atomicReference, sharedPreferences, this.f3502e, handler, dVar3, iVar2, eVar, jVar5, this.f3506i));
        C1234g gVar7 = gVar5;
        this.f3511n = (C1348o) hVar6.mo10361a(new C1348o(nVar4, gVar6, this.f3520w, gVar7, atomicReference));
        C1418k.f3540j = str;
        C1418k.f3541k = str2;
        C1239i d2 = hVar4.mo10132d();
        this.f3507j = (C1266e) hVar6.mo10361a(new C1266e(context, (C1265d) hVar6.mo10361a(new C1265d(d2.mo10138b(), d2.mo10139c())), this.f3520w, gVar7, scheduledExecutorService, d2));
    }

    /* renamed from: c */
    public static void m3871c(C1414j jVar) {
        f3490G = jVar;
    }

    /* renamed from: d */
    private void m3872d(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: l */
    public static boolean m3874l() {
        C1414j b = m3867b();
        if (b == null || !b.mo10717j().mo10130b()) {
            return true;
        }
        try {
            throw new Exception("Chartboost Integration Warning: your account has been disabled for this session. This app has no active publishing campaigns, please create a publishing campaign in the Chartboost dashboard and wait at least 30 minutes to re-enable. If you need assistance, please visit http://chartboo.st/publishing .");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: n */
    private void m3875n() {
        if (!this.f3512o) {
            C1272a aVar = C1418k.f3534d;
            if (aVar != null) {
                aVar.didInitialize();
            }
            this.f3512o = true;
        }
    }

    /* renamed from: p */
    private void m3876p() {
        C1268g gVar = this.f3506i;
        if (gVar != null && !this.f3512o) {
            gVar.mo10258a();
            CBLogging.m2907c("Sdk", "Current session count: " + this.f3506i.mo10261c());
        }
    }

    /* renamed from: q */
    private void m3877q() {
        C1239i d;
        C1236h j = mo10717j();
        if (this.f3507j != null && j != null && (d = j.mo10132d()) != null) {
            this.f3507j.mo10254a(d);
        }
    }

    /* renamed from: e */
    public C1266e mo10712e() {
        return this.f3507j;
    }

    /* renamed from: f */
    public C1305g mo10713f() {
        return this.f3518u;
    }

    /* renamed from: g */
    public C1286a mo10714g() {
        return this.f3519v;
    }

    /* renamed from: h */
    public C1305g mo10715h() {
        return this.f3522y;
    }

    /* renamed from: i */
    public C1286a mo10716i() {
        return this.f3523z;
    }

    /* renamed from: j */
    public C1236h mo10717j() {
        return this.f3492A.get();
    }

    /* renamed from: k */
    public Handler mo10718k() {
        return this.f3493B;
    }

    /* renamed from: m */
    public boolean mo10719m() {
        return this.f3512o;
    }

    /* renamed from: o */
    public void mo10720o() {
        this.f3505h.mo10523c();
    }

    /* renamed from: b */
    public static C1414j m3867b() {
        return f3490G;
    }

    /* renamed from: e */
    public static void m3873e(Runnable runnable) {
        C1406x b = C1406x.m3823b();
        if (!b.mo10697c()) {
            b.f3484a.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10710c(Runnable runnable) {
        this.f3496E = runnable;
        C1357p0 p0Var = new C1357p0("https://live.chartboost.com", "/api/config", this.f3521x, 1, this.f3497F);
        p0Var.f3342m = true;
        this.f3520w.mo10147a(p0Var);
    }

    /* renamed from: d */
    public Context mo10711d() {
        return this.f3499b;
    }

    /* renamed from: b */
    private static SharedPreferences m3865b(Context context) {
        return context.getSharedPreferences("cbPrefs", 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10707a(Activity activity) {
        if (this.f3498a.mo10695a(23)) {
            C1274c.m3274b(activity);
        }
        if (!this.f3513p && !this.f3494C.mo10310g()) {
            this.f3505h.mo10522b();
        }
    }

    /* renamed from: b */
    private void m3868b(Runnable runnable) {
        m3877q();
        m3872d(runnable);
        m3876p();
        m3875n();
    }

    /* renamed from: b */
    static DataUseConsent m3866b(Context context, String str) {
        return m3860a(context).mo10671b(str);
    }

    /* renamed from: c */
    public static C1273b m3869c() {
        C1414j b = m3867b();
        if (b != null) {
            return b.f3509l;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10709a(Runnable runnable, JSONObject jSONObject) {
        m3863a(C1217e.m2936a(jSONObject, "response"));
        m3868b(runnable);
    }

    /* renamed from: c */
    public static void m3870c(Context context) {
        String property = System.getProperty("http.agent");
        try {
            property = WebSettings.getDefaultUserAgent(context);
        } catch (Exception e) {
            try {
                C1266e.m3223e(new C1264c("user_agent_update_error", e.getMessage(), "", ""));
            } catch (Exception unused) {
            }
        }
        C1418k.f3547q = property;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10708a(Runnable runnable) {
        m3868b(runnable);
    }

    /* renamed from: a */
    private void m3863a(JSONObject jSONObject) {
        SharedPreferences.Editor edit;
        if (jSONObject != null && C1274c.m3272a(this.f3492A, jSONObject) && (edit = this.f3510m.edit()) != null) {
            edit.putString("config", jSONObject.toString()).apply();
        }
    }

    /* renamed from: a */
    public void mo10706a(int i) {
        C1268g gVar = this.f3506i;
        if (gVar != null && this.f3512o) {
            gVar.mo10259a(i);
            CBLogging.m2907c("Sdk", "Current session impression count: " + this.f3506i.mo10260b(i) + " in session: " + this.f3506i.mo10261c());
        }
    }

    /* renamed from: a */
    public static C1387w0 m3860a(Context context) {
        if (f3491H == null) {
            SharedPreferences b = m3865b(context);
            C1407x0 x0Var = new C1407x0(m3865b(context));
            f3491H = new C1387w0(new C1292b1(x0Var), new C1411y0(x0Var), new C1295c1(x0Var), new C1413z0(), new C1289a1(x0Var), new C1298d1(x0Var, b));
        }
        return f3491H;
    }

    /* renamed from: a */
    static void m3862a(Context context, DataUseConsent dataUseConsent) {
        if (dataUseConsent.getPrivacyStandard() == null || dataUseConsent.getConsent() == null) {
            try {
                C1266e.m3223e(new C1260a("consent_persistence_error", "", "", ""));
            } catch (Exception unused) {
            }
            CBLogging.m2905b("Sdk", "addDataUseConsent failed");
            return;
        }
        m3860a(context).mo10669a(dataUseConsent);
    }

    /* renamed from: a */
    static DataUseConsent m3858a(Context context, String str) {
        return m3860a(context).mo10667a(str);
    }
}
