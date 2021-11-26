package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationManager;
import com.mopub.mobileads.ChartboostShared;

/* renamed from: com.flurry.sdk.at */
public final class C1516at extends C1907m<C1515as> {

    /* renamed from: a */
    public boolean f3817a = true;

    /* renamed from: b */
    protected C1914o<C1920r> f3818b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f3819d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Location f3820e;

    /* renamed from: f */
    private C1916q f3821f;

    public C1516at(C1916q qVar) {
        super("LocationProvider");
        C15171 r0 = new C1914o<C1920r>() {
            /* renamed from: a */
            public final /* synthetic */ void mo11263a(Object obj) {
                if (((C1920r) obj).f4752b == C1915p.FOREGROUND) {
                    C1516at.this.refresh();
                }
            }
        };
        this.f3818b = r0;
        this.f3821f = qVar;
        qVar.subscribe(r0);
    }

    public final void refresh() {
        Location a = m4014a();
        if (a != null) {
            this.f3820e = a;
        }
        notifyObservers(new C1515as(this.f3817a, this.f3819d, this.f3820e));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public Location m4014a() {
        if (!this.f3817a) {
            return null;
        }
        if (C1738fd.m4505a() || C1738fd.m4507b()) {
            String str = C1738fd.m4505a() ? "passive" : "network";
            this.f3819d = true;
            LocationManager locationManager = (LocationManager) C1536b.m4057a().getSystemService(ChartboostShared.LOCATION_KEY);
            if (locationManager != null) {
                return locationManager.getLastKnownLocation(str);
            }
            return null;
        }
        this.f3819d = false;
        return null;
    }

    public final void subscribe(final C1914o<C1515as> oVar) {
        super.subscribe(oVar);
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                Location a = C1516at.this.m4014a();
                if (a != null) {
                    Location unused = C1516at.this.f3820e = a;
                }
                oVar.mo11263a(new C1515as(C1516at.this.f3817a, C1516at.this.f3819d, C1516at.this.f3820e));
            }
        });
    }

    public final void destroy() {
        super.destroy();
        this.f3821f.unsubscribe(this.f3818b);
    }
}
