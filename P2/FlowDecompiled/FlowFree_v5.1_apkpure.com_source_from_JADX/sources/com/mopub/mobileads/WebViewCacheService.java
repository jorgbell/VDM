package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WebViewCacheService {
    private static Handler sHandler = new Handler();
    @VisibleForTesting
    static final TrimCacheRunnable sTrimCacheRunnable = new TrimCacheRunnable();
    @SuppressLint({"UseSparseArrays"})
    private static final Map<Long, Config> sWebViewConfigs = Collections.synchronizedMap(new HashMap());

    public static class Config {
        private final MoPubWebViewController mController;
        private final WeakReference<BaseAd> mWeakBaseAd;
        private final BaseWebView mWebView;

        Config(BaseWebView baseWebView, BaseAd baseAd, MoPubWebViewController moPubWebViewController) {
            Preconditions.checkNotNull(baseWebView);
            Preconditions.checkNotNull(baseAd);
            this.mWebView = baseWebView;
            this.mWeakBaseAd = new WeakReference<>(baseAd);
            this.mController = moPubWebViewController;
        }

        public BaseWebView getWebView() {
            return this.mWebView;
        }

        public WeakReference<BaseAd> getWeakBaseAd() {
            return this.mWeakBaseAd;
        }

        public MoPubWebViewController getController() {
            return this.mController;
        }

        public void invalidate() {
            this.mWebView.destroy();
            this.mWeakBaseAd.clear();
            MoPubWebViewController moPubWebViewController = this.mController;
            if (moPubWebViewController != null) {
                moPubWebViewController.destroy();
            }
        }
    }

    private WebViewCacheService() {
    }

    @VisibleForTesting
    public static void storeWebViewConfig(Long l, BaseWebView baseWebView, BaseAd baseAd, MoPubWebViewController moPubWebViewController) {
        Preconditions.checkNotNull(l);
        Preconditions.checkNotNull(baseWebView);
        Preconditions.checkNotNull(baseAd);
        trimCache();
        Map<Long, Config> map = sWebViewConfigs;
        if (map.size() >= 50) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Unable to cache web view. Please destroy some via MoPubInterstitial#destroy() and try again.");
            return;
        }
        map.put(l, new Config(baseWebView, baseAd, moPubWebViewController));
    }

    public static Config popWebViewConfig(Long l) {
        Preconditions.checkNotNull(l);
        return sWebViewConfigs.remove(l);
    }

    @VisibleForTesting
    static synchronized void trimCache() {
        synchronized (WebViewCacheService.class) {
            Iterator<Map.Entry<Long, Config>> it = sWebViewConfigs.entrySet().iterator();
            while (it.hasNext()) {
                if (((Config) it.next().getValue()).getWeakBaseAd().get() == null) {
                    it.remove();
                }
            }
            if (!sWebViewConfigs.isEmpty()) {
                Handler handler = sHandler;
                TrimCacheRunnable trimCacheRunnable = sTrimCacheRunnable;
                handler.removeCallbacks(trimCacheRunnable);
                sHandler.postDelayed(trimCacheRunnable, 900000);
            }
        }
    }

    private static class TrimCacheRunnable implements Runnable {
        private TrimCacheRunnable() {
        }

        public void run() {
            WebViewCacheService.trimCache();
        }
    }

    @Deprecated
    @VisibleForTesting
    public static void clearAll() {
        sWebViewConfigs.clear();
        sHandler.removeCallbacks(sTrimCacheRunnable);
    }
}
