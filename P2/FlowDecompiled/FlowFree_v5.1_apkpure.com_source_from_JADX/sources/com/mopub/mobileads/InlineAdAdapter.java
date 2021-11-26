package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.MoPubReward;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdAdapter;
import com.mopub.mobileads.InlineVisibilityTracker;
import com.mopub.mobileads.factories.BaseAdFactory;

public class InlineAdAdapter extends AdAdapter {
    private int mImpressionMinVisibleDips = Integer.MIN_VALUE;
    private int mImpressionMinVisibleMs = Integer.MIN_VALUE;
    protected InlineVisibilityTracker mVisibilityTracker;

    public void onAdComplete(MoPubReward moPubReward) {
    }

    public void onAdDismissed() {
    }

    public InlineAdAdapter(Context context, String str, AdData adData) throws AdAdapter.BaseAdNotFoundException {
        super(context, str, adData);
        MoPubLog.AdLogEvent adLogEvent = MoPubLog.AdLogEvent.CUSTOM;
        MoPubLog.log(adLogEvent, "Attempting to invoke base ad: " + str);
        try {
            this.mBaseAd = BaseAdFactory.create(str);
            parseBannerImpressionTrackingHeaders();
        } catch (Exception e) {
            throw new AdAdapter.BaseAdNotFoundException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void show(MoPubAd moPubAd) {
        MoPubLog.log(MoPubLog.AdLogEvent.SHOW_ATTEMPTED, new Object[0]);
        BaseAd baseAd = this.mBaseAd;
        if (!isInvalidated() && baseAd != null) {
            if (!(moPubAd instanceof MoPubView) || baseAd.getAdView() == null) {
                MoPubLog.AdLogEvent adLogEvent = MoPubLog.AdLogEvent.SHOW_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.INLINE_SHOW_ERROR;
                MoPubLog.log(adLogEvent, moPubErrorCode);
                onAdFailed(moPubErrorCode);
                return;
            }
            MoPubView moPubView = (MoPubView) moPubAd;
            View adView = baseAd.getAdView();
            if (isAutomaticImpressionAndClickTrackingEnabled()) {
                onAdPauseAutoRefresh();
                InlineVisibilityTracker inlineVisibilityTracker = new InlineVisibilityTracker(this.mContext, moPubView, adView, this.mImpressionMinVisibleDips, this.mImpressionMinVisibleMs);
                this.mVisibilityTracker = inlineVisibilityTracker;
                inlineVisibilityTracker.setInlineVisibilityTrackerListener(new InlineVisibilityTracker.InlineVisibilityTrackerListener(baseAd) {
                    public final /* synthetic */ BaseAd f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onVisibilityChanged() {
                        InlineAdAdapter.this.lambda$show$0$InlineAdAdapter(this.f$1);
                    }
                });
            }
            baseAd.internalShow(this);
            View adView2 = baseAd.getAdView();
            if (adView2 != null) {
                moPubAd.setAdContentView(adView2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$show$0 */
    public /* synthetic */ void lambda$show$0$InlineAdAdapter(BaseAd baseAd) {
        baseAd.trackMpxAndThirdPartyImpressions();
        onAdShown();
        onAdResumeAutoRefresh();
    }

    /* access modifiers changed from: package-private */
    public void doInvalidate() {
        BaseAd baseAd = this.mBaseAd;
        if (baseAd != null) {
            try {
                baseAd.onInvalidate();
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM_WITH_THROWABLE, "Invalidating a base ad banner threw an exception", e);
            }
        }
        InlineVisibilityTracker inlineVisibilityTracker = this.mVisibilityTracker;
        if (inlineVisibilityTracker != null) {
            try {
                inlineVisibilityTracker.destroy();
            } catch (Exception e2) {
                MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM_WITH_THROWABLE, "Destroying a banner visibility tracker threw an exception", e2);
            }
            this.mVisibilityTracker = null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void parseBannerImpressionTrackingHeaders() {
        String impressionMinVisibleDips = this.mAdData.getImpressionMinVisibleDips();
        String impressionMinVisibleMs = this.mAdData.getImpressionMinVisibleMs();
        if (!TextUtils.isEmpty(impressionMinVisibleDips) && !TextUtils.isEmpty(impressionMinVisibleMs)) {
            try {
                this.mImpressionMinVisibleDips = Integer.parseInt(impressionMinVisibleDips);
            } catch (NumberFormatException unused) {
                MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, "Cannot parse integer from header banner-impression-min-pixels");
            }
            try {
                this.mImpressionMinVisibleMs = Integer.parseInt(impressionMinVisibleMs);
            } catch (NumberFormatException unused2) {
                MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, "Cannot parse integer from header banner-impression-min-ms");
            }
        }
    }
}
