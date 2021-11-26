package com.chartboost.sdk.impl;

import android.os.Build;
import com.chartboost.sdk.C1272a;
import com.chartboost.sdk.C1273b;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.z */
public class C1412z {
    /* renamed from: a */
    private static String m3848a(int i) {
        return i != 0 ? i != 1 ? i != 3 ? "" : "Banner" : "Rewarded" : "Interstitial";
    }

    /* renamed from: a */
    public static void m3855a(String str, String str2, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m2905b("OpenRTBCache", "OpenRTBCache not supported for this Android version");
            C1272a aVar = C1418k.f3534d;
            if (aVar != null) {
                aVar.didFailToLoadInterstitial(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C1414j b = C1414j.m3867b();
        if (b == null) {
            CBLogging.m2905b("OpenRTBCache", "OpenRTBCache cache: SDK is null");
        } else if (!C1288a0.m3370a(str, str2)) {
            C1288a0.m3367a(b, str, i, "");
        } else {
            C1344n nVar = b.f3511n.f3306a;
            if (nVar == null) {
                C1288a0.m3367a(b, str, i, "");
                return;
            }
            try {
                C1410y yVar = new C1410y(i, new JSONObject(str2));
                C1418k.f3544n = false;
                m3851a(b, i, str, nVar, yVar);
            } catch (JSONException e) {
                C1266e.m3223e(new C1260a("cache_bid_response_parsing_error", e.toString(), m3848a(i), str));
                C1288a0.m3367a(b, str, i, "");
            }
        }
    }

    /* renamed from: b */
    private static C1305g m3856b(C1414j jVar, int i, String str, String str2) {
        if (i == 0) {
            return jVar.mo10713f();
        }
        if (i == 1) {
            return jVar.mo10715h();
        }
        if (i != 3) {
            return null;
        }
        return m3847a(jVar, str, str2);
    }

    /* renamed from: a */
    private static void m3851a(C1414j jVar, int i, String str, C1344n nVar, C1410y yVar) {
        m3850a(nVar, yVar, (C1328j) new C1328j(i, str, yVar) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ C1410y f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            /* renamed from: a */
            public final void mo10363a(boolean z, int i, int i2) {
                C1412z.m3853a(C1414j.this, this.f$1, this.f$2, this.f$3, z, i, i2);
            }
        }, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m3853a(C1414j jVar, int i, String str, C1410y yVar, boolean z, int i2, int i3) {
        if (z) {
            m3852a(jVar, i, str, yVar);
        } else {
            C1288a0.m3366a(jVar, str, i, yVar);
        }
    }

    /* renamed from: a */
    static void m3852a(C1414j jVar, int i, String str, C1410y yVar) {
        String str2 = yVar != null ? yVar.f2716i : "";
        C1305g b = m3856b(jVar, i, str, str2);
        if (b != null) {
            m3849a(b, str, yVar);
            m3854a(jVar, i, str, str2);
            return;
        }
        C1288a0.m3367a(jVar, str, i, yVar.f2716i);
    }

    /* renamed from: a */
    private static void m3850a(C1344n nVar, C1410y yVar, C1328j jVar, int i) {
        nVar.mo10519a(1, yVar.mo10703b().mo10400b(), new AtomicInteger(), jVar, m3848a(i));
    }

    /* renamed from: a */
    private static void m3854a(C1414j jVar, int i, String str, String str2) {
        if (i == 0) {
            Chartboost.cacheInterstitial(str);
        } else if (i == 1) {
            Chartboost.cacheRewardedVideo(str);
        } else if (i == 3) {
            jVar.f3509l.mo10290a(str, str2);
        }
    }

    /* renamed from: a */
    private static C1305g m3847a(C1414j jVar, String str, String str2) {
        C1273b bVar = jVar.f3509l;
        if (bVar != null) {
            return bVar.mo10288a(str);
        }
        C1288a0.m3373d(jVar, str, str2);
        return null;
    }

    /* renamed from: a */
    private static void m3849a(C1305g gVar, String str, C1410y yVar) {
        if (gVar.mo10422f(str) == null) {
            gVar.mo10416a(str, yVar);
        }
    }
}
