package com.flurry.sdk;

import android.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.flurry.sdk.ho */
final class C1836ho implements C1914o<C1501ak> {
    C1836ho() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        C1501ak akVar = (C1501ak) obj;
        boolean z = akVar.f3770b;
        Map<C1502al, String> a = akVar.mo11283a();
        if (a == null || a.size() == 0) {
            C1648cy.m4317a(2, "ReportedIDFrame", "Reported ids is empty, do not send the frame.");
        } else {
            C1735fb.m4502a().mo11504a(new C1882je(new C1883jf(a, z)));
        }
        Map<C1502al, String> a2 = akVar.mo11283a();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : a2.entrySet()) {
            if (((C1502al) next.getKey()).equals(C1502al.AndroidInstallationId)) {
                hashMap.put(((C1502al) next.getKey()).name(), C1698dz.m4441a(Base64.decode((String) next.getValue(), 2)).toUpperCase(Locale.getDefault()));
            } else {
                hashMap.put(((C1502al) next.getKey()).name(), next.getValue());
            }
        }
        C1548be.m4072a();
        C1548be.m4075b("Reported Ids", hashMap);
        C1648cy.m4317a(4, "IdObserver", "IdProvider" + akVar.mo11283a());
    }
}
