package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.ViewabilityManager;
import com.mopub.common.ViewabilityVendor;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.util.WebViews;
import com.mopub.mraid.WebViewDebugListener;
import java.lang.ref.WeakReference;
import java.util.Set;

public abstract class MoPubWebViewController {
    /* access modifiers changed from: protected */
    public BaseHtmlWebView.BaseWebViewListener mBaseWebViewListener;
    /* access modifiers changed from: protected */
    public final Context mContext;
    protected WebViewDebugListener mDebugListener;
    /* access modifiers changed from: protected */
    public final ViewGroup mDefaultAdContainer;
    protected String mDspCreativeId;
    protected boolean mIsPaused = true;
    protected WeakReference<Activity> mWeakActivity;
    /* access modifiers changed from: protected */
    public BaseWebView mWebView;

    public interface WebViewCacheListener {
        void onReady(BaseWebView baseWebView);
    }

    /* access modifiers changed from: protected */
    public abstract BaseWebView createWebView();

    /* access modifiers changed from: protected */
    public abstract void doFillContent(String str);

    public void loadJavascript(String str) {
    }

    public MoPubWebViewController(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        Preconditions.checkNotNull(applicationContext);
        this.mDspCreativeId = str;
        if (context instanceof Activity) {
            this.mWeakActivity = new WeakReference<>((Activity) context);
        } else {
            this.mWeakActivity = new WeakReference<>((Object) null);
        }
        this.mDefaultAdContainer = new FrameLayout(applicationContext);
    }

    public final void fillContent(String str, Set<ViewabilityVendor> set, WebViewCacheListener webViewCacheListener) {
        Preconditions.checkNotNull(str, "htmlData cannot be null");
        BaseWebView createWebView = createWebView();
        this.mWebView = createWebView;
        if (webViewCacheListener != null) {
            webViewCacheListener.onReady(createWebView);
        }
        if (!Patterns.WEB_URL.matcher(str).matches()) {
            str = ViewabilityManager.injectScriptContentIntoHtml(ViewabilityManager.injectVerificationUrlsIntoHtml(str, set));
        }
        doFillContent(str);
    }

    public void onShow(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.mWeakActivity = new WeakReference<>(activity);
    }

    /* access modifiers changed from: protected */
    public void pause(boolean z) {
        this.mIsPaused = true;
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null) {
            WebViews.onPause(baseWebView, z);
        }
    }

    /* access modifiers changed from: protected */
    public void resume() {
        this.mIsPaused = false;
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null) {
            baseWebView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        if (!this.mIsPaused) {
            pause(true);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setMoPubWebViewListener(BaseHtmlWebView.BaseWebViewListener baseWebViewListener) {
        this.mBaseWebViewListener = baseWebViewListener;
    }

    public void setDebugListener(WebViewDebugListener webViewDebugListener) {
        this.mDebugListener = webViewDebugListener;
    }

    public View getAdContainer() {
        return this.mDefaultAdContainer;
    }

    @VisibleForTesting
    public static class ScreenMetricsWaiter {
        private final Handler mHandler = new Handler();
        private WaitRequest mLastWaitRequest;

        public static class WaitRequest {
            private final Handler mHandler;
            private Runnable mSuccessRunnable;
            /* access modifiers changed from: private */
            public final View[] mViews;
            int mWaitCount;
            final Runnable mWaitingRunnable = new Runnable() {
                public void run() {
                    for (final View view : WaitRequest.this.mViews) {
                        if (view.getHeight() > 0 || view.getWidth() > 0) {
                            WaitRequest.this.countDown();
                        } else {
                            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                                public boolean onPreDraw() {
                                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                                    WaitRequest.this.countDown();
                                    return true;
                                }
                            });
                        }
                    }
                }
            };

            WaitRequest(Handler handler, View[] viewArr) {
                this.mHandler = handler;
                this.mViews = viewArr;
            }

            /* access modifiers changed from: package-private */
            public void countDown() {
                Runnable runnable;
                int i = this.mWaitCount - 1;
                this.mWaitCount = i;
                if (i == 0 && (runnable = this.mSuccessRunnable) != null) {
                    runnable.run();
                    this.mSuccessRunnable = null;
                }
            }

            public void start(Runnable runnable) {
                this.mSuccessRunnable = runnable;
                this.mWaitCount = this.mViews.length;
                this.mHandler.post(this.mWaitingRunnable);
            }

            /* access modifiers changed from: package-private */
            public void cancel() {
                this.mHandler.removeCallbacks(this.mWaitingRunnable);
                this.mSuccessRunnable = null;
            }
        }

        public WaitRequest waitFor(View... viewArr) {
            WaitRequest waitRequest = new WaitRequest(this.mHandler, viewArr);
            this.mLastWaitRequest = waitRequest;
            return waitRequest;
        }

        public void cancelLastRequest() {
            WaitRequest waitRequest = this.mLastWaitRequest;
            if (waitRequest != null) {
                waitRequest.cancel();
                this.mLastWaitRequest = null;
            }
        }
    }

    @VisibleForTesting
    public BaseHtmlWebView.BaseWebViewListener getBaseWebViewListener() {
        return this.mBaseWebViewListener;
    }
}
