package com.iab.omid.library.mopub.adsession;

import android.view.View;
import com.iab.omid.library.mopub.p044d.C2392e;

public abstract class AdSession {
    public static AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        C2392e.m5594a();
        C2392e.m5597a((Object) adSessionConfiguration, "AdSessionConfiguration is null");
        C2392e.m5597a((Object) adSessionContext, "AdSessionContext is null");
        return new C2370a(adSessionConfiguration, adSessionContext);
    }

    public abstract void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str);

    public abstract void finish();

    public abstract void registerAdView(View view);

    public abstract void start();
}
