package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.AdLifecycleListener;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.MoPubWebViewController;
import com.mopub.mobileads.factories.HtmlControllerFactory;
import com.mopub.mobileads.factories.MraidControllerFactory;
import com.mopub.mraid.PlacementType;
import com.mopub.mraid.WebViewDebugListener;
import java.util.Map;

public class MoPubInline extends BaseAd {
    public static final String ADAPTER_NAME = "MoPubInline";
    private AdData mAdData;
    /* access modifiers changed from: private */
    public Runnable mAdExpiration;
    private Context mContext;
    private MoPubWebViewController mController;
    private WebViewDebugListener mDebugListener;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        MoPubLog.AdLogEvent adLogEvent = MoPubLog.AdLogEvent.LOAD_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adLogEvent, str);
        this.mContext = context;
        this.mAdData = adData;
        this.mHandler = new Handler();
        this.mAdExpiration = new Runnable() {
            public final void run() {
                MoPubInline.this.lambda$load$0$MoPubInline();
            }
        };
        Map<String, String> extras = this.mAdData.getExtras();
        String dspCreativeId = this.mAdData.getDspCreativeId();
        if (!extrasAreValid(extras)) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.INLINE_LOAD_ERROR;
            MoPubLog.log(adapterLogEvent, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            this.mLoadListener.onAdLoadFailed(moPubErrorCode);
            return;
        }
        if ("mraid".equals(this.mAdData.getAdType())) {
            this.mController = MraidControllerFactory.create(this.mContext, dspCreativeId, PlacementType.INLINE, this.mAdData.getAllowCustomClose());
        } else if (AdType.HTML.equals(this.mAdData.getAdType())) {
            this.mController = HtmlControllerFactory.create(context, dspCreativeId);
        } else {
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.INLINE_LOAD_ERROR;
            MoPubLog.log(adapterLogEvent2, str, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
            this.mLoadListener.onAdLoadFailed(moPubErrorCode2);
            return;
        }
        this.mController.setDebugListener(this.mDebugListener);
        this.mController.setMoPubWebViewListener(new BaseHtmlWebView.BaseWebViewListener() {
            public void onLoaded(View view) {
                AdViewController.setShouldHonorServerDimensions(view);
                MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_SUCCESS, MoPubInline.ADAPTER_NAME);
                MoPubInline.this.mLoadListener.onAdLoaded();
                if (MoPubInline.this.mHandler != null) {
                    MoPubInline.this.mHandler.postDelayed(MoPubInline.this.mAdExpiration, 14400000);
                }
            }

            public void onFailedToLoad(MoPubErrorCode moPubErrorCode) {
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_FAILED;
                MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.INLINE_LOAD_ERROR;
                MoPubLog.log(adapterLogEvent, MoPubInline.ADAPTER_NAME, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
                MoPubInline.this.mLoadListener.onAdLoadFailed(moPubErrorCode2);
            }

            public void onFailed() {
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_FAILED;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.INLINE_SHOW_ERROR;
                MoPubLog.log(adapterLogEvent, MoPubInline.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                AdLifecycleListener.InteractionListener interactionListener = MoPubInline.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdFailed(moPubErrorCode);
                }
            }

            public void onRenderProcessGone(MoPubErrorCode moPubErrorCode) {
                MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_FAILED, MoPubInline.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                AdLifecycleListener.InteractionListener interactionListener = MoPubInline.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdFailed(moPubErrorCode);
                }
            }

            public void onClicked() {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CLICKED, MoPubInline.ADAPTER_NAME);
                AdLifecycleListener.InteractionListener interactionListener = MoPubInline.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdClicked();
                }
            }

            public void onExpand() {
                AdLifecycleListener.InteractionListener interactionListener = MoPubInline.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdExpanded();
                }
            }

            public void onResize(boolean z) {
                AdLifecycleListener.InteractionListener interactionListener = MoPubInline.this.mInteractionListener;
                if (interactionListener != null) {
                    if (z) {
                        interactionListener.onAdResumeAutoRefresh();
                    } else {
                        interactionListener.onAdPauseAutoRefresh();
                    }
                }
            }

            public void onClose() {
                AdLifecycleListener.InteractionListener interactionListener = MoPubInline.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdCollapsed();
                }
            }
        });
        this.mController.fillContent(this.mAdData.getAdPayload(), adData.getViewabilityVendors(), new MoPubWebViewController.WebViewCacheListener(this) {
            public void onReady(BaseWebView baseWebView) {
                baseWebView.getSettings().setJavaScriptEnabled(true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$load$0 */
    public /* synthetic */ void lambda$load$0$MoPubInline() {
        MoPubLog.log(MoPubLog.AdapterLogEvent.EXPIRED, ADAPTER_NAME, "time in seconds");
        this.mInteractionListener.onAdFailed(MoPubErrorCode.EXPIRED);
    }

    /* access modifiers changed from: protected */
    public View getAdView() {
        MoPubWebViewController moPubWebViewController = this.mController;
        if (moPubWebViewController != null) {
            return moPubWebViewController.getAdContainer();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        Runnable runnable;
        Handler handler = this.mHandler;
        if (!(handler == null || (runnable = this.mAdExpiration) == null)) {
            handler.removeCallbacks(runnable);
        }
        this.mAdExpiration = null;
        this.mHandler = null;
        MoPubWebViewController moPubWebViewController = this.mController;
        if (moPubWebViewController != null) {
            moPubWebViewController.setMoPubWebViewListener((BaseHtmlWebView.BaseWebViewListener) null);
            this.mController.destroy();
            this.mController = null;
        }
    }

    /* access modifiers changed from: protected */
    public void trackMpxAndThirdPartyImpressions() {
        MoPubWebViewController moPubWebViewController = this.mController;
        if (moPubWebViewController != null) {
            moPubWebViewController.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
        }
    }

    @VisibleForTesting
    public void setDebugListener(WebViewDebugListener webViewDebugListener) {
        this.mDebugListener = webViewDebugListener;
        MoPubWebViewController moPubWebViewController = this.mController;
        if (moPubWebViewController != null) {
            moPubWebViewController.setDebugListener(webViewDebugListener);
        }
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        AdData adData = this.mAdData;
        return (adData == null || adData.getAdUnit() == null) ? "" : this.mAdData.getAdUnit();
    }

    private boolean extrasAreValid(Map<String, String> map) {
        return map.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }
}
