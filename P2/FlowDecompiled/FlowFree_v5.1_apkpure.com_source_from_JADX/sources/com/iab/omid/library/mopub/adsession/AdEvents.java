package com.iab.omid.library.mopub.adsession;

import com.iab.omid.library.mopub.adsession.media.VastProperties;
import com.iab.omid.library.mopub.p044d.C2392e;

public final class AdEvents {
    private final C2370a adSession;

    private AdEvents(C2370a aVar) {
        this.adSession = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession2) {
        C2370a aVar = (C2370a) adSession2;
        C2392e.m5597a((Object) adSession2, "AdSession is null");
        C2392e.m5602d(aVar);
        C2392e.m5600b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().mo24068a(adEvents);
        return adEvents;
    }

    public void impressionOccurred() {
        C2392e.m5600b(this.adSession);
        C2392e.m5604f(this.adSession);
        if (!this.adSession.mo23991e()) {
            try {
                this.adSession.start();
            } catch (Exception unused) {
            }
        }
        if (this.adSession.mo23991e()) {
            this.adSession.mo23988b();
        }
    }

    public void loaded() {
        C2392e.m5601c(this.adSession);
        C2392e.m5604f(this.adSession);
        this.adSession.mo23989c();
    }

    public void loaded(VastProperties vastProperties) {
        C2392e.m5597a((Object) vastProperties, "VastProperties is null");
        C2392e.m5601c(this.adSession);
        C2392e.m5604f(this.adSession);
        this.adSession.mo23987a(vastProperties.mo24015a());
    }
}
