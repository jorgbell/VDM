package com.chartboost.sdk.Libraries;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.util.Base64;
import com.chartboost.sdk.C1285i;
import com.chartboost.sdk.impl.C1327i1;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.d */
public class C1215d {

    /* renamed from: a */
    private int f2668a = -1;

    /* renamed from: b */
    private String f2669b = null;

    /* renamed from: c */
    private String f2670c;

    /* renamed from: com.chartboost.sdk.Libraries.d$a */
    public static class C1216a {

        /* renamed from: a */
        public final int f2671a;

        /* renamed from: b */
        public final String f2672b;

        /* renamed from: c */
        public final String f2673c;

        /* renamed from: d */
        public final String f2674d;

        public C1216a(int i, String str, String str2, String str3) {
            this.f2671a = i;
            this.f2672b = str;
            this.f2673c = str2;
            this.f2674d = str3;
        }

        /* renamed from: a */
        public synchronized Boolean mo10044a() {
            boolean z;
            z = true;
            if (this.f2671a != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: a */
    private static boolean m2931a() {
        return !"Amazon".equalsIgnoreCase(Build.MANUFACTURER);
    }

    /* renamed from: b */
    private void m2932b(Context context) {
        C1212a aVar = new C1212a(context);
        this.f2668a = aVar.f2664a;
        this.f2669b = aVar.f2665b;
    }

    /* renamed from: c */
    public synchronized C1216a mo10043c(Context context) {
        String str;
        if (Looper.myLooper() != Looper.getMainLooper() || "robolectric".equals(Build.FINGERPRINT)) {
            if (m2931a()) {
                m2932b(context);
            } else {
                m2930a(context);
            }
            String str2 = this.f2669b;
            boolean z = true;
            if (this.f2668a != 1) {
                z = false;
            }
            this.f2670c = C1327i1.m3547a(context, z);
            JSONObject jSONObject = new JSONObject();
            String str3 = this.f2670c;
            if (str3 != null && str2 == null) {
                C1217e.m2938a(jSONObject, "uuid", str3);
            }
            if (str2 != null) {
                C1217e.m2938a(jSONObject, "gaid", str2);
            }
            if (C1285i.f3034a) {
                C1285i.m3346a(str2);
                if (str2 != null) {
                    str = "000000000";
                } else {
                    str = this.f2670c;
                }
                C1285i.m3348b(str);
            }
            return new C1216a(this.f2668a, Base64.encodeToString(jSONObject.toString().getBytes(), 0), str2 != null ? "000000000" : this.f2670c, str2);
        }
        CBLogging.m2905b("CBIdentity", "I must be called from a background thread");
        return null;
    }

    /* renamed from: a */
    private void m2930a(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (!(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0)) {
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                if ("00000000-0000-0000-0000-000000000000".equals(string)) {
                    this.f2668a = 1;
                    this.f2669b = null;
                    return;
                }
                this.f2668a = 0;
                this.f2669b = string;
                return;
            }
            this.f2668a = 1;
            this.f2669b = null;
        } catch (Settings.SettingNotFoundException unused) {
            this.f2668a = -1;
            this.f2669b = null;
        }
    }
}
