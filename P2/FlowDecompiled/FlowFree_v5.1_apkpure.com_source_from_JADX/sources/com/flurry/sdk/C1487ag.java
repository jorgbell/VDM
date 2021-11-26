package com.flurry.sdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.flurry.sdk.ag */
public final class C1487ag extends C1907m<C1501ak> {

    /* renamed from: a */
    protected C1501ak f3740a = null;

    /* renamed from: b */
    protected C1916q f3741b;

    /* renamed from: d */
    protected C1498ai f3742d;

    /* renamed from: e */
    protected C1485af f3743e;

    /* renamed from: f */
    protected C1484ae f3744f;

    /* renamed from: g */
    protected AtomicBoolean f3745g = new AtomicBoolean(false);

    /* renamed from: h */
    protected C1914o<C1920r> f3746h = new C1914o<C1920r>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            C1487ag.this.mo11269b();
            C1487ag.m3969a((C1920r) obj);
        }
    };

    public C1487ag(C1916q qVar) {
        super("IdProvider");
        this.f3741b = qVar;
        this.f3742d = new C1498ai();
        this.f3743e = new C1485af();
        this.f3744f = new C1484ae();
        this.f3740a = new C1501ak();
        this.f3741b.subscribe(this.f3746h);
    }

    public final void subscribe(C1914o<C1501ak> oVar) {
        super.subscribe(oVar);
    }

    public final void start() {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1487ag.this.f3742d.mo11277a();
            }
        });
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1548be.m4072a();
                C1548be.m4075b("IdProvider: Provider start", Collections.emptyMap());
                C1487ag.this.mo11269b();
            }
        });
    }

    /* renamed from: a */
    public final C1501ak mo11264a() {
        return this.f3740a;
    }

    /* renamed from: a */
    public final void mo11267a(C1502al alVar, String str) {
        if (alVar.f3778g >= 1001) {
            this.f3740a.mo11284a(alVar, str);
            mo11269b();
        }
    }

    /* renamed from: a */
    public final void mo11268a(Map<C1502al, String> map) {
        boolean z = false;
        for (Map.Entry next : map.entrySet()) {
            if (((C1502al) next.getKey()).f3778g >= 1001) {
                z = true;
                this.f3740a.mo11284a((C1502al) next.getKey(), (String) next.getValue());
            }
        }
        if (z) {
            mo11269b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo11269b() {
        runAsync(new C1702eb() {
            /* JADX WARNING: Removed duplicated region for block: B:33:0x012b A[Catch:{ Exception -> 0x0135 }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x015e A[Catch:{ Exception -> 0x01c4 }] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x01b6 A[Catch:{ Exception -> 0x01c4 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x01f3  */
            /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void mo11257a() {
                /*
                    r13 = this;
                    java.lang.String r0 = "IdProvider"
                    com.flurry.sdk.ag r1 = com.flurry.sdk.C1487ag.this
                    java.util.concurrent.atomic.AtomicBoolean r1 = r1.f3745g
                    r2 = 0
                    r1.set(r2)
                    com.flurry.sdk.ag r1 = com.flurry.sdk.C1487ag.this
                    com.flurry.sdk.ai r1 = r1.f3742d
                    r1.mo11277a()
                    r1 = 6
                    r3 = 1
                    r4 = 0
                    com.flurry.sdk.ag r5 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x007a }
                    com.flurry.sdk.ae r5 = r5.f3744f     // Catch:{ Exception -> 0x007a }
                    java.lang.String r6 = "advertising_id"
                    java.lang.String r6 = com.flurry.sdk.C1739fe.m4516b((java.lang.String) r6, (java.lang.String) r4)     // Catch:{ Exception -> 0x007a }
                    java.lang.String r7 = "ad_tracking_enabled"
                    android.content.Context r8 = com.flurry.sdk.C1536b.m4057a()     // Catch:{ Exception -> 0x007a }
                    java.lang.String r9 = "FLURRY_SHARED_PREFERENCES"
                    android.content.SharedPreferences r8 = r8.getSharedPreferences(r9, r2)     // Catch:{ Exception -> 0x007a }
                    java.util.Locale r9 = java.util.Locale.US     // Catch:{ Exception -> 0x007a }
                    java.lang.String r10 = "com.flurry.sdk.%s"
                    java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x007a }
                    r11[r2] = r7     // Catch:{ Exception -> 0x007a }
                    java.lang.String r7 = java.lang.String.format(r9, r10, r11)     // Catch:{ Exception -> 0x007a }
                    boolean r2 = r8.getBoolean(r7, r2)     // Catch:{ Exception -> 0x007a }
                    r2 = r2 ^ r3
                    if (r6 == 0) goto L_0x0042
                    r5.f3734a = r6     // Catch:{ Exception -> 0x007a }
                    r5.f3735b = r2     // Catch:{ Exception -> 0x007a }
                    goto L_0x0045
                L_0x0042:
                    r5.mo11264a()     // Catch:{ Exception -> 0x007a }
                L_0x0045:
                    com.flurry.sdk.ag r2 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x007a }
                    com.flurry.sdk.ae r2 = r2.f3744f     // Catch:{ Exception -> 0x007a }
                    java.lang.String r5 = r2.f3734a     // Catch:{ Exception -> 0x007a }
                    boolean r2 = r2.f3735b     // Catch:{ Exception -> 0x007a }
                    boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x007a }
                    if (r6 != 0) goto L_0x0062
                    com.flurry.sdk.ag r6 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x007a }
                    com.flurry.sdk.ak r6 = r6.f3740a     // Catch:{ Exception -> 0x007a }
                    com.flurry.sdk.al r7 = com.flurry.sdk.C1502al.AndroidAdvertisingId     // Catch:{ Exception -> 0x007a }
                    r6.mo11284a(r7, r5)     // Catch:{ Exception -> 0x007a }
                    com.flurry.sdk.ag r6 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x007a }
                    com.flurry.sdk.ak r6 = r6.f3740a     // Catch:{ Exception -> 0x007a }
                    r6.f3770b = r2     // Catch:{ Exception -> 0x007a }
                L_0x0062:
                    com.flurry.sdk.ag r6 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x007a }
                    com.flurry.sdk.ae r6 = r6.f3744f     // Catch:{ Exception -> 0x007a }
                    java.util.concurrent.atomic.AtomicBoolean r6 = r6.f3736d     // Catch:{ Exception -> 0x007a }
                    boolean r6 = r6.get()     // Catch:{ Exception -> 0x007a }
                    r6 = r6 ^ r3
                    if (r6 == 0) goto L_0x009a
                    com.flurry.sdk.ag r6 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x007a }
                    com.flurry.sdk.ag$4$1 r7 = new com.flurry.sdk.ag$4$1     // Catch:{ Exception -> 0x007a }
                    r7.<init>(r2, r5)     // Catch:{ Exception -> 0x007a }
                    java.util.concurrent.Future unused = r6.runAsync(r7)     // Catch:{ Exception -> 0x007a }
                    goto L_0x009a
                L_0x007a:
                    r2 = move-exception
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    java.lang.String r6 = "Error Fetching Ad Id - "
                    r5.<init>(r6)
                    java.lang.String r6 = r2.getLocalizedMessage()
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    com.flurry.sdk.C1648cy.m4317a((int) r1, (java.lang.String) r0, (java.lang.String) r5)
                    com.flurry.sdk.C1548be.m4072a()
                    java.lang.String r5 = "Error fetching Ad Id"
                    java.lang.String r6 = "Exception happened during fetching Ad Id"
                    com.flurry.sdk.C1548be.m4073a(r5, r6, r2)
                L_0x009a:
                    com.flurry.sdk.ag r2 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x0135 }
                    com.flurry.sdk.af r2 = r2.f3743e     // Catch:{ Exception -> 0x0135 }
                    java.lang.String r5 = r2.f3737a     // Catch:{ Exception -> 0x0135 }
                    boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0135 }
                    if (r5 == 0) goto L_0x0127
                    android.content.Context r5 = com.flurry.sdk.C1536b.m4057a()     // Catch:{ Exception -> 0x0135 }
                    android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x0135 }
                    java.lang.String r6 = "android_id"
                    java.lang.String r5 = android.provider.Settings.Secure.getString(r5, r6)     // Catch:{ Exception -> 0x0135 }
                    java.util.Set<java.lang.String> r6 = r2.f3738b     // Catch:{ Exception -> 0x0135 }
                    java.util.Locale r7 = java.util.Locale.US     // Catch:{ Exception -> 0x0135 }
                    java.lang.String r7 = r5.toLowerCase(r7)     // Catch:{ Exception -> 0x0135 }
                    boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0135 }
                    if (r6 == 0) goto L_0x00c4
                    r5 = r4
                    goto L_0x00ce
                L_0x00c4:
                    java.lang.String r6 = "AND"
                    java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0135 }
                    java.lang.String r5 = r6.concat(r5)     // Catch:{ Exception -> 0x0135 }
                L_0x00ce:
                    boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0135 }
                    if (r6 != 0) goto L_0x00d5
                    goto L_0x0129
                L_0x00d5:
                    java.lang.String r5 = com.flurry.sdk.C1485af.m3964a()     // Catch:{ Exception -> 0x0135 }
                    boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0135 }
                    if (r6 == 0) goto L_0x0125
                    java.lang.String r5 = r2.mo11265b()     // Catch:{ Exception -> 0x0135 }
                    boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0135 }
                    if (r6 == 0) goto L_0x0122
                    java.security.SecureRandom r5 = new java.security.SecureRandom     // Catch:{ Exception -> 0x0135 }
                    r5.<init>()     // Catch:{ Exception -> 0x0135 }
                    double r5 = r5.nextDouble()     // Catch:{ Exception -> 0x0135 }
                    long r5 = java.lang.Double.doubleToLongBits(r5)     // Catch:{ Exception -> 0x0135 }
                    long r7 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0135 }
                    android.content.Context r9 = com.flurry.sdk.C1536b.m4057a()     // Catch:{ Exception -> 0x0135 }
                    java.lang.String r9 = com.flurry.sdk.C1695dx.m4430a(r9)     // Catch:{ Exception -> 0x0135 }
                    long r9 = com.flurry.sdk.C1698dz.m4450e(r9)     // Catch:{ Exception -> 0x0135 }
                    r11 = 37
                    long r9 = r9 * r11
                    long r7 = r7 + r9
                    long r7 = r7 * r11
                    long r5 = r5 + r7
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0135 }
                    java.lang.String r8 = "ID"
                    r7.<init>(r8)     // Catch:{ Exception -> 0x0135 }
                    r8 = 16
                    java.lang.String r5 = java.lang.Long.toString(r5, r8)     // Catch:{ Exception -> 0x0135 }
                    r7.append(r5)     // Catch:{ Exception -> 0x0135 }
                    java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0135 }
                L_0x0122:
                    com.flurry.sdk.C1485af.m3965a(r5)     // Catch:{ Exception -> 0x0135 }
                L_0x0125:
                    r2.f3737a = r5     // Catch:{ Exception -> 0x0135 }
                L_0x0127:
                    java.lang.String r5 = r2.f3737a     // Catch:{ Exception -> 0x0135 }
                L_0x0129:
                    if (r5 == 0) goto L_0x0155
                    com.flurry.sdk.ag r2 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x0135 }
                    com.flurry.sdk.ak r2 = r2.f3740a     // Catch:{ Exception -> 0x0135 }
                    com.flurry.sdk.al r6 = com.flurry.sdk.C1502al.DeviceId     // Catch:{ Exception -> 0x0135 }
                    r2.mo11284a(r6, r5)     // Catch:{ Exception -> 0x0135 }
                    goto L_0x0155
                L_0x0135:
                    r2 = move-exception
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    java.lang.String r6 = "Error Fetching Device Id - "
                    r5.<init>(r6)
                    java.lang.String r6 = r2.getLocalizedMessage()
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    com.flurry.sdk.C1648cy.m4317a((int) r1, (java.lang.String) r0, (java.lang.String) r5)
                    com.flurry.sdk.C1548be.m4072a()
                    java.lang.String r5 = "Error fetching Device Id"
                    java.lang.String r6 = "Exception happened during fetching Device Id"
                    com.flurry.sdk.C1548be.m4073a(r5, r6, r2)
                L_0x0155:
                    com.flurry.sdk.ag r2 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x01c4 }
                    com.flurry.sdk.ai r2 = r2.f3742d     // Catch:{ Exception -> 0x01c4 }
                    byte[] r5 = r2.f3762a     // Catch:{ Exception -> 0x01c4 }
                    r6 = 2
                    if (r5 != 0) goto L_0x01b4
                    int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01c4 }
                    r7 = 23
                    if (r5 >= r7) goto L_0x0167
                    com.flurry.sdk.k$a r5 = com.flurry.sdk.C1904k.C1905a.CRYPTO_ALGO_PADDING_5     // Catch:{ Exception -> 0x01c4 }
                    goto L_0x0169
                L_0x0167:
                    com.flurry.sdk.k$a r5 = com.flurry.sdk.C1904k.C1905a.CRYPTO_ALGO_PADDING_7     // Catch:{ Exception -> 0x01c4 }
                L_0x0169:
                    java.security.Key r7 = r2.mo11280b()     // Catch:{ Exception -> 0x01c4 }
                    byte[] r7 = r2.mo11279a(r7)     // Catch:{ Exception -> 0x01c4 }
                    if (r7 != 0) goto L_0x01b1
                    java.util.UUID r7 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x01c4 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01c4 }
                    java.util.Locale r8 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01c4 }
                    java.lang.String r7 = r7.toLowerCase(r8)     // Catch:{ Exception -> 0x01c4 }
                    boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01c4 }
                    if (r8 == 0) goto L_0x0188
                    goto L_0x01ac
                L_0x0188:
                    java.lang.String r8 = "[^a-f0-9]+"
                    java.lang.String r9 = ""
                    java.lang.String r7 = r7.replaceAll(r8, r9)     // Catch:{ Exception -> 0x01c4 }
                    int r8 = r7.length()     // Catch:{ Exception -> 0x01c4 }
                    int r8 = r8 % r6
                    if (r8 == 0) goto L_0x01a8
                    r8 = 4
                    java.lang.String r9 = "InstallationIdProvider"
                    java.lang.String r10 = "Input string must contain an even number of characters "
                    java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x01c4 }
                    java.lang.String r7 = r10.concat(r7)     // Catch:{ Exception -> 0x01c4 }
                    com.flurry.sdk.C1648cy.m4317a((int) r8, (java.lang.String) r9, (java.lang.String) r7)     // Catch:{ Exception -> 0x01c4 }
                    goto L_0x01ac
                L_0x01a8:
                    byte[] r4 = com.flurry.sdk.C1698dz.m4448c(r7)     // Catch:{ Exception -> 0x01c4 }
                L_0x01ac:
                    r2.mo11278a(r4, r5)     // Catch:{ Exception -> 0x01c4 }
                    r5 = r4
                    goto L_0x01b2
                L_0x01b1:
                    r5 = r7
                L_0x01b2:
                    r2.f3762a = r5     // Catch:{ Exception -> 0x01c4 }
                L_0x01b4:
                    if (r5 == 0) goto L_0x01e4
                    java.lang.String r2 = android.util.Base64.encodeToString(r5, r6)     // Catch:{ Exception -> 0x01c4 }
                    com.flurry.sdk.ag r4 = com.flurry.sdk.C1487ag.this     // Catch:{ Exception -> 0x01c4 }
                    com.flurry.sdk.ak r4 = r4.f3740a     // Catch:{ Exception -> 0x01c4 }
                    com.flurry.sdk.al r5 = com.flurry.sdk.C1502al.AndroidInstallationId     // Catch:{ Exception -> 0x01c4 }
                    r4.mo11284a(r5, r2)     // Catch:{ Exception -> 0x01c4 }
                    goto L_0x01e4
                L_0x01c4:
                    r2 = move-exception
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    java.lang.String r5 = "Error Fetching Install Id - "
                    r4.<init>(r5)
                    java.lang.String r5 = r2.getLocalizedMessage()
                    r4.append(r5)
                    java.lang.String r4 = r4.toString()
                    com.flurry.sdk.C1648cy.m4317a((int) r1, (java.lang.String) r0, (java.lang.String) r4)
                    com.flurry.sdk.C1548be.m4072a()
                    java.lang.String r0 = "Error fetching Install Id"
                    java.lang.String r1 = "Exception happened during fetching Install Id"
                    com.flurry.sdk.C1548be.m4073a(r0, r1, r2)
                L_0x01e4:
                    com.flurry.sdk.ag r0 = com.flurry.sdk.C1487ag.this
                    java.util.concurrent.atomic.AtomicBoolean r0 = r0.f3745g
                    r0.set(r3)
                    com.flurry.sdk.ag r0 = com.flurry.sdk.C1487ag.this
                    boolean r0 = r0.mo11270c()
                    if (r0 == 0) goto L_0x01fe
                    com.flurry.sdk.ag r0 = com.flurry.sdk.C1487ag.this
                    com.flurry.sdk.ak r1 = r0.f3740a
                    com.flurry.sdk.ak r1 = r1.mo11285b()
                    r0.notifyObservers(r1)
                L_0x01fe:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1487ag.C14914.mo11257a():void");
            }
        });
    }

    /* renamed from: c */
    public final boolean mo11270c() {
        boolean z = this.f3745g.get();
        C1501ak akVar = this.f3740a;
        return z && (akVar != null && akVar.mo11283a() != null && this.f3740a.mo11283a().size() > 0);
    }

    public final void destroy() {
        super.destroy();
        this.f3741b.unsubscribe(this.f3746h);
    }

    /* renamed from: a */
    static /* synthetic */ void m3969a(C1920r rVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("previous_state", rVar.f4751a.name());
        hashMap.put("current_state", rVar.f4752b.name());
        C1548be.m4072a();
        C1548be.m4075b("IdProvider: App State Change", hashMap);
    }
}
