package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1115d;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1160r;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.o */
public class C1020o {

    /* renamed from: A */
    private boolean f2028A;

    /* renamed from: a */
    private final String f2029a = "TaskManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1062k f2030b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1107r f2031c;

    /* renamed from: d */
    private final ScheduledThreadPoolExecutor f2032d;

    /* renamed from: e */
    private final ScheduledThreadPoolExecutor f2033e;

    /* renamed from: f */
    private final ScheduledThreadPoolExecutor f2034f;

    /* renamed from: g */
    private final ScheduledThreadPoolExecutor f2035g;

    /* renamed from: h */
    private final ScheduledThreadPoolExecutor f2036h;

    /* renamed from: i */
    private final ScheduledThreadPoolExecutor f2037i;

    /* renamed from: j */
    private final ScheduledThreadPoolExecutor f2038j;

    /* renamed from: k */
    private final ScheduledThreadPoolExecutor f2039k;

    /* renamed from: l */
    private final ScheduledThreadPoolExecutor f2040l;

    /* renamed from: m */
    private final ScheduledThreadPoolExecutor f2041m;

    /* renamed from: n */
    private final ScheduledThreadPoolExecutor f2042n;

    /* renamed from: o */
    private final ScheduledThreadPoolExecutor f2043o;

    /* renamed from: p */
    private final ScheduledThreadPoolExecutor f2044p;

    /* renamed from: q */
    private final ScheduledThreadPoolExecutor f2045q;

    /* renamed from: r */
    private final ScheduledThreadPoolExecutor f2046r;

    /* renamed from: s */
    private final ScheduledThreadPoolExecutor f2047s;

    /* renamed from: t */
    private final ScheduledThreadPoolExecutor f2048t;

    /* renamed from: u */
    private final ScheduledThreadPoolExecutor f2049u;

    /* renamed from: v */
    private final ScheduledThreadPoolExecutor f2050v;

    /* renamed from: w */
    private final ScheduledThreadPoolExecutor f2051w;

    /* renamed from: x */
    private final ScheduledThreadPoolExecutor f2052x;

    /* renamed from: y */
    private final List<C1025c> f2053y = new ArrayList(5);

    /* renamed from: z */
    private final Object f2054z = new Object();

    /* renamed from: com.applovin.impl.sdk.e.o$a */
    public enum C1022a {
        MAIN,
        TIMEOUT,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARDED_INTERSTITIAL,
        MEDIATION_REWARD
    }

    /* renamed from: com.applovin.impl.sdk.e.o$b */
    private class C1023b implements ThreadFactory {

        /* renamed from: b */
        private final String f2078b;

        C1023b(String str) {
            this.f2078b = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f2078b + ":" + C1160r.m2708a(C1020o.this.f2030b.mo9409x()));
            thread.setDaemon(true);
            thread.setPriority(10);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    C1020o.this.f2031c.mo9585b("TaskManager", "Caught unhandled exception", th);
                }
            });
            return thread;
        }
    }

    /* renamed from: com.applovin.impl.sdk.e.o$c */
    private class C1025c implements Runnable {

        /* renamed from: b */
        private final String f2081b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final C0989a f2082c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C1022a f2083d;

        C1025c(C0989a aVar, C1022a aVar2) {
            this.f2081b = aVar.mo9217e();
            this.f2082c = aVar;
            this.f2083d = aVar2;
        }

        public void run() {
            long j;
            StringBuilder sb;
            C1107r rVar;
            try {
                C1119g.m2527a();
                if (C1020o.this.f2030b.mo9387c()) {
                    if (!this.f2082c.mo9219g()) {
                        C1020o.this.f2031c.mo9586c(this.f2081b, "Task re-scheduled...");
                        C1020o.this.mo9267a(this.f2082c, this.f2083d, 2000);
                        j = C1020o.this.m1984a(this.f2083d) - 1;
                        rVar = C1020o.this.f2031c;
                        sb = new StringBuilder();
                        sb.append(this.f2083d);
                        sb.append(" queue finished task ");
                        sb.append(this.f2082c.mo9217e());
                        sb.append(" with queue size ");
                        sb.append(j);
                        rVar.mo9586c("TaskManager", sb.toString());
                    }
                }
                this.f2082c.run();
                j = C1020o.this.m1984a(this.f2083d) - 1;
                rVar = C1020o.this.f2031c;
                sb = new StringBuilder();
            } catch (Throwable th) {
                C1107r b = C1020o.this.f2031c;
                b.mo9586c("TaskManager", this.f2083d + " queue finished task " + this.f2082c.mo9217e() + " with queue size " + (C1020o.this.m1984a(this.f2083d) - 1));
                throw th;
            }
            sb.append(this.f2083d);
            sb.append(" queue finished task ");
            sb.append(this.f2082c.mo9217e());
            sb.append(" with queue size ");
            sb.append(j);
            rVar.mo9586c("TaskManager", sb.toString());
        }
    }

    public C1020o(C1062k kVar) {
        this.f2030b = kVar;
        this.f2031c = kVar.mo9411z();
        this.f2032d = m1987a("main");
        this.f2033e = m1987a("timeout");
        this.f2034f = m1987a("back");
        this.f2035g = m1987a("advertising_info_collection");
        this.f2036h = m1987a("postbacks");
        this.f2037i = m1987a("caching_interstitial");
        this.f2038j = m1987a("caching_incentivized");
        this.f2039k = m1987a("caching_other");
        this.f2040l = m1987a("reward");
        this.f2041m = m1987a("mediation_main");
        this.f2042n = m1987a("mediation_timeout");
        this.f2043o = m1987a("mediation_background");
        this.f2044p = m1987a("mediation_postbacks");
        this.f2045q = m1987a("mediation_banner");
        this.f2046r = m1987a("mediation_interstitial");
        this.f2047s = m1987a("mediation_incentivized");
        this.f2048t = m1987a("mediation_rewarded_interstitial");
        this.f2049u = m1987a("mediation_reward");
        this.f2050v = m1988a("auxiliary_operations", ((Integer) kVar.mo9350a(C0965b.f1646bR)).intValue());
        this.f2051w = m1988a("caching_operations", ((Integer) kVar.mo9350a(C0965b.f1647bS)).intValue());
        this.f2052x = m1988a("shared_thread_pool", ((Integer) kVar.mo9350a(C0965b.f1611aj)).intValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public long m1984a(C1022a aVar) {
        long taskCount;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (aVar == C1022a.MAIN) {
            taskCount = this.f2032d.getTaskCount();
            scheduledThreadPoolExecutor = this.f2032d;
        } else if (aVar == C1022a.TIMEOUT) {
            taskCount = this.f2033e.getTaskCount();
            scheduledThreadPoolExecutor = this.f2033e;
        } else if (aVar == C1022a.BACKGROUND) {
            taskCount = this.f2034f.getTaskCount();
            scheduledThreadPoolExecutor = this.f2034f;
        } else if (aVar == C1022a.ADVERTISING_INFO_COLLECTION) {
            taskCount = this.f2035g.getTaskCount();
            scheduledThreadPoolExecutor = this.f2035g;
        } else if (aVar == C1022a.POSTBACKS) {
            taskCount = this.f2036h.getTaskCount();
            scheduledThreadPoolExecutor = this.f2036h;
        } else if (aVar == C1022a.CACHING_INTERSTITIAL) {
            taskCount = this.f2037i.getTaskCount();
            scheduledThreadPoolExecutor = this.f2037i;
        } else if (aVar == C1022a.CACHING_INCENTIVIZED) {
            taskCount = this.f2038j.getTaskCount();
            scheduledThreadPoolExecutor = this.f2038j;
        } else if (aVar == C1022a.CACHING_OTHER) {
            taskCount = this.f2039k.getTaskCount();
            scheduledThreadPoolExecutor = this.f2039k;
        } else if (aVar == C1022a.REWARD) {
            taskCount = this.f2040l.getTaskCount();
            scheduledThreadPoolExecutor = this.f2040l;
        } else if (aVar == C1022a.MEDIATION_MAIN) {
            taskCount = this.f2041m.getTaskCount();
            scheduledThreadPoolExecutor = this.f2041m;
        } else if (aVar == C1022a.MEDIATION_TIMEOUT) {
            taskCount = this.f2042n.getTaskCount();
            scheduledThreadPoolExecutor = this.f2042n;
        } else if (aVar == C1022a.MEDIATION_BACKGROUND) {
            taskCount = this.f2043o.getTaskCount();
            scheduledThreadPoolExecutor = this.f2043o;
        } else if (aVar == C1022a.MEDIATION_POSTBACKS) {
            taskCount = this.f2044p.getTaskCount();
            scheduledThreadPoolExecutor = this.f2044p;
        } else if (aVar == C1022a.MEDIATION_BANNER) {
            taskCount = this.f2045q.getTaskCount();
            scheduledThreadPoolExecutor = this.f2045q;
        } else if (aVar == C1022a.MEDIATION_INTERSTITIAL) {
            taskCount = this.f2046r.getTaskCount();
            scheduledThreadPoolExecutor = this.f2046r;
        } else if (aVar == C1022a.MEDIATION_INCENTIVIZED) {
            taskCount = this.f2047s.getTaskCount();
            scheduledThreadPoolExecutor = this.f2047s;
        } else if (aVar == C1022a.MEDIATION_REWARDED_INTERSTITIAL) {
            taskCount = this.f2048t.getTaskCount();
            scheduledThreadPoolExecutor = this.f2048t;
        } else if (aVar != C1022a.MEDIATION_REWARD) {
            return 0;
        } else {
            taskCount = this.f2049u.getTaskCount();
            scheduledThreadPoolExecutor = this.f2049u;
        }
        return taskCount - scheduledThreadPoolExecutor.getCompletedTaskCount();
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m1987a(String str) {
        return m1988a(str, 1);
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m1988a(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new C1023b(str));
    }

    /* renamed from: a */
    private void m1989a(final Runnable runnable, long j, final ScheduledExecutorService scheduledExecutorService, boolean z) {
        if (j <= 0) {
            scheduledExecutorService.submit(runnable);
        } else if (z) {
            C1115d.m2514a(j, this.f2030b, new Runnable() {
                public void run() {
                    scheduledExecutorService.execute(runnable);
                }
            });
        } else {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    private boolean m1990a(C1025c cVar) {
        if (cVar.f2082c.mo9219g()) {
            return false;
        }
        synchronized (this.f2054z) {
            if (this.f2028A) {
                return false;
            }
            this.f2053y.add(cVar);
            return true;
        }
    }

    /* renamed from: a */
    public void mo9265a(C0989a aVar) {
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Throwable th) {
                this.f2031c.mo9585b(aVar.mo9217e(), "Task failed execution", th);
            }
        } else {
            this.f2031c.mo9588e("TaskManager", "Attempted to execute null task immediately");
        }
    }

    /* renamed from: a */
    public void mo9266a(C0989a aVar, C1022a aVar2) {
        mo9267a(aVar, aVar2, 0);
    }

    /* renamed from: a */
    public void mo9267a(C0989a aVar, C1022a aVar2, long j) {
        mo9268a(aVar, aVar2, j, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.applovin.impl.sdk.e.o$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: com.applovin.impl.sdk.e.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: com.applovin.impl.sdk.e.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: com.applovin.impl.sdk.e.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9268a(com.applovin.impl.sdk.p039e.C0989a r12, com.applovin.impl.sdk.p039e.C1020o.C1022a r13, long r14, boolean r16) {
        /*
            r11 = this;
            r6 = r11
            r1 = r12
            r0 = r13
            r2 = r14
            if (r1 == 0) goto L_0x012b
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0114
            com.applovin.impl.sdk.e.o$c r4 = new com.applovin.impl.sdk.e.o$c
            r4.<init>(r12, r13)
            boolean r5 = r11.m1990a((com.applovin.impl.sdk.p039e.C1020o.C1025c) r4)
            if (r5 != 0) goto L_0x00f0
            com.applovin.impl.sdk.k r5 = r6.f2030b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r7 = com.applovin.impl.sdk.p037c.C0965b.f1612ak
            java.lang.Object r5 = r5.mo9350a(r7)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0033
            java.util.concurrent.ScheduledThreadPoolExecutor r4 = r6.f2052x
            r0 = r11
            r1 = r12
            r2 = r14
        L_0x002c:
            r5 = r16
            r0.m1989a((java.lang.Runnable) r1, (long) r2, (java.util.concurrent.ScheduledExecutorService) r4, (boolean) r5)
            goto L_0x0113
        L_0x0033:
            long r7 = r11.m1984a((com.applovin.impl.sdk.p039e.C1020o.C1022a) r13)
            r9 = 1
            long r7 = r7 + r9
            com.applovin.impl.sdk.r r5 = r6.f2031c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Scheduling "
            r9.append(r10)
            java.lang.String r1 = r12.mo9217e()
            r9.append(r1)
            java.lang.String r1 = " on "
            r9.append(r1)
            r9.append(r13)
            java.lang.String r1 = " queue in "
            r9.append(r1)
            r9.append(r14)
            java.lang.String r1 = "ms with new queue size "
            r9.append(r1)
            r9.append(r7)
            java.lang.String r1 = r9.toString()
            java.lang.String r7 = "TaskManager"
            r5.mo9584b(r7, r1)
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MAIN
            if (r0 != r1) goto L_0x0079
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2032d
        L_0x0074:
            r0 = r11
            r1 = r4
            r2 = r14
            r4 = r5
            goto L_0x002c
        L_0x0079:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.TIMEOUT
            if (r0 != r1) goto L_0x0080
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2033e
            goto L_0x0074
        L_0x0080:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.BACKGROUND
            if (r0 != r1) goto L_0x0087
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2034f
            goto L_0x0074
        L_0x0087:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.ADVERTISING_INFO_COLLECTION
            if (r0 != r1) goto L_0x008e
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2035g
            goto L_0x0074
        L_0x008e:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.POSTBACKS
            if (r0 != r1) goto L_0x0095
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2036h
            goto L_0x0074
        L_0x0095:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.CACHING_INTERSTITIAL
            if (r0 != r1) goto L_0x009c
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2037i
            goto L_0x0074
        L_0x009c:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.CACHING_INCENTIVIZED
            if (r0 != r1) goto L_0x00a3
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2038j
            goto L_0x0074
        L_0x00a3:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.CACHING_OTHER
            if (r0 != r1) goto L_0x00aa
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2039k
            goto L_0x0074
        L_0x00aa:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.REWARD
            if (r0 != r1) goto L_0x00b1
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2040l
            goto L_0x0074
        L_0x00b1:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_MAIN
            if (r0 != r1) goto L_0x00b8
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2041m
            goto L_0x0074
        L_0x00b8:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_TIMEOUT
            if (r0 != r1) goto L_0x00bf
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2042n
            goto L_0x0074
        L_0x00bf:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_BACKGROUND
            if (r0 != r1) goto L_0x00c6
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2043o
            goto L_0x0074
        L_0x00c6:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_POSTBACKS
            if (r0 != r1) goto L_0x00cd
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2044p
            goto L_0x0074
        L_0x00cd:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_BANNER
            if (r0 != r1) goto L_0x00d4
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2045q
            goto L_0x0074
        L_0x00d4:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_INTERSTITIAL
            if (r0 != r1) goto L_0x00db
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2046r
            goto L_0x0074
        L_0x00db:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_INCENTIVIZED
            if (r0 != r1) goto L_0x00e2
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2047s
            goto L_0x0074
        L_0x00e2:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_REWARDED_INTERSTITIAL
            if (r0 != r1) goto L_0x00e9
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2048t
            goto L_0x0074
        L_0x00e9:
            com.applovin.impl.sdk.e.o$a r1 = com.applovin.impl.sdk.p039e.C1020o.C1022a.MEDIATION_REWARD
            if (r0 != r1) goto L_0x0113
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f2049u
            goto L_0x0074
        L_0x00f0:
            com.applovin.impl.sdk.r r0 = r6.f2031c
            java.lang.String r2 = r12.mo9217e()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Task "
            r3.append(r4)
            java.lang.String r1 = r12.mo9217e()
            r3.append(r1)
            java.lang.String r1 = " execution delayed until after init"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.mo9586c(r2, r1)
        L_0x0113:
            return
        L_0x0114:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Invalid delay specified: "
            r1.append(r4)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x012b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No task specified"
            r0.<init>(r1)
            goto L_0x0134
        L_0x0133:
            throw r0
        L_0x0134:
            goto L_0x0133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p039e.C1020o.mo9268a(com.applovin.impl.sdk.e.a, com.applovin.impl.sdk.e.o$a, long, boolean):void");
    }

    /* renamed from: a */
    public boolean mo9269a() {
        return this.f2028A;
    }

    /* renamed from: b */
    public ScheduledExecutorService mo9270b() {
        return this.f2050v;
    }

    /* renamed from: c */
    public void mo9271c() {
        synchronized (this.f2054z) {
            this.f2028A = false;
        }
    }

    /* renamed from: d */
    public void mo9272d() {
        synchronized (this.f2054z) {
            this.f2028A = true;
            for (C1025c next : this.f2053y) {
                mo9266a(next.f2082c, next.f2083d);
            }
            this.f2053y.clear();
        }
    }
}
