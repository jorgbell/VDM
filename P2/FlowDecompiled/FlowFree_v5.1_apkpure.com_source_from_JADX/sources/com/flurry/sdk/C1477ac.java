package com.flurry.sdk;

import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.ac */
public final class C1477ac extends C1907m<C1483ad> {

    /* renamed from: a */
    public String f3706a;

    /* renamed from: b */
    public String f3707b;

    /* renamed from: d */
    public boolean f3708d = false;

    /* renamed from: e */
    public boolean f3709e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1503am f3710f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1914o<C1503am> f3711g = new C1914o<C1503am>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            final C1503am amVar = (C1503am) obj;
            Future unused = C1477ac.this.runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() throws Exception {
                    C1648cy.m4317a(3, "FlurryProvider", "isInstantApp: " + amVar.f3780a);
                    C1503am unused = C1477ac.this.f3710f = amVar;
                    C1477ac.m3954a(C1477ac.this);
                    C1477ac.this.f3712h.unsubscribe(C1477ac.this.f3711g);
                }
            });
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1504an f3712h;

    /* renamed from: i */
    private C1916q f3713i;

    /* renamed from: j */
    private C1914o<C1920r> f3714j = new C1914o<C1920r>() {
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo11263a(Object obj) {
            C1477ac.m3954a(C1477ac.this);
        }
    };

    /* renamed from: com.flurry.sdk.ac$a */
    public enum C1482a {
        UNAVAILABLE(-2),
        UNKNOWN(-1),
        SUCCESS(0),
        SERVICE_MISSING(1),
        SERVICE_UPDATING(2),
        SERVICE_VERSION_UPDATE_REQUIRED(3),
        SERVICE_DISABLED(4),
        SERVICE_INVALID(5);
        

        /* renamed from: i */
        public int f3729i;

        private C1482a(int i) {
            this.f3729i = i;
        }
    }

    public C1477ac(C1504an anVar, C1916q qVar) {
        super("FlurryProvider");
        this.f3712h = anVar;
        anVar.subscribe(this.f3711g);
        this.f3713i = qVar;
        qVar.subscribe(this.f3714j);
    }

    /* renamed from: a */
    private static C1482a m3951a() {
        try {
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(C1536b.m4057a());
            if (isGooglePlayServicesAvailable == 0) {
                return C1482a.SUCCESS;
            }
            if (isGooglePlayServicesAvailable == 1) {
                return C1482a.SERVICE_MISSING;
            }
            if (isGooglePlayServicesAvailable == 2) {
                return C1482a.SERVICE_VERSION_UPDATE_REQUIRED;
            }
            if (isGooglePlayServicesAvailable == 3) {
                return C1482a.SERVICE_DISABLED;
            }
            if (isGooglePlayServicesAvailable == 9) {
                return C1482a.SERVICE_INVALID;
            }
            if (isGooglePlayServicesAvailable != 18) {
                return C1482a.UNAVAILABLE;
            }
            return C1482a.SERVICE_UPDATING;
        } catch (Exception | NoClassDefFoundError unused) {
            C1648cy.m4317a(3, "FlurryProvider", "Error retrieving Google Play Services Availability. This probably means google play services is unavailable.");
            return C1482a.UNAVAILABLE;
        }
    }

    public final void destroy() {
        super.destroy();
        this.f3712h.unsubscribe(this.f3711g);
        this.f3713i.unsubscribe(this.f3714j);
    }

    /* renamed from: a */
    static /* synthetic */ void m3954a(C1477ac acVar) {
        if (!TextUtils.isEmpty(acVar.f3706a) && acVar.f3710f != null) {
            acVar.notifyObservers(new C1483ad(C1561bi.m4088a().mo11318b(), acVar.f3708d, m3951a(), acVar.f3710f));
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m3957d(C1477ac acVar) {
        if (TextUtils.isEmpty(acVar.f3706a)) {
            C1648cy.m4317a(6, "FlurryProvider", "Streaming API Key is invalid");
            return;
        }
        int b = C1739fe.m4514b("prev_streaming_api_key", 0);
        int hashCode = C1739fe.m4516b("api_key", "").hashCode();
        int hashCode2 = acVar.f3706a.hashCode();
        if (b != hashCode2 && hashCode != hashCode2) {
            C1648cy.m4317a(3, "FlurryProvider", "Streaming API key is refreshed");
            C1739fe.m4511a("prev_streaming_api_key", hashCode2);
            C1538bb bbVar = C1913n.m4811a().f4732k;
            C1648cy.m4317a(3, "ReportingProvider", "Reset initial timestamp.");
            bbVar.runAsync(new C1702eb() {
                /* renamed from: a */
                public final void mo11257a() throws Exception {
                    long unused = C1538bb.this.f3891g = Long.MIN_VALUE;
                }
            });
        }
    }
}
