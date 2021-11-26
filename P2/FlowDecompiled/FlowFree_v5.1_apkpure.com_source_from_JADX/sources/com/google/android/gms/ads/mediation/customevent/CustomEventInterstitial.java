package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.mediation.MediationAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public interface CustomEventInterstitial extends CustomEvent {
    /* synthetic */ void onDestroy();

    /* synthetic */ void onPause();

    /* synthetic */ void onResume();

    void requestInterstitialAd(@RecentlyNonNull Context context, @RecentlyNonNull CustomEventInterstitialListener customEventInterstitialListener, String str, @RecentlyNonNull MediationAdRequest mediationAdRequest, Bundle bundle);

    void showInterstitial();
}
