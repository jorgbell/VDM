package com.iab.omid.library.vungle.adsession;

import android.view.View;
import com.iab.omid.library.vungle.p050d.C2441e;

public abstract class AdSession {
    public static AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        C2441e.m5789a();
        C2441e.m5791a((Object) adSessionConfiguration, "AdSessionConfiguration is null");
        C2441e.m5791a((Object) adSessionContext, "AdSessionContext is null");
        return new C2421a(adSessionConfiguration, adSessionContext);
    }

    public abstract void finish();

    public abstract void registerAdView(View view);

    public abstract void start();
}
