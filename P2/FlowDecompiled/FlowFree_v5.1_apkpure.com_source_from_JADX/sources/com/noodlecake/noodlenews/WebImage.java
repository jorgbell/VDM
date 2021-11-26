package com.noodlecake.noodlenews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WebImage {
    private static final int CONNECT_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 10000;
    private static WebImageCache webImageCache;
    private String url;

    public WebImage(String str) {
        this.url = str;
    }

    public Bitmap getBitmap(Context context) {
        if (webImageCache == null) {
            webImageCache = new WebImageCache(context);
        }
        Bitmap bitmap = null;
        String str = this.url;
        if (!(str == null || (bitmap = webImageCache.get(str)) != null || (bitmap = getBitmapFromUrl(this.url)) == null)) {
            webImageCache.put(this.url, bitmap);
        }
        return bitmap;
    }

    private Bitmap getBitmapFromUrl(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(5000);
            openConnection.setReadTimeout(10000);
            return BitmapFactory.decodeStream((InputStream) openConnection.getContent());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void removeFromCache(String str) {
        WebImageCache webImageCache2 = webImageCache;
        if (webImageCache2 != null) {
            webImageCache2.remove(str);
        }
    }
}
