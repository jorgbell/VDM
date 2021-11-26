package com.google.android.gms.ads.formats;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.VideoController;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class UnifiedNativeAd {

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public interface OnUnifiedNativeAdLoadedListener {
        void onUnifiedNativeAdLoaded(@RecentlyNonNull UnifiedNativeAd unifiedNativeAd);
    }

    @RecentlyNonNull
    public abstract String getAdvertiser();

    @RecentlyNonNull
    public abstract String getBody();

    @RecentlyNonNull
    public abstract String getCallToAction();

    @RecentlyNonNull
    public abstract String getHeadline();

    @RecentlyNonNull
    public abstract NativeAd$Image getIcon();

    @RecentlyNonNull
    public abstract List<NativeAd$Image> getImages();

    @RecentlyNonNull
    public abstract String getPrice();

    @RecentlyNonNull
    public abstract Double getStarRating();

    @RecentlyNonNull
    public abstract String getStore();

    @RecentlyNonNull
    @Deprecated
    public abstract VideoController getVideoController();

    @RecentlyNonNull
    public abstract Object zza();
}
