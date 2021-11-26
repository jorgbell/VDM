package com.flurry.sdk;

import com.flurry.sdk.C1720ex;
import com.flurry.sdk.C1752fm;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.fr */
public abstract class C1762fr extends C1730f implements C1752fm {

    /* renamed from: a */
    private C1752fm f4395a;

    /* renamed from: e */
    volatile int f4396e = C1767b.f4403a;

    /* renamed from: f */
    protected Queue<C1895jq> f4397f;

    /* renamed from: g */
    protected C1754fn f4398g;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo11508a(C1895jq jqVar);

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo11509a_() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo11521c() {
    }

    /* renamed from: com.flurry.sdk.fr$b */
    public enum C1767b {
        ;
        

        /* renamed from: a */
        public static final int f4403a = 1;

        /* renamed from: b */
        public static final int f4404b = 2;

        /* renamed from: c */
        public static final int f4405c = 3;

        /* renamed from: d */
        public static final int f4406d = 4;

        /* renamed from: e */
        public static final int f4407e = 5;

        static {
            f4408f = new int[]{1, 2, 3, 4, 5};
        }

        /* renamed from: a */
        public static int[] m4586a() {
            return (int[]) f4408f.clone();
        }
    }

    C1762fr(String str, C1752fm fmVar) {
        super(str, C1720ex.m4478a(C1720ex.C1722a.CORE));
        this.f4395a = fmVar;
        this.f4397f = new ConcurrentLinkedQueue();
        this.f4396e = C1767b.f4404b;
    }

    /* renamed from: a */
    public final void mo11512a(C1754fn fnVar) {
        this.f4396e = C1767b.f4405c;
        this.f4398g = fnVar;
        mo11509a_();
        C1752fm fmVar = this.f4395a;
        if (fmVar != null) {
            fmVar.mo11512a(new C1764a(this, (byte) 0));
            return;
        }
        if (fnVar != null) {
            fnVar.mo11515a();
        }
        this.f4396e = C1767b.f4406d;
    }

    /* renamed from: com.flurry.sdk.fr$1 */
    static /* synthetic */ class C17631 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4399a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0027 */
        static {
            /*
                int[] r0 = com.flurry.sdk.C1762fr.C1767b.m4586a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4399a = r0
                r1 = 1
                int r2 = com.flurry.sdk.C1762fr.C1767b.f4403a     // Catch:{ NoSuchFieldError -> 0x000f }
                int r2 = r2 - r1
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f4399a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = com.flurry.sdk.C1762fr.C1767b.f4407e     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = r2 - r1
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r0 = f4399a     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = com.flurry.sdk.C1762fr.C1767b.f4404b     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = r2 - r1
                r3 = 3
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f4399a     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = com.flurry.sdk.C1762fr.C1767b.f4405c     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = r2 - r1
                r3 = 4
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                int[] r0 = f4399a     // Catch:{ NoSuchFieldError -> 0x002f }
                int r2 = com.flurry.sdk.C1762fr.C1767b.f4406d     // Catch:{ NoSuchFieldError -> 0x002f }
                int r2 = r2 - r1
                r1 = 5
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x002f }
            L_0x002f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1762fr.C17631.<clinit>():void");
        }
    }

    /* renamed from: c */
    public final C1752fm.C1753a mo11514c(C1895jq jqVar) {
        C1752fm.C1753a aVar = C1752fm.C1753a.ERROR;
        int i = C17631.f4399a[this.f4396e - 1];
        if (i == 3 || i == 4) {
            C1752fm.C1753a aVar2 = C1752fm.C1753a.DEFERRED;
            this.f4397f.add(jqVar);
            C1648cy.m4317a(4, "StreamingCoreModule", "Adding frame to deferred queue:" + jqVar.mo11559e());
            return aVar2;
        } else if (i != 5) {
            return aVar;
        } else {
            C1752fm.C1753a aVar3 = C1752fm.C1753a.QUEUED;
            mo11508a(jqVar);
            return aVar3;
        }
    }

    /* renamed from: d */
    public final void mo11526d(C1895jq jqVar) {
        C1752fm fmVar = this.f4395a;
        if (fmVar != null) {
            C1752fm.C1753a c = fmVar.mo11514c(jqVar);
            C1648cy.m4317a(4, "StreamingCoreModule", "Enqueue message status for module: " + this.f4395a + " is: " + c);
        }
    }

    /* renamed from: b */
    public C1752fm.C1753a mo11510b(C1895jq jqVar) {
        C1752fm.C1753a aVar = C1752fm.C1753a.ERROR;
        C1752fm fmVar = this.f4395a;
        return fmVar != null ? fmVar.mo11510b(jqVar) : aVar;
    }

    /* renamed from: com.flurry.sdk.fr$a */
    class C1764a implements C1754fn {
        private C1764a() {
        }

        /* synthetic */ C1764a(C1762fr frVar, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo11515a() {
            Future unused = C1762fr.this.runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() {
                    C1762fr.this.mo11525d();
                    C1762fr.this.f4396e = C1767b.f4406d;
                    Future unused = C1762fr.this.runAsync(new C1702eb() {
                        /* renamed from: a */
                        public final void mo11257a() {
                            C1754fn fnVar = C1762fr.this.f4398g;
                            if (fnVar != null) {
                                fnVar.mo11515a();
                            }
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo11525d() {
        while (this.f4397f.peek() != null) {
            C1895jq poll = this.f4397f.poll();
            C1648cy.m4317a(4, "StreamingCoreModule", "Processing deferred message status for module: " + poll.mo11559e());
            mo11508a(poll);
        }
    }

    /* renamed from: b */
    public final void mo11513b() {
        mo11521c();
        C1752fm fmVar = this.f4395a;
        if (fmVar != null) {
            fmVar.mo11513b();
        }
    }
}
