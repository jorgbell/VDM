package com.applovin.impl.sdk.network;

import android.content.SharedPreferences;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.e */
public class C1090e {

    /* renamed from: a */
    private final C1062k f2312a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1107r f2313b;

    /* renamed from: c */
    private final SharedPreferences f2314c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f2315d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ArrayList<C1094f> f2316e;

    /* renamed from: f */
    private final ArrayList<C1094f> f2317f = new ArrayList<>();

    /* renamed from: g */
    private final Set<C1094f> f2318g = new HashSet();

    public C1090e(C1062k kVar) {
        if (kVar != null) {
            this.f2312a = kVar;
            this.f2313b = kVar.mo9411z();
            this.f2314c = kVar.mo9334J().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
            this.f2316e = m2350b();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r0 = ((java.lang.Integer) r4.f2312a.mo9350a(com.applovin.impl.sdk.p037c.C0965b.f1692cL)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (r5.mo9516k() <= r0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        r6 = r4.f2313b;
        r6.mo9587d("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + r0 + ". Dequeuing postback: " + r5);
        m2360d(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0093, code lost:
        r1 = r4.f2315d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0095, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f2318g.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
        if (r5.mo9510f() == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
        r0 = new org.json.JSONObject(r5.mo9510f());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ac, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ad, code lost:
        r4.f2312a.mo9346W().dispatchPostbackRequest(com.applovin.impl.sdk.network.C1097g.m2402b(r4.f2312a).mo9540d(r5.mo9505b()).mo9543e(r5.mo9506c()).mo9538c(r5.mo9507d()).mo9545f(r5.mo9504a()).mo9541d(r5.mo9508e()).mo9536b(r0).mo9548g(r5.mo9512h()).mo9546f(r5.mo9511g()).mo9549h(r5.mo9514i()).mo9547g(r5.mo9515j()).mo9537b(), new com.applovin.impl.sdk.network.C1090e.C10922(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2348a(final com.applovin.impl.sdk.network.C1094f r5, final com.applovin.sdk.AppLovinPostbackListener r6) {
        /*
            r4 = this;
            com.applovin.impl.sdk.r r0 = r4.f2313b
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Preparing to submit postback..."
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.mo9584b(r1, r2)
            com.applovin.impl.sdk.k r0 = r4.f2312a
            boolean r0 = r0.mo9387c()
            if (r0 == 0) goto L_0x002a
            com.applovin.impl.sdk.r r5 = r4.f2313b
            java.lang.String r6 = "PersistentPostbackManager"
            java.lang.String r0 = "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards"
            r5.mo9584b(r6, r0)
            return
        L_0x002a:
            java.lang.Object r0 = r4.f2315d
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.network.f> r1 = r4.f2318g     // Catch:{ all -> 0x0115 }
            boolean r1 = r1.contains(r5)     // Catch:{ all -> 0x0115 }
            if (r1 == 0) goto L_0x0053
            com.applovin.impl.sdk.r r6 = r4.f2313b     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r2.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "Skip pending postback: "
            r2.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r5.mo9505b()     // Catch:{ all -> 0x0115 }
            r2.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0115 }
            r6.mo9584b(r1, r5)     // Catch:{ all -> 0x0115 }
            monitor-exit(r0)     // Catch:{ all -> 0x0115 }
            return
        L_0x0053:
            r5.mo9517l()     // Catch:{ all -> 0x0115 }
            r4.m2353c()     // Catch:{ all -> 0x0115 }
            monitor-exit(r0)     // Catch:{ all -> 0x0115 }
            com.applovin.impl.sdk.k r0 = r4.f2312a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r1 = com.applovin.impl.sdk.p037c.C0965b.f1692cL
            java.lang.Object r0 = r0.mo9350a(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r1 = r5.mo9516k()
            if (r1 <= r0) goto L_0x0093
            com.applovin.impl.sdk.r r6 = r4.f2313b
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Exceeded maximum persisted attempt count of "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ". Dequeuing postback: "
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            r6.mo9587d(r1, r0)
            r4.m2360d((com.applovin.impl.sdk.network.C1094f) r5)
            goto L_0x0111
        L_0x0093:
            java.lang.Object r1 = r4.f2315d
            monitor-enter(r1)
            java.util.Set<com.applovin.impl.sdk.network.f> r0 = r4.f2318g     // Catch:{ all -> 0x0112 }
            r0.add(r5)     // Catch:{ all -> 0x0112 }
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            java.util.Map r0 = r5.mo9510f()
            if (r0 == 0) goto L_0x00ac
            org.json.JSONObject r0 = new org.json.JSONObject
            java.util.Map r1 = r5.mo9510f()
            r0.<init>(r1)
            goto L_0x00ad
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            com.applovin.impl.sdk.k r1 = r4.f2312a
            com.applovin.impl.sdk.network.g$a r1 = com.applovin.impl.sdk.network.C1097g.m2402b(r1)
            java.lang.String r2 = r5.mo9505b()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo9481a((java.lang.String) r2)
            java.lang.String r2 = r5.mo9506c()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo9491c((java.lang.String) r2)
            java.util.Map r2 = r5.mo9507d()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo9482a((java.util.Map<java.lang.String, java.lang.String>) r2)
            java.lang.String r2 = r5.mo9504a()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo9487b((java.lang.String) r2)
            java.util.Map r2 = r5.mo9508e()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo9488b((java.util.Map<java.lang.String, java.lang.String>) r2)
            com.applovin.impl.sdk.network.g$a r0 = r1.mo9483a((org.json.JSONObject) r0)
            boolean r1 = r5.mo9512h()
            com.applovin.impl.sdk.network.g$a r0 = r0.mo9493d((boolean) r1)
            boolean r1 = r5.mo9511g()
            com.applovin.impl.sdk.network.g$a r0 = r0.mo9492c((boolean) r1)
            boolean r1 = r5.mo9514i()
            com.applovin.impl.sdk.network.g$a r0 = r0.mo9549h(r1)
            java.lang.String r1 = r5.mo9515j()
            com.applovin.impl.sdk.network.g$a r0 = r0.mo9547g((java.lang.String) r1)
            com.applovin.impl.sdk.network.g r0 = r0.mo9485a()
            com.applovin.impl.sdk.k r1 = r4.f2312a
            com.applovin.impl.sdk.network.PostbackServiceImpl r1 = r1.mo9346W()
            com.applovin.impl.sdk.network.e$2 r2 = new com.applovin.impl.sdk.network.e$2
            r2.<init>(r5, r6)
            r1.dispatchPostbackRequest(r0, r2)
        L_0x0111:
            return
        L_0x0112:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            throw r5
        L_0x0115:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0115 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1090e.m2348a(com.applovin.impl.sdk.network.f, com.applovin.sdk.AppLovinPostbackListener):void");
    }

    /* renamed from: b */
    private ArrayList<C1094f> m2350b() {
        Set<String> set = (Set) this.f2312a.mo9380b(C0967d.f1859n, new LinkedHashSet(0), this.f2314c);
        ArrayList<C1094f> arrayList = new ArrayList<>(Math.max(1, set.size()));
        int intValue = ((Integer) this.f2312a.mo9350a(C0965b.f1692cL)).intValue();
        C1107r rVar = this.f2313b;
        rVar.mo9584b("PersistentPostbackManager", "Deserializing " + set.size() + " postback(s).");
        for (String str : set) {
            try {
                C1094f fVar = new C1094f(new JSONObject(str), this.f2312a);
                if (fVar.mo9516k() < intValue) {
                    arrayList.add(fVar);
                } else {
                    C1107r rVar2 = this.f2313b;
                    rVar2.mo9584b("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + fVar);
                }
            } catch (Throwable th) {
                C1107r rVar3 = this.f2313b;
                rVar3.mo9585b("PersistentPostbackManager", "Unable to deserialize postback request from json: " + str, th);
            }
        }
        C1107r rVar4 = this.f2313b;
        rVar4.mo9584b("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2352b(C1094f fVar) {
        synchronized (this.f2315d) {
            this.f2316e.add(fVar);
            m2353c();
            C1107r rVar = this.f2313b;
            rVar.mo9584b("PersistentPostbackManager", "Enqueued postback: " + fVar);
        }
    }

    /* renamed from: c */
    private void m2353c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f2316e.size());
        Iterator<C1094f> it = this.f2316e.iterator();
        while (it.hasNext()) {
            try {
                linkedHashSet.add(it.next().mo9519n().toString());
            } catch (Throwable th) {
                this.f2313b.mo9585b("PersistentPostbackManager", "Unable to serialize postback request to JSON.", th);
            }
        }
        this.f2312a.mo9358a(C0967d.f1859n, linkedHashSet, this.f2314c);
        this.f2313b.mo9584b("PersistentPostbackManager", "Wrote updated postback queue to disk.");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2356c(C1094f fVar) {
        m2348a(fVar, (AppLovinPostbackListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2358d() {
        synchronized (this.f2315d) {
            Iterator<C1094f> it = this.f2317f.iterator();
            while (it.hasNext()) {
                m2356c(it.next());
            }
            this.f2317f.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2360d(C1094f fVar) {
        synchronized (this.f2315d) {
            this.f2318g.remove(fVar);
            this.f2316e.remove(fVar);
            m2353c();
        }
        C1107r rVar = this.f2313b;
        rVar.mo9584b("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + fVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2361e(C1094f fVar) {
        synchronized (this.f2315d) {
            this.f2318g.remove(fVar);
            this.f2317f.add(fVar);
        }
    }

    /* renamed from: a */
    public void mo9498a() {
        C10933 r0 = new Runnable() {
            public void run() {
                synchronized (C1090e.this.f2315d) {
                    if (C1090e.this.f2316e != null) {
                        for (C1094f d : new ArrayList(C1090e.this.f2316e)) {
                            C1090e.this.m2356c(d);
                        }
                    }
                }
            }
        };
        if (((Boolean) this.f2312a.mo9350a(C0965b.f1693cM)).booleanValue()) {
            this.f2312a.mo9340Q().mo9266a((C0989a) new C1042y(this.f2312a, r0), C1020o.C1022a.POSTBACKS);
            return;
        }
        r0.run();
    }

    /* renamed from: a */
    public void mo9499a(C1094f fVar) {
        mo9500a(fVar, true);
    }

    /* renamed from: a */
    public void mo9500a(C1094f fVar, boolean z) {
        mo9501a(fVar, z, (AppLovinPostbackListener) null);
    }

    /* renamed from: a */
    public void mo9501a(final C1094f fVar, boolean z, final AppLovinPostbackListener appLovinPostbackListener) {
        if (C1155o.m2673b(fVar.mo9505b())) {
            if (z) {
                fVar.mo9518m();
            }
            C10911 r3 = new Runnable() {
                public void run() {
                    synchronized (C1090e.this.f2315d) {
                        C1090e.this.m2352b(fVar);
                        C1090e.this.m2348a(fVar, appLovinPostbackListener);
                    }
                }
            };
            if (C1160r.m2744b()) {
                this.f2312a.mo9340Q().mo9266a((C0989a) new C1042y(this.f2312a, r3), C1020o.C1022a.POSTBACKS);
                return;
            }
            r3.run();
        }
    }
}
