package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.AdType;
import com.mopub.common.CloseableLayout;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.FullAdType;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.ViewabilityVendor;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Intents;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.MoPubWebViewController;
import com.mopub.mobileads.VastResource;
import com.mopub.mobileads.WebViewCacheService;
import com.mopub.mobileads.factories.HtmlControllerFactory;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;
import com.mopub.mraid.WebViewDebugListener;
import com.mopub.network.C2676Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import java.util.EnumSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class FullscreenAdController implements BaseVideoViewController.BaseVideoViewControllerListener, MraidController.UseCustomCloseListener {
    private static final EnumSet<UrlAction> SUPPORTED_URL_ACTIONS = EnumSet.of(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[]{UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
    private final Activity mActivity;
    private final AdData mAdData;
    private VastVideoBlurLastVideoFrameTask mBlurLastVideoFrameTask;
    private CloseableLayout mCloseableLayout;
    private CloseButtonCountdownRunnable mCountdownRunnable;
    private int mCurrentElapsedTimeMillis;
    private WebViewDebugListener mDebugListener;
    private String mImageClickDestinationUrl;
    /* access modifiers changed from: private */
    public ImageView mImageView;
    private boolean mIsCalibrationDone;
    /* access modifiers changed from: private */
    public final MoPubWebViewController mMoPubWebViewController;
    private boolean mOnVideoFinishCalled;
    private RadialCountdownWidget mRadialCountdownWidget;
    private boolean mRewardedCompletionFired;
    private VastCompanionAdConfig mSelectedVastCompanionAdConfig;
    private int mShowCloseButtonDelayMillis;
    private boolean mShowCloseButtonEventFired;
    /* access modifiers changed from: private */
    public ControllerState mState;
    private VideoCtaButtonWidget mVideoCtaButtonWidget;
    private int mVideoTimeElapsed;
    private BaseVideoViewController mVideoViewController;

    enum ControllerState {
        VIDEO,
        MRAID,
        HTML,
        IMAGE
    }

    static /* synthetic */ void lambda$new$1(BaseWebView baseWebView) {
    }

    public FullscreenAdController(Activity activity, Bundle bundle, Intent intent, AdData adData) {
        final Activity activity2 = activity;
        final AdData adData2 = adData;
        ControllerState controllerState = ControllerState.MRAID;
        this.mState = controllerState;
        this.mActivity = activity2;
        this.mAdData = adData2;
        WebViewCacheService.Config popWebViewConfig = WebViewCacheService.popWebViewConfig(Long.valueOf(adData.getBroadcastIdentifier()));
        if (popWebViewConfig != null && popWebViewConfig.getController() != null) {
            this.mMoPubWebViewController = popWebViewConfig.getController();
        } else if (AdType.HTML.equals(adData.getAdType())) {
            this.mMoPubWebViewController = HtmlControllerFactory.create(activity2, adData.getDspCreativeId());
        } else {
            this.mMoPubWebViewController = new MraidController(activity2, adData.getDspCreativeId(), PlacementType.INTERSTITIAL, adData.getAllowCustomClose());
        }
        String adPayload = adData.getAdPayload();
        if (TextUtils.isEmpty(adPayload)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "MoPubFullscreenActivity received an empty HTML body. Finishing the activity.");
            activity.finish();
            return;
        }
        MoPubWebViewController moPubWebViewController = this.mMoPubWebViewController;
        if (moPubWebViewController instanceof MraidController) {
            ((MraidController) moPubWebViewController).setUseCustomCloseListener(this);
        }
        this.mMoPubWebViewController.setDebugListener(this.mDebugListener);
        this.mMoPubWebViewController.setMoPubWebViewListener(new BaseHtmlWebView.BaseWebViewListener() {
            public void onExpand() {
            }

            public void onFailedToLoad(MoPubErrorCode moPubErrorCode) {
            }

            public void onResize(boolean z) {
            }

            public void onLoaded(View view) {
                if (ControllerState.HTML.equals(FullscreenAdController.this.mState) || ControllerState.MRAID.equals(FullscreenAdController.this.mState)) {
                    FullscreenAdController.this.mMoPubWebViewController.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
                }
            }

            public void onFailed() {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "FullscreenAdController failed to load. Finishing MoPubFullscreenActivity.");
                BaseBroadcastReceiver.broadcastAction(activity2, adData2.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_FAIL);
                activity2.finish();
            }

            public void onRenderProcessGone(MoPubErrorCode moPubErrorCode) {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "Finishing the activity due to a render process gone problem: " + moPubErrorCode);
                BaseBroadcastReceiver.broadcastAction(activity2, adData2.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_FAIL);
                activity2.finish();
            }

            public void onClicked() {
                FullscreenAdController.this.onAdClicked(activity2, adData2);
            }

            public void onClose() {
                BaseBroadcastReceiver.broadcastAction(activity2, adData2.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_DISMISS);
                FullscreenAdController.this.mMoPubWebViewController.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getJavascript());
                activity2.finish();
            }
        });
        this.mCloseableLayout = new CloseableLayout(activity2);
        if (FullAdType.VAST.equals(adData.getFullAdType())) {
            BaseVideoViewController createVideoViewController = createVideoViewController(activity2, bundle, intent, Long.valueOf(adData.getBroadcastIdentifier()));
            this.mVideoViewController = createVideoViewController;
            this.mState = ControllerState.VIDEO;
            createVideoViewController.onCreate();
            return;
        }
        if ("json".equals(adData.getFullAdType())) {
            this.mState = ControllerState.IMAGE;
            try {
                JSONObject jSONObject = new JSONObject(adData.getAdPayload());
                final String string = jSONObject.getString("image");
                int i = jSONObject.getInt("w");
                int i2 = jSONObject.getInt("h");
                this.mImageClickDestinationUrl = jSONObject.optString("clk");
                this.mImageView = new ImageView(activity2);
                C2676Networking.getImageLoader(activity).get(string, new ImageLoader.ImageListener() {
                    public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                        Bitmap bitmap = imageContainer.getBitmap();
                        if (FullscreenAdController.this.mImageView == null || bitmap == null) {
                            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format("%s returned null bitmap", new Object[]{string}));
                            return;
                        }
                        FullscreenAdController.this.mImageView.setAdjustViewBounds(true);
                        FullscreenAdController.this.mImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        bitmap.setDensity(160);
                        FullscreenAdController.this.mImageView.setImageBitmap(bitmap);
                    }

                    public void onErrorResponse(VolleyError volleyError) {
                        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format("Failed to retrieve image at %s", new Object[]{string}));
                    }
                }, i, i2, ImageView.ScaleType.CENTER_INSIDE);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.mImageView.setLayoutParams(layoutParams);
                this.mCloseableLayout.addView(this.mImageView);
                this.mCloseableLayout.setOnCloseListener(new CloseableLayout.OnCloseListener() {
                    public final void onClose() {
                        FullscreenAdController.this.lambda$new$0$FullscreenAdController();
                    }
                });
                if (adData.isRewarded()) {
                    this.mCloseableLayout.setCloseAlwaysInteractable(false);
                    this.mCloseableLayout.setCloseVisible(false);
                }
                activity2.setContentView(this.mCloseableLayout);
            } catch (JSONException unused) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Unable to load image into fullscreen container.");
                BaseBroadcastReceiver.broadcastAction(activity2, adData.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_FAIL);
                this.mActivity.finish();
                return;
            }
        } else {
            if (popWebViewConfig == null || popWebViewConfig.getController() == null) {
                this.mMoPubWebViewController.fillContent(adPayload, adData.getViewabilityVendors(), $$Lambda$FullscreenAdController$v0tMuALGannaXgyoChlQAPfb_WY.INSTANCE);
            }
            if (AdType.HTML.equals(adData.getAdType())) {
                this.mState = ControllerState.HTML;
            } else {
                this.mState = controllerState;
            }
            this.mCloseableLayout.setOnCloseListener(new CloseableLayout.OnCloseListener() {
                public final void onClose() {
                    FullscreenAdController.this.lambda$new$2$FullscreenAdController();
                }
            });
            this.mCloseableLayout.addView(this.mMoPubWebViewController.getAdContainer(), new FrameLayout.LayoutParams(-1, -1));
            if (adData.isRewarded()) {
                this.mCloseableLayout.setCloseAlwaysInteractable(false);
                this.mCloseableLayout.setCloseVisible(false);
            }
            activity2.setContentView(this.mCloseableLayout);
            this.mMoPubWebViewController.onShow(activity2);
        }
        if (ControllerState.HTML.equals(this.mState) || ControllerState.IMAGE.equals(this.mState)) {
            DeviceUtils.lockOrientation(activity2, adData.getOrientation() != null ? adData.getOrientation() : CreativeOrientation.DEVICE);
        }
        if (adData.isRewarded()) {
            addRadialCountdownWidget(activity2, 4);
            if (ControllerState.IMAGE.equals(this.mState)) {
                this.mShowCloseButtonDelayMillis = adData.getRewardedDurationSeconds() >= 0 ? adData.getRewardedDurationSeconds() * 1000 : 5000;
            } else {
                this.mShowCloseButtonDelayMillis = adData.getRewardedDurationSeconds() >= 0 ? adData.getRewardedDurationSeconds() * 1000 : 30000;
            }
            this.mRadialCountdownWidget.calibrateAndMakeVisible(this.mShowCloseButtonDelayMillis);
            this.mIsCalibrationDone = true;
            this.mCountdownRunnable = new CloseButtonCountdownRunnable(new Handler(Looper.getMainLooper()));
            return;
        }
        showCloseButton();
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$new$0 */
    public /* synthetic */ void lambda$new$0$FullscreenAdController() {
        destroy();
        this.mActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$new$2 */
    public /* synthetic */ void lambda$new$2$FullscreenAdController() {
        destroy();
        this.mActivity.finish();
    }

    /* access modifiers changed from: package-private */
    public BaseVideoViewController createVideoViewController(Activity activity, Bundle bundle, Intent intent, Long l) throws IllegalStateException {
        return new VastVideoViewController(activity, intent.getExtras(), bundle, l.longValue(), this);
    }

    public void onSetContentView(View view) {
        this.mActivity.setContentView(view);
    }

    public void onSetRequestedOrientation(int i) {
        this.mActivity.setRequestedOrientation(i);
    }

    public void onVideoFinish(int i) {
        if (this.mCloseableLayout == null || this.mSelectedVastCompanionAdConfig == null) {
            destroy();
            this.mActivity.finish();
        } else if (!this.mOnVideoFinishCalled) {
            this.mOnVideoFinishCalled = true;
            this.mVideoTimeElapsed = i;
            BaseVideoViewController baseVideoViewController = this.mVideoViewController;
            if (baseVideoViewController != null) {
                baseVideoViewController.onPause();
                this.mVideoViewController.onDestroy();
                this.mVideoViewController = null;
            }
            this.mCloseableLayout.removeAllViews();
            this.mCloseableLayout.setOnCloseListener(new CloseableLayout.OnCloseListener() {
                public final void onClose() {
                    FullscreenAdController.this.lambda$onVideoFinish$3$FullscreenAdController();
                }
            });
            VastResource vastResource = this.mSelectedVastCompanionAdConfig.getVastResource();
            if ((!VastResource.Type.STATIC_RESOURCE.equals(vastResource.getType()) || !VastResource.CreativeType.IMAGE.equals(vastResource.getCreativeType())) && !VastResource.Type.BLURRED_LAST_FRAME.equals(vastResource.getType())) {
                this.mState = ControllerState.MRAID;
                this.mCloseableLayout.addView(this.mMoPubWebViewController.getAdContainer(), new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mState = ControllerState.IMAGE;
                if (this.mImageView == null) {
                    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Companion image null. Skipping.");
                    destroy();
                    this.mActivity.finish();
                    return;
                }
                RelativeLayout relativeLayout = new RelativeLayout(this.mActivity);
                this.mImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ViewGroup viewGroup = (ViewGroup) this.mImageView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mImageView);
                }
                relativeLayout.addView(this.mImageView);
                VideoCtaButtonWidget videoCtaButtonWidget = this.mVideoCtaButtonWidget;
                if (videoCtaButtonWidget != null) {
                    ViewGroup viewGroup2 = (ViewGroup) videoCtaButtonWidget.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.mVideoCtaButtonWidget);
                    }
                    relativeLayout.addView(this.mVideoCtaButtonWidget);
                }
                this.mCloseableLayout.addView(relativeLayout);
            }
            if (this.mAdData.isRewarded()) {
                this.mCloseableLayout.setCloseAlwaysInteractable(false);
                this.mCloseableLayout.setCloseVisible(false);
            }
            this.mActivity.setContentView(this.mCloseableLayout);
            this.mMoPubWebViewController.onShow(this.mActivity);
            if (this.mAdData.isRewarded()) {
                int rewardedDurationSeconds = this.mAdData.getRewardedDurationSeconds() >= 0 ? this.mAdData.getRewardedDurationSeconds() * 1000 : 30000;
                this.mShowCloseButtonDelayMillis = rewardedDurationSeconds;
                if (i >= rewardedDurationSeconds || VastResource.Type.BLURRED_LAST_FRAME.equals(this.mSelectedVastCompanionAdConfig.getVastResource().getType())) {
                    this.mCloseableLayout.setCloseAlwaysInteractable(true);
                    showCloseButton();
                } else {
                    addRadialCountdownWidget(this.mActivity, 4);
                    this.mRadialCountdownWidget.calibrateAndMakeVisible(this.mShowCloseButtonDelayMillis);
                    this.mRadialCountdownWidget.updateCountdownProgress(this.mShowCloseButtonDelayMillis, i);
                    this.mIsCalibrationDone = true;
                    CloseButtonCountdownRunnable closeButtonCountdownRunnable = new CloseButtonCountdownRunnable(new Handler(Looper.getMainLooper()));
                    this.mCountdownRunnable = closeButtonCountdownRunnable;
                    int unused = closeButtonCountdownRunnable.mCurrentElapsedTimeMillis = i;
                    startRunnables();
                }
            } else {
                this.mCloseableLayout.setCloseAlwaysInteractable(true);
                showCloseButton();
            }
            this.mSelectedVastCompanionAdConfig.handleImpression(this.mActivity, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onVideoFinish$3 */
    public /* synthetic */ void lambda$onVideoFinish$3$FullscreenAdController() {
        destroy();
        this.mActivity.finish();
    }

    public void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle) {
        if (cls != null) {
            try {
                this.mActivity.startActivityForResult(Intents.getStartActivityIntent(this.mActivity, cls, bundle), i);
            } catch (ActivityNotFoundException unused) {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "Activity " + cls.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            }
        }
    }

    public void onCompanionAdsReady(Set<VastCompanionAdConfig> set, int i) {
        Preconditions.checkNotNull(set);
        if (this.mCloseableLayout == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "CloseableLayout is null. This should not happen.");
        }
        DisplayMetrics displayMetrics = this.mActivity.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        int i4 = (int) (((float) i2) / f);
        int i5 = (int) (((float) i3) / f);
        VastCompanionAdConfig vastCompanionAdConfig = null;
        for (VastCompanionAdConfig next : set) {
            if (next != null && (vastCompanionAdConfig == null || next.calculateScore(i4, i5) > vastCompanionAdConfig.calculateScore(i4, i5))) {
                vastCompanionAdConfig = next;
            }
        }
        this.mSelectedVastCompanionAdConfig = vastCompanionAdConfig;
        if (vastCompanionAdConfig != null) {
            final VastResource vastResource = vastCompanionAdConfig.getVastResource();
            String htmlResourceValue = vastResource.getHtmlResourceValue();
            if (!TextUtils.isEmpty(htmlResourceValue)) {
                if (VastResource.Type.STATIC_RESOURCE.equals(vastResource.getType()) && VastResource.CreativeType.IMAGE.equals(vastResource.getCreativeType())) {
                    this.mImageView = new ImageView(this.mActivity);
                    C2676Networking.getImageLoader(this.mActivity).get(vastResource.getResource(), new ImageLoader.ImageListener() {
                        public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                            Bitmap bitmap = imageContainer.getBitmap();
                            if (FullscreenAdController.this.mImageView == null || bitmap == null) {
                                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format("%s returned null bitmap", new Object[]{vastResource.getResource()}));
                                return;
                            }
                            FullscreenAdController.this.mImageView.setAdjustViewBounds(true);
                            FullscreenAdController.this.mImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            bitmap.setDensity(160);
                            FullscreenAdController.this.mImageView.setImageBitmap(bitmap);
                        }

                        public void onErrorResponse(VolleyError volleyError) {
                            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format("Failed to retrieve image at %s", new Object[]{vastResource.getResource()}));
                        }
                    }, this.mSelectedVastCompanionAdConfig.getWidth(), this.mSelectedVastCompanionAdConfig.getHeight(), ImageView.ScaleType.CENTER_INSIDE);
                    this.mImageView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            FullscreenAdController.this.lambda$onCompanionAdsReady$4$FullscreenAdController(view);
                        }
                    });
                } else if (VastResource.Type.BLURRED_LAST_FRAME.equals(vastResource.getType())) {
                    ImageView imageView = new ImageView(this.mActivity);
                    this.mImageView = imageView;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            FullscreenAdController.this.lambda$onCompanionAdsReady$5$FullscreenAdController(view);
                        }
                    });
                    VastVideoBlurLastVideoFrameTask vastVideoBlurLastVideoFrameTask = new VastVideoBlurLastVideoFrameTask(new MediaMetadataRetriever(), this.mImageView, i);
                    this.mBlurLastVideoFrameTask = vastVideoBlurLastVideoFrameTask;
                    AsyncTasks.safeExecuteOnExecutor(vastVideoBlurLastVideoFrameTask, vastResource.getResource());
                    if (!TextUtils.isEmpty(this.mSelectedVastCompanionAdConfig.getClickThroughUrl())) {
                        this.mVideoCtaButtonWidget = new VideoCtaButtonWidget(this.mActivity, false, true);
                        String customCtaText = this.mSelectedVastCompanionAdConfig.getCustomCtaText();
                        if (!TextUtils.isEmpty(customCtaText)) {
                            this.mVideoCtaButtonWidget.updateCtaText(customCtaText);
                        }
                        this.mVideoCtaButtonWidget.notifyVideoComplete();
                        this.mVideoCtaButtonWidget.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                FullscreenAdController.this.lambda$onCompanionAdsReady$6$FullscreenAdController(view);
                            }
                        });
                    }
                } else {
                    this.mMoPubWebViewController.fillContent(htmlResourceValue, (Set<ViewabilityVendor>) null, (MoPubWebViewController.WebViewCacheListener) null);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onCompanionAdsReady$4 */
    public /* synthetic */ void lambda$onCompanionAdsReady$4$FullscreenAdController(View view) {
        onAdClicked(this.mActivity, this.mAdData);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onCompanionAdsReady$5 */
    public /* synthetic */ void lambda$onCompanionAdsReady$5$FullscreenAdController(View view) {
        onAdClicked(this.mActivity, this.mAdData);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$onCompanionAdsReady$6 */
    public /* synthetic */ void lambda$onCompanionAdsReady$6$FullscreenAdController(View view) {
        onAdClicked(this.mActivity, this.mAdData);
    }

    public void useCustomCloseChanged(boolean z) {
        if (this.mCloseableLayout != null) {
            if (z && !this.mAdData.isRewarded()) {
                this.mCloseableLayout.setCloseVisible(false);
            } else if (this.mShowCloseButtonEventFired) {
                this.mCloseableLayout.setCloseVisible(true);
            }
        }
    }

    public void pause() {
        BaseVideoViewController baseVideoViewController = this.mVideoViewController;
        if (baseVideoViewController != null) {
            baseVideoViewController.onPause();
        }
        if (ControllerState.HTML.equals(this.mState) || ControllerState.MRAID.equals(this.mState)) {
            this.mMoPubWebViewController.pause(false);
        }
        stopRunnables();
    }

    public void resume() {
        BaseVideoViewController baseVideoViewController = this.mVideoViewController;
        if (baseVideoViewController != null) {
            baseVideoViewController.onResume();
        }
        if (ControllerState.HTML.equals(this.mState) || ControllerState.MRAID.equals(this.mState)) {
            this.mMoPubWebViewController.resume();
        }
        startRunnables();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        BaseVideoViewController baseVideoViewController = this.mVideoViewController;
        if (baseVideoViewController != null) {
            baseVideoViewController.onActivityResult(i, i2, intent);
        }
    }

    public void destroy() {
        this.mMoPubWebViewController.destroy();
        BaseVideoViewController baseVideoViewController = this.mVideoViewController;
        if (baseVideoViewController != null) {
            baseVideoViewController.onDestroy();
            this.mVideoViewController = null;
        }
        stopRunnables();
        VastVideoBlurLastVideoFrameTask vastVideoBlurLastVideoFrameTask = this.mBlurLastVideoFrameTask;
        if (vastVideoBlurLastVideoFrameTask != null) {
            vastVideoBlurLastVideoFrameTask.cancel(true);
        }
        BaseBroadcastReceiver.broadcastAction(this.mActivity, this.mAdData.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_DISMISS);
    }

    /* access modifiers changed from: package-private */
    public boolean backButtonEnabled() {
        BaseVideoViewController baseVideoViewController;
        if (ControllerState.VIDEO.equals(this.mState) && (baseVideoViewController = this.mVideoViewController) != null) {
            return baseVideoViewController.backButtonEnabled();
        }
        if (ControllerState.MRAID.equals(this.mState) || ControllerState.IMAGE.equals(this.mState)) {
            return this.mShowCloseButtonEventFired;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isCloseable() {
        return !this.mShowCloseButtonEventFired && this.mCurrentElapsedTimeMillis >= this.mShowCloseButtonDelayMillis;
    }

    /* access modifiers changed from: package-private */
    public void showCloseButton() {
        this.mShowCloseButtonEventFired = true;
        RadialCountdownWidget radialCountdownWidget = this.mRadialCountdownWidget;
        if (radialCountdownWidget != null) {
            radialCountdownWidget.setVisibility(8);
        }
        CloseableLayout closeableLayout = this.mCloseableLayout;
        if (closeableLayout != null) {
            closeableLayout.setCloseVisible(true);
        }
        if (!this.mRewardedCompletionFired && this.mAdData.isRewarded()) {
            BaseBroadcastReceiver.broadcastAction(this.mActivity, this.mAdData.getBroadcastIdentifier(), IntentActions.ACTION_REWARDED_AD_COMPLETE);
            this.mRewardedCompletionFired = true;
        }
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FullscreenAdController.this.lambda$showCloseButton$7$FullscreenAdController(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$showCloseButton$7 */
    public /* synthetic */ void lambda$showCloseButton$7$FullscreenAdController(View view) {
        onAdClicked(this.mActivity, this.mAdData);
    }

    /* access modifiers changed from: private */
    public void updateCountdown(int i) {
        RadialCountdownWidget radialCountdownWidget;
        this.mCurrentElapsedTimeMillis = i;
        if (this.mIsCalibrationDone && (radialCountdownWidget = this.mRadialCountdownWidget) != null) {
            radialCountdownWidget.updateCountdownProgress(this.mShowCloseButtonDelayMillis, i);
        }
    }

    private void startRunnables() {
        CloseButtonCountdownRunnable closeButtonCountdownRunnable = this.mCountdownRunnable;
        if (closeButtonCountdownRunnable != null) {
            closeButtonCountdownRunnable.startRepeating(250);
        }
    }

    private void stopRunnables() {
        CloseButtonCountdownRunnable closeButtonCountdownRunnable = this.mCountdownRunnable;
        if (closeButtonCountdownRunnable != null) {
            closeButtonCountdownRunnable.stop();
        }
    }

    private void addRadialCountdownWidget(Context context, int i) {
        RadialCountdownWidget radialCountdownWidget = new RadialCountdownWidget(context);
        this.mRadialCountdownWidget = radialCountdownWidget;
        radialCountdownWidget.setVisibility(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRadialCountdownWidget.getLayoutParams();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
        layoutParams.rightMargin = Dips.dipsToIntPixels(4.0f, context);
        layoutParams.topMargin = Dips.dipsToIntPixels(4.0f, context);
        layoutParams.gravity = 53;
        this.mCloseableLayout.addView(this.mRadialCountdownWidget, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void onAdClicked(Activity activity, AdData adData) {
        String str;
        VastCompanionAdConfig vastCompanionAdConfig = this.mSelectedVastCompanionAdConfig;
        if (vastCompanionAdConfig != null && !TextUtils.isEmpty(vastCompanionAdConfig.getClickThroughUrl()) && ControllerState.IMAGE.equals(this.mState)) {
            BaseBroadcastReceiver.broadcastAction(activity, adData.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_CLICK);
            TrackingRequest.makeVastTrackingHttpRequest(this.mSelectedVastCompanionAdConfig.getClickTrackers(), (VastErrorCode) null, Integer.valueOf(this.mVideoTimeElapsed), (String) null, activity);
            this.mSelectedVastCompanionAdConfig.handleClick(activity, 1, (String) null, adData.getDspCreativeId());
        } else if (this.mSelectedVastCompanionAdConfig != null && ControllerState.MRAID.equals(this.mState)) {
            BaseBroadcastReceiver.broadcastAction(activity, adData.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_CLICK);
            TrackingRequest.makeVastTrackingHttpRequest(this.mSelectedVastCompanionAdConfig.getClickTrackers(), (VastErrorCode) null, Integer.valueOf(this.mVideoTimeElapsed), (String) null, activity);
        } else if (this.mSelectedVastCompanionAdConfig == null && ControllerState.IMAGE.equals(this.mState) && (str = this.mImageClickDestinationUrl) != null && !TextUtils.isEmpty(str)) {
            BaseBroadcastReceiver.broadcastAction(activity, adData.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_CLICK);
            new UrlHandler.Builder().withDspCreativeId(this.mAdData.getDspCreativeId()).withSupportedUrlActions(SUPPORTED_URL_ACTIONS).build().handleUrl(this.mActivity, this.mImageClickDestinationUrl);
        } else if (this.mSelectedVastCompanionAdConfig != null) {
        } else {
            if (ControllerState.MRAID.equals(this.mState) || ControllerState.HTML.equals(this.mState)) {
                BaseBroadcastReceiver.broadcastAction(activity, adData.getBroadcastIdentifier(), IntentActions.ACTION_FULLSCREEN_CLICK);
            }
        }
    }

    static class CloseButtonCountdownRunnable extends RepeatingHandlerRunnable {
        private final FullscreenAdController mController;
        /* access modifiers changed from: private */
        public int mCurrentElapsedTimeMillis;

        private CloseButtonCountdownRunnable(FullscreenAdController fullscreenAdController, Handler handler) {
            super(handler);
            Preconditions.checkNotNull(handler);
            Preconditions.checkNotNull(fullscreenAdController);
            this.mController = fullscreenAdController;
        }

        public void doWork() {
            int i = (int) (((long) this.mCurrentElapsedTimeMillis) + this.mUpdateIntervalMillis);
            this.mCurrentElapsedTimeMillis = i;
            this.mController.updateCountdown(i);
            if (this.mController.isCloseable()) {
                this.mController.showCloseButton();
            }
        }
    }
}
