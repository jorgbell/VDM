package com.mopub.network;

import android.content.Context;
import com.mopub.common.Constants;
import com.mopub.common.util.DeviceUtils;
import com.mopub.volley.toolbox.BasicNetwork;
import com.mopub.volley.toolbox.DiskBasedCache;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Networking.kt */
final class Networking$getRequestQueue$$inlined$synchronized$lambda$1 extends Lambda implements Function0<MoPubRequestQueue> {
    final /* synthetic */ Context $context$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Networking$getRequestQueue$$inlined$synchronized$lambda$1(Context context) {
        super(0);
        this.$context$inlined = context;
    }

    public final MoPubRequestQueue invoke() {
        CustomSSLSocketFactory customSSLSocketFactory = CustomSSLSocketFactory.getDefault(10000);
        Intrinsics.checkNotNullExpressionValue(customSSLSocketFactory, "CustomSSLSocketFactory.g…tants.TEN_SECONDS_MILLIS)");
        Context applicationContext = this.$context$inlined.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        BasicNetwork basicNetwork = new BasicNetwork(new RequestQueueHttpStack(C2676Networking.getUserAgent(applicationContext), C2676Networking.getUrlRewriter(), customSSLSocketFactory));
        StringBuilder sb = new StringBuilder();
        File cacheDir = this.$context$inlined.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        sb.append(cacheDir.getPath());
        sb.append(File.separator);
        sb.append("mopub-volley-cache");
        File file = new File(sb.toString());
        MoPubRequestQueue moPubRequestQueue = new MoPubRequestQueue(new DiskBasedCache(file, (int) DeviceUtils.diskCacheSizeBytes(file, (long) Constants.TEN_MB)), basicNetwork);
        C2676Networking.requestQueue = moPubRequestQueue;
        moPubRequestQueue.start();
        return moPubRequestQueue;
    }
}
