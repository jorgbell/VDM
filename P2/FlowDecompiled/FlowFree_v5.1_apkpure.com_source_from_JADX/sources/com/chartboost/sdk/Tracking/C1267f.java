package com.chartboost.sdk.Tracking;

import com.chartboost.sdk.Tracking.C1270i;

/* renamed from: com.chartboost.sdk.Tracking.f */
public class C1267f extends C1270i {
    public C1267f(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        mo10272a(C1270i.C1271a.INFO);
        if ("cache_finish_success".equals(str) || "cache_finish_failure".equals(str) || "show_finish_success".equals(str) || "show_finish_failure".equals(str)) {
            mo10274a(true);
        }
    }
}
