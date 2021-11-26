package com.mopub.network;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.mopub.common.util.DeviceUtils;
import com.mopub.volley.toolbox.ImageLoader;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Networking.kt */
final class Networking$getImageLoader$$inlined$synchronized$lambda$1 extends Lambda implements Function0<MaxWidthImageLoader> {
    final /* synthetic */ Context $context$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Networking$getImageLoader$$inlined$synchronized$lambda$1(Context context) {
        super(0);
        this.$context$inlined = context;
    }

    public final MaxWidthImageLoader invoke() {
        MoPubRequestQueue requestQueue = C2676Networking.getRequestQueue(this.$context$inlined);
        int memoryCacheSizeBytes = DeviceUtils.memoryCacheSizeBytes(this.$context$inlined);
        final C26771 r2 = new LruCache<String, Bitmap>(memoryCacheSizeBytes, memoryCacheSizeBytes) {
            /* access modifiers changed from: protected */
            public int sizeOf(String str, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(bitmap, "value");
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
        MaxWidthImageLoader maxWidthImageLoader = new MaxWidthImageLoader(requestQueue, this.$context$inlined, new ImageLoader.ImageCache() {
            public Bitmap getBitmap(String str) {
                Intrinsics.checkNotNullParameter(str, "key");
                return (Bitmap) r2.get(str);
            }

            public void putBitmap(String str, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                r2.put(str, bitmap);
            }
        });
        C2676Networking.maxWidthImageLoader = maxWidthImageLoader;
        return maxWidthImageLoader;
    }
}
