package com.vungle.warren.p054ui.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.ViewManager;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcessClient;
import android.widget.RelativeLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.vungle.warren.AdConfig;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.VungleNativeAd;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p054ui.CloseDelegate;
import com.vungle.warren.p054ui.JavascriptBridge;
import com.vungle.warren.p054ui.contract.AdContract$AdvertisementPresenter;
import com.vungle.warren.p054ui.contract.WebAdContract$WebAdPresenter;
import com.vungle.warren.p054ui.contract.WebAdContract$WebAdView;
import com.vungle.warren.p054ui.state.OptionsState;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.ExternalRouter;
import com.vungle.warren.utility.HandlerScheduler;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.vungle.warren.ui.view.VungleNativeView */
public class VungleNativeView extends WebView implements WebAdContract$WebAdView, VungleNativeAd {
    private static final String TAG = VungleNativeView.class.getName();
    private BroadcastReceiver broadcastReceiver;
    private final AdConfig config;
    private boolean destroyed;
    /* access modifiers changed from: private */
    public AtomicReference<Boolean> isAdVisible = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final AdContract$AdvertisementPresenter.EventListener listener;
    /* access modifiers changed from: private */
    public final String placementID;
    /* access modifiers changed from: private */
    public WebAdContract$WebAdPresenter presenter;
    PresentationFactory presenterFactory;

    public boolean hasWebView() {
        return true;
    }

    public void setImmersiveMode() {
    }

    public void setOrientation(int i) {
    }

    public void setPresenter(WebAdContract$WebAdPresenter webAdContract$WebAdPresenter) {
    }

    public void updateWindow() {
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "Resuming Flex");
        setAdVisibility(true);
    }

    public void onPause() {
        super.onPause();
        setAdVisibility(false);
    }

    public VungleNativeView(Context context, String str, AdConfig adConfig, PresentationFactory presentationFactory, AdContract$AdvertisementPresenter.EventListener eventListener) {
        super(context);
        this.listener = eventListener;
        this.placementID = str;
        this.config = adConfig;
        this.presenterFactory = presentationFactory;
        setLayerType(2, (Paint) null);
        setBackgroundColor(0);
    }

    /* access modifiers changed from: private */
    public void prepare(Bundle bundle) {
        WebSettingsUtils.applyDefault(this);
        addJavascriptInterface(new JavascriptBridge(this.presenter), "Android");
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT < 17) {
            setAdVisibility(true);
        } else {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    public void finishDisplayingAdInternal(boolean z) {
        WebAdContract$WebAdPresenter webAdContract$WebAdPresenter = this.presenter;
        if (webAdContract$WebAdPresenter != null) {
            webAdContract$WebAdPresenter.detach((z ? 4 : 0) | 2);
        } else {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                this.listener.onError(new VungleException(25), this.placementID);
            }
        }
        destroyAdView(0);
    }

    public void setAdVisibility(boolean z) {
        WebAdContract$WebAdPresenter webAdContract$WebAdPresenter = this.presenter;
        if (webAdContract$WebAdPresenter != null) {
            webAdContract$WebAdPresenter.setAdVisibility(z);
        } else {
            this.isAdVisible.set(Boolean.valueOf(z));
        }
    }

    public void showWebsite(String str) {
        loadUrl(str);
    }

    public String getWebsiteUrl() {
        return getUrl();
    }

    public void close() {
        WebAdContract$WebAdPresenter webAdContract$WebAdPresenter = this.presenter;
        if (webAdContract$WebAdPresenter == null) {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                this.listener.onError(new VungleException(25), this.placementID);
            }
        } else if (webAdContract$WebAdPresenter.handleExit()) {
            finishDisplayingAdInternal(false);
        }
    }

    public void destroyAdView(long j) {
        if (!this.destroyed) {
            this.destroyed = true;
            this.presenter = null;
            this.presenterFactory = null;
            removeJavascriptInterface("Android");
            setWebChromeClient((WebChromeClient) null);
            C30551 r0 = new Runnable() {
                public void run() {
                    VungleNativeView.this.stopLoading();
                    VungleNativeView.this.setWebViewClient((WebViewClient) null);
                    if (Build.VERSION.SDK_INT >= 29) {
                        VungleNativeView.this.setWebViewRenderProcessClient((WebViewRenderProcessClient) null);
                    }
                    VungleNativeView.this.loadUrl("about:blank");
                }
            };
            if (j <= 0) {
                r0.run();
            } else {
                new HandlerScheduler().schedule(r0, j);
            }
        }
    }

    public void open(String str, ActivityManager.LeftApplicationCallback leftApplicationCallback) {
        String str2 = TAG;
        Log.d(str2, "Opening " + str);
        if (!ExternalRouter.launch(str, getContext(), leftApplicationCallback)) {
            Log.e(str2, "Cannot open url " + str);
        }
    }

    public void resumeWeb() {
        onResume();
    }

    public void pauseWeb() {
        onPause();
    }

    public void removeWebView() {
        ViewParent parent = getParent();
        if (parent instanceof ViewManager) {
            ((ViewManager) parent).removeView(this);
        }
    }

    public void setVisibility(boolean z) {
        setVisibility(z ? 0 : 4);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null && this.presenter == null) {
            presentationFactory.getNativeViewPresentation(this.placementID, this.config, new CloseDelegate() {
                public void close() {
                    VungleNativeView.this.finishDisplayingAdInternal(false);
                }
            }, new PresentationFactory.ViewCallback() {
                public void onResult(Pair<WebAdContract$WebAdPresenter, VungleWebClient> pair, VungleException vungleException) {
                    VungleNativeView vungleNativeView = VungleNativeView.this;
                    vungleNativeView.presenterFactory = null;
                    if (pair != null && vungleException == null) {
                        WebAdContract$WebAdPresenter unused = vungleNativeView.presenter = (WebAdContract$WebAdPresenter) pair.first;
                        VungleNativeView.this.setWebViewClient((VungleWebClient) pair.second);
                        VungleNativeView.this.presenter.setEventListener(VungleNativeView.this.listener);
                        VungleNativeView.this.presenter.attach(VungleNativeView.this, (OptionsState) null);
                        VungleNativeView.this.prepare((Bundle) null);
                        if (VungleNativeView.this.isAdVisible.get() != null) {
                            VungleNativeView vungleNativeView2 = VungleNativeView.this;
                            vungleNativeView2.setAdVisibility(((Boolean) vungleNativeView2.isAdVisible.get()).booleanValue());
                        }
                    } else if (vungleNativeView.listener != null) {
                        AdContract$AdvertisementPresenter.EventListener access$000 = VungleNativeView.this.listener;
                        if (vungleException == null) {
                            vungleException = new VungleException(10);
                        }
                        access$000.onError(vungleException, VungleNativeView.this.placementID);
                    }
                }
            });
        }
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra("command");
                if ("stopAll".equalsIgnoreCase(stringExtra)) {
                    VungleNativeView.this.finishDisplayingAdInternal(false);
                    return;
                }
                VungleLogger.warn(VungleNativeView.class.getSimpleName() + "#onAttachedToWindow", String.format("Receiving Invalid Broadcast: %1$s", new Object[]{stringExtra}));
            }
        };
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.broadcastReceiver, new IntentFilter("AdvertisementBus"));
        resumeWeb();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        setAdVisibility(z);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.broadcastReceiver);
        super.onDetachedFromWindow();
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.destroy();
        }
        pauseWeb();
    }
}
