package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0966c;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p037c.C0968e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.h */
public class C1120h {

    /* renamed from: a */
    private static final int[] f2395a = {7, 4, 2, 1, 11};

    /* renamed from: b */
    private static final int[] f2396b = {5, 6, 10, 3, 9, 8, 14};

    /* renamed from: c */
    private static final int[] f2397c = {15, 12, 13};

    /* renamed from: d */
    private static final int[] f2398d = {20};

    /* renamed from: a */
    public static String m2536a(InputStream inputStream, C1062k kVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) kVar.mo9350a(C0965b.f1704cX)).intValue()];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static String m2537a(String str, C1062k kVar) {
        return m2538a((String) kVar.mo9350a(C0965b.f1590aO), str, kVar);
    }

    /* renamed from: a */
    public static String m2538a(String str, String str2, C1062k kVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (kVar != null) {
            return str + str2;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    public static JSONObject m2539a(JSONObject jSONObject) throws JSONException {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    /* renamed from: a */
    public static void m2540a(int i, C1062k kVar) {
        C0966c I = kVar.mo9333I();
        if (i == 401) {
            I.mo9123a((C0965b<?>) C0965b.f1569U, (Object) "");
            I.mo9123a((C0965b<?>) C0965b.f1571W, (Object) "");
            I.mo9122a();
            C1107r.m2484i("AppLovinSdk", "SDK key \"" + kVar.mo9409x() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
        } else if (i == 418) {
            I.mo9123a((C0965b<?>) C0965b.f1568T, (Object) Boolean.TRUE);
            I.mo9122a();
        } else {
            if (i < 400 || i >= 500) {
                if (i != -1 || !((Boolean) kVar.mo9350a(C0965b.f1570V)).booleanValue()) {
                    return;
                }
            } else if (!((Boolean) kVar.mo9350a(C0965b.f1570V)).booleanValue()) {
                return;
            }
            kVar.mo9395k();
        }
    }

    /* renamed from: a */
    public static void m2541a(JSONObject jSONObject, boolean z, C1062k kVar) {
        kVar.mo9372ag().mo9307a(jSONObject, z);
    }

    /* renamed from: a */
    public static boolean m2542a() {
        return m2545a((String) null);
    }

    /* renamed from: a */
    private static boolean m2543a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2544a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo b = m2546b(context);
        if (b != null) {
            return b.isConnected();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2545a(String str) {
        if (C1119g.m2532e()) {
            return (!C1119g.m2533f() || TextUtils.isEmpty(str)) ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        return true;
    }

    /* renamed from: b */
    private static NetworkInfo m2546b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: b */
    public static String m2547b(String str, C1062k kVar) {
        return m2538a((String) kVar.mo9350a(C0965b.f1591aP), str, kVar);
    }

    /* renamed from: c */
    public static void m2548c(JSONObject jSONObject, C1062k kVar) {
        String b = C1123j.m2594b(jSONObject, "persisted_data", (String) null, kVar);
        if (C1155o.m2673b(b)) {
            kVar.mo9357a(C0967d.f1871z, b);
            kVar.mo9411z().mo9586c("ConnectionUtils", "Updated persisted data");
        }
    }

    /* renamed from: d */
    public static void m2549d(JSONObject jSONObject, C1062k kVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (kVar != null) {
            try {
                if (jSONObject.has("settings")) {
                    C0966c I = kVar.mo9333I();
                    if (!jSONObject.isNull("settings")) {
                        I.mo9124a(jSONObject.getJSONObject("settings"));
                        I.mo9122a();
                    }
                }
            } catch (JSONException e) {
                kVar.mo9411z().mo9585b("ConnectionUtils", "Unable to parse settings out of API response", e);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: e */
    public static Map<String, String> m2550e(C1062k kVar) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = (String) kVar.mo9350a(C0965b.f1571W);
        if (C1155o.m2673b(str2)) {
            str = "device_token";
        } else {
            if (!((Boolean) kVar.mo9350a(C0965b.f1818ek)).booleanValue()) {
                str2 = kVar.mo9409x();
                str = "api_key";
            }
            hashMap.putAll(C1160r.m2719a(kVar.mo9343T().mo9434h()));
            return hashMap;
        }
        hashMap.put(str, str2);
        hashMap.putAll(C1160r.m2719a(kVar.mo9343T().mo9434h()));
        return hashMap;
    }

    /* renamed from: e */
    public static void m2551e(JSONObject jSONObject, C1062k kVar) {
        JSONObject b = C1123j.m2600b(jSONObject, "filesystem_values", (JSONObject) null, kVar);
        if (b != null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(kVar.mo9334J()).edit();
            Iterator<String> keys = b.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object b2 = C1123j.m2593b(b, next, (Object) null, kVar);
                if (b2 != null) {
                    C0968e.m1770a(next, b2, (SharedPreferences) null, edit);
                }
            }
            edit.apply();
        }
    }

    /* renamed from: f */
    public static String m2552f(C1062k kVar) {
        NetworkInfo b = m2546b(kVar.mo9334J());
        if (b == null) {
            return "unknown";
        }
        int type = b.getType();
        int subtype = b.getSubtype();
        return type == 1 ? "wifi" : type == 0 ? m2543a(subtype, f2395a) ? "2g" : m2543a(subtype, f2396b) ? "3g" : m2543a(subtype, f2397c) ? "4g" : m2543a(subtype, f2398d) ? "5g" : "mobile" : "unknown";
    }

    /* renamed from: f */
    public static void m2553f(JSONObject jSONObject, C1062k kVar) {
        JSONArray b = C1123j.m2599b(jSONObject, "zones", (JSONArray) null, kVar);
        if (b != null && b.length() > 0) {
            kVar.mo9366aa().mo8983a(b);
        }
    }

    /* renamed from: g */
    public static String m2554g(C1062k kVar) {
        return m2538a((String) kVar.mo9350a(C0965b.f1588aM), ((Boolean) kVar.mo9350a(C0965b.f1764df)).booleanValue() ? "5.0/ad" : "4.0/ad", kVar);
    }

    /* renamed from: g */
    public static void m2555g(JSONObject jSONObject, C1062k kVar) {
        JSONArray b = C1123j.m2599b(jSONObject, "zones", (JSONArray) null, kVar);
        if (b != null) {
            kVar.mo9366aa().mo8984b(b);
        }
    }

    /* renamed from: h */
    public static String m2556h(C1062k kVar) {
        return m2538a((String) kVar.mo9350a(C0965b.f1589aN), ((Boolean) kVar.mo9350a(C0965b.f1764df)).booleanValue() ? "5.0/ad" : "4.0/ad", kVar);
    }

    /* renamed from: h */
    public static void m2557h(JSONObject jSONObject, C1062k kVar) {
        JSONObject b = C1123j.m2600b(jSONObject, "variables", (JSONObject) null, kVar);
        if (b != null) {
            kVar.mo9408w().updateVariables(b);
        }
    }

    /* renamed from: i */
    public static String m2558i(C1062k kVar) {
        return m2538a((String) kVar.mo9350a(C0965b.f1594aS), "1.0/variable_config", kVar);
    }

    /* renamed from: j */
    public static String m2559j(C1062k kVar) {
        return m2538a((String) kVar.mo9350a(C0965b.f1595aT), "1.0/variable_config", kVar);
    }
}
