package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.flurry.android.FlurryAgent;
import com.flurry.sdk.C1618cc;
import com.flurry.sdk.C1624ch;
import com.flurry.sdk.C1720ex;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.bx */
public abstract class C1601bx extends C1730f {

    /* renamed from: a */
    private static boolean f4028a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1618cc f4029b;

    /* renamed from: d */
    private C1634cp f4030d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1604a f4031e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1616ca f4032f;

    /* renamed from: g */
    private C1629ck f4033g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f4034h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1624ch f4035i;

    /* renamed from: com.flurry.sdk.bx$a */
    public interface C1604a {
        /* renamed from: a */
        void mo11361a(C1618cc ccVar, boolean z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo11357b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract String mo11358c();

    public C1601bx(C1634cp cpVar, C1604a aVar, C1616ca caVar, C1629ck ckVar) {
        super("ConfigFetcher", C1720ex.m4478a(C1720ex.C1722a.CONFIG));
        this.f4030d = cpVar;
        this.f4031e = aVar;
        this.f4032f = caVar;
        this.f4033g = ckVar;
    }

    /* renamed from: a */
    public final synchronized void mo11264a() {
        C1648cy.m4319a("ConfigFetcher", "Starting Config fetch.");
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1618cc unused = C1601bx.this.f4029b = C1618cc.f4085b;
                long unused2 = C1601bx.this.f4034h = System.currentTimeMillis();
                C1624ch unused3 = C1601bx.this.f4035i = null;
                C1601bx.this.f4032f.mo11377b();
                if (!C1601bx.m4175c(C1601bx.this)) {
                    C1601bx.this.f4031e.mo11361a(C1601bx.this.f4029b, false);
                } else {
                    C1601bx.this.mo11357b();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final synchronized void mo11359d() {
        JSONObject a;
        C1648cy.m4319a("ConfigFetcher", "Fetching Config data.");
        this.f4030d.run();
        C1618cc h = this.f4030d.mo11416h();
        this.f4029b = h;
        C1618cc ccVar = C1618cc.f4084a;
        if (h == ccVar) {
            C1648cy.m4319a("ConfigFetcher", "Processing Config fetched data.");
            try {
                String str = this.f4030d.f4137h;
                C1648cy.m4319a("ConfigFetcher", "JSON body: ".concat(String.valueOf(str)));
                JSONObject jSONObject = new JSONObject(str);
                String d = this.f4030d.mo11412d();
                String c = mo11358c();
                String optString = jSONObject.optString("requestGuid");
                String optString2 = jSONObject.optString("apiKey");
                if (d.equals(optString)) {
                    if (c.equals(optString2)) {
                        List<C1628cj> a2 = C1617cb.m4227a(jSONObject);
                        long optLong = jSONObject.optLong("refreshInSeconds");
                        this.f4033g.f4124d = optLong;
                        if (!C1636cr.m4292a(this.f4032f.mo11379d()) || !this.f4030d.mo11411c() || this.f4033g.mo11404b(a2)) {
                            this.f4033g.mo11402a(a2, this.f4030d.mo11411c());
                            this.f4029b = ccVar;
                            C1629ck ckVar = this.f4033g;
                            Context a3 = C1536b.m4057a();
                            if (!this.f4030d.mo11411c()) {
                                str = null;
                            }
                            if (str == null && (a = ckVar.mo11398a(ckVar.f4121a, ckVar.f4123c, false)) != null) {
                                str = a.toString();
                            }
                            if (str != null) {
                                C1636cr.m4289a(a3, str);
                            }
                            C1616ca caVar = this.f4032f;
                            String g = this.f4030d.mo11415g();
                            SharedPreferences sharedPreferences = caVar.f4079a;
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().putString("lastETag", g).apply();
                            }
                            C1616ca caVar2 = this.f4032f;
                            String e = this.f4030d.mo11413e();
                            SharedPreferences sharedPreferences2 = caVar2.f4079a;
                            if (sharedPreferences2 != null) {
                                sharedPreferences2.edit().putString("lastKeyId", e).apply();
                            }
                            C1616ca caVar3 = this.f4032f;
                            String f = this.f4030d.mo11414f();
                            SharedPreferences sharedPreferences3 = caVar3.f4079a;
                            if (sharedPreferences3 != null) {
                                sharedPreferences3.edit().putString("lastRSA", f).apply();
                            }
                        } else {
                            this.f4029b = C1618cc.f4085b;
                        }
                        f4028a = true;
                        C1795gi.m4646a(this.f4033g.mo11403b());
                        C1616ca caVar4 = this.f4032f;
                        String c2 = this.f4033g.mo11405c();
                        if (caVar4.f4079a != null) {
                            C1648cy.m4319a("ConfigMeta", "Save serialized variant IDs: ".concat(String.valueOf(c2)));
                            caVar4.f4079a.edit().putString("com.flurry.sdk.variant_ids", c2).apply();
                        }
                        C1616ca caVar5 = this.f4032f;
                        SharedPreferences sharedPreferences4 = caVar5.f4079a;
                        if (sharedPreferences4 != null) {
                            sharedPreferences4.edit().putInt("appVersion", caVar5.f4080b).apply();
                        }
                        this.f4032f.mo11375a(System.currentTimeMillis());
                        C1616ca caVar6 = this.f4032f;
                        long j = optLong * 1000;
                        if (j == 0) {
                            caVar6.f4081c = 0;
                        } else if (j > 604800000) {
                            caVar6.f4081c = 604800000;
                        } else if (j < 60000) {
                            caVar6.f4081c = 60000;
                        } else {
                            caVar6.f4081c = j;
                        }
                        SharedPreferences sharedPreferences5 = caVar6.f4079a;
                        if (sharedPreferences5 != null) {
                            sharedPreferences5.edit().putLong("refreshFetch", caVar6.f4081c).apply();
                        }
                        if (C1607bz.m4193b() != null) {
                            C1607bz.m4193b();
                            C1630cl.m4270a(this.f4033g);
                        }
                        this.f4032f.mo11377b();
                        if (C1607bz.m4193b() != null) {
                            C1607bz.m4193b();
                            C1630cl.m4269a(this.f4029b.f4087d.f4096h, System.currentTimeMillis() - this.f4034h, this.f4029b.toString());
                        }
                        this.f4031e.mo11361a(this.f4029b, false);
                        return;
                    }
                }
                C1618cc.C1619a aVar = C1618cc.C1619a.AUTHENTICATE;
                this.f4029b = new C1618cc(aVar, "Guid: " + d + ", payload: " + optString + " APIKey: " + c + ", payload: " + optString2);
                StringBuilder sb = new StringBuilder("Authentication error: ");
                sb.append(this.f4029b);
                C1648cy.m4325b("ConfigFetcher", sb.toString());
                m4178e();
            } catch (JSONException e2) {
                C1648cy.m4320a("ConfigFetcher", "Json parse error", (Throwable) e2);
                this.f4029b = new C1618cc(C1618cc.C1619a.NOT_VALID_JSON, e2.toString());
            } catch (Exception e3) {
                C1648cy.m4320a("ConfigFetcher", "Fetch result error", (Throwable) e3);
                this.f4029b = new C1618cc(C1618cc.C1619a.OTHER, e3.toString());
            }
        } else if (h == C1618cc.f4085b) {
            this.f4032f.mo11375a(System.currentTimeMillis());
            this.f4032f.mo11377b();
            this.f4031e.mo11361a(this.f4029b, false);
        } else {
            C1648cy.m4317a(5, "ConfigFetcher", "fetch error:" + this.f4029b.toString());
            if (this.f4035i == null) {
                C1618cc ccVar2 = this.f4029b;
                if (ccVar2.f4087d == C1618cc.C1619a.UNKNOWN_CERTIFICATE) {
                    FlurryAgent.onError("FlurryUnknownCertificate", ccVar2.f4086c, "ConfigFetcher");
                }
            }
            if (C1607bz.m4193b() != null) {
                C1607bz.m4193b();
                C1630cl.m4269a(this.f4029b.f4087d.f4096h, System.currentTimeMillis() - this.f4034h, this.f4029b.toString());
            }
            m4178e();
        }
    }

    /* renamed from: e */
    private void m4178e() {
        C1648cy.m4319a("ConfigFetcher", "Retry fetching Config data.");
        C1624ch chVar = this.f4035i;
        if (chVar == null) {
            this.f4035i = new C1624ch(C1624ch.C1625a.values()[0]);
        } else {
            this.f4035i = new C1624ch(chVar.f4106a.mo11389a());
        }
        if (this.f4035i.f4106a == C1624ch.C1625a.ABANDON) {
            this.f4031e.mo11361a(this.f4029b, false);
            return;
        }
        this.f4031e.mo11361a(this.f4029b, true);
        this.f4032f.mo11376a(new TimerTask() {
            public final void run() {
                C1601bx.this.mo11359d();
            }
        }, ((long) this.f4035i.mo11388a()) * 1000);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m4175c(C1601bx bxVar) {
        if (!C1636cr.m4291a(C1536b.m4057a())) {
            return true;
        }
        C1648cy.m4319a("ConfigFetcher", "Compare version: current=" + bxVar.f4032f.f4080b + ", recorded=" + bxVar.f4032f.mo11374a());
        int a = bxVar.f4032f.mo11374a();
        C1616ca caVar = bxVar.f4032f;
        if (a < caVar.f4080b) {
            return true;
        }
        long j = caVar.f4081c;
        long j2 = 0;
        if (j != 0) {
            SharedPreferences sharedPreferences = caVar.f4079a;
            if (sharedPreferences != null) {
                j2 = sharedPreferences.getLong("lastFetch", 0);
            }
            if (System.currentTimeMillis() - j2 > j) {
                return true;
            }
        } else if (!f4028a) {
            return true;
        }
        C1648cy.m4319a("ConfigFetcher", "It does not meet any criterias for data fetch.");
        return false;
    }
}
