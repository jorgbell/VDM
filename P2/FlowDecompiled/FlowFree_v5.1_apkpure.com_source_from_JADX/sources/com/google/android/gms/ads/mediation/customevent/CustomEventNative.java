package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public interface CustomEventNative extends CustomEvent {
    /* synthetic */ void onDestroy();

    /* synthetic */ void onPause();

    /* synthetic */ void onResume();

    void requestNativeAd(@RecentlyNonNull Context context, @RecentlyNonNull CustomEventNativeListener customEventNativeListener, String str, @RecentlyNonNull NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle);
}
