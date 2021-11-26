package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.C1062k;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.applovin.impl.sdk.utils.p */
public class C1157p {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f2483a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Timer f2484b;

    /* renamed from: c */
    private long f2485c;

    /* renamed from: d */
    private long f2486d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Runnable f2487e;

    /* renamed from: f */
    private long f2488f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Object f2489g = new Object();

    private C1157p(C1062k kVar, Runnable runnable) {
        this.f2483a = kVar;
        this.f2487e = runnable;
    }

    /* renamed from: a */
    public static C1157p m2682a(long j, C1062k kVar, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + ".");
        } else if (runnable != null) {
            C1157p pVar = new C1157p(kVar, runnable);
            pVar.f2485c = System.currentTimeMillis();
            pVar.f2486d = j;
            try {
                Timer timer = new Timer();
                pVar.f2484b = timer;
                timer.schedule(pVar.m2687e(), j);
            } catch (OutOfMemoryError e) {
                kVar.mo9411z().mo9585b("Timer", "Failed to create timer due to OOM error", e);
            }
            return pVar;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    /* renamed from: e */
    private TimerTask m2687e() {
        return new TimerTask() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    r0 = 0
                    com.applovin.impl.sdk.utils.p r1 = com.applovin.impl.sdk.utils.C1157p.this     // Catch:{ all -> 0x001b }
                    java.lang.Runnable r1 = r1.f2487e     // Catch:{ all -> 0x001b }
                    r1.run()     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.utils.p r1 = com.applovin.impl.sdk.utils.C1157p.this
                    java.lang.Object r1 = r1.f2489g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C1157p.this     // Catch:{ all -> 0x0018 }
                    java.util.Timer unused = r2.f2484b = r0     // Catch:{ all -> 0x0018 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    goto L_0x0042
                L_0x0018:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    throw r0
                L_0x001b:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C1157p.this     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.k r2 = r2.f2483a     // Catch:{ all -> 0x0046 }
                    if (r2 == 0) goto L_0x0035
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C1157p.this     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.k r2 = r2.f2483a     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.r r2 = r2.mo9411z()     // Catch:{ all -> 0x0046 }
                    java.lang.String r3 = "Timer"
                    java.lang.String r4 = "Encountered error while executing timed task"
                    r2.mo9585b(r3, r4, r1)     // Catch:{ all -> 0x0046 }
                L_0x0035:
                    com.applovin.impl.sdk.utils.p r1 = com.applovin.impl.sdk.utils.C1157p.this
                    java.lang.Object r1 = r1.f2489g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C1157p.this     // Catch:{ all -> 0x0043 }
                    java.util.Timer unused = r2.f2484b = r0     // Catch:{ all -> 0x0043 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                L_0x0042:
                    return
                L_0x0043:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                    throw r0
                L_0x0046:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C1157p.this
                    java.lang.Object r2 = r2.f2489g
                    monitor-enter(r2)
                    com.applovin.impl.sdk.utils.p r3 = com.applovin.impl.sdk.utils.C1157p.this     // Catch:{ all -> 0x0055 }
                    java.util.Timer unused = r3.f2484b = r0     // Catch:{ all -> 0x0055 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                    throw r1
                L_0x0055:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C1157p.C11581.run():void");
            }
        };
    }

    /* renamed from: a */
    public long mo9661a() {
        if (this.f2484b == null) {
            return this.f2486d - this.f2488f;
        }
        return this.f2486d - (System.currentTimeMillis() - this.f2485c);
    }

    /* renamed from: b */
    public void mo9662b() {
        synchronized (this.f2489g) {
            Timer timer = this.f2484b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f2488f = System.currentTimeMillis() - this.f2485c;
                } catch (Throwable th) {
                    this.f2484b = null;
                    throw th;
                }
                this.f2484b = null;
            }
        }
    }

    /* renamed from: c */
    public void mo9663c() {
        synchronized (this.f2489g) {
            long j = this.f2488f;
            if (j > 0) {
                try {
                    long j2 = this.f2486d - j;
                    this.f2486d = j2;
                    if (j2 < 0) {
                        this.f2486d = 0;
                    }
                    Timer timer = new Timer();
                    this.f2484b = timer;
                    timer.schedule(m2687e(), this.f2486d);
                    this.f2485c = System.currentTimeMillis();
                } catch (Throwable th) {
                    this.f2488f = 0;
                    throw th;
                }
                this.f2488f = 0;
            }
        }
    }

    /* renamed from: d */
    public void mo9664d() {
        synchronized (this.f2489g) {
            Timer timer = this.f2484b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f2484b = null;
                } catch (Throwable th) {
                    this.f2484b = null;
                    this.f2488f = 0;
                    throw th;
                }
                this.f2488f = 0;
            }
        }
    }
}
