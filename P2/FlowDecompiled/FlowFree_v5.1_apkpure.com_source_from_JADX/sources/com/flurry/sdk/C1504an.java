package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.sdk.C1508ao;
import com.google.android.instantapps.InstantApps;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.an */
public final class C1504an extends C1907m<C1503am> {

    /* renamed from: a */
    public String f3782a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1510ap f3783b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f3784d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f3785e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1914o<C1508ao> f3786f;

    public C1504an(C1510ap apVar) {
        super("InstantAppProvider");
        C15051 r0 = new C1914o<C1508ao>() {
            /* renamed from: a */
            public final /* synthetic */ void mo11263a(Object obj) {
                final C1508ao aoVar = (C1508ao) obj;
                Future unused = C1504an.this.runAsync(new C1702eb() {
                    /* renamed from: a */
                    public final void mo11257a() throws Exception {
                        if (C1504an.this.f3785e == null && aoVar.f3791a.equals(C1508ao.C1509a.CREATED)) {
                            String unused = C1504an.this.f3785e = aoVar.f3792b.getString("activity_name");
                            C1504an.this.mo11287b();
                            C1504an.this.f3783b.unsubscribe(C1504an.this.f3786f);
                        }
                    }
                });
            }
        };
        this.f3786f = r0;
        this.f3783b = apVar;
        apVar.subscribe(r0);
    }

    public final void start() {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                Context a = C1536b.m4057a();
                if (a == null) {
                    C1648cy.m4317a(6, "InstantAppProvider", "Context is null");
                    return;
                }
                try {
                    Class.forName("com.google.android.instantapps.InstantApps");
                    boolean unused = C1504an.this.f3784d = InstantApps.isInstantApp(a);
                    C1648cy.m4317a(3, "InstantAppProvider", "isInstantApp: " + String.valueOf(C1504an.this.f3784d));
                } catch (ClassNotFoundException unused2) {
                    C1648cy.m4317a(3, "InstantAppProvider", "isInstantApps dependency is not added");
                }
                C1504an.this.mo11287b();
            }
        });
    }

    /* renamed from: a */
    public final String mo11264a() {
        if (!this.f3784d) {
            return null;
        }
        return !TextUtils.isEmpty(this.f3782a) ? this.f3782a : this.f3785e;
    }

    /* renamed from: b */
    public final void mo11287b() {
        if (!this.f3784d || mo11264a() != null) {
            boolean z = this.f3784d;
            notifyObservers(new C1503am(z, z ? mo11264a() : null));
            return;
        }
        C1648cy.m4317a(3, "InstantAppProvider", "Fetching instant app name");
    }

    public final void destroy() {
        super.destroy();
        this.f3783b.unsubscribe(this.f3786f);
    }
}
