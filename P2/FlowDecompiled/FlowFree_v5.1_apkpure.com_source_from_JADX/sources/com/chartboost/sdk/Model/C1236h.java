package com.chartboost.sdk.Model;

import com.chartboost.sdk.Libraries.C1213b;
import com.chartboost.sdk.Privacy.model.CCPA;
import com.chartboost.sdk.impl.C1406x;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.h */
public class C1236h {

    /* renamed from: A */
    private String f2805A;

    /* renamed from: B */
    private C1239i f2806B;

    /* renamed from: a */
    public final String f2807a;

    /* renamed from: b */
    public final boolean f2808b;

    /* renamed from: c */
    public final boolean f2809c;

    /* renamed from: d */
    public final List<String> f2810d;

    /* renamed from: e */
    public final boolean f2811e;

    /* renamed from: f */
    public final boolean f2812f;

    /* renamed from: g */
    public final boolean f2813g;

    /* renamed from: h */
    public final boolean f2814h;

    /* renamed from: i */
    public final int f2815i;

    /* renamed from: j */
    public final boolean f2816j;

    /* renamed from: k */
    public final long f2817k;

    /* renamed from: l */
    public final int f2818l;

    /* renamed from: m */
    public final int f2819m;

    /* renamed from: n */
    public final int f2820n;

    /* renamed from: o */
    public final int f2821o;

    /* renamed from: p */
    public final List<String> f2822p;

    /* renamed from: q */
    public final boolean f2823q;

    /* renamed from: r */
    public final boolean f2824r;

    /* renamed from: s */
    public final boolean f2825s;

    /* renamed from: t */
    public final boolean f2826t;

    /* renamed from: u */
    public final int f2827u;

    /* renamed from: v */
    public final boolean f2828v;

    /* renamed from: w */
    public final String f2829w;

    /* renamed from: x */
    public final String f2830x;

    /* renamed from: y */
    private final C1237a f2831y;

    /* renamed from: z */
    public C1238b f2832z;

    public C1236h(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        this.f2807a = jSONObject2.optString("configVariant");
        this.f2808b = jSONObject2.optBoolean("prefetchDisable");
        this.f2809c = jSONObject2.optBoolean("publisherDisable");
        this.f2831y = C1237a.m3068a(jSONObject);
        try {
            this.f2832z = C1238b.m3072a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f2805A = jSONObject2.optString("publisherWarning", (String) null);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("invalidateFolderList");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = optJSONArray.optString(i);
                if (!optString.isEmpty()) {
                    arrayList.add(optString);
                }
            }
        }
        this.f2810d = Collections.unmodifiableList(arrayList);
        JSONObject optJSONObject = jSONObject2.optJSONObject("native");
        optJSONObject = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.f2811e = optJSONObject.optBoolean("enabled", true);
        this.f2812f = optJSONObject.optBoolean("inplayEnabled", true);
        this.f2813g = optJSONObject.optBoolean("interstitialEnabled", true);
        this.f2814h = optJSONObject.optBoolean("lockOrientation");
        this.f2815i = optJSONObject.optInt("prefetchSession", 3);
        this.f2816j = optJSONObject.optBoolean("rewardVideoEnabled", true);
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("trackingLevels");
        optJSONObject2 = optJSONObject2 == null ? new JSONObject() : optJSONObject2;
        optJSONObject2.optBoolean("critical", true);
        optJSONObject2.optBoolean("includeStackTrace", true);
        optJSONObject2.optBoolean("error");
        optJSONObject2.optBoolean("debug");
        optJSONObject2.optBoolean("session");
        optJSONObject2.optBoolean("system");
        optJSONObject2.optBoolean("timing");
        optJSONObject2.optBoolean("user");
        this.f2806B = C1239i.m3076a(jSONObject);
        this.f2817k = jSONObject2.optLong("getAdRetryBaseMs", 200);
        this.f2818l = jSONObject2.optInt("getAdRetryMaxBackoffExponent", 3);
        JSONObject optJSONObject3 = jSONObject2.optJSONObject("webview");
        optJSONObject3 = optJSONObject3 == null ? new JSONObject() : optJSONObject3;
        this.f2819m = optJSONObject3.optInt("cacheMaxBytes", 104857600);
        int i2 = 10;
        int optInt = optJSONObject3.optInt("cacheMaxUnits", 10);
        this.f2820n = optInt > 0 ? optInt : i2;
        this.f2821o = (int) TimeUnit.SECONDS.toDays((long) optJSONObject3.optInt("cacheTTLs", C1213b.f2666a));
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray2 = optJSONObject3.optJSONArray("directories");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                String optString2 = optJSONArray2.optString(i3);
                if (!optString2.isEmpty()) {
                    arrayList2.add(optString2);
                }
            }
        }
        this.f2822p = Collections.unmodifiableList(arrayList2);
        this.f2823q = optJSONObject3.optBoolean("enabled", m3063e());
        this.f2824r = optJSONObject3.optBoolean("inplayEnabled", true);
        this.f2825s = optJSONObject3.optBoolean("interstitialEnabled", true);
        optJSONObject3.optInt("invalidatePendingImpression", 3);
        this.f2826t = optJSONObject3.optBoolean("lockOrientation", true);
        this.f2827u = optJSONObject3.optInt("prefetchSession", 3);
        this.f2828v = optJSONObject3.optBoolean("rewardVideoEnabled", true);
        String optString3 = optJSONObject3.optString(MediationMetaData.KEY_VERSION, "v2");
        this.f2829w = optString3;
        String.format("%s/%s%s", new Object[]{"webview", optString3, "/interstitial/get"});
        this.f2830x = String.format("%s/%s/%s", new Object[]{"webview", optString3, "prefetch"});
        String.format("%s/%s%s", new Object[]{"webview", optString3, "/reward/get"});
    }

    /* renamed from: e */
    private static boolean m3063e() {
        int[] iArr = {4, 4, 2};
        String a = C1406x.m3823b().mo10694a();
        if (a != null && a.length() > 0) {
            String[] split = a.replaceAll("[^\\d.]", "").split("\\.");
            int i = 0;
            while (i < split.length && i < 3) {
                try {
                    if (Integer.valueOf(split[i]).intValue() > iArr[i]) {
                        return true;
                    }
                    if (Integer.valueOf(split[i]).intValue() < iArr[i]) {
                        return false;
                    }
                    i++;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public C1237a mo10129a() {
        return this.f2831y;
    }

    /* renamed from: b */
    public boolean mo10130b() {
        return this.f2809c;
    }

    /* renamed from: c */
    public String mo10131c() {
        return this.f2805A;
    }

    /* renamed from: d */
    public C1239i mo10132d() {
        return this.f2806B;
    }

    /* renamed from: com.chartboost.sdk.Model.h$a */
    public static class C1237a {

        /* renamed from: a */
        private double f2833a;

        /* renamed from: b */
        private double f2834b;

        /* renamed from: c */
        private boolean f2835c;

        /* renamed from: a */
        public static C1237a m3068a(JSONObject jSONObject) {
            C1237a aVar = new C1237a();
            aVar.f2835c = jSONObject.optBoolean("bannerEnable", true);
            aVar.f2833a = jSONObject.optDouble("bannerRefreshInterval", 30.0d);
            aVar.f2834b = jSONObject.optDouble("bannerShowTimeout", 30.0d);
            return aVar;
        }

        /* renamed from: b */
        public double mo10134b() {
            return this.f2834b;
        }

        /* renamed from: c */
        public boolean mo10135c() {
            return this.f2835c;
        }

        /* renamed from: a */
        public double mo10133a() {
            return this.f2833a;
        }
    }

    /* renamed from: com.chartboost.sdk.Model.h$b */
    public static class C1238b {

        /* renamed from: a */
        private HashSet<String> f2836a;

        /* renamed from: a */
        public static C1238b m3072a(JSONObject jSONObject) throws JSONException {
            C1238b bVar = new C1238b();
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(CCPA.CCPA_STANDARD);
            JSONArray optJSONArray = jSONObject.optJSONArray("privacyStandards");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                m3074a(optJSONArray, hashSet, length);
                m3073a(hashSet, length);
            }
            bVar.f2836a = hashSet;
            return bVar;
        }

        /* renamed from: a */
        private static void m3074a(JSONArray jSONArray, HashSet<String> hashSet, int i) throws JSONException {
            for (int i2 = 0; i2 < i; i2++) {
                hashSet.add(jSONArray.getString(i2));
            }
        }

        /* renamed from: a */
        private static void m3073a(HashSet<String> hashSet, int i) {
            if (i == 0) {
                hashSet.clear();
            }
        }

        /* renamed from: a */
        public HashSet<String> mo10136a() {
            return this.f2836a;
        }
    }
}
