package com.flurry.sdk;

import android.app.ActivityManager;
import android.content.Context;
import com.flurry.android.FlurryConfig;
import com.flurry.android.FlurryConfigListener;
import com.flurry.android.FlurryPerformance;
import com.mopub.common.Constants;
import java.util.Locale;

/* renamed from: com.flurry.sdk.dl */
public final class C1676dl {

    /* renamed from: a */
    private static String f4253a = "resource";

    /* renamed from: b */
    private static String f4254b = "http";

    /* renamed from: c */
    private static int f4255c = 4;

    /* renamed from: d */
    private static int f4256d = 8;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String[] f4257e = {Constants.VAST_RESOURCE, "http"};
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static int[] f4258f = {4, 8};

    /* renamed from: g */
    private static boolean f4259g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static boolean f4260h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static int f4261i = (4 | 8);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static FlurryConfig f4262j;

    /* renamed from: k */
    private static FlurryConfigListener f4263k;

    /* renamed from: a */
    public static ActivityManager.MemoryInfo m4398a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    /* renamed from: a */
    public static void m4399a() {
        if (!f4259g) {
            C1648cy.m4317a(3, "PerformanceUtils", "Initialize Flurry Config for Performance metrics flags.");
            f4259g = true;
            f4262j = FlurryConfig.getInstance();
            C16771 r0 = new FlurryConfigListener() {
                public final void onFetchSuccess() {
                    C1676dl.f4262j.activateConfig();
                }

                public final void onFetchNoChange() {
                    m4407a();
                    boolean unused = C1676dl.f4260h = true;
                }

                public final void onFetchError(boolean z) {
                    m4407a();
                }

                public final void onActivateComplete(boolean z) {
                    m4407a();
                    if (!z) {
                        boolean unused = C1676dl.f4260h = true;
                    }
                }

                /* renamed from: a */
                private static void m4407a() {
                    String[] split = C1676dl.f4262j.getString(FlurryPerformance.PERFORMANCE_CONFIG_FLAGS, "resource|http").toLowerCase(Locale.ENGLISH).split("\\W+");
                    int unused = C1676dl.f4261i = 0;
                    for (String str : split) {
                        int i = 0;
                        while (true) {
                            if (i >= C1676dl.f4257e.length) {
                                break;
                            } else if (C1676dl.f4257e[i].equals(str)) {
                                int unused2 = C1676dl.f4261i = C1676dl.f4261i | C1676dl.f4258f[i];
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    C1648cy.m4317a(3, "PerformanceUtils", "Performance metrics flags: " + C1676dl.f4261i);
                }
            };
            f4263k = r0;
            f4262j.registerListener(r0);
            f4262j.fetchConfig();
        }
    }

    /* renamed from: b */
    public static boolean m4400b() {
        m4399a();
        int i = f4261i;
        int i2 = f4256d;
        return (i & i2) == i2;
    }

    /* renamed from: c */
    public static boolean m4401c() {
        m4399a();
        int i = f4261i;
        int i2 = f4255c;
        return (i & i2) == i2;
    }
}
