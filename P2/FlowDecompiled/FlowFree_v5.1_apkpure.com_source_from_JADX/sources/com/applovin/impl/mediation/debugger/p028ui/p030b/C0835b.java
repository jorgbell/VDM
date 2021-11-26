package com.applovin.impl.mediation.debugger.p028ui.p030b;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0796a;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.mediation.debugger.p028ui.p030b.p031a.C0833a;
import com.applovin.impl.mediation.debugger.p028ui.p030b.p031a.C0834b;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0850d;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0852e;
import com.applovin.impl.sdk.C1048h;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1118f;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1199R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.b */
public class C0835b extends C0850d {

    /* renamed from: a */
    private C1062k f1063a;

    /* renamed from: b */
    private List<C0796a> f1064b;

    /* renamed from: d */
    private String f1065d;

    /* renamed from: e */
    private String f1066e;

    /* renamed from: f */
    private String f1067f;

    /* renamed from: g */
    private final AtomicBoolean f1068g = new AtomicBoolean();

    /* renamed from: h */
    private boolean f1069h = false;

    /* renamed from: i */
    private List<C0846c> f1070i = new ArrayList();

    /* renamed from: j */
    private List<C0846c> f1071j = new ArrayList();

    /* renamed from: k */
    private List<C0846c> f1072k = new ArrayList();

    /* renamed from: l */
    private List<C0846c> f1073l = new ArrayList();

    /* renamed from: m */
    private List<C0846c> f1074m = new ArrayList();

    /* renamed from: n */
    private List<C0846c> f1075n = new ArrayList();

    /* renamed from: o */
    private List<C0801b> f1076o = new ArrayList();

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$a */
    public enum C0837a {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        COUNT
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$b */
    public enum C0838b {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public C0835b(Context context) {
        super(context);
    }

    /* renamed from: a */
    private C0846c m1270a(String str, String str2) {
        C0846c.C0848a a = C0846c.m1320p().mo8692a(str);
        if (C1155o.m2673b(str2)) {
            a.mo8697b(str2);
        } else {
            a.mo8689a(C1199R.C1200drawable.applovin_ic_x_mark);
            a.mo8699c(C1118f.m2525a(C1199R.color.applovin_sdk_xmarkColor, this.f1153c));
        }
        return a.mo8694a();
    }

    /* renamed from: a */
    private void m1271a(C0846c.C0848a aVar, String str) {
        aVar.mo8700c("MAX Ad Review").mo8701d(str).mo8689a(C1199R.C1200drawable.applovin_ic_x_mark).mo8699c(C1118f.m2525a(C1199R.color.applovin_sdk_xmarkColor, this.f1153c)).mo8693a(true);
    }

    /* renamed from: a */
    private void m1272a(List<C0801b> list) {
        Object obj;
        List list2;
        this.f1063a.mo9411z().mo9584b("MediationDebuggerListAdapter", "Updating networks...");
        for (C0801b next : list) {
            C0833a aVar = new C0833a(next, this.f1153c);
            if (next.mo8587a() == C0801b.C0802a.INCOMPLETE_INTEGRATION || next.mo8587a() == C0801b.C0802a.INVALID_INTEGRATION) {
                list2 = this.f1073l;
                obj = aVar;
            } else if (next.mo8587a() == C0801b.C0802a.COMPLETE) {
                this.f1074m.add(aVar);
                list2 = this.f1076o;
                obj = aVar.mo8655d();
            } else if (next.mo8587a() == C0801b.C0802a.MISSING) {
                list2 = this.f1075n;
                obj = aVar;
            }
            list2.add(obj);
        }
    }

    /* renamed from: i */
    private List<C0846c> m1273i() {
        String str;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(C0846c.m1320p().mo8692a("Package Name").mo8697b(this.f1153c.getPackageName()).mo8694a());
        try {
            str = this.f1153c.getPackageManager().getPackageInfo(this.f1153c.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(C0846c.m1320p().mo8692a("App Version").mo8697b(str).mo8694a());
        }
        if (!TextUtils.isEmpty(this.f1067f)) {
            arrayList.add(C0846c.m1320p().mo8692a("Account").mo8697b(this.f1067f).mo8694a());
        }
        arrayList.add(C0846c.m1320p().mo8692a("Mediation Provider").mo8697b(!TextUtils.isEmpty(this.f1063a.mo9403s()) ? this.f1063a.mo9403s() : "None").mo8694a());
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c4  */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c> m1274j() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 4
            r0.<init>(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c.m1320p()
            java.lang.String r2 = "SDK Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.mo8692a((java.lang.String) r2)
            java.lang.String r2 = com.applovin.sdk.AppLovinSdk.VERSION
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.mo8697b((java.lang.String) r2)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.mo8694a()
            r0.add(r1)
            com.applovin.impl.sdk.k r1 = r6.f1063a
            com.applovin.impl.sdk.c.b<java.lang.String> r2 = com.applovin.impl.sdk.p037c.C0965b.f1779du
            java.lang.Object r1 = r1.mo9350a(r2)
            java.lang.String r1 = (java.lang.String) r1
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c.m1320p()
            java.lang.String r3 = "Plugin Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = r2.mo8692a((java.lang.String) r3)
            boolean r3 = com.applovin.impl.sdk.utils.C1155o.m2673b(r1)
            java.lang.String r4 = "None"
            if (r3 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r4
        L_0x003b:
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r2.mo8697b((java.lang.String) r1)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.mo8694a()
            r0.add(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c.m1320p()
            java.lang.String r2 = "Ad Review Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.mo8692a((java.lang.String) r2)
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1160r.m2758f()
            boolean r3 = com.applovin.impl.sdk.utils.C1155o.m2673b(r2)
            if (r3 == 0) goto L_0x0096
            java.lang.String r3 = com.applovin.impl.sdk.utils.C1160r.m2761g()
            boolean r5 = com.applovin.impl.sdk.utils.C1155o.m2673b(r3)
            if (r5 == 0) goto L_0x0092
            com.applovin.impl.sdk.k r5 = r6.f1063a
            java.lang.String r5 = r5.mo9409x()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0071
            goto L_0x0092
        L_0x0071:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MAX Ad Review integrated with wrong SDK key. Please check that your "
            r2.<init>(r3)
            com.applovin.impl.sdk.k r3 = r6.f1063a
            boolean r3 = r3.mo9391g()
            if (r3 == 0) goto L_0x0083
            java.lang.String r3 = "SDK key is downloaded"
            goto L_0x0085
        L_0x0083:
            java.lang.String r3 = "Gradle plugin snippet is integrated"
        L_0x0085:
            r2.append(r3)
            java.lang.String r3 = " from the correct account."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L_0x0098
        L_0x0092:
            r1.mo8697b((java.lang.String) r2)
            goto L_0x009b
        L_0x0096:
            java.lang.String r2 = "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps."
        L_0x0098:
            r6.m1271a((com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c.C0848a) r1, (java.lang.String) r2)
        L_0x009b:
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.mo8694a()
            r0.add(r1)
            com.applovin.impl.sdk.k r1 = r6.f1063a
            boolean r1 = r1.mo9391g()
            if (r1 == 0) goto L_0x00ce
            com.applovin.impl.sdk.k r1 = r6.f1063a
            com.applovin.sdk.AppLovinSdkSettings r1 = r1.mo9400p()
            java.util.Map r1 = com.applovin.impl.sdk.utils.C1160r.m2718a((com.applovin.sdk.AppLovinSdkSettings) r1)
            if (r1 == 0) goto L_0x00ce
            java.lang.String r2 = "UnityVersion"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = com.applovin.impl.sdk.utils.C1155o.m2673b(r1)
            if (r2 == 0) goto L_0x00c5
            r4 = r1
        L_0x00c5:
            java.lang.String r1 = "Unity Version"
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r6.m1270a((java.lang.String) r1, (java.lang.String) r4)
            r0.add(r1)
        L_0x00ce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.p028ui.p030b.C0835b.m1274j():java.util.List");
    }

    /* renamed from: k */
    private List<C0846c> m1275k() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new C0834b(C1048h.m2071a(), true, this.f1153c));
        arrayList.add(new C0834b(C1048h.m2076b(), false, this.f1153c));
        arrayList.add(new C0834b(C1048h.m2078c(), true, this.f1153c));
        return arrayList;
    }

    /* renamed from: l */
    private List<C0846c> m1276l() {
        ArrayList arrayList = new ArrayList(2);
        C0846c.C0848a p = C0846c.m1320p();
        arrayList.add(p.mo8692a("View Ad Units (" + this.f1064b.size() + ")").mo8690a(this.f1153c).mo8693a(true).mo8694a());
        arrayList.add(m1277m());
        return arrayList;
    }

    /* renamed from: m */
    private C0846c m1277m() {
        C0846c.C0848a p = C0846c.m1320p();
        if (!this.f1063a.mo9332H().mo8729a()) {
            p.mo8690a(this.f1153c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1063a.mo9332H().mo8732c() != null ? "" : "Select ");
        sb.append("Live Network");
        return p.mo8692a(sb.toString()).mo8697b(this.f1063a.mo9332H().mo8729a() ? "Enable" : null).mo8695b(-16776961).mo8701d("This is not supported while Test Mode is enabled. Please restart the app.").mo8693a(true).mo8694a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo8631a(int i) {
        return (i == C0838b.APP_INFO.ordinal() ? this.f1070i : i == C0838b.MAX.ordinal() ? this.f1071j : i == C0838b.PRIVACY.ordinal() ? m1275k() : i == C0838b.ADS.ordinal() ? this.f1072k : i == C0838b.INCOMPLETE_NETWORKS.ordinal() ? this.f1073l : i == C0838b.COMPLETED_NETWORKS.ordinal() ? this.f1074m : this.f1075n).size();
    }

    /* renamed from: a */
    public void mo8662a(List<C0801b> list, List<C0796a> list2, String str, String str2, String str3, C1062k kVar) {
        this.f1063a = kVar;
        this.f1064b = list2;
        this.f1065d = str;
        this.f1066e = str2;
        this.f1067f = str3;
        if (list != null && this.f1068g.compareAndSet(false, true)) {
            this.f1070i.addAll(m1273i());
            this.f1071j.addAll(m1274j());
            this.f1072k.addAll(m1276l());
            m1272a(list);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C0835b.this.notifyDataSetChanged();
            }
        });
    }

    /* renamed from: a */
    public void mo8663a(boolean z) {
        this.f1069h = z;
    }

    /* renamed from: a */
    public boolean mo8664a() {
        return this.f1068g.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo8633b() {
        return C0838b.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0846c mo8634b(int i) {
        return i == C0838b.APP_INFO.ordinal() ? new C0852e("APP INFO") : i == C0838b.MAX.ordinal() ? new C0852e("MAX") : i == C0838b.PRIVACY.ordinal() ? new C0852e("PRIVACY") : i == C0838b.ADS.ordinal() ? new C0852e("ADS") : i == C0838b.INCOMPLETE_NETWORKS.ordinal() ? new C0852e("INCOMPLETE INTEGRATIONS") : i == C0838b.COMPLETED_NETWORKS.ordinal() ? new C0852e("COMPLETED INTEGRATIONS") : new C0852e("MISSING INTEGRATIONS");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public List<C0846c> mo8635c(int i) {
        return i == C0838b.APP_INFO.ordinal() ? this.f1070i : i == C0838b.MAX.ordinal() ? this.f1071j : i == C0838b.PRIVACY.ordinal() ? m1275k() : i == C0838b.ADS.ordinal() ? this.f1072k : i == C0838b.INCOMPLETE_NETWORKS.ordinal() ? this.f1073l : i == C0838b.COMPLETED_NETWORKS.ordinal() ? this.f1074m : this.f1075n;
    }

    /* renamed from: c */
    public boolean mo8665c() {
        return this.f1069h;
    }

    /* renamed from: d */
    public C1062k mo8666d() {
        return this.f1063a;
    }

    /* renamed from: e */
    public List<C0796a> mo8667e() {
        return this.f1064b;
    }

    /* renamed from: f */
    public String mo8668f() {
        return this.f1065d;
    }

    /* renamed from: g */
    public String mo8669g() {
        return this.f1066e;
    }

    /* renamed from: h */
    public List<C0801b> mo8670h() {
        return this.f1076o;
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.f1068g.get() + "}";
    }
}
