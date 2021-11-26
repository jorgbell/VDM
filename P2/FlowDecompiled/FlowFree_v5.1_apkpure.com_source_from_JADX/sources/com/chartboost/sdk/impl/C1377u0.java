package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Networking.C1244d;
import com.chartboost.sdk.Networking.NetworkHelper;
import com.chartboost.sdk.Tracking.C1261b;
import com.chartboost.sdk.Tracking.C1270i;
import com.chartboost.sdk.impl.C1357p0;
import java.util.HashMap;

/* renamed from: com.chartboost.sdk.impl.u0 */
public class C1377u0 extends C1357p0 {

    /* renamed from: o */
    private final C1270i f3386o;

    /* renamed from: p */
    private final C1261b f3387p;

    /* renamed from: q */
    private C1373t0 f3388q;

    public C1377u0(String str, C1270i iVar, C1261b bVar) {
        this(NetworkHelper.m3081a(str), NetworkHelper.m3083b(str), (C1357p0.C1358a) null, iVar, bVar, new C1373t0());
    }

    /* renamed from: a */
    public C1244d mo10142a() {
        String a = this.f3388q.mo10609a(this.f3386o, this.f3387p);
        HashMap hashMap = new HashMap();
        hashMap.put("Accept", "application/json");
        hashMap.put("X-Chartboost-Client", CBUtility.m2925e());
        hashMap.put("X-Chartboost-API", "8.2.0");
        return new C1244d(hashMap, a.getBytes(), "application/json");
    }

    public C1377u0(String str, String str2, C1357p0.C1358a aVar, C1270i iVar, C1261b bVar, C1373t0 t0Var) {
        super(str, str2, (C1234g) null, 2, aVar);
        this.f3342m = false;
        this.f3386o = iVar;
        this.f3387p = bVar;
        this.f3388q = t0Var;
    }
}
