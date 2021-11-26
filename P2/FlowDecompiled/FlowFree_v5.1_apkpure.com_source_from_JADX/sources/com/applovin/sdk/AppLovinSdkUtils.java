package com.applovin.sdk;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1160r;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLovinSdkUtils {

    /* renamed from: a */
    private static final Handler f2607a = new Handler(Looper.getMainLooper());

    public static final class Size {

        /* renamed from: a */
        private int f2608a;

        /* renamed from: b */
        private int f2609b;

        private Size() {
        }

        public Size(int i, int i2) {
            this.f2608a = i;
            this.f2609b = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.f2608a == size.getWidth() && this.f2609b == size.getHeight();
        }

        public int getHeight() {
            return this.f2609b;
        }

        public int getWidth() {
            return this.f2608a;
        }

        public int hashCode() {
            int i = this.f2609b;
            int i2 = this.f2608a;
            return i ^ ((i2 >>> 16) | (i2 << 16));
        }

        public String toString() {
            return this.f2608a + "x" + this.f2609b;
        }
    }

    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static boolean isSdkVersionGreaterThanOrEqualTo(String str) {
        return AppLovinSdk.VERSION_CODE >= C1160r.m2757f(str);
    }

    public static boolean isTablet(Context context) {
        Point a = C1119g.m2526a(context);
        return Math.min(a.x, a.y) >= dpToPx(context, 600);
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static int pxToDp(Context context, int i) {
        return (int) Math.ceil((double) (((float) i) / context.getResources().getDisplayMetrics().density));
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(false, runnable);
    }

    public static void runOnUiThread(boolean z, Runnable runnable) {
        if (z || !C1160r.m2744b()) {
            f2607a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j) {
        runOnUiThreadDelayed(runnable, j, f2607a);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j, Handler handler) {
        if (j > 0) {
            handler.postDelayed(runnable, j);
        } else if (C1160r.m2744b()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return C1123j.m2577a(jSONObject);
    }
}
