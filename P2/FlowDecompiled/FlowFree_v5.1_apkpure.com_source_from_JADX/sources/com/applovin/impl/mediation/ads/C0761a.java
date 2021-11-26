package com.applovin.impl.mediation.ads;

import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1099h;
import com.applovin.impl.sdk.utils.C1152l;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.mediation.ads.a */
public abstract class C0761a {

    /* renamed from: a */
    private static C1062k f842a;
    protected final MaxAdFormat adFormat;
    protected MaxAdListener adListener = null;
    protected final String adUnitId;
    protected final C1099h.C1101a loadRequestBuilder;
    protected final C1107r logger;
    protected final C1062k sdk;
    protected final String tag;

    protected C0761a(String str, MaxAdFormat maxAdFormat, String str2, C1062k kVar) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.sdk = kVar;
        this.tag = str2;
        this.logger = kVar.mo9411z();
        this.loadRequestBuilder = new C1099h.C1101a();
    }

    public static void logApiCall(String str, String str2) {
        C1062k kVar = f842a;
        if (kVar != null) {
            kVar.mo9411z().mo9584b(str, str2);
            return;
        }
        for (AppLovinSdk appLovinSdk : AppLovinSdk.m2841a()) {
            C1062k kVar2 = appLovinSdk.coreSdk;
            if (!kVar2.mo9389e()) {
                kVar2.mo9411z().mo9584b(str, str2);
                f842a = kVar2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8514a(C0733a aVar) {
        C1152l lVar = new C1152l();
        lVar.mo9643a().mo9648a("MAX Ad").mo9645a(aVar).mo9643a();
        C1107r.m2481f(this.tag, lVar.toString());
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void logApiCall(String str) {
        this.logger.mo9584b(this.tag, str);
    }

    public void setExtraParameter(String str, String str2) {
        if (str != null) {
            this.loadRequestBuilder.mo9553a(str, str2);
            return;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public void setListener(MaxAdListener maxAdListener) {
        C1107r rVar = this.logger;
        String str = this.tag;
        rVar.mo9584b(str, "Setting listener: " + maxAdListener);
        this.adListener = maxAdListener;
    }
}
