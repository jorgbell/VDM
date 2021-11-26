package com.flurry.sdk;

import java.util.Collections;

/* renamed from: com.flurry.sdk.ht */
final class C1841ht implements C1914o<C1530aw> {

    /* renamed from: a */
    private String f4565a;

    C1841ht() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        C1530aw awVar = (C1530aw) obj;
        String str = awVar.f3865a;
        boolean z = awVar.f3866b;
        if (str != null && !str.equals(this.f4565a) && z) {
            C1548be.m4072a();
            C1548be.m4075b("Log Notification Frame", Collections.emptyMap());
            this.f4565a = str;
            C1735fb.m4502a().mo11504a(new C1873iw(new C1874ix(str, z)));
        }
    }
}
