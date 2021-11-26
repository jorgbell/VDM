package com.flurry.sdk;

import android.os.Bundle;
import com.flurry.sdk.C1508ao;
import java.util.ArrayList;

/* renamed from: com.flurry.sdk.hp */
final class C1837hp implements C1914o<C1508ao> {
    C1837hp() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        Bundle bundle;
        C1508ao aoVar = (C1508ao) obj;
        if (C1508ao.C1509a.APP_ORIENTATION_CHANGE.equals(aoVar.f3791a) && (bundle = aoVar.f3792b) != null && bundle.containsKey("orientation_name")) {
            int i = bundle.getInt("orientation_name");
            C1853ic.m4714a(i);
            C1648cy.m4317a(5, "LifecycleObserver", aoVar.f3791a.name() + " orientation: " + i);
        }
        if (C1508ao.C1509a.CREATED.equals(aoVar.f3791a)) {
            m4696a(aoVar);
        }
    }

    /* renamed from: a */
    private static void m4696a(C1508ao aoVar) {
        Bundle bundle;
        Bundle bundle2 = aoVar.f3792b;
        if (bundle2 != null && (bundle = bundle2.getBundle("launch_options")) != null) {
            C1648cy.m4317a(3, "LifecycleObserver", "Launch Options Bundle is present " + bundle.toString());
            for (String str : bundle.keySet()) {
                if (str != null) {
                    Object obj = bundle.get(str);
                    String obj2 = obj != null ? obj.toString() : "null";
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj2);
                    if (str == null || str.isEmpty()) {
                        C1648cy.m4317a(2, "LaunchOptionsFrame", "Launch option key is empty, do not send the frame.");
                    } else if (arrayList.size() == 0) {
                        C1648cy.m4317a(2, "LaunchOptionsFrame", "Launch option values is empty, do not send the frame.");
                    } else {
                        C1735fb.m4502a().mo11504a(new C1869is(new C1870it(str, arrayList)));
                    }
                    C1648cy.m4317a(3, "LifecycleObserver", "Launch options Key: " + str + ". Its value: " + obj2);
                }
            }
        }
    }
}
