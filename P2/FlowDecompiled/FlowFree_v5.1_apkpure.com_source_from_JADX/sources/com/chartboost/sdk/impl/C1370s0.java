package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Networking.requests.models.ShowParamsModel;
import com.chartboost.sdk.impl.C1357p0;
import com.mopub.mobileads.ChartboostShared;

/* renamed from: com.chartboost.sdk.impl.s0 */
public class C1370s0 extends C1357p0 {
    public C1370s0(String str, C1234g gVar, ShowParamsModel showParamsModel, C1357p0.C1358a aVar) {
        super("https://live.chartboost.com", str, gVar, 2, aVar);
        this.f2855i = 1;
        m3719a(showParamsModel);
    }

    /* renamed from: a */
    private void m3719a(ShowParamsModel showParamsModel) {
        mo10562a("cached", (Object) "0");
        mo10562a(ChartboostShared.LOCATION_KEY, (Object) showParamsModel.getLocation());
        String adId = showParamsModel.getAdId();
        if (!adId.isEmpty()) {
            mo10562a("ad_id", (Object) adId);
        }
    }
}
