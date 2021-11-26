package com.chartboost.sdk.impl;

import android.text.TextUtils;
import com.chartboost.sdk.Banner.C1205a;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostError;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C1286a;

/* renamed from: com.chartboost.sdk.impl.a0 */
class C1288a0 {
    /* renamed from: a */
    static void m3366a(C1414j jVar, String str, int i, C1410y yVar) {
        String str2 = yVar != null ? yVar.f2716i : "";
        if (i == 0) {
            m3371b(jVar, str, str2);
        } else if (i == 1) {
            m3372c(jVar, str, str2);
        } else if (i == 3) {
            m3368a(jVar, str, str2);
        }
    }

    /* renamed from: b */
    private static void m3371b(C1414j jVar, String str, String str2) {
        C1286a aVar = jVar.f3519v;
        aVar.getClass();
        m3365a(jVar, new C1286a.C1287a(4, str, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE, (ChartboostError) null, false, str2));
    }

    /* renamed from: c */
    private static void m3372c(C1414j jVar, String str, String str2) {
        C1286a aVar = jVar.f3523z;
        aVar.getClass();
        m3365a(jVar, new C1286a.C1287a(4, str, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE, (ChartboostError) null, false, str2));
    }

    /* renamed from: d */
    static void m3373d(C1414j jVar, String str, String str2) {
        C1205a a = jVar.f3509l.mo10288a(str);
        if (a != null) {
            C1296d g = a.mo9943g();
            if (g != null) {
                g.getClass();
                m3365a(jVar, new C1286a.C1287a(6, str, (CBError.CBImpressionError) null, new ChartboostCacheError(ChartboostCacheError.Code.INTERNAL), false, str2));
                return;
            }
            CBLogging.m2903a("OpenRTBErrorsHelper", "Banner trait is null");
        }
    }

    /* renamed from: e */
    private static void m3374e(C1414j jVar, String str, String str2) {
        C1286a g = jVar.mo10714g();
        g.getClass();
        m3365a(jVar, new C1286a.C1287a(4, str, CBError.CBImpressionError.INTERNAL, (ChartboostError) null, false, str2));
    }

    /* renamed from: f */
    private static void m3375f(C1414j jVar, String str, String str2) {
        C1286a i = jVar.mo10716i();
        i.getClass();
        m3365a(jVar, new C1286a.C1287a(4, str, CBError.CBImpressionError.INTERNAL, (ChartboostError) null, false, str2));
    }

    /* renamed from: a */
    private static void m3368a(C1414j jVar, String str, String str2) {
        C1205a a = jVar.f3509l.mo10288a(str);
        if (a != null) {
            C1296d g = a.mo9943g();
            g.getClass();
            m3365a(jVar, new C1286a.C1287a(4, str, (CBError.CBImpressionError) null, new ChartboostCacheError(ChartboostCacheError.Code.ASSET_DOWNLOAD_FAILURE), false, str2));
        }
    }

    /* renamed from: a */
    static void m3367a(C1414j jVar, String str, int i, String str2) {
        if (i == 0) {
            m3374e(jVar, str, str2);
        } else if (i == 1) {
            m3375f(jVar, str, str2);
        } else if (i == 3) {
            m3373d(jVar, str, str2);
        }
    }

    /* renamed from: a */
    private static void m3365a(C1414j jVar, C1286a.C1287a aVar) {
        jVar.mo10718k().post(aVar);
    }

    /* renamed from: a */
    static boolean m3370a(String str, String str2) {
        return m3369a(str) && m3369a(str2);
    }

    /* renamed from: a */
    private static boolean m3369a(String str) {
        return !TextUtils.isEmpty(str);
    }
}
