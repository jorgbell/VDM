package com.mopub.network;

import android.content.Context;
import android.os.Looper;
import android.webkit.WebSettings;
import com.mopub.common.Constants;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.toolbox.HurlStack;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* renamed from: com.mopub.network.Networking */
/* compiled from: Networking.kt */
public final class C2676Networking {
    private static final String DEFAULT_USER_AGENT;
    public static final C2676Networking INSTANCE = new C2676Networking();
    /* access modifiers changed from: private */
    public static volatile MaxWidthImageLoader maxWidthImageLoader;
    /* access modifiers changed from: private */
    public static volatile MoPubRequestQueue requestQueue;
    private static final String scheme = Constants.HTTPS;
    private static HurlStack.UrlRewriter urlRewriter;
    private static volatile String userAgent;

    public static /* synthetic */ void getCachedUserAgent$annotations() {
    }

    public static /* synthetic */ void getRequestQueue$annotations() {
    }

    public static /* synthetic */ void getScheme$annotations() {
    }

    static {
        String str;
        String str2 = "";
        try {
            str = System.getProperty("http.agent", str2);
        } catch (SecurityException unused) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Unable to get system user agent.");
            str = str2;
        }
        if (str != null) {
            str2 = str;
        }
        DEFAULT_USER_AGENT = str2;
    }

    private C2676Networking() {
    }

    public static final MoPubRequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static final String getCachedUserAgent() {
        String str = userAgent;
        return str != null ? str : DEFAULT_USER_AGENT;
    }

    public static final String getScheme() {
        return scheme;
    }

    public static final HurlStack.UrlRewriter getUrlRewriter() {
        HurlStack.UrlRewriter urlRewriter2 = urlRewriter;
        if (urlRewriter2 != null) {
            return urlRewriter2;
        }
        PlayServicesUrlRewriter playServicesUrlRewriter = new PlayServicesUrlRewriter();
        urlRewriter = playServicesUrlRewriter;
        return playServicesUrlRewriter;
    }

    public static final MoPubRequestQueue getRequestQueue(Context context) {
        MoPubRequestQueue moPubRequestQueue;
        Intrinsics.checkNotNullParameter(context, "context");
        MoPubRequestQueue moPubRequestQueue2 = requestQueue;
        if (moPubRequestQueue2 != null) {
            return moPubRequestQueue2;
        }
        synchronized (Reflection.getOrCreateKotlinClass(C2676Networking.class)) {
            MoPubRequestQueue moPubRequestQueue3 = requestQueue;
            moPubRequestQueue = moPubRequestQueue3 != null ? moPubRequestQueue3 : (MoPubRequestQueue) new Networking$getRequestQueue$$inlined$synchronized$lambda$1(context).invoke();
        }
        return moPubRequestQueue;
    }

    public static final MaxWidthImageLoader getImageLoader(Context context) {
        MaxWidthImageLoader maxWidthImageLoader2;
        Intrinsics.checkNotNullParameter(context, "context");
        MaxWidthImageLoader maxWidthImageLoader3 = maxWidthImageLoader;
        if (maxWidthImageLoader3 != null) {
            return maxWidthImageLoader3;
        }
        synchronized (Reflection.getOrCreateKotlinClass(C2676Networking.class)) {
            MaxWidthImageLoader maxWidthImageLoader4 = maxWidthImageLoader;
            maxWidthImageLoader2 = maxWidthImageLoader4 != null ? maxWidthImageLoader4 : (MaxWidthImageLoader) new Networking$getImageLoader$$inlined$synchronized$lambda$1(context).invoke();
        }
        return maxWidthImageLoader2;
    }

    public static final String getUserAgent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = userAgent;
        if (!(str == null || str.length() == 0)) {
            return str;
        }
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            return DEFAULT_USER_AGENT;
        }
        String str2 = DEFAULT_USER_AGENT;
        try {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            Intrinsics.checkNotNullExpressionValue(defaultUserAgent, "WebSettings.getDefaultUserAgent(context)");
            str2 = defaultUserAgent;
        } catch (Exception unused) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Failed to get a user agent. Defaulting to the system user agent.");
        }
        userAgent = str2;
        return str2;
    }

    @VisibleForTesting
    public static final synchronized void clearForTesting() {
        synchronized (C2676Networking.class) {
            requestQueue = null;
            maxWidthImageLoader = null;
            userAgent = null;
        }
    }

    @VisibleForTesting
    public static final synchronized void setRequestQueueForTesting(MoPubRequestQueue moPubRequestQueue) {
        synchronized (C2676Networking.class) {
            requestQueue = moPubRequestQueue;
        }
    }

    @VisibleForTesting
    public static final synchronized void setImageLoaderForTesting(MaxWidthImageLoader maxWidthImageLoader2) {
        synchronized (C2676Networking.class) {
            maxWidthImageLoader = maxWidthImageLoader2;
        }
    }

    @VisibleForTesting
    public static final synchronized void setUserAgentForTesting(String str) {
        synchronized (C2676Networking.class) {
            userAgent = str;
        }
    }
}
