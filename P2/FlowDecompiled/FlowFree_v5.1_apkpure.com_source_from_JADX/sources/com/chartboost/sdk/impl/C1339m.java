package com.chartboost.sdk.impl;

import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1243c;
import com.chartboost.sdk.Networking.C1244d;
import com.chartboost.sdk.Networking.C1246f;
import com.chartboost.sdk.Networking.C1248h;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.chartboost.sdk.impl.m */
class C1339m extends C1243c<Void> {

    /* renamed from: j */
    private final C1344n f3279j;

    /* renamed from: k */
    private final C1248h f3280k;

    /* renamed from: l */
    final C1334l f3281l;

    C1339m(C1344n nVar, C1248h hVar, C1334l lVar, File file) {
        super("GET", lVar.f3263d, 2, file);
        this.f2855i = 1;
        this.f3279j = nVar;
        this.f3280k = hVar;
        this.f3281l = lVar;
    }

    /* renamed from: a */
    public C1244d mo10142a() {
        HashMap hashMap = new HashMap();
        hashMap.put("X-Chartboost-App", C1418k.f3540j);
        hashMap.put("X-Chartboost-Client", CBUtility.m2925e());
        hashMap.put("X-Chartboost-Reachability", Integer.toString(this.f3280k.mo10150b()));
        return new C1244d(hashMap, (byte[]) null, (String) null);
    }

    /* renamed from: a */
    public void mo10145a(Void voidR, C1246f fVar) {
        this.f3279j.mo10520a(this, (CBError) null, (C1246f) null);
    }

    /* renamed from: a */
    public void mo10144a(CBError cBError, C1246f fVar) {
        this.f3279j.mo10520a(this, cBError, fVar);
    }
}
