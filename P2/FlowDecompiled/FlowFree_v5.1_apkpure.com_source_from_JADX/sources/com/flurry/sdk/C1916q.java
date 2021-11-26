package com.flurry.sdk;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: com.flurry.sdk.q */
public final class C1916q extends C1907m<C1920r> {

    /* renamed from: a */
    protected C1914o<C1508ao> f4743a = new C1914o<C1508ao>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            Bundle bundle;
            C1508ao aoVar = (C1508ao) obj;
            int i = C19193.f4750a[aoVar.f3791a.ordinal()];
            if (i == 1) {
                C1916q.m4814a(C1916q.this, true);
            } else if (i == 2) {
                C1916q.m4814a(C1916q.this, false);
            } else if (i == 3 && (bundle = aoVar.f3792b) != null && bundle.containsKey("trim_memory_level") && bundle.getInt("trim_memory_level") == 20) {
                C1916q.m4814a(C1916q.this, false);
            }
        }
    };

    /* renamed from: b */
    private C1510ap f4744b;

    /* renamed from: d */
    private C1920r f4745d = null;

    public C1916q(C1510ap apVar) {
        super("AppStateChangeProvider");
        this.f4744b = apVar;
        C1915p pVar = C1915p.UNKNOWN;
        this.f4745d = new C1920r(pVar, pVar);
        this.f4744b.subscribe(this.f4743a);
    }

    public final void subscribe(final C1914o<C1920r> oVar) {
        super.subscribe(oVar);
        final C1920r rVar = this.f4745d;
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                oVar.mo11263a(rVar);
            }
        });
    }

    /* renamed from: com.flurry.sdk.q$3 */
    static /* synthetic */ class C19193 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4750a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.flurry.sdk.ao$a[] r0 = com.flurry.sdk.C1508ao.C1509a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4750a = r0
                com.flurry.sdk.ao$a r1 = com.flurry.sdk.C1508ao.C1509a.STARTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4750a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flurry.sdk.ao$a r1 = com.flurry.sdk.C1508ao.C1509a.APP_BACKGROUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4750a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flurry.sdk.ao$a r1 = com.flurry.sdk.C1508ao.C1509a.TRIM_MEMORY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1916q.C19193.<clinit>():void");
        }
    }

    /* renamed from: a */
    public final C1915p mo11264a() {
        C1920r rVar = this.f4745d;
        if (rVar == null) {
            return C1915p.UNKNOWN;
        }
        return rVar.f4752b;
    }

    public final void destroy() {
        super.destroy();
        this.f4744b.unsubscribe(this.f4743a);
    }

    /* renamed from: a */
    static /* synthetic */ void m4814a(C1916q qVar, boolean z) {
        C1915p pVar = z ? C1915p.FOREGROUND : C1915p.BACKGROUND;
        C1915p pVar2 = qVar.f4745d.f4752b;
        if (pVar2 != pVar) {
            qVar.f4745d = new C1920r(pVar2, pVar);
            C1648cy.m4317a(2, "AppStateChangeProvider", "AppStateChangeRule: prev " + qVar.f4745d.f4751a + " stateData.currentState:" + qVar.f4745d.f4752b);
            HashMap hashMap = new HashMap();
            hashMap.put("previous_state", qVar.f4745d.f4751a.name());
            hashMap.put("current_state", qVar.f4745d.f4752b.name());
            C1548be.m4072a();
            C1548be.m4075b("AppStateChangeProvider: app state change", hashMap);
            C1920r rVar = qVar.f4745d;
            qVar.notifyObservers(new C1920r(rVar.f4751a, rVar.f4752b));
        }
    }
}
