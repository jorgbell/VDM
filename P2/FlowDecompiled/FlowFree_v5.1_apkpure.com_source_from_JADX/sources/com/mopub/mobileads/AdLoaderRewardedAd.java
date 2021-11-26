package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.network.AdLoader;
import com.mopub.network.AdResponse;
import com.mopub.network.SingleImpression;
import com.mopub.network.TrackingRequest;
import java.util.Collections;
import java.util.List;

class AdLoaderRewardedAd extends AdLoader {
    private boolean mClickTrackerFired = false;
    private boolean mImpressionTrackerFired = false;

    AdLoaderRewardedAd(String str, AdFormat adFormat, String str2, Context context, AdLoader.Listener listener) {
        super(str, adFormat, str2, context, listener);
    }

    /* access modifiers changed from: package-private */
    public List<String> getImpressionUrls() {
        AdResponse adResponse = this.mLastDeliveredResponse;
        if (adResponse != null) {
            return adResponse.getImpressionTrackingUrls();
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public List<String> getClickUrls() {
        AdResponse adResponse = this.mLastDeliveredResponse;
        if (adResponse != null) {
            return adResponse.getClickTrackingUrls();
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public AdResponse getLastDeliveredResponse() {
        return this.mLastDeliveredResponse;
    }

    /* access modifiers changed from: package-private */
    public void trackImpression(Context context) {
        Preconditions.checkNotNull(context);
        if (this.mLastDeliveredResponse != null && !this.mImpressionTrackerFired) {
            this.mImpressionTrackerFired = true;
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) getImpressionUrls(), context);
            new SingleImpression(this.mLastDeliveredResponse.getAdUnitId(), this.mLastDeliveredResponse.getImpressionData()).sendImpression();
        }
    }

    /* access modifiers changed from: package-private */
    public void trackClick(Context context) {
        Preconditions.checkNotNull(context);
        if (this.mLastDeliveredResponse != null && !this.mClickTrackerFired) {
            this.mClickTrackerFired = true;
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) getClickUrls(), context);
        }
    }
}
