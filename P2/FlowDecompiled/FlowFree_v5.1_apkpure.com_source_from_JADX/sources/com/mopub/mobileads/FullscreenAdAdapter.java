package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdAdapter;
import com.mopub.mobileads.WebViewCacheService;
import com.mopub.mobileads.factories.BaseAdFactory;

public class FullscreenAdAdapter extends AdAdapter {
    private long mBroadcastIdentifier;

    public void onAdPauseAutoRefresh() {
    }

    public void onAdResumeAutoRefresh() {
    }

    public FullscreenAdAdapter(Context context, String str, AdData adData) throws AdAdapter.BaseAdNotFoundException {
        super(context, str, adData);
        this.mBroadcastIdentifier = adData.getBroadcastIdentifier();
        adData.getExtras();
        adData.getDspCreativeId();
        if (context instanceof Activity) {
            MoPubLog.AdLogEvent adLogEvent = MoPubLog.AdLogEvent.CUSTOM;
            MoPubLog.log(adLogEvent, "Attempting to invoke base ad: " + str);
            try {
                this.mBaseAd = BaseAdFactory.create(str);
            } catch (Exception e) {
                throw new AdAdapter.BaseAdNotFoundException(e);
            }
        } else {
            throw new IllegalArgumentException("An Activity Context is required.");
        }
    }

    /* access modifiers changed from: package-private */
    public void show(MoPubAd moPubAd) {
        BaseAd baseAd;
        MoPubLog.log(MoPubLog.AdLogEvent.SHOW_ATTEMPTED, new Object[0]);
        if (!isInvalidated() && (baseAd = this.mBaseAd) != null) {
            try {
                baseAd.internalShow(this);
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM_WITH_THROWABLE, "Calling show on base ad threw an exception.", e);
                MoPubLog.AdLogEvent adLogEvent = MoPubLog.AdLogEvent.SHOW_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.FULLSCREEN_SHOW_ERROR;
                MoPubLog.log(adLogEvent, moPubErrorCode, Integer.valueOf(moPubErrorCode.getIntCode()));
                onAdFailed(moPubErrorCode);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void doInvalidate() {
        BaseAd baseAd = this.mBaseAd;
        if (baseAd != null) {
            try {
                baseAd.onInvalidate();
            } catch (Exception e) {
                MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM_WITH_THROWABLE, "Invalidating a base ad interstitial threw an exception.", e);
            }
        }
        WebViewCacheService.Config popWebViewConfig = WebViewCacheService.popWebViewConfig(Long.valueOf(this.mBroadcastIdentifier));
        if (popWebViewConfig != null) {
            popWebViewConfig.invalidate();
        }
    }
}
