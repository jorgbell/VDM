package com.google.android.gms.ads.formats;

import androidx.annotation.RecentlyNonNull;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public interface NativeCustomTemplateAd {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public interface OnCustomClickListener {
        void onCustomClick(@RecentlyNonNull NativeCustomTemplateAd nativeCustomTemplateAd, @RecentlyNonNull String str);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public interface OnCustomTemplateAdLoadedListener {
        void onCustomTemplateAdLoaded(@RecentlyNonNull NativeCustomTemplateAd nativeCustomTemplateAd);
    }

    @RecentlyNonNull
    String getCustomTemplateId();
}
