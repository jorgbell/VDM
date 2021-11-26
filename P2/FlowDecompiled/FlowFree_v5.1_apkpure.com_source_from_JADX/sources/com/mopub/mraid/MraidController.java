package com.mopub.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import com.mopub.common.CloseableLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Utils;
import com.mopub.common.util.Views;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.BaseWebViewViewability;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubWebViewController;
import com.mopub.mobileads.util.WebViews;
import com.mopub.mraid.MraidBridge;
import java.net.URI;
import java.util.EnumSet;

public class MraidController extends MoPubWebViewController {
    private boolean mAllowOrientationChange;
    private final CloseableLayout mCloseableAdContainer;
    private UrlHandler.MoPubSchemeListener mDebugSchemeListener;
    private String mDspCreativeId;
    private MraidOrientation mForceOrientation;
    /* access modifiers changed from: private */
    public final MraidBridge mMraidBridge;
    private final MraidBridge.MraidBridgeListener mMraidBridgeListener;
    /* access modifiers changed from: private */
    public final MraidNativeCommandHandler mMraidNativeCommandHandler;
    private UseCustomCloseListener mOnCloseButtonListener;
    private OrientationBroadcastReceiver mOrientationBroadcastReceiver;
    private Integer mOriginalActivityOrientation;
    /* access modifiers changed from: private */
    public final PlacementType mPlacementType;
    private ViewGroup mRootView;
    /* access modifiers changed from: private */
    public final MraidScreenMetrics mScreenMetrics;
    private final MoPubWebViewController.ScreenMetricsWaiter mScreenMetricsWaiter;
    /* access modifiers changed from: private */
    public final MraidBridge mTwoPartBridge;
    private final MraidBridge.MraidBridgeListener mTwoPartBridgeListener;
    private MraidBridge.MraidWebView mTwoPartWebView;
    /* access modifiers changed from: private */
    public ViewState mViewState;

    public interface UseCustomCloseListener {
        void useCustomCloseChanged(boolean z);
    }

    public MraidController(Context context, String str, PlacementType placementType, boolean z) {
        this(context, str, placementType, new MraidBridge(placementType, z), new MraidBridge(PlacementType.INTERSTITIAL, z), new MoPubWebViewController.ScreenMetricsWaiter());
    }

    @VisibleForTesting
    MraidController(Context context, String str, PlacementType placementType, MraidBridge mraidBridge, MraidBridge mraidBridge2, MoPubWebViewController.ScreenMetricsWaiter screenMetricsWaiter) {
        super(context, str);
        ViewState viewState = ViewState.LOADING;
        this.mViewState = viewState;
        this.mOrientationBroadcastReceiver = new OrientationBroadcastReceiver();
        this.mDebugSchemeListener = new UrlHandler.MoPubSchemeListener() {
            public void onClose() {
            }

            public void onFailLoad() {
            }

            public void onFinishLoad() {
            }

            public void onCrash() {
                if (MraidController.this.mWebView != null) {
                    MraidController.this.mWebView.loadUrl("chrome://crash");
                }
            }
        };
        this.mAllowOrientationChange = true;
        this.mForceOrientation = MraidOrientation.NONE;
        C26574 r4 = new MraidBridge.MraidBridgeListener() {
            public void onPageLoaded() {
                MraidController.this.handlePageLoad();
                if (MraidController.this.mBaseWebViewListener != null) {
                    MraidController.this.mBaseWebViewListener.onLoaded(MraidController.this.mDefaultAdContainer);
                }
            }

            public void onPageFailedToLoad() {
                if (MraidController.this.mBaseWebViewListener != null) {
                    MraidController.this.mBaseWebViewListener.onFailedToLoad(MoPubErrorCode.MRAID_LOAD_ERROR);
                }
            }

            public void onRenderProcessGone(MoPubErrorCode moPubErrorCode) {
                MraidController.this.handleRenderProcessGone(moPubErrorCode);
            }

            public void onVisibilityChanged(boolean z) {
                if (!MraidController.this.mTwoPartBridge.isAttached()) {
                    MraidController.this.mMraidBridge.notifyViewability(z);
                }
            }

            public boolean onJsAlert(String str, JsResult jsResult) {
                return MraidController.this.handleJsAlert(str, jsResult);
            }

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return MraidController.this.handleConsoleMessage(consoleMessage);
            }

            public void onClose() {
                MraidController.this.handleClose();
            }

            public void onResize(int i, int i2, int i3, int i4, CloseableLayout.ClosePosition closePosition, boolean z) throws MraidCommandException {
                MraidController.this.handleResize(i, i2, i3, i4, closePosition, z);
            }

            public void onExpand(URI uri, boolean z) throws MraidCommandException {
                MraidController.this.handleExpand(uri, z);
            }

            public void onUseCustomClose(boolean z) {
                MraidController.this.handleCustomClose(z);
            }

            public void onSetOrientationProperties(boolean z, MraidOrientation mraidOrientation) throws MraidCommandException {
                MraidController.this.handleSetOrientationProperties(z, mraidOrientation);
            }

            public void onOpen(URI uri) {
                MraidController.this.handleOpen(uri.toString());
            }
        };
        this.mMraidBridgeListener = r4;
        C26585 r0 = new MraidBridge.MraidBridgeListener() {
            public void onExpand(URI uri, boolean z) {
            }

            public void onPageFailedToLoad() {
            }

            public void onPageLoaded() {
                MraidController.this.handleTwoPartPageLoad();
            }

            public void onRenderProcessGone(MoPubErrorCode moPubErrorCode) {
                MraidController.this.handleRenderProcessGone(moPubErrorCode);
            }

            public void onVisibilityChanged(boolean z) {
                MraidController.this.mMraidBridge.notifyViewability(z);
                MraidController.this.mTwoPartBridge.notifyViewability(z);
            }

            public boolean onJsAlert(String str, JsResult jsResult) {
                return MraidController.this.handleJsAlert(str, jsResult);
            }

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return MraidController.this.handleConsoleMessage(consoleMessage);
            }

            public void onResize(int i, int i2, int i3, int i4, CloseableLayout.ClosePosition closePosition, boolean z) throws MraidCommandException {
                throw new MraidCommandException("Not allowed to resize from an expanded state");
            }

            public void onClose() {
                MraidController.this.handleClose();
            }

            public void onUseCustomClose(boolean z) {
                MraidController.this.handleCustomClose(z);
            }

            public void onSetOrientationProperties(boolean z, MraidOrientation mraidOrientation) throws MraidCommandException {
                MraidController.this.handleSetOrientationProperties(z, mraidOrientation);
            }

            public void onOpen(URI uri) {
                MraidController.this.handleOpen(uri.toString());
            }
        };
        this.mTwoPartBridgeListener = r0;
        this.mPlacementType = placementType;
        this.mMraidBridge = mraidBridge;
        this.mTwoPartBridge = mraidBridge2;
        this.mScreenMetricsWaiter = screenMetricsWaiter;
        this.mViewState = viewState;
        this.mScreenMetrics = new MraidScreenMetrics(this.mContext, this.mContext.getResources().getDisplayMetrics().density);
        CloseableLayout closeableLayout = new CloseableLayout(this.mContext);
        this.mCloseableAdContainer = closeableLayout;
        closeableLayout.setOnCloseListener(new CloseableLayout.OnCloseListener() {
            public void onClose() {
                MraidController.this.handleClose();
            }
        });
        View view = new View(this.mContext);
        view.setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        closeableLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        this.mOrientationBroadcastReceiver.register(this.mContext);
        mraidBridge.setMraidBridgeListener(r4);
        mraidBridge2.setMraidBridgeListener(r0);
        this.mMraidNativeCommandHandler = new MraidNativeCommandHandler();
    }

    public void setUseCustomCloseListener(UseCustomCloseListener useCustomCloseListener) {
        this.mOnCloseButtonListener = useCustomCloseListener;
    }

    public void setDebugListener(WebViewDebugListener webViewDebugListener) {
        this.mDebugListener = webViewDebugListener;
    }

    public void onShow(Activity activity) {
        super.onShow(activity);
        UseCustomCloseListener useCustomCloseListener = this.mOnCloseButtonListener;
        if (useCustomCloseListener != null) {
            useCustomCloseListener.useCustomCloseChanged(isUsingCustomClose());
        }
        try {
            applyOrientation();
        } catch (MraidCommandException unused) {
            MoPubLog.m5876d("Failed to apply orientation.");
        }
    }

    /* access modifiers changed from: private */
    public int getDisplayRotation() {
        return ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean handleConsoleMessage(ConsoleMessage consoleMessage) {
        WebViewDebugListener webViewDebugListener = this.mDebugListener;
        if (webViewDebugListener != null) {
            return webViewDebugListener.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean handleJsAlert(String str, JsResult jsResult) {
        WebViewDebugListener webViewDebugListener = this.mDebugListener;
        if (webViewDebugListener != null) {
            return webViewDebugListener.onJsAlert(str, jsResult);
        }
        jsResult.confirm();
        return true;
    }

    public MraidBridge.MraidWebView getCurrentWebView() {
        return this.mTwoPartBridge.isAttached() ? this.mTwoPartWebView : (MraidBridge.MraidWebView) this.mWebView;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isInlineVideoAvailable() {
        Activity activity = (Activity) this.mWeakActivity.get();
        if (activity == null || getCurrentWebView() == null) {
            return false;
        }
        if (this.mPlacementType != PlacementType.INLINE) {
            return true;
        }
        return this.mMraidNativeCommandHandler.isInlineVideoAvailable(activity, getCurrentWebView());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void handlePageLoad() {
        this.mMraidBridge.notifySupports(this.mMraidNativeCommandHandler.isSmsAvailable(this.mContext), this.mMraidNativeCommandHandler.isTelAvailable(this.mContext), MraidNativeCommandHandler.isCalendarAvailable(this.mContext), MraidNativeCommandHandler.isStorePictureSupported(this.mContext), isInlineVideoAvailable());
        this.mMraidBridge.notifyPlacementType(this.mPlacementType);
        MraidBridge mraidBridge = this.mMraidBridge;
        mraidBridge.notifyViewability(mraidBridge.isViewable());
        this.mMraidBridge.notifyScreenMetrics(this.mScreenMetrics);
        setViewState(ViewState.DEFAULT);
        this.mMraidBridge.notifyReady();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void handleTwoPartPageLoad() {
        updateScreenMetricsAsync(new Runnable() {
            public void run() {
                MraidBridge access$700 = MraidController.this.mTwoPartBridge;
                boolean isSmsAvailable = MraidController.this.mMraidNativeCommandHandler.isSmsAvailable(MraidController.this.mContext);
                boolean isTelAvailable = MraidController.this.mMraidNativeCommandHandler.isTelAvailable(MraidController.this.mContext);
                MraidNativeCommandHandler unused = MraidController.this.mMraidNativeCommandHandler;
                boolean isCalendarAvailable = MraidNativeCommandHandler.isCalendarAvailable(MraidController.this.mContext);
                MraidNativeCommandHandler unused2 = MraidController.this.mMraidNativeCommandHandler;
                access$700.notifySupports(isSmsAvailable, isTelAvailable, isCalendarAvailable, MraidNativeCommandHandler.isStorePictureSupported(MraidController.this.mContext), MraidController.this.isInlineVideoAvailable());
                MraidController.this.mTwoPartBridge.notifyViewState(MraidController.this.mViewState);
                MraidController.this.mTwoPartBridge.notifyPlacementType(MraidController.this.mPlacementType);
                MraidController.this.mTwoPartBridge.notifyViewability(MraidController.this.mTwoPartBridge.isViewable());
                MraidController.this.mTwoPartBridge.notifyReady();
            }
        });
    }

    private void updateScreenMetricsAsync(final Runnable runnable) {
        this.mScreenMetricsWaiter.cancelLastRequest();
        final MraidBridge.MraidWebView currentWebView = getCurrentWebView();
        if (currentWebView != null) {
            this.mScreenMetricsWaiter.waitFor(this.mDefaultAdContainer, currentWebView).start(new Runnable() {
                public void run() {
                    DisplayMetrics displayMetrics = MraidController.this.mContext.getResources().getDisplayMetrics();
                    MraidController.this.mScreenMetrics.setScreenSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
                    int[] iArr = new int[2];
                    ViewGroup access$1800 = MraidController.this.getRootView();
                    access$1800.getLocationOnScreen(iArr);
                    MraidController.this.mScreenMetrics.setRootViewPosition(iArr[0], iArr[1], access$1800.getWidth(), access$1800.getHeight());
                    MraidController.this.mDefaultAdContainer.getLocationOnScreen(iArr);
                    MraidController.this.mScreenMetrics.setDefaultAdPosition(iArr[0], iArr[1], MraidController.this.mDefaultAdContainer.getWidth(), MraidController.this.mDefaultAdContainer.getHeight());
                    currentWebView.getLocationOnScreen(iArr);
                    MraidController.this.mScreenMetrics.setCurrentAdPosition(iArr[0], iArr[1], currentWebView.getWidth(), currentWebView.getHeight());
                    MraidController.this.mMraidBridge.notifyScreenMetrics(MraidController.this.mScreenMetrics);
                    if (MraidController.this.mTwoPartBridge.isAttached()) {
                        MraidController.this.mTwoPartBridge.notifyScreenMetrics(MraidController.this.mScreenMetrics);
                    }
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void handleOrientationChange(int i) {
        updateScreenMetricsAsync((Runnable) null);
    }

    /* access modifiers changed from: protected */
    public void pause(boolean z) {
        super.pause(z);
        MraidBridge.MraidWebView mraidWebView = this.mTwoPartWebView;
        if (mraidWebView != null) {
            WebViews.onPause(mraidWebView, z);
        }
    }

    /* access modifiers changed from: protected */
    public void resume() {
        super.resume();
        MraidBridge.MraidWebView mraidWebView = this.mTwoPartWebView;
        if (mraidWebView != null) {
            mraidWebView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        super.destroy();
        this.mScreenMetricsWaiter.cancelLastRequest();
        try {
            this.mOrientationBroadcastReceiver.unregister();
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        Views.removeFromParent(this.mCloseableAdContainer);
        detachMraidWebView();
        detachTwoPartWebView();
        unApplyOrientation();
    }

    private void detachMraidWebView() {
        this.mMraidBridge.detach();
        this.mWebView = null;
    }

    private void detachTwoPartWebView() {
        this.mTwoPartBridge.detach();
        this.mTwoPartWebView = null;
    }

    private void setViewState(ViewState viewState) {
        MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        MoPubLog.log(sdkLogEvent, "MRAID state set to " + viewState);
        ViewState viewState2 = this.mViewState;
        this.mViewState = viewState;
        this.mMraidBridge.notifyViewState(viewState);
        if (this.mTwoPartBridge.isLoaded()) {
            this.mTwoPartBridge.notifyViewState(viewState);
        }
        BaseHtmlWebView.BaseWebViewListener baseWebViewListener = this.mBaseWebViewListener;
        if (baseWebViewListener != null) {
            callMraidListenerCallbacks(baseWebViewListener, viewState2, viewState);
        }
        updateScreenMetricsAsync((Runnable) null);
    }

    @VisibleForTesting
    static void callMraidListenerCallbacks(BaseHtmlWebView.BaseWebViewListener baseWebViewListener, ViewState viewState, ViewState viewState2) {
        Preconditions.checkNotNull(baseWebViewListener);
        Preconditions.checkNotNull(viewState);
        Preconditions.checkNotNull(viewState2);
        ViewState viewState3 = ViewState.EXPANDED;
        if (viewState2 == viewState3) {
            baseWebViewListener.onExpand();
        } else if (viewState == viewState3 && viewState2 == ViewState.DEFAULT) {
            baseWebViewListener.onClose();
        } else if (viewState2 == ViewState.HIDDEN) {
            baseWebViewListener.onClose();
        } else {
            ViewState viewState4 = ViewState.RESIZED;
            if (viewState == viewState4 && viewState2 == ViewState.DEFAULT) {
                baseWebViewListener.onResize(true);
            } else if (viewState2 == viewState4) {
                baseWebViewListener.onResize(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int clampInt(int i, int i2, int i3) {
        return Math.max(i, Math.min(i2, i3));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void handleResize(int i, int i2, int i3, int i4, CloseableLayout.ClosePosition closePosition, boolean z) throws MraidCommandException {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        CloseableLayout.ClosePosition closePosition2 = closePosition;
        if (this.mWebView != null) {
            ViewState viewState = this.mViewState;
            if (viewState != ViewState.LOADING && viewState != ViewState.HIDDEN) {
                if (viewState == ViewState.EXPANDED) {
                    throw new MraidCommandException("Not allowed to resize from an already expanded ad");
                } else if (this.mPlacementType != PlacementType.INTERSTITIAL) {
                    int dipsToIntPixels = Dips.dipsToIntPixels((float) i5, this.mContext);
                    int dipsToIntPixels2 = Dips.dipsToIntPixels((float) i6, this.mContext);
                    int dipsToIntPixels3 = Dips.dipsToIntPixels((float) i7, this.mContext);
                    int dipsToIntPixels4 = Dips.dipsToIntPixels((float) i8, this.mContext);
                    int i9 = this.mScreenMetrics.getDefaultAdRect().left + dipsToIntPixels3;
                    int i10 = this.mScreenMetrics.getDefaultAdRect().top + dipsToIntPixels4;
                    Rect rect = new Rect(i9, i10, dipsToIntPixels + i9, i10 + dipsToIntPixels2);
                    if (!z) {
                        Rect rootViewRect = this.mScreenMetrics.getRootViewRect();
                        if (rect.width() > rootViewRect.width() || rect.height() > rootViewRect.height()) {
                            throw new MraidCommandException("resizeProperties specified a size (" + i5 + ", " + i6 + ") and offset (" + i7 + ", " + i8 + ") that doesn't allow the ad to appear within the max allowed size (" + this.mScreenMetrics.getRootViewRectDips().width() + ", " + this.mScreenMetrics.getRootViewRectDips().height() + ")");
                        }
                        rect.offsetTo(clampInt(rootViewRect.left, rect.left, rootViewRect.right - rect.width()), clampInt(rootViewRect.top, rect.top, rootViewRect.bottom - rect.height()));
                    }
                    Rect rect2 = new Rect();
                    this.mCloseableAdContainer.applyCloseRegionBounds(closePosition2, rect, rect2);
                    if (!this.mScreenMetrics.getRootViewRect().contains(rect2)) {
                        throw new MraidCommandException("resizeProperties specified a size (" + i5 + ", " + i6 + ") and offset (" + i7 + ", " + i8 + ") that doesn't allow the close region to appear within the max allowed size (" + this.mScreenMetrics.getRootViewRectDips().width() + ", " + this.mScreenMetrics.getRootViewRectDips().height() + ")");
                    } else if (rect.contains(rect2)) {
                        this.mCloseableAdContainer.setClosePosition(closePosition2);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
                        layoutParams.leftMargin = rect.left - this.mScreenMetrics.getRootViewRect().left;
                        layoutParams.topMargin = rect.top - this.mScreenMetrics.getRootViewRect().top;
                        ViewState viewState2 = this.mViewState;
                        if (viewState2 == ViewState.DEFAULT) {
                            BaseWebView baseWebView = this.mWebView;
                            if (baseWebView instanceof BaseWebViewViewability) {
                                ((BaseWebViewViewability) baseWebView).disableTracking();
                            }
                            this.mDefaultAdContainer.removeView(this.mWebView);
                            this.mDefaultAdContainer.setVisibility(4);
                            this.mCloseableAdContainer.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
                            getAndMemoizeRootView().addView(this.mCloseableAdContainer, layoutParams);
                            BaseWebView baseWebView2 = this.mWebView;
                            if (baseWebView2 instanceof BaseWebViewViewability) {
                                ((BaseWebViewViewability) baseWebView2).enableTracking();
                            }
                        } else if (viewState2 == ViewState.RESIZED) {
                            this.mCloseableAdContainer.setLayoutParams(layoutParams);
                        }
                        this.mCloseableAdContainer.setClosePosition(closePosition2);
                        setViewState(ViewState.RESIZED);
                    } else {
                        throw new MraidCommandException("resizeProperties specified a size (" + i5 + ", " + dipsToIntPixels2 + ") and offset (" + i7 + ", " + i8 + ") that don't allow the close region to appear within the resized ad.");
                    }
                } else {
                    throw new MraidCommandException("Not allowed to resize from an interstitial ad");
                }
            }
        } else {
            throw new MraidCommandException("Unable to resize after the WebView is destroyed");
        }
    }

    /* access modifiers changed from: package-private */
    public void handleExpand(URI uri, boolean z) throws MraidCommandException {
        if (this.mWebView == null) {
            throw new MraidCommandException("Unable to expand after the WebView is destroyed");
        } else if (this.mPlacementType != PlacementType.INTERSTITIAL) {
            ViewState viewState = this.mViewState;
            ViewState viewState2 = ViewState.DEFAULT;
            if (viewState == viewState2 || viewState == ViewState.RESIZED) {
                applyOrientation();
                boolean z2 = uri != null;
                if (z2) {
                    MraidBridge.MraidWebView mraidWebView = (MraidBridge.MraidWebView) createWebView();
                    this.mTwoPartWebView = mraidWebView;
                    mraidWebView.disableTracking();
                    this.mTwoPartBridge.attachView(this.mTwoPartWebView);
                    this.mTwoPartBridge.setContentUrl(uri.toString());
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                ViewState viewState3 = this.mViewState;
                if (viewState3 == viewState2) {
                    if (z2) {
                        this.mCloseableAdContainer.addView(this.mTwoPartWebView, layoutParams);
                    } else {
                        BaseWebView baseWebView = this.mWebView;
                        if (baseWebView instanceof BaseWebViewViewability) {
                            ((BaseWebViewViewability) baseWebView).disableTracking();
                        }
                        this.mDefaultAdContainer.removeView(this.mWebView);
                        this.mDefaultAdContainer.setVisibility(4);
                        this.mCloseableAdContainer.addView(this.mWebView, layoutParams);
                        BaseWebView baseWebView2 = this.mWebView;
                        if (baseWebView2 instanceof BaseWebViewViewability) {
                            ((BaseWebViewViewability) baseWebView2).enableTracking();
                        }
                    }
                    getAndMemoizeRootView().addView(this.mCloseableAdContainer, new FrameLayout.LayoutParams(-1, -1));
                } else if (viewState3 == ViewState.RESIZED && z2) {
                    BaseWebView baseWebView3 = this.mWebView;
                    if (baseWebView3 instanceof BaseWebViewViewability) {
                        ((BaseWebViewViewability) baseWebView3).disableTracking();
                    }
                    this.mCloseableAdContainer.removeView(this.mWebView);
                    this.mDefaultAdContainer.addView(this.mWebView, layoutParams);
                    BaseWebView baseWebView4 = this.mWebView;
                    if (baseWebView4 instanceof BaseWebViewViewability) {
                        ((BaseWebViewViewability) baseWebView4).enableTracking();
                    }
                    this.mDefaultAdContainer.setVisibility(4);
                    this.mCloseableAdContainer.addView(this.mTwoPartWebView, layoutParams);
                }
                this.mCloseableAdContainer.setLayoutParams(layoutParams);
                handleCustomClose(z);
                setViewState(ViewState.EXPANDED);
            }
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public void handleClose() {
        ViewState viewState;
        ViewState viewState2;
        MraidBridge.MraidWebView mraidWebView;
        if (this.mWebView != null && (viewState = this.mViewState) != ViewState.LOADING && viewState != (viewState2 = ViewState.HIDDEN)) {
            ViewState viewState3 = ViewState.EXPANDED;
            if (viewState == viewState3 || this.mPlacementType == PlacementType.INTERSTITIAL) {
                unApplyOrientation();
            }
            ViewState viewState4 = this.mViewState;
            if (viewState4 == ViewState.RESIZED || viewState4 == viewState3) {
                if (!this.mTwoPartBridge.isAttached() || (mraidWebView = this.mTwoPartWebView) == null) {
                    this.mCloseableAdContainer.removeView(this.mWebView);
                    this.mDefaultAdContainer.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
                    this.mDefaultAdContainer.setVisibility(0);
                } else {
                    detachTwoPartWebView();
                    this.mCloseableAdContainer.removeView(mraidWebView);
                }
                Views.removeFromParent(this.mCloseableAdContainer);
                setViewState(ViewState.DEFAULT);
            } else if (viewState4 == ViewState.DEFAULT) {
                this.mDefaultAdContainer.setVisibility(4);
                setViewState(viewState2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void handleRenderProcessGone(MoPubErrorCode moPubErrorCode) {
        BaseHtmlWebView.BaseWebViewListener baseWebViewListener = this.mBaseWebViewListener;
        if (baseWebViewListener != null) {
            baseWebViewListener.onRenderProcessGone(moPubErrorCode);
        }
    }

    /* access modifiers changed from: private */
    public ViewGroup getRootView() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            return viewGroup;
        }
        View topmostView = Views.getTopmostView((Context) this.mWeakActivity.get(), this.mDefaultAdContainer);
        return topmostView instanceof ViewGroup ? (ViewGroup) topmostView : this.mDefaultAdContainer;
    }

    private ViewGroup getAndMemoizeRootView() {
        if (this.mRootView == null) {
            this.mRootView = getRootView();
        }
        return this.mRootView;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void lockOrientation(int i) throws MraidCommandException {
        Activity activity = (Activity) this.mWeakActivity.get();
        if (activity == null || !shouldAllowForceOrientation(this.mForceOrientation)) {
            throw new MraidCommandException("Attempted to lock orientation to unsupported value: " + this.mForceOrientation.name());
        }
        if (this.mOriginalActivityOrientation == null) {
            this.mOriginalActivityOrientation = Integer.valueOf(activity.getRequestedOrientation());
        }
        activity.setRequestedOrientation(i);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void applyOrientation() throws MraidCommandException {
        MraidOrientation mraidOrientation = this.mForceOrientation;
        if (mraidOrientation != MraidOrientation.NONE) {
            lockOrientation(mraidOrientation.getActivityInfoOrientation());
        } else if (this.mAllowOrientationChange) {
            unApplyOrientation();
        } else {
            Activity activity = (Activity) this.mWeakActivity.get();
            if (activity != null) {
                lockOrientation(DeviceUtils.getScreenOrientation(activity));
                return;
            }
            throw new MraidCommandException("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void unApplyOrientation() {
        Integer num;
        Activity activity = (Activity) this.mWeakActivity.get();
        if (!(activity == null || (num = this.mOriginalActivityOrientation) == null)) {
            activity.setRequestedOrientation(num.intValue());
        }
        this.mOriginalActivityOrientation = null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean shouldAllowForceOrientation(MraidOrientation mraidOrientation) {
        if (mraidOrientation == MraidOrientation.NONE) {
            return true;
        }
        Activity activity = (Activity) this.mWeakActivity.get();
        if (activity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            int i = activityInfo.screenOrientation;
            if (i != -1) {
                if (i == mraidOrientation.getActivityInfoOrientation()) {
                    return true;
                }
                return false;
            } else if (!Utils.bitMaskContainsFlag(activityInfo.configChanges, 128) || !Utils.bitMaskContainsFlag(activityInfo.configChanges, 1024)) {
                return false;
            } else {
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public void handleCustomClose(boolean z) {
        if (z != isUsingCustomClose()) {
            this.mCloseableAdContainer.setCloseVisible(!z);
            UseCustomCloseListener useCustomCloseListener = this.mOnCloseButtonListener;
            if (useCustomCloseListener != null) {
                useCustomCloseListener.useCustomCloseChanged(z);
            }
        }
    }

    private boolean isUsingCustomClose() {
        return !this.mCloseableAdContainer.isCloseVisible();
    }

    public BaseWebView createWebView() {
        return new MraidBridge.MraidWebView(this.mContext);
    }

    /* access modifiers changed from: protected */
    public void doFillContent(String str) {
        this.mMraidBridge.attachView((MraidBridge.MraidWebView) this.mWebView);
        this.mDefaultAdContainer.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
        if (Patterns.WEB_URL.matcher(str).matches()) {
            this.mMraidBridge.setContentUrl(str);
        } else {
            this.mMraidBridge.setContentHtml(str);
        }
    }

    public void loadJavascript(String str) {
        this.mMraidBridge.injectJavaScript(str);
    }

    @VisibleForTesting
    class OrientationBroadcastReceiver extends BroadcastReceiver {
        private Context mContext;
        private int mLastRotation = -1;

        OrientationBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int access$2200;
            if (this.mContext != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) && (access$2200 = MraidController.this.getDisplayRotation()) != this.mLastRotation) {
                this.mLastRotation = access$2200;
                MraidController.this.handleOrientationChange(access$2200);
            }
        }

        public void register(Context context) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            if (applicationContext != null) {
                applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        public void unregister() {
            Context context = this.mContext;
            if (context != null) {
                context.unregisterReceiver(this);
                this.mContext = null;
            }
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void handleSetOrientationProperties(boolean z, MraidOrientation mraidOrientation) throws MraidCommandException {
        if (shouldAllowForceOrientation(mraidOrientation)) {
            this.mAllowOrientationChange = z;
            this.mForceOrientation = mraidOrientation;
            if (this.mViewState == ViewState.EXPANDED || (this.mPlacementType == PlacementType.INTERSTITIAL && !this.mIsPaused)) {
                applyOrientation();
                return;
            }
            return;
        }
        throw new MraidCommandException("Unable to force orientation to " + mraidOrientation);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void handleOpen(String str) {
        BaseHtmlWebView.BaseWebViewListener baseWebViewListener = this.mBaseWebViewListener;
        if (baseWebViewListener != null) {
            baseWebViewListener.onClicked();
        }
        Uri parse = Uri.parse(str);
        if (UrlAction.HANDLE_PHONE_SCHEME.shouldTryHandlingUrl(parse)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, String.format("Uri scheme %s is not allowed.", new Object[]{parse.getScheme()}), new MraidCommandException("Unsupported MRAID Javascript command"));
            return;
        }
        UrlHandler.Builder builder = new UrlHandler.Builder();
        if (!TextUtils.isEmpty(this.mDspCreativeId)) {
            builder.withDspCreativeId(this.mDspCreativeId);
        }
        EnumSet of = EnumSet.of(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[]{UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
        if (ManifestUtils.isDebuggable(this.mContext)) {
            of.add(UrlAction.HANDLE_MOPUB_SCHEME);
            builder.withMoPubSchemeListener(this.mDebugSchemeListener);
        }
        builder.withSupportedUrlActions(of).build().handleUrl(this.mContext, str);
    }
}
