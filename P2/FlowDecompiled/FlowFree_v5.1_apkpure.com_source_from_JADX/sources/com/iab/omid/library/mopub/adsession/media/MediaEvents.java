package com.iab.omid.library.mopub.adsession.media;

import com.iab.omid.library.mopub.adsession.AdSession;
import com.iab.omid.library.mopub.adsession.C2370a;
import com.iab.omid.library.mopub.p042b.C2380f;
import com.iab.omid.library.mopub.p044d.C2388b;
import com.iab.omid.library.mopub.p044d.C2392e;
import com.mopub.mobileads.VastIconXmlManager;
import org.json.JSONObject;

public final class MediaEvents {
    private final C2370a adSession;

    private MediaEvents(C2370a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession2) {
        C2370a aVar = (C2370a) adSession2;
        C2392e.m5597a((Object) adSession2, "AdSession is null");
        C2392e.m5605g(aVar);
        C2392e.m5596a(aVar);
        C2392e.m5600b(aVar);
        C2392e.m5603e(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().mo24072a(mediaEvents);
        return mediaEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        C2392e.m5597a((Object) interactionType, "InteractionType is null");
        C2392e.m5601c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2388b.m5581a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().mo24075a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("bufferFinish");
    }

    public void bufferStart() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("bufferStart");
    }

    public void complete() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("complete");
    }

    public void firstQuartile() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("firstQuartile");
    }

    public void midpoint() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("midpoint");
    }

    public void pause() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("pause");
    }

    public void playerStateChange(PlayerState playerState) {
        C2392e.m5597a((Object) playerState, "PlayerState is null");
        C2392e.m5601c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2388b.m5581a(jSONObject, "state", playerState);
        this.adSession.getAdSessionStatePublisher().mo24075a("playerStateChange", jSONObject);
    }

    public void resume() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("resume");
    }

    public void skipped() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("skipped");
    }

    public void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        C2392e.m5601c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2388b.m5581a(jSONObject, VastIconXmlManager.DURATION, Float.valueOf(f));
        C2388b.m5581a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        C2388b.m5581a(jSONObject, "deviceVolume", Float.valueOf(C2380f.m5545a().mo24058d()));
        this.adSession.getAdSessionStatePublisher().mo24075a("start", jSONObject);
    }

    public void thirdQuartile() {
        C2392e.m5601c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo24073a("thirdQuartile");
    }

    public void volumeChange(float f) {
        confirmValidVolume(f);
        C2392e.m5601c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2388b.m5581a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        C2388b.m5581a(jSONObject, "deviceVolume", Float.valueOf(C2380f.m5545a().mo24058d()));
        this.adSession.getAdSessionStatePublisher().mo24075a("volumeChange", jSONObject);
    }
}
