package com.applovin.impl.mediation.debugger.p024a.p026b;

import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.b */
public class C0801b implements AppLovinCommunicatorSubscriber, Comparable<C0801b> {

    /* renamed from: a */
    private final C1062k f945a;

    /* renamed from: b */
    private final C0802a f946b;

    /* renamed from: c */
    private int f947c;

    /* renamed from: d */
    private final boolean f948d;

    /* renamed from: e */
    private final boolean f949e;

    /* renamed from: f */
    private final boolean f950f;

    /* renamed from: g */
    private final boolean f951g;

    /* renamed from: h */
    private final boolean f952h;

    /* renamed from: i */
    private final boolean f953i;

    /* renamed from: j */
    private final String f954j;

    /* renamed from: k */
    private final String f955k;

    /* renamed from: l */
    private final String f956l;

    /* renamed from: m */
    private final String f957m;

    /* renamed from: n */
    private final String f958n;

    /* renamed from: o */
    private final String f959o;

    /* renamed from: p */
    private final int f960p;

    /* renamed from: q */
    private final List<MaxAdFormat> f961q;

    /* renamed from: r */
    private final List<C0805d> f962r;

    /* renamed from: s */
    private final List<C0800a> f963s;

    /* renamed from: t */
    private final List<String> f964t;

    /* renamed from: u */
    private final C0804c f965u;

    /* renamed from: com.applovin.impl.mediation.debugger.a.b.b$a */
    public enum C0802a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");
        

        /* renamed from: e */
        private final String f971e;

        private C0802a(String str) {
            this.f971e = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m1187a() {
            return this.f971e;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.a.b.b$b */
    public enum C0803b {
        NOT_SUPPORTED("Not Supported", -65536, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", -65536, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", -65536, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");
        

        /* renamed from: f */
        private final String f978f;

        /* renamed from: g */
        private final int f979g;

        /* renamed from: h */
        private final String f980h;

        private C0803b(String str, int i, String str2) {
            this.f978f = str;
            this.f979g = i;
            this.f980h = str2;
        }

        /* renamed from: a */
        public String mo8609a() {
            return this.f978f;
        }

        /* renamed from: b */
        public int mo8610b() {
            return this.f979g;
        }

        /* renamed from: c */
        public String mo8611c() {
            return this.f980h;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0801b(org.json.JSONObject r11, com.applovin.impl.sdk.C1062k r12) {
        /*
            r10 = this;
            r10.<init>()
            r10.f945a = r12
            java.lang.String r0 = "name"
            java.lang.String r1 = ""
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1123j.m2594b((org.json.JSONObject) r11, (java.lang.String) r0, (java.lang.String) r1, (com.applovin.impl.sdk.C1062k) r12)
            r10.f954j = r0
            java.lang.String r0 = "display_name"
            java.lang.String r0 = com.applovin.impl.sdk.utils.C1123j.m2594b((org.json.JSONObject) r11, (java.lang.String) r0, (java.lang.String) r1, (com.applovin.impl.sdk.C1062k) r12)
            r10.f955k = r0
            java.lang.String r0 = "adapter_class"
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1123j.m2594b((org.json.JSONObject) r11, (java.lang.String) r0, (java.lang.String) r1, (com.applovin.impl.sdk.C1062k) r12)
            r10.f956l = r2
            java.lang.String r3 = "latest_adapter_version"
            java.lang.String r3 = com.applovin.impl.sdk.utils.C1123j.m2594b((org.json.JSONObject) r11, (java.lang.String) r3, (java.lang.String) r1, (com.applovin.impl.sdk.C1062k) r12)
            r10.f959o = r3
            java.util.List r3 = r10.m1162a((org.json.JSONObject) r11)
            r10.f964t = r3
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "configuration"
            org.json.JSONObject r3 = com.applovin.impl.sdk.utils.C1123j.m2600b((org.json.JSONObject) r11, (java.lang.String) r4, (org.json.JSONObject) r3, (com.applovin.impl.sdk.C1062k) r12)
            java.util.List r4 = r10.m1163a(r3, r12)
            r10.f962r = r4
            java.util.List r4 = r10.m1164b(r3, r12)
            r10.f963s = r4
            com.applovin.impl.mediation.debugger.a.b.c r4 = new com.applovin.impl.mediation.debugger.a.b.c
            r4.<init>(r3, r12)
            r10.f965u = r4
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "test_mode"
            org.json.JSONObject r3 = com.applovin.impl.sdk.utils.C1123j.m2600b((org.json.JSONObject) r11, (java.lang.String) r4, (org.json.JSONObject) r3, (com.applovin.impl.sdk.C1062k) r12)
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            java.lang.String r5 = "supported"
            java.lang.Boolean r3 = com.applovin.impl.sdk.utils.C1123j.m2568a((org.json.JSONObject) r3, (java.lang.String) r5, (java.lang.Boolean) r4, (com.applovin.impl.sdk.C1062k) r12)
            boolean r3 = r3.booleanValue()
            r10.f952h = r3
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            java.lang.String r4 = "test_mode_requires_init"
            java.lang.Boolean r3 = com.applovin.impl.sdk.utils.C1123j.m2568a((org.json.JSONObject) r11, (java.lang.String) r4, (java.lang.Boolean) r3, (com.applovin.impl.sdk.C1062k) r12)
            boolean r3 = r3.booleanValue()
            r10.f953i = r3
            java.lang.String r3 = "existence_class"
            java.lang.String r3 = com.applovin.impl.sdk.utils.C1123j.m2594b((org.json.JSONObject) r11, (java.lang.String) r3, (java.lang.String) r1, (com.applovin.impl.sdk.C1062k) r12)
            boolean r3 = com.applovin.impl.sdk.utils.C1160r.m2753d((java.lang.String) r3)
            r10.f948d = r3
            java.util.List r3 = java.util.Collections.emptyList()
            com.applovin.mediation.adapter.MaxAdapter r2 = com.applovin.impl.mediation.p023c.C0788c.m1109a(r2, r12)
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x00ce
            r10.f949e = r4
            java.lang.String r6 = r2.getAdapterVersion()     // Catch:{ all -> 0x00aa }
            java.lang.String r7 = r2.getSdkVersion()     // Catch:{ all -> 0x00a7 }
            if (r7 == 0) goto L_0x009b
            java.lang.String r7 = r2.getSdkVersion()     // Catch:{ all -> 0x00a7 }
            goto L_0x009c
        L_0x009b:
            r7 = r1
        L_0x009c:
            java.util.List r3 = r10.m1161a((com.applovin.mediation.adapter.MaxAdapter) r2)     // Catch:{ all -> 0x00a5 }
            boolean r2 = r2.isBeta()     // Catch:{ all -> 0x00a5 }
            goto L_0x00d3
        L_0x00a5:
            r2 = move-exception
            goto L_0x00ad
        L_0x00a7:
            r2 = move-exception
            r7 = r1
            goto L_0x00ad
        L_0x00aa:
            r2 = move-exception
            r6 = r1
            r7 = r6
        L_0x00ad:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Failed to load adapter for network "
            r8.append(r9)
            java.lang.String r9 = r10.f954j
            r8.append(r9)
            java.lang.String r9 = ". Please check that you have a compatible network SDK integrated. Error: "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            java.lang.String r8 = "MediatedNetwork"
            com.applovin.impl.sdk.C1107r.m2484i(r8, r2)
            goto L_0x00d2
        L_0x00ce:
            r10.f949e = r5
            r6 = r1
            r7 = r6
        L_0x00d2:
            r2 = 0
        L_0x00d3:
            r10.f958n = r6
            r10.f957m = r7
            r10.f961q = r3
            r3 = 0
            java.lang.String r7 = "alternative_network"
            org.json.JSONObject r11 = com.applovin.impl.sdk.utils.C1123j.m2600b((org.json.JSONObject) r11, (java.lang.String) r7, (org.json.JSONObject) r3, (com.applovin.impl.sdk.C1062k) r12)
            java.lang.String r11 = com.applovin.impl.sdk.utils.C1123j.m2594b((org.json.JSONObject) r11, (java.lang.String) r0, (java.lang.String) r1, (com.applovin.impl.sdk.C1062k) r12)
            boolean r11 = com.applovin.impl.sdk.utils.C1160r.m2753d((java.lang.String) r11)
            r10.f951g = r11
            com.applovin.impl.mediation.debugger.a.b.b$a r11 = r10.m1165u()
            r10.f946b = r11
            java.lang.String r11 = r10.f959o
            boolean r11 = r6.equals(r11)
            if (r11 != 0) goto L_0x00fb
            if (r2 != 0) goto L_0x00fb
            goto L_0x00fc
        L_0x00fb:
            r4 = 0
        L_0x00fc:
            r10.f950f = r4
            android.content.Context r11 = r12.mo9334J()
            java.lang.String r12 = r10.f954j
            java.lang.String r0 = "_"
            int r12 = r12.lastIndexOf(r0)
            r0 = -1
            if (r12 == r0) goto L_0x0118
            java.lang.String r0 = r10.f954j
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r12 = r0.substring(r5, r12)
            goto L_0x011e
        L_0x0118:
            java.lang.String r12 = r10.f954j
            java.lang.String r12 = r12.toLowerCase()
        L_0x011e:
            android.content.res.Resources r0 = r11.getResources()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "applovin_ic_mediation_"
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = r11.getPackageName()
            java.lang.String r2 = "drawable"
            int r12 = r0.getIdentifier(r12, r2, r1)
            r10.f960p = r12
            com.applovin.mediation.adapter.MaxAdapter$InitializationStatus r12 = com.applovin.mediation.adapter.MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN
            int r12 = r12.getCode()
            r10.f947c = r12
            com.applovin.communicator.AppLovinCommunicator r11 = com.applovin.communicator.AppLovinCommunicator.getInstance(r11)
            java.lang.String r12 = "adapter_initialization_status"
            r11.subscribe((com.applovin.communicator.AppLovinCommunicatorSubscriber) r10, (java.lang.String) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.p024a.p026b.C0801b.<init>(org.json.JSONObject, com.applovin.impl.sdk.k):void");
    }

    /* renamed from: a */
    private List<MaxAdFormat> m1161a(MaxAdapter maxAdapter) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            arrayList.add(MaxAdFormat.MREC);
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<String> m1162a(JSONObject jSONObject) {
        return C1123j.m2573a(C1123j.m2599b(jSONObject, "supported_regions", (JSONArray) null, this.f945a), (List) null);
    }

    /* renamed from: a */
    private List<C0805d> m1163a(JSONObject jSONObject, C1062k kVar) {
        ArrayList arrayList = new ArrayList();
        JSONObject b = C1123j.m2600b(jSONObject, "permissions", new JSONObject(), kVar);
        Iterator<String> keys = b.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                arrayList.add(new C0805d(next, b.getString(next), kVar.mo9334J()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private List<C0800a> m1164b(JSONObject jSONObject, C1062k kVar) {
        ArrayList arrayList = new ArrayList();
        JSONArray b = C1123j.m2599b(jSONObject, "dependencies", new JSONArray(), kVar);
        for (int i = 0; i < b.length(); i++) {
            JSONObject a = C1123j.m2581a(b, i, (JSONObject) null, kVar);
            if (a != null) {
                arrayList.add(new C0800a(a, kVar));
            }
        }
        return arrayList;
    }

    /* renamed from: u */
    private C0802a m1165u() {
        if (!this.f948d && !this.f949e) {
            return C0802a.MISSING;
        }
        for (C0805d c : this.f962r) {
            if (!c.mo8617c()) {
                return C0802a.INVALID_INTEGRATION;
            }
        }
        for (C0800a c2 : this.f963s) {
            if (!c2.mo8585c()) {
                return C0802a.INVALID_INTEGRATION;
            }
        }
        if (this.f965u.mo8612a() && !this.f965u.mo8613b()) {
            return C0802a.INVALID_INTEGRATION;
        }
        if (this.f948d) {
            if (this.f949e) {
                return C0802a.COMPLETE;
            }
            if (this.f951g) {
                return C0802a.MISSING;
            }
        }
        return C0802a.INCOMPLETE_INTEGRATION;
    }

    /* renamed from: a */
    public int compareTo(C0801b bVar) {
        return this.f955k.compareToIgnoreCase(bVar.f955k);
    }

    /* renamed from: a */
    public C0802a mo8587a() {
        return this.f946b;
    }

    /* renamed from: b */
    public int mo8588b() {
        return this.f947c;
    }

    /* renamed from: c */
    public C0803b mo8589c() {
        return !this.f952h ? C0803b.NOT_SUPPORTED : this.f946b == C0802a.INVALID_INTEGRATION ? C0803b.INVALID_INTEGRATION : !this.f945a.mo9332H().mo8729a() ? C0803b.DISABLED : (!this.f953i || !(this.f947c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.f947c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? C0803b.READY : C0803b.NOT_INITIALIZED;
    }

    /* renamed from: d */
    public boolean mo8591d() {
        return this.f948d;
    }

    /* renamed from: e */
    public boolean mo8592e() {
        return this.f949e;
    }

    /* renamed from: f */
    public boolean mo8593f() {
        return this.f950f;
    }

    /* renamed from: g */
    public String mo8594g() {
        return this.f954j;
    }

    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    /* renamed from: h */
    public String mo8595h() {
        return this.f955k;
    }

    /* renamed from: i */
    public String mo8596i() {
        return this.f957m;
    }

    /* renamed from: j */
    public String mo8597j() {
        return this.f958n;
    }

    /* renamed from: k */
    public String mo8598k() {
        return this.f959o;
    }

    /* renamed from: l */
    public String mo8599l() {
        return this.f956l;
    }

    /* renamed from: m */
    public List<String> mo8600m() {
        return this.f964t;
    }

    /* renamed from: n */
    public int mo8601n() {
        return this.f960p;
    }

    /* renamed from: o */
    public List<MaxAdFormat> mo8602o() {
        return this.f961q;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f956l.equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f947c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
        }
    }

    /* renamed from: p */
    public List<C0805d> mo8603p() {
        return this.f962r;
    }

    /* renamed from: q */
    public List<C0800a> mo8604q() {
        return this.f963s;
    }

    /* renamed from: r */
    public final C0804c mo8605r() {
        return this.f965u;
    }

    /* renamed from: s */
    public final C1062k mo8606s() {
        return this.f945a;
    }

    /* renamed from: t */
    public final String mo8607t() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------- ");
        sb.append(this.f954j);
        sb.append(" ----------");
        sb.append("\nStatus  - ");
        sb.append(this.f946b.m1187a());
        sb.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb.append((!this.f948d || TextUtils.isEmpty(this.f957m)) ? str : this.f957m);
        sb.append("\nAdapter - ");
        if (this.f949e && !TextUtils.isEmpty(this.f958n)) {
            str = this.f958n;
        }
        sb.append(str);
        if (this.f965u.mo8612a() && !this.f965u.mo8613b()) {
            sb.append("\n* ");
            sb.append(this.f965u.mo8614c());
        }
        for (C0805d next : mo8603p()) {
            if (!next.mo8617c()) {
                sb.append("\n* MISSING ");
                sb.append(next.mo8615a());
                sb.append(": ");
                sb.append(next.mo8616b());
            }
        }
        for (C0800a next2 : mo8604q()) {
            if (!next2.mo8585c()) {
                sb.append("\n* MISSING ");
                sb.append(next2.mo8583a());
                sb.append(": ");
                sb.append(next2.mo8584b());
            }
        }
        return sb.toString();
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.f954j + ", displayName=" + this.f955k + ", sdkAvailable=" + this.f948d + ", sdkVersion=" + this.f957m + ", adapterAvailable=" + this.f949e + ", adapterVersion=" + this.f958n + "}";
    }
}
