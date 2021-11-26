package com.applovin.impl.mediation;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p021a.C0737e;
import com.applovin.impl.mediation.p021a.C0740g;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;

public class MaxAdapterParametersImpl implements MaxAdapterInitializationParameters, MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters {

    /* renamed from: a */
    private Bundle f729a;

    /* renamed from: b */
    private Boolean f730b;

    /* renamed from: c */
    private Boolean f731c;

    /* renamed from: d */
    private Boolean f732d;

    /* renamed from: e */
    private boolean f733e;

    /* renamed from: f */
    private String f734f;

    /* renamed from: g */
    private String f735g;

    /* renamed from: h */
    private MaxAdFormat f736h;

    private MaxAdapterParametersImpl() {
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m845a(C0733a aVar, Context context) {
        MaxAdapterParametersImpl a = m846a(aVar);
        a.f734f = aVar.mo8401i();
        a.f735g = aVar.mo8400h();
        return a;
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m846a(C0737e eVar) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f730b = eVar.mo8446M();
        maxAdapterParametersImpl.f731c = eVar.mo8447N();
        maxAdapterParametersImpl.f732d = eVar.mo8448O();
        maxAdapterParametersImpl.f729a = eVar.mo8450Q();
        maxAdapterParametersImpl.f733e = eVar.mo8445L();
        return maxAdapterParametersImpl;
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m847a(C0740g gVar, MaxAdFormat maxAdFormat, Context context) {
        MaxAdapterParametersImpl a = m846a(gVar);
        a.f736h = maxAdFormat;
        return a;
    }

    public MaxAdFormat getAdFormat() {
        return this.f736h;
    }

    public String getBidResponse() {
        return this.f735g;
    }

    public Bundle getServerParameters() {
        return this.f729a;
    }

    public String getThirdPartyAdPlacementId() {
        return this.f734f;
    }

    public Boolean hasUserConsent() {
        return this.f730b;
    }

    public Boolean isAgeRestrictedUser() {
        return this.f731c;
    }

    public Boolean isDoNotSell() {
        return this.f732d;
    }

    public boolean isTesting() {
        return this.f733e;
    }
}
