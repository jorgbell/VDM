package com.unity3d.services.monetization.placementcontent.ads;

import com.unity3d.ads.UnityAds;

public abstract class ShowAdListenerAdapter implements IShowAdListener {
    public void onAdFinished(String str, UnityAds.FinishState finishState) {
    }

    public void onAdStarted(String str) {
    }
}
