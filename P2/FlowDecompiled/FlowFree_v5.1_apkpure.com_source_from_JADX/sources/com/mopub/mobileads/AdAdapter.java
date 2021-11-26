package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;

public abstract class AdAdapter implements AdLifecycleListener.LoadListener, AdLifecycleListener.InteractionListener {
    protected AdData mAdData;
    protected BaseAd mBaseAd;
    protected Context mContext;
    protected AdLifecycleListener.InteractionListener mInteractionListener;
    protected boolean mInvalidated;
    protected boolean mIsReady = false;
    protected AdLifecycleListener.LoadListener mLoadListener;
    private final Handler mMainHandler;
    protected final Runnable mTimeout;

    /* access modifiers changed from: package-private */
    public abstract void doInvalidate();

    /* access modifiers changed from: package-private */
    public abstract void show(MoPubAd moPubAd);

    public AdAdapter(Context context, String str, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(adData);
        this.mContext = context;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mAdData = adData;
        this.mTimeout = new Runnable() {
            public final void run() {
                AdAdapter.this.lambda$new$0$AdAdapter();
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$new$0 */
    public /* synthetic */ void lambda$new$0$AdAdapter() {
        MoPubLog.AdLogEvent adLogEvent = MoPubLog.AdLogEvent.CUSTOM_WITH_THROWABLE;
        MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_TIMEOUT;
        MoPubLog.log(adLogEvent, "AdAdapter() failed", moPubErrorCode);
        onAdLoadFailed(moPubErrorCode);
        this.mMainHandler.post(new Runnable() {
            public final void run() {
                AdAdapter.this.invalidate();
            }
        });
    }

    public final void load(AdLifecycleListener.LoadListener loadListener) {
        Preconditions.checkNotNull(loadListener);
        MoPubLog.log(MoPubLog.AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
        if (!isInvalidated() && this.mBaseAd != null) {
            this.mLoadListener = loadListener;
            this.mMainHandler.postDelayed(this.mTimeout, (long) getTimeoutDelayMilliseconds());
            try {
                this.mBaseAd.internalLoad(this.mContext, this, this.mAdData);
            } catch (Exception unused) {
                MoPubLog.AdLogEvent adLogEvent = MoPubLog.AdLogEvent.LOAD_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
                MoPubLog.log(adLogEvent, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                onAdLoadFailed(moPubErrorCode);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidate() {
        doInvalidate();
        this.mBaseAd = null;
        this.mContext = null;
        this.mAdData = null;
        this.mLoadListener = null;
        this.mInteractionListener = null;
        this.mInvalidated = true;
        this.mIsReady = false;
    }

    public boolean isReady() {
        return this.mIsReady;
    }

    private int getTimeoutDelayMilliseconds() {
        return this.mAdData.getTimeoutDelayMillis();
    }

    public String getBaseAdClassName() {
        BaseAd baseAd = this.mBaseAd;
        if (baseAd != null) {
            return baseAd.getClass().getName();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void setInteractionListener(AdLifecycleListener.InteractionListener interactionListener) {
        Preconditions.checkNotNull(interactionListener);
        this.mInteractionListener = interactionListener;
    }

    /* access modifiers changed from: package-private */
    public boolean isInvalidated() {
        return this.mInvalidated;
    }

    private void cancelTimeout() {
        this.mMainHandler.removeCallbacks(this.mTimeout);
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        BaseAd baseAd = this.mBaseAd;
        return baseAd != null ? baseAd.getAdNetworkId() : "";
    }

    /* access modifiers changed from: protected */
    public boolean isAutomaticImpressionAndClickTrackingEnabled() {
        BaseAd baseAd = this.mBaseAd;
        if (baseAd == null) {
            return true;
        }
        return baseAd.isAutomaticImpressionAndClickTrackingEnabled();
    }

    public void onAdLoaded() {
        if (!isInvalidated()) {
            MoPubLog.log(MoPubLog.AdLogEvent.LOAD_SUCCESS, new Object[0]);
            this.mIsReady = true;
            cancelTimeout();
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AdAdapter.this.lambda$onAdLoaded$1$AdAdapter();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdLoaded$1 */
    public /* synthetic */ void lambda$onAdLoaded$1$AdAdapter() {
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onAdLoaded();
        }
    }

    public void onAdLoadFailed(MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(moPubErrorCode);
        if (!isInvalidated()) {
            cancelTimeout();
            this.mMainHandler.post(new Runnable(moPubErrorCode) {
                public final /* synthetic */ MoPubErrorCode f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AdAdapter.this.lambda$onAdLoadFailed$2$AdAdapter(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdLoadFailed$2 */
    public /* synthetic */ void lambda$onAdLoadFailed$2$AdAdapter(MoPubErrorCode moPubErrorCode) {
        AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
        if (loadListener != null) {
            loadListener.onAdLoadFailed(moPubErrorCode);
        }
    }

    public void onAdFailed(MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(moPubErrorCode);
        if (!isInvalidated()) {
            cancelTimeout();
            this.mMainHandler.post(new Runnable(moPubErrorCode) {
                public final /* synthetic */ MoPubErrorCode f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AdAdapter.this.lambda$onAdFailed$3$AdAdapter(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdFailed$3 */
    public /* synthetic */ void lambda$onAdFailed$3$AdAdapter(MoPubErrorCode moPubErrorCode) {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdFailed(moPubErrorCode);
        }
    }

    public void onAdShown() {
        if (!isInvalidated()) {
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AdAdapter.this.lambda$onAdShown$4$AdAdapter();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdShown$4 */
    public /* synthetic */ void lambda$onAdShown$4$AdAdapter() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdShown();
        }
        BaseAd baseAd = this.mBaseAd;
        if (baseAd == null || baseAd.isAutomaticImpressionAndClickTrackingEnabled()) {
            AdLifecycleListener.InteractionListener interactionListener2 = this.mInteractionListener;
            if (interactionListener2 != null) {
                interactionListener2.onAdImpression();
            }
            if (baseAd != null) {
                baseAd.trackMpxAndThirdPartyImpressions();
            }
        }
    }

    public void onAdClicked() {
        if (!isInvalidated()) {
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AdAdapter.this.lambda$onAdClicked$5$AdAdapter();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdClicked$5 */
    public /* synthetic */ void lambda$onAdClicked$5$AdAdapter() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdClicked();
        }
    }

    public void onAdImpression() {
        if (!isInvalidated()) {
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AdAdapter.this.lambda$onAdImpression$6$AdAdapter();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdImpression$6 */
    public /* synthetic */ void lambda$onAdImpression$6$AdAdapter() {
        BaseAd baseAd = this.mBaseAd;
        if (baseAd != null && !baseAd.isAutomaticImpressionAndClickTrackingEnabled()) {
            AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdImpression();
            }
            baseAd.trackMpxAndThirdPartyImpressions();
        }
    }

    public void onAdDismissed() {
        if (!isInvalidated()) {
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AdAdapter.this.lambda$onAdDismissed$7$AdAdapter();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdDismissed$7 */
    public /* synthetic */ void lambda$onAdDismissed$7$AdAdapter() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdDismissed();
        }
    }

    public void onAdComplete(MoPubReward moPubReward) {
        if (!isInvalidated()) {
            this.mMainHandler.post(new Runnable(moPubReward) {
                public final /* synthetic */ MoPubReward f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AdAdapter.this.lambda$onAdComplete$8$AdAdapter(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdComplete$8 */
    public /* synthetic */ void lambda$onAdComplete$8$AdAdapter(MoPubReward moPubReward) {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdComplete(moPubReward);
        }
    }

    public void onAdResumeAutoRefresh() {
        this.mMainHandler.post(new Runnable() {
            public final void run() {
                AdAdapter.this.lambda$onAdResumeAutoRefresh$9$AdAdapter();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdResumeAutoRefresh$9 */
    public /* synthetic */ void lambda$onAdResumeAutoRefresh$9$AdAdapter() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdResumeAutoRefresh();
        }
    }

    public void onAdPauseAutoRefresh() {
        this.mMainHandler.post(new Runnable() {
            public final void run() {
                AdAdapter.this.lambda$onAdPauseAutoRefresh$10$AdAdapter();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdPauseAutoRefresh$10 */
    public /* synthetic */ void lambda$onAdPauseAutoRefresh$10$AdAdapter() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdPauseAutoRefresh();
        }
    }

    public void onAdExpanded() {
        if (!isInvalidated()) {
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AdAdapter.this.lambda$onAdExpanded$11$AdAdapter();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdExpanded$11 */
    public /* synthetic */ void lambda$onAdExpanded$11$AdAdapter() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdExpanded();
        }
    }

    public void onAdCollapsed() {
        if (!isInvalidated()) {
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    AdAdapter.this.lambda$onAdCollapsed$12$AdAdapter();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onAdCollapsed$12 */
    public /* synthetic */ void lambda$onAdCollapsed$12$AdAdapter() {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdCollapsed();
        }
    }

    public static class BaseAdNotFoundException extends Exception {
        public BaseAdNotFoundException(Exception exc) {
            exc.getMessage();
            exc.getCause();
            MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM_WITH_THROWABLE, "AdAdapter.create() failed with exception", exc);
        }
    }
}
