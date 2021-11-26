package com.flurry.sdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.flurry.android.FlurryConfigListener;
import com.flurry.sdk.C1601bx;
import com.flurry.sdk.C1618cc;
import com.flurry.sdk.C1720ex;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.flurry.sdk.bz */
public final class C1607bz extends C1730f {

    /* renamed from: b */
    private static volatile C1607bz f4047b;

    /* renamed from: k */
    private static final Object f4048k = new Object();

    /* renamed from: p */
    private static C1630cl f4049p;

    /* renamed from: a */
    public C1616ca f4050a;

    /* renamed from: d */
    private C1600bw f4051d;

    /* renamed from: e */
    private C1621ce f4052e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1629ck f4053f;

    /* renamed from: g */
    private C1635cq f4054g;

    /* renamed from: h */
    private Handler f4055h;

    /* renamed from: i */
    private final Map<FlurryConfigListener, Pair<C1623cg, WeakReference<Handler>>> f4056i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Map<C1623cg, Pair<Boolean, Boolean>> f4057j;

    /* renamed from: l */
    private volatile boolean f4058l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile boolean f4059m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public volatile boolean f4060n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1614a f4061o;

    /* renamed from: com.flurry.sdk.bz$a */
    enum C1614a {
        Complete("Complete", 3),
        CompleteNoChange("No Change", 2),
        Fail("Fail", 1),
        None("None", 0);
        

        /* renamed from: e */
        int f4077e;

        /* renamed from: f */
        private String f4078f;

        private C1614a(String str, int i) {
            this.f4078f = str;
            this.f4077e = i;
        }

        public final String toString() {
            return this.f4078f;
        }
    }

    /* renamed from: a */
    public static synchronized C1607bz m4189a() {
        C1607bz f;
        synchronized (C1607bz.class) {
            f = m4199f();
        }
        return f;
    }

    /* renamed from: f */
    private static synchronized C1607bz m4199f() {
        C1607bz bzVar;
        synchronized (C1607bz.class) {
            if (f4047b == null) {
                f4047b = new C1607bz((byte) 0);
            }
            bzVar = f4047b;
        }
        return bzVar;
    }

    private C1607bz() {
        this((byte) 0);
    }

    private C1607bz(byte b) {
        super("ConfigManager", C1720ex.m4478a(C1720ex.C1722a.CONFIG));
        this.f4056i = new ConcurrentHashMap();
        this.f4057j = new HashMap();
        this.f4058l = false;
        this.f4059m = false;
        this.f4060n = false;
        this.f4061o = C1614a.None;
        f4049p = null;
        for (C1623cg put : C1623cg.m4239b()) {
            Map<C1623cg, Pair<Boolean, Boolean>> map = this.f4057j;
            Boolean bool = Boolean.FALSE;
            map.put(put, new Pair(bool, bool));
        }
        this.f4052e = new C1621ce();
        this.f4053f = new C1629ck();
        this.f4050a = new C1616ca();
        this.f4054g = new C1635cq();
        this.f4055h = new Handler(Looper.getMainLooper());
        runAsync(new C1702eb() {
            /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                jadx.core.utils.exceptions.JadxOverflowException: 
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            /* renamed from: a */
            public final void mo11257a() throws java.lang.Exception {
                /*
                    r8 = this;
                    java.lang.String r0 = "ConfigManager"
                    r1 = 1
                    android.content.Context r2 = com.flurry.sdk.C1536b.m4057a()     // Catch:{ Exception -> 0x00c0 }
                    java.lang.String r2 = com.flurry.sdk.C1636cr.m4295b(r2)     // Catch:{ Exception -> 0x00c0 }
                    java.lang.String r3 = "Cached Data: "
                    java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00c0 }
                    java.lang.String r3 = r3.concat(r4)     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.C1648cy.m4319a(r0, r3)     // Catch:{ Exception -> 0x00c0 }
                    if (r2 == 0) goto L_0x007a
                    com.flurry.sdk.bz r3 = com.flurry.sdk.C1607bz.this     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.ca r3 = r3.f4050a     // Catch:{ Exception -> 0x00c0 }
                    java.lang.String r3 = r3.mo11379d()     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.bz r4 = com.flurry.sdk.C1607bz.this     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.ca r4 = r4.f4050a     // Catch:{ Exception -> 0x00c0 }
                    android.content.SharedPreferences r4 = r4.f4079a     // Catch:{ Exception -> 0x00c0 }
                    r5 = 0
                    if (r4 == 0) goto L_0x0035
                    java.lang.String r6 = "lastRSA"
                    java.lang.String r5 = r4.getString(r6, r5)     // Catch:{ Exception -> 0x00c0 }
                L_0x0035:
                    boolean r3 = com.flurry.sdk.C1636cr.m4293a(r3, r2, r5)     // Catch:{ Exception -> 0x00c0 }
                    if (r3 == 0) goto L_0x0065
                    com.flurry.sdk.bz r3 = com.flurry.sdk.C1607bz.this     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.ck r3 = r3.f4053f     // Catch:{ Exception -> 0x00c0 }
                    if (r2 == 0) goto L_0x0058
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0050 }
                    r4.<init>(r2)     // Catch:{ Exception -> 0x0050 }
                    java.util.List r2 = com.flurry.sdk.C1617cb.m4227a(r4)     // Catch:{ Exception -> 0x0050 }
                    r3.mo11401a((java.util.List<com.flurry.sdk.C1628cj>) r2)     // Catch:{ Exception -> 0x0050 }
                    goto L_0x0058
                L_0x0050:
                    r2 = move-exception
                    java.lang.String r4 = "VariantsManager"
                    java.lang.String r5 = "Cached variants parsing error: "
                    com.flurry.sdk.C1648cy.m4320a((java.lang.String) r4, (java.lang.String) r5, (java.lang.Throwable) r2)     // Catch:{ Exception -> 0x00c0 }
                L_0x0058:
                    com.flurry.sdk.cl r2 = com.flurry.sdk.C1607bz.m4193b()     // Catch:{ Exception -> 0x00c0 }
                    if (r2 == 0) goto L_0x007a
                    com.flurry.sdk.C1607bz.m4193b()     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.C1630cl.m4270a(r3)     // Catch:{ Exception -> 0x00c0 }
                    goto L_0x007a
                L_0x0065:
                    java.lang.String r2 = "Incorrect signature for cache."
                    com.flurry.sdk.C1648cy.m4325b(r0, r2)     // Catch:{ Exception -> 0x00c0 }
                    android.content.Context r2 = com.flurry.sdk.C1536b.m4057a()     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.C1636cr.m4298c(r2)     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.bz r2 = com.flurry.sdk.C1607bz.this     // Catch:{ Exception -> 0x00c0 }
                    com.flurry.sdk.ca r2 = r2.f4050a     // Catch:{ Exception -> 0x00c0 }
                    r2.mo11378c()     // Catch:{ Exception -> 0x00c0 }
                L_0x007a:
                    com.flurry.sdk.bz r0 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.C1607bz.m4195c(r0)
                    com.flurry.sdk.bz r0 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.ck r0 = r0.f4053f
                    int r0 = r0.mo11407e()
                    if (r0 <= 0) goto L_0x0109
                    com.flurry.sdk.bz r0 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.ck r0 = r0.f4053f
                    java.util.List r0 = r0.mo11406d()
                    java.util.Iterator r0 = r0.iterator()
                L_0x0099:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto L_0x00bd
                    java.lang.Object r2 = r0.next()
                    com.flurry.sdk.cg r2 = (com.flurry.sdk.C1623cg) r2
                    com.flurry.sdk.bz r3 = com.flurry.sdk.C1607bz.this
                    java.util.Map r3 = r3.f4057j
                    android.util.Pair r4 = new android.util.Pair
                    java.lang.Boolean r5 = java.lang.Boolean.TRUE
                    java.lang.Boolean r6 = java.lang.Boolean.FALSE
                    r4.<init>(r5, r6)
                    r3.put(r2, r4)
                    com.flurry.sdk.bz r3 = com.flurry.sdk.C1607bz.this
                    r3.mo11367a((com.flurry.sdk.C1623cg) r2, (boolean) r1)
                    goto L_0x0099
                L_0x00bd:
                    return
                L_0x00be:
                    r0 = move-exception
                    goto L_0x010a
                L_0x00c0:
                    r2 = move-exception
                    java.lang.String r3 = "Exception!"
                    com.flurry.sdk.C1648cy.m4320a((java.lang.String) r0, (java.lang.String) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x00be }
                    com.flurry.sdk.bz r0 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.C1607bz.m4195c(r0)
                    com.flurry.sdk.bz r0 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.ck r0 = r0.f4053f
                    int r0 = r0.mo11407e()
                    if (r0 <= 0) goto L_0x0109
                    com.flurry.sdk.bz r0 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.ck r0 = r0.f4053f
                    java.util.List r0 = r0.mo11406d()
                    java.util.Iterator r0 = r0.iterator()
                L_0x00e5:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto L_0x0109
                    java.lang.Object r2 = r0.next()
                    com.flurry.sdk.cg r2 = (com.flurry.sdk.C1623cg) r2
                    com.flurry.sdk.bz r3 = com.flurry.sdk.C1607bz.this
                    java.util.Map r3 = r3.f4057j
                    android.util.Pair r4 = new android.util.Pair
                    java.lang.Boolean r5 = java.lang.Boolean.TRUE
                    java.lang.Boolean r6 = java.lang.Boolean.FALSE
                    r4.<init>(r5, r6)
                    r3.put(r2, r4)
                    com.flurry.sdk.bz r3 = com.flurry.sdk.C1607bz.this
                    r3.mo11367a((com.flurry.sdk.C1623cg) r2, (boolean) r1)
                    goto L_0x00e5
                L_0x0109:
                    return
                L_0x010a:
                    com.flurry.sdk.bz r2 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.C1607bz.m4195c(r2)
                    com.flurry.sdk.bz r2 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.ck r2 = r2.f4053f
                    int r2 = r2.mo11407e()
                    if (r2 <= 0) goto L_0x014d
                    com.flurry.sdk.bz r2 = com.flurry.sdk.C1607bz.this
                    com.flurry.sdk.ck r2 = r2.f4053f
                    java.util.List r2 = r2.mo11406d()
                    java.util.Iterator r2 = r2.iterator()
                L_0x0129:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x014d
                    java.lang.Object r3 = r2.next()
                    com.flurry.sdk.cg r3 = (com.flurry.sdk.C1623cg) r3
                    com.flurry.sdk.bz r4 = com.flurry.sdk.C1607bz.this
                    java.util.Map r4 = r4.f4057j
                    android.util.Pair r5 = new android.util.Pair
                    java.lang.Boolean r6 = java.lang.Boolean.TRUE
                    java.lang.Boolean r7 = java.lang.Boolean.FALSE
                    r5.<init>(r6, r7)
                    r4.put(r3, r5)
                    com.flurry.sdk.bz r4 = com.flurry.sdk.C1607bz.this
                    r4.mo11367a((com.flurry.sdk.C1623cg) r3, (boolean) r1)
                    goto L_0x0129
                L_0x014d:
                    goto L_0x014f
                L_0x014e:
                    throw r0
                L_0x014f:
                    goto L_0x014e
                */
                throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1607bz.C16081.mo11257a():void");
            }
        });
    }

    /* renamed from: b */
    public static C1630cl m4193b() {
        return f4049p;
    }

    /* renamed from: c */
    public final C1600bw mo11369c() {
        if (this.f4051d == null) {
            m4200g();
            this.f4051d = new C1600bw(this.f4052e, this.f4053f);
        }
        return this.f4051d;
    }

    /* renamed from: g */
    private void m4200g() {
        synchronized (f4048k) {
            while (!this.f4058l) {
                try {
                    f4048k.wait();
                } catch (InterruptedException e) {
                    C1648cy.m4320a("ConfigManager", "Interrupted Exception!", (Throwable) e);
                }
            }
        }
    }

    /* renamed from: d */
    public final void mo11370d() {
        if (this.f4059m) {
            C1648cy.m4317a(3, "ConfigManager", "Preventing re-entry...");
            return;
        }
        this.f4059m = true;
        C1648cy.m4317a(3, "ConfigManager", "Fetch started");
        for (C1601bx a : C1620cd.m4229a(C1635cq.m4288a(C1536b.m4057a(), "https://cfg.flurry.com/sdk/v1/config"), new C1601bx.C1604a() {
            /* renamed from: a */
            public final void mo11361a(C1618cc ccVar, boolean z) {
                C1614a aVar;
                if (!z) {
                    boolean unused = C1607bz.this.f4059m = false;
                }
                C1618cc.C1619a aVar2 = ccVar.f4087d;
                if (aVar2 == C1618cc.C1619a.SUCCEED) {
                    C1648cy.m4319a("ConfigManager", "Fetch succeeded.");
                    aVar = C1614a.Complete;
                    boolean unused2 = C1607bz.this.f4060n = true;
                    for (C1623cg next : C1623cg.m4239b()) {
                        boolean z2 = false;
                        if (C1607bz.this.f4057j.containsKey(next)) {
                            z2 = ((Boolean) ((Pair) C1607bz.this.f4057j.get(next)).first).booleanValue();
                        }
                        C1607bz.this.f4057j.put(next, new Pair(Boolean.valueOf(z2), Boolean.FALSE));
                    }
                } else if (aVar2 == C1618cc.C1619a.NO_CHANGE) {
                    C1648cy.m4319a("ConfigManager", "Fetch finished.");
                    aVar = C1614a.CompleteNoChange;
                } else {
                    C1648cy.m4319a("ConfigManager", "Error occured while fetching: ".concat(String.valueOf(ccVar)));
                    aVar = C1614a.Fail;
                }
                if (C1607bz.this.f4061o.f4077e <= aVar.f4077e) {
                    C1614a unused3 = C1607bz.this.f4061o = aVar;
                }
                C1607bz.m4194b(C1607bz.this, aVar);
            }
        }, this.f4050a, this.f4053f)) {
            a.mo11264a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo11366a(com.flurry.android.FlurryConfigListener r5, com.flurry.sdk.C1623cg r6, android.os.Handler r7) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.Map<com.flurry.android.FlurryConfigListener, android.util.Pair<com.flurry.sdk.cg, java.lang.ref.WeakReference<android.os.Handler>>> r0 = r4.f4056i
            monitor-enter(r0)
            java.util.Map<com.flurry.android.FlurryConfigListener, android.util.Pair<com.flurry.sdk.cg, java.lang.ref.WeakReference<android.os.Handler>>> r1 = r4.f4056i     // Catch:{ all -> 0x008b }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0018
            r5 = 5
            java.lang.String r6 = "ConfigManager"
            java.lang.String r7 = "The listener is already registered"
            com.flurry.sdk.C1648cy.m4317a((int) r5, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x008b }
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x0018:
            java.util.Map<com.flurry.android.FlurryConfigListener, android.util.Pair<com.flurry.sdk.cg, java.lang.ref.WeakReference<android.os.Handler>>> r1 = r4.f4056i     // Catch:{ all -> 0x008b }
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x008b }
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x008b }
            r3.<init>(r7)     // Catch:{ all -> 0x008b }
            r2.<init>(r6, r3)     // Catch:{ all -> 0x008b }
            r1.put(r5, r2)     // Catch:{ all -> 0x008b }
            int[] r7 = com.flurry.sdk.C1607bz.C16136.f4071a     // Catch:{ all -> 0x008b }
            com.flurry.sdk.bz$a r1 = r4.f4061o     // Catch:{ all -> 0x008b }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x008b }
            r7 = r7[r1]     // Catch:{ all -> 0x008b }
            r1 = 2
            if (r7 == r1) goto L_0x0045
            r1 = 3
            if (r7 == r1) goto L_0x0041
            r1 = 4
            if (r7 == r1) goto L_0x003b
            goto L_0x0048
        L_0x003b:
            boolean r7 = r4.f4059m     // Catch:{ all -> 0x008b }
            r5.onFetchError(r7)     // Catch:{ all -> 0x008b }
            goto L_0x0048
        L_0x0041:
            r5.onFetchNoChange()     // Catch:{ all -> 0x008b }
            goto L_0x0048
        L_0x0045:
            r5.onFetchSuccess()     // Catch:{ all -> 0x008b }
        L_0x0048:
            java.util.Map<com.flurry.sdk.cg, android.util.Pair<java.lang.Boolean, java.lang.Boolean>> r7 = r4.f4057j     // Catch:{ all -> 0x008b }
            boolean r7 = r7.containsKey(r6)     // Catch:{ all -> 0x008b }
            if (r7 == 0) goto L_0x007d
            java.util.Map<com.flurry.sdk.cg, android.util.Pair<java.lang.Boolean, java.lang.Boolean>> r7 = r4.f4057j     // Catch:{ all -> 0x008b }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x008b }
            android.util.Pair r6 = (android.util.Pair) r6     // Catch:{ all -> 0x008b }
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x008b }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x008b }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x008b }
            if (r7 != 0) goto L_0x006c
            java.lang.Object r7 = r6.second     // Catch:{ all -> 0x008b }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x008b }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x008b }
            if (r7 == 0) goto L_0x0089
        L_0x006c:
            java.lang.Object r6 = r6.second     // Catch:{ all -> 0x008b }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x008b }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x008b }
            if (r6 != 0) goto L_0x0078
            r6 = 1
            goto L_0x0079
        L_0x0078:
            r6 = 0
        L_0x0079:
            r5.onActivateComplete(r6)     // Catch:{ all -> 0x008b }
            goto L_0x0089
        L_0x007d:
            java.util.Map<com.flurry.sdk.cg, android.util.Pair<java.lang.Boolean, java.lang.Boolean>> r5 = r4.f4057j     // Catch:{ all -> 0x008b }
            android.util.Pair r7 = new android.util.Pair     // Catch:{ all -> 0x008b }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008b }
            r7.<init>(r1, r1)     // Catch:{ all -> 0x008b }
            r5.put(r6, r7)     // Catch:{ all -> 0x008b }
        L_0x0089:
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x008b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1607bz.mo11366a(com.flurry.android.FlurryConfigListener, com.flurry.sdk.cg, android.os.Handler):void");
    }

    /* renamed from: com.flurry.sdk.bz$6 */
    static /* synthetic */ class C16136 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4071a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.flurry.sdk.bz$a[] r0 = com.flurry.sdk.C1607bz.C1614a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4071a = r0
                com.flurry.sdk.bz$a r1 = com.flurry.sdk.C1607bz.C1614a.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4071a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flurry.sdk.bz$a r1 = com.flurry.sdk.C1607bz.C1614a.Complete     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4071a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flurry.sdk.bz$a r1 = com.flurry.sdk.C1607bz.C1614a.CompleteNoChange     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4071a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flurry.sdk.bz$a r1 = com.flurry.sdk.C1607bz.C1614a.Fail     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1607bz.C16136.<clinit>():void");
        }
    }

    /* renamed from: a */
    public final void mo11365a(FlurryConfigListener flurryConfigListener) {
        if (flurryConfigListener != null) {
            synchronized (this.f4056i) {
                this.f4056i.remove(flurryConfigListener);
            }
        }
    }

    /* renamed from: a */
    public final void mo11367a(C1623cg cgVar, final boolean z) {
        synchronized (this.f4056i) {
            for (Map.Entry next : this.f4056i.entrySet()) {
                if (cgVar == null || cgVar == ((Pair) next.getValue()).first) {
                    final FlurryConfigListener flurryConfigListener = (FlurryConfigListener) next.getKey();
                    Handler handler = (Handler) ((WeakReference) ((Pair) next.getValue()).second).get();
                    C16114 r4 = new C1702eb() {
                        /* renamed from: a */
                        public final void mo11257a() {
                            flurryConfigListener.onActivateComplete(z);
                        }
                    };
                    if (handler == null) {
                        this.f4055h.post(r4);
                    } else {
                        handler.post(r4);
                    }
                }
            }
        }
    }

    /* renamed from: e */
    public final List<C1628cj> mo11371e() {
        C1629ck ckVar = this.f4053f;
        if (ckVar != null) {
            return ckVar.mo11403b();
        }
        return null;
    }

    /* renamed from: a */
    public final boolean mo11368a(C1623cg cgVar) {
        boolean z;
        if (!this.f4060n) {
            return false;
        }
        boolean z2 = true;
        if (cgVar == null) {
            boolean z3 = false;
            for (Map.Entry next : this.f4057j.entrySet()) {
                Pair pair = (Pair) next.getValue();
                if (!((Boolean) pair.second).booleanValue()) {
                    next.setValue(new Pair(pair.first, Boolean.TRUE));
                    z3 = true;
                }
            }
            z2 = z3;
        } else {
            Pair pair2 = this.f4057j.get(cgVar);
            if (pair2 == null || !((Boolean) pair2.second).booleanValue()) {
                Map<C1623cg, Pair<Boolean, Boolean>> map = this.f4057j;
                if (pair2 == null) {
                    z = false;
                } else {
                    z = ((Boolean) pair2.first).booleanValue();
                }
                map.put(cgVar, new Pair(Boolean.valueOf(z), Boolean.TRUE));
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.f4053f.mo11400a(cgVar);
            mo11367a(cgVar, false);
        }
        return z2;
    }

    public final String toString() {
        m4200g();
        ArrayList arrayList = new ArrayList();
        List<C1628cj> e = mo11371e();
        if (e == null || e.isEmpty()) {
            return "No variants were found!";
        }
        for (C1628cj cjVar : e) {
            arrayList.add(cjVar.toString());
        }
        return TextUtils.join(",", arrayList);
    }

    /* renamed from: c */
    static /* synthetic */ void m4195c(C1607bz bzVar) {
        Object obj = f4048k;
        synchronized (obj) {
            bzVar.f4058l = true;
            obj.notifyAll();
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m4194b(C1607bz bzVar, final C1614a aVar) {
        synchronized (bzVar.f4056i) {
            for (Map.Entry next : bzVar.f4056i.entrySet()) {
                final FlurryConfigListener flurryConfigListener = (FlurryConfigListener) next.getKey();
                Handler handler = (Handler) ((WeakReference) ((Pair) next.getValue()).second).get();
                C16103 r4 = new C1702eb() {
                    /* renamed from: a */
                    public final void mo11257a() {
                        int i = C16136.f4071a[aVar.ordinal()];
                        if (i == 2) {
                            flurryConfigListener.onFetchSuccess();
                        } else if (i == 3) {
                            flurryConfigListener.onFetchNoChange();
                        } else if (i == 4) {
                            flurryConfigListener.onFetchError(C1607bz.this.f4059m);
                        }
                    }
                };
                if (handler == null) {
                    bzVar.f4055h.post(r4);
                } else {
                    handler.post(r4);
                }
            }
        }
    }
}
