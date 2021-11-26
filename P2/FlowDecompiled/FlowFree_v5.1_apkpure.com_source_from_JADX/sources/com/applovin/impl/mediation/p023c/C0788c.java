package com.applovin.impl.mediation.p023c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mopub.common.logging.MoPubLog;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.c */
public class C0788c {

    /* renamed from: a */
    private static final TreeMap<String, String> f908a;

    /* renamed from: b */
    private static final List<String> f909b;

    /* renamed from: c */
    private static JSONArray f910c;

    static {
        TreeMap<String, String> treeMap = new TreeMap<>();
        f908a = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        treeMap.put("com.applovin.mediation.adapters.AmazonMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AmazonBiddingMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "AppLovin");
        treeMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        treeMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        treeMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "AdMob");
        treeMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        treeMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        treeMap.put("com.applovin.mediation.adapters.IMobileMediationAdapter", "i-mobile");
        treeMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        treeMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "Fyber");
        treeMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        treeMap.put("com.applovin.mediation.adapters.LeadboltMediationAdapter", "Leadbolt");
        treeMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        treeMap.put("com.applovin.mediation.adapters.MadvertiseMediationAdapter", "madvertise");
        treeMap.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        treeMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "Mintegral");
        treeMap.put("com.applovin.mediation.adapters.MoPubMediationAdapter", MoPubLog.LOGTAG);
        treeMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        treeMap.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        treeMap.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        treeMap.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        treeMap.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        treeMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        treeMap.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        treeMap.put("com.applovin.mediation.adapters.TapjoyMediationAdapter", "Tapjoy");
        treeMap.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        treeMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        treeMap.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        treeMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", "Vungle");
        treeMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
        f909b = new ArrayList(treeMap.keySet());
    }

    /* renamed from: a */
    public static C1020o.C1022a m1108a(MaxAdFormat maxAdFormat) {
        return maxAdFormat == MaxAdFormat.INTERSTITIAL ? C1020o.C1022a.MEDIATION_INTERSTITIAL : maxAdFormat == MaxAdFormat.REWARDED ? C1020o.C1022a.MEDIATION_INCENTIVIZED : maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL ? C1020o.C1022a.MEDIATION_REWARDED_INTERSTITIAL : C1020o.C1022a.MEDIATION_BANNER;
    }

    /* renamed from: a */
    public static MaxAdapter m1109a(String str, C1062k kVar) {
        Class<MaxAdapter> cls = MaxAdapter.class;
        if (TextUtils.isEmpty(str)) {
            kVar.mo9411z().mo9588e("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            return null;
        }
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                return (MaxAdapter) cls2.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{kVar.mo9347X()});
            }
            C1107r z = kVar.mo9411z();
            z.mo9588e("AppLovinSdk", str + " error: not an instance of '" + cls.getName() + "'.");
            return null;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            C1107r z2 = kVar.mo9411z();
            z2.mo9585b("AppLovinSdk", "Failed to load: " + str, th);
        }
    }

    /* renamed from: a */
    public static AppLovinSdkUtils.Size m1110a(int i, MaxAdFormat maxAdFormat, Activity activity) {
        if (i < 0) {
            try {
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i = AppLovinSdkUtils.pxToDp(activity, displayMetrics.widthPixels);
            } catch (Throwable th) {
                C1107r.m2480c("MediationUtils", "Failed to get adaptive banner size. Will fallback to using format specific ad view ad size.", th);
                return maxAdFormat.getSize();
            }
        }
        Class<?> cls = Class.forName("com.google.android.gms.ads.AdSize");
        Method method = cls.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", new Class[]{Context.class, Integer.TYPE});
        Method method2 = cls.getMethod("getWidth", new Class[0]);
        Method method3 = cls.getMethod("getHeight", new Class[0]);
        Object invoke = method.invoke((Object) null, new Object[]{activity, Integer.valueOf(i)});
        return new AppLovinSdkUtils.Size(((Integer) method2.invoke(invoke, new Object[0])).intValue(), ((Integer) method3.invoke(invoke, new Object[0])).intValue());
    }

    /* renamed from: a */
    public static JSONArray m1111a(C1062k kVar) {
        JSONArray jSONArray;
        if (!((Boolean) kVar.mo9350a(C0964a.f1533K)).booleanValue() && (jSONArray = f910c) != null) {
            return jSONArray;
        }
        if (f910c != null) {
            m1113b(kVar);
            return f910c;
        }
        f910c = new JSONArray();
        for (String next : f909b) {
            MaxAdapter a = m1109a(next, kVar);
            if (a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(MediationMetaData.KEY_NAME, f908a.get(next));
                    jSONObject.put("class", next);
                    jSONObject.put("sdk_version", a.getSdkVersion());
                    jSONObject.put(MediationMetaData.KEY_VERSION, a.getAdapterVersion());
                } catch (Throwable unused) {
                }
                f910c.put(jSONObject);
            }
        }
        return f910c;
    }

    /* renamed from: a */
    public static boolean m1112a(Object obj) {
        return (obj instanceof C0934g) && C1155o.m2673b(((C0934g) obj).mo9003L());
    }

    /* renamed from: b */
    private static void m1113b(C1062k kVar) {
        MaxAdapter a;
        for (int i = 0; i < f910c.length(); i++) {
            JSONObject a2 = C1123j.m2581a(f910c, i, (JSONObject) null, kVar);
            String b = C1123j.m2594b(a2, "class", "", kVar);
            if (!C1155o.m2673b(C1123j.m2594b(a2, "sdk_version", "", kVar)) && (a = m1109a(b, kVar)) != null) {
                C1123j.m2584a(a2, "sdk_version", a.getSdkVersion(), kVar);
            }
        }
    }

    /* renamed from: b */
    public static boolean m1114b(Object obj) {
        return (obj instanceof C0733a) && "APPLOVIN".equals(((C0733a) obj).mo8444K());
    }
}
