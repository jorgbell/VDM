package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1001g;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

public class PostbackServiceImpl implements AppLovinPostbackService {

    /* renamed from: a */
    private final C1062k f2268a;

    public PostbackServiceImpl(C1062k kVar) {
        this.f2268a = kVar;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(C1097g.m2402b(this.f2268a).mo9481a(str).mo9492c(false).mo9485a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(C1097g gVar, C1020o.C1022a aVar, AppLovinPostbackListener appLovinPostbackListener) {
        this.f2268a.mo9340Q().mo9266a((C0989a) new C1001g(gVar, aVar, this.f2268a, appLovinPostbackListener), aVar);
    }

    public void dispatchPostbackRequest(C1097g gVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(gVar, C1020o.C1022a.POSTBACKS, appLovinPostbackListener);
    }

    public String toString() {
        return "PostbackService{}";
    }
}
