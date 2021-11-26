package com.chartboost.sdk.Banner;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.chartboost.sdk.C1274c;
import com.chartboost.sdk.C1275d;
import com.chartboost.sdk.C1277e;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.ChartboostBanner;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.C1224j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.Networking.C1248h;
import com.chartboost.sdk.Networking.C1249i;
import com.chartboost.sdk.Networking.C1252j;
import com.chartboost.sdk.Tracking.C1268g;
import com.chartboost.sdk.impl.C1286a;
import com.chartboost.sdk.impl.C1296d;
import com.chartboost.sdk.impl.C1305g;
import com.chartboost.sdk.impl.C1344n;
import com.chartboost.sdk.impl.C1406x;
import com.chartboost.sdk.impl.C1412z;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.chartboost.sdk.Banner.a */
public class C1205a extends C1305g implements C1206b {

    /* renamed from: E */
    private C1296d f2631E;

    /* renamed from: F */
    private Handler f2632F;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1205a(Context context, C1296d dVar, ScheduledExecutorService scheduledExecutorService, C1344n nVar, C1220g gVar, C1247g gVar2, C1248h hVar, C1234g gVar3, AtomicReference<C1236h> atomicReference, SharedPreferences sharedPreferences, C1224j jVar, Handler handler, C1275d dVar2, C1249i iVar, C1277e eVar, C1252j jVar2, C1268g gVar4) {
        super(context, dVar, scheduledExecutorService, nVar, gVar, gVar2, hVar, gVar3, atomicReference, sharedPreferences, jVar, handler, dVar2, iVar, eVar, jVar2, gVar4);
        this.f2631E = dVar;
        this.f2632F = handler;
    }

    /* renamed from: i */
    private boolean m2845i(String str) {
        if (!C1406x.m3823b().mo10696a((CharSequence) str)) {
            return true;
        }
        CBLogging.m2905b("AdUnitBannerManager", "Location cannot be empty");
        ChartboostCacheError chartboostCacheError = new ChartboostCacheError(ChartboostCacheError.Code.INTERNAL);
        Handler handler = this.f2632F;
        C1296d dVar = this.f2631E;
        dVar.getClass();
        handler.post(new C1286a.C1287a(6, str, (CBError.CBImpressionError) null, chartboostCacheError, false, ""));
        return false;
    }

    /* renamed from: j */
    private void m2846j(String str) {
        ChartboostCacheError chartboostCacheError = new ChartboostCacheError(ChartboostCacheError.Code.SESSION_NOT_STARTED);
        String location = this.f3107p.getLocation();
        C1296d dVar = this.f2631E;
        dVar.getClass();
        this.f2632F.post(new C1286a.C1287a(6, location, (CBError.CBImpressionError) null, chartboostCacheError, false, str));
    }

    /* renamed from: k */
    private void m2847k(String str) {
        ChartboostShowError chartboostShowError = new ChartboostShowError(ChartboostShowError.Code.SESSION_NOT_STARTED, false);
        String location = this.f3107p.getLocation();
        C1296d dVar = this.f2631E;
        dVar.getClass();
        this.f2632F.post(new C1286a.C1287a(7, location, (CBError.CBImpressionError) null, chartboostShowError, true, str));
    }

    /* renamed from: a */
    public void mo9938a(String str) {
        if (mo9944h()) {
            this.f3092a.execute(new C1305g.C1307b(3, this.f3107p.getLocation(), (C1312h) null, (CBError.CBImpressionError) null));
            return;
        }
        m2846j(str);
    }

    /* renamed from: b */
    public void mo9941b(String str) {
        if (mo9944h()) {
            this.f3092a.execute(new C1305g.C1307b(4, this.f3107p.getLocation(), (C1312h) null, (CBError.CBImpressionError) null));
            return;
        }
        m2847k(str);
    }

    /* renamed from: c */
    public void mo9942c(String str) {
        if (mo9944h()) {
            ChartboostBanner chartboostBanner = this.f3107p;
            chartboostBanner.didClickBanner(chartboostBanner.getLocation(), str, (ChartboostClickError) null);
        }
    }

    /* renamed from: g */
    public C1296d mo9943g() {
        return this.f2631E;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo9944h() {
        ChartboostBanner chartboostBanner;
        if (!m2844a(C1414j.m3867b()) || (chartboostBanner = this.f3107p) == null) {
            return false;
        }
        return m2845i(chartboostBanner.getLocation());
    }

    /* renamed from: a */
    public void mo9939a(String str, String str2) {
        if (mo9944h()) {
            C1412z.m3855a(this.f3107p.getLocation(), str, 3);
        } else {
            m2847k(str2);
        }
    }

    /* renamed from: a */
    private boolean m2844a(C1414j jVar) {
        if (jVar == null || !C1274c.m3275c()) {
            return false;
        }
        return C1414j.m3874l();
    }

    /* renamed from: a */
    public boolean mo9940a() {
        return mo10422f(this.f3107p.getLocation()) != null;
    }

    /* renamed from: a */
    public void mo9937a(ChartboostBanner chartboostBanner) {
        this.f3107p = chartboostBanner;
    }
}
