package com.flurry.sdk;

import com.flurry.android.FlurryAgentListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.flurry.sdk.bb */
public final class C1538bb extends C1907m<C1537ba> {

    /* renamed from: a */
    public AtomicLong f3886a = new AtomicLong(0);

    /* renamed from: b */
    public AtomicLong f3887b = new AtomicLong(0);

    /* renamed from: d */
    public AtomicBoolean f3888d = new AtomicBoolean(true);

    /* renamed from: e */
    public long f3889e;

    /* renamed from: f */
    public List<FlurryAgentListener> f3890f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f3891g;

    /* renamed from: h */
    private C1916q f3892h;

    /* renamed from: i */
    private C1914o<C1920r> f3893i = new C1914o<C1920r>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            int i = C15457.f3905a[((C1920r) obj).f4752b.ordinal()];
            if (i == 1) {
                C1538bb.this.mo11314a(C1547bd.FOREGROUND, false);
            } else if (i == 2) {
                C1538bb.this.mo11315b(C1547bd.FOREGROUND, false);
            }
        }
    };

    /* renamed from: com.flurry.sdk.bb$7 */
    static /* synthetic */ class C15457 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3905a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.flurry.sdk.p[] r0 = com.flurry.sdk.C1915p.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3905a = r0
                com.flurry.sdk.p r1 = com.flurry.sdk.C1915p.FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3905a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flurry.sdk.p r1 = com.flurry.sdk.C1915p.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1538bb.C15457.<clinit>():void");
        }
    }

    public C1538bb(C1916q qVar) {
        super("ReportingProvider");
        this.f3892h = qVar;
        qVar.subscribe(this.f3893i);
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                long unused = C1538bb.this.f3891g = C1739fe.m4515b("initial_run_time", Long.MIN_VALUE);
            }
        });
    }

    /* renamed from: a */
    public final void mo11313a(FlurryAgentListener flurryAgentListener) {
        if (flurryAgentListener == null) {
            C1648cy.m4317a(2, "ReportingProvider", "Cannot register with null listener");
        } else {
            this.f3890f.add(flurryAgentListener);
        }
    }

    /* renamed from: a */
    public final String mo11264a() {
        return String.valueOf(this.f3886a.get());
    }

    /* renamed from: a */
    public final void mo11312a(long j, long j2) {
        this.f3886a.set(j);
        this.f3887b.set(j2);
        if (!this.f3890f.isEmpty()) {
            final ArrayList arrayList = new ArrayList(this.f3890f);
            postOnMainThread(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() throws Exception {
                    for (FlurryAgentListener flurryAgentListener : arrayList) {
                        if (flurryAgentListener != null) {
                            flurryAgentListener.onSessionStarted();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo11314a(final C1547bd bdVar, final boolean z) {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1648cy.m4317a(3, "ReportingProvider", "Start session: " + bdVar.name() + ", isManualSession: " + z);
                C1538bb.m4060a(C1538bb.this, bdVar, C1546bc.SESSION_START, z);
            }
        });
    }

    /* renamed from: b */
    public final void mo11315b(final C1547bd bdVar, final boolean z) {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1648cy.m4317a(3, "ReportingProvider", "End session: " + bdVar.name() + ", isManualSession: " + z);
                C1538bb.m4060a(C1538bb.this, bdVar, C1546bc.SESSION_END, z);
            }
        });
    }

    public final void destroy() {
        super.destroy();
        this.f3892h.unsubscribe(this.f3893i);
    }

    /* renamed from: a */
    static /* synthetic */ void m4060a(C1538bb bbVar, C1547bd bdVar, C1546bc bcVar, boolean z) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (bbVar.f3891g == Long.MIN_VALUE) {
            bbVar.f3891g = currentTimeMillis;
            C1739fe.m4512a("initial_run_time", currentTimeMillis);
            C1648cy.m4317a(3, "ReportingProvider", "Refresh initial timestamp");
        }
        if (bdVar.equals(C1547bd.FOREGROUND)) {
            j = bbVar.f3889e;
        } else {
            j = 60000;
        }
        C1547bd bdVar2 = bdVar;
        bbVar.notifyObservers(new C1537ba(bdVar2, currentTimeMillis, bbVar.f3891g, j, bcVar, z));
    }
}
