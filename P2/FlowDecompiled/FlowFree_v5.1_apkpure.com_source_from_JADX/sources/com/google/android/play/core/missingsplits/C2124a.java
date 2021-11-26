package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.google.android.play.core.internal.C2058ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.play.core.missingsplits.a */
final class C2124a {

    /* renamed from: a */
    private static final C2058ag f5224a = new C2058ag("MissingSplitsAppComponentsHelper");

    /* renamed from: b */
    private final Context f5225b;

    /* renamed from: c */
    private final PackageManager f5226c;

    C2124a(Context context, PackageManager packageManager) {
        this.f5225b = context;
        this.f5226c = packageManager;
    }

    /* renamed from: d */
    private final void m5341d(List<ComponentInfo> list, int i) {
        for (ComponentInfo next : list) {
            this.f5226c.setComponentEnabledSetting(new ComponentName(next.packageName, next.name), i, 1);
        }
    }

    /* renamed from: e */
    private final List<ComponentInfo> m5342e() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.f5226c.getPackageInfo(this.f5225b.getPackageName(), 526);
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr != null) {
                Collections.addAll(arrayList, providerInfoArr);
            }
            ActivityInfo[] activityInfoArr = packageInfo.receivers;
            if (activityInfoArr != null) {
                Collections.addAll(arrayList, activityInfoArr);
            }
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                Collections.addAll(arrayList, serviceInfoArr);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            f5224a.mo22028e("Failed to resolve own package : %s", e);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo22117a() {
        for (ComponentInfo next : m5342e()) {
            if (this.f5226c.getComponentEnabledSetting(new ComponentName(next.packageName, next.name)) != 2) {
                f5224a.mo22024a("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        f5224a.mo22024a("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo22118b() {
        f5224a.mo22027d("Disabling all non-activity components", new Object[0]);
        m5341d(m5342e(), 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo22119c() {
        f5224a.mo22027d("Resetting enabled state of all non-activity components", new Object[0]);
        m5341d(m5342e(), 0);
    }
}
