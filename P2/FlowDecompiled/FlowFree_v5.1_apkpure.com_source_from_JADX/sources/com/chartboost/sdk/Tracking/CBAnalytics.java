package com.chartboost.sdk.Tracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.impl.C1357p0;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.util.EnumMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class CBAnalytics {

    public enum CBIAPPurchaseInfo {
        PRODUCT_ID,
        PRODUCT_TITLE,
        PRODUCT_DESCRIPTION,
        PRODUCT_PRICE,
        PRODUCT_CURRENCY_CODE,
        GOOGLE_PURCHASE_DATA,
        GOOGLE_PURCHASE_SIGNATURE,
        AMAZON_PURCHASE_TOKEN,
        AMAZON_USER_ID
    }

    public enum CBIAPType {
        GOOGLE_PLAY,
        AMAZON
    }

    public enum CBLevelType {
        HIGHEST_LEVEL_REACHED(1),
        CURRENT_AREA(2),
        CHARACTER_LEVEL(3),
        OTHER_SEQUENTIAL(4),
        OTHER_NONSEQUENTIAL(5);
        

        /* renamed from: a */
        private final int f2899a;

        private CBLevelType(int i) {
            this.f2899a = i;
        }

        public int getLevelType() {
            return this.f2899a;
        }
    }

    private CBAnalytics() {
    }

    /* renamed from: a */
    private static synchronized void m3126a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CBIAPType cBIAPType) {
        CBIAPType cBIAPType2 = cBIAPType;
        synchronized (CBAnalytics.class) {
            C1414j b = C1414j.m3867b();
            if (b == null) {
                CBLogging.m2905b("CBPostInstallTracker", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
            } else if (b.mo10711d() == null) {
                CBLogging.m2905b("CBPostInstallTracker", "You need call Chartboost.init() before calling any public API's");
            } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                CBLogging.m2905b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
            } else {
                try {
                    String str10 = str4;
                    Matcher matcher = Pattern.compile("(\\d+\\.\\d+)|(\\d+)").matcher(str4);
                    matcher.find();
                    String group = matcher.group();
                    if (TextUtils.isEmpty(group)) {
                        CBLogging.m2905b("CBPostInstallTracker", "Invalid price object");
                        return;
                    }
                    float parseFloat = Float.parseFloat(group);
                    JSONObject jSONObject = null;
                    CBIAPType cBIAPType3 = CBIAPType.GOOGLE_PLAY;
                    if (cBIAPType2 == cBIAPType3) {
                        if (!TextUtils.isEmpty(str6)) {
                            if (!TextUtils.isEmpty(str7)) {
                                jSONObject = C1217e.m2937a(C1217e.m2935a("purchaseData", (Object) str6), C1217e.m2935a("purchaseSignature", (Object) str7), C1217e.m2935a("type", (Object) Integer.valueOf(cBIAPType3.ordinal())));
                            }
                        }
                        CBLogging.m2905b("CBPostInstallTracker", "Null object is passed for for purchase data or purchase signature");
                        return;
                    }
                    CBIAPType cBIAPType4 = CBIAPType.AMAZON;
                    if (cBIAPType2 == cBIAPType4) {
                        if (!TextUtils.isEmpty(str8)) {
                            if (!TextUtils.isEmpty(str9)) {
                                jSONObject = C1217e.m2937a(C1217e.m2935a("userID", (Object) str8), C1217e.m2935a("purchaseToken", (Object) str9), C1217e.m2935a("type", (Object) Integer.valueOf(cBIAPType4.ordinal())));
                            }
                        }
                        CBLogging.m2905b("CBPostInstallTracker", "Null object is passed for for amazon user id or amazon purchase token");
                        return;
                    }
                    if (jSONObject == null) {
                        CBLogging.m2905b("CBPostInstallTracker", "Error while parsing the receipt to a JSON Object, ");
                        return;
                    }
                    String str11 = str2;
                    String str12 = str3;
                    String str13 = str;
                    m3125a(b.f3520w, b.f3521x, C1217e.m2937a(C1217e.m2935a("localized-title", (Object) str2), C1217e.m2935a("localized-description", (Object) str3), C1217e.m2935a("price", (Object) Float.valueOf(parseFloat)), C1217e.m2935a("currency", (Object) str5), C1217e.m2935a("productID", (Object) str), C1217e.m2935a((String) TransactionDetailsUtilities.RECEIPT, (Object) Base64.encodeToString(jSONObject.toString().getBytes(), 2))), "iap", cBIAPType2);
                } catch (IllegalStateException unused) {
                    CBLogging.m2905b("CBPostInstallTracker", "Invalid price object");
                }
            }
        }
    }

    public static synchronized void trackInAppAmazonStorePurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        synchronized (CBAnalytics.class) {
            m3126a(str5, str, str2, str3, str4, (String) null, (String) null, str6, str7, CBIAPType.AMAZON);
        }
    }

    public static synchronized void trackInAppGooglePlayPurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        synchronized (CBAnalytics.class) {
            m3126a(str5, str, str2, str3, str4, str6, str7, (String) null, (String) null, CBIAPType.GOOGLE_PLAY);
        }
    }

    public static synchronized void trackLevelInfo(String str, CBLevelType cBLevelType, int i, String str2) {
        synchronized (CBAnalytics.class) {
            trackLevelInfo(str, cBLevelType, i, 0, str2);
        }
    }

    public synchronized void trackInAppPurchaseEvent(EnumMap<CBIAPPurchaseInfo, String> enumMap, CBIAPType cBIAPType) {
        if (!(enumMap == null || cBIAPType == null)) {
            CBIAPPurchaseInfo cBIAPPurchaseInfo = CBIAPPurchaseInfo.PRODUCT_ID;
            if (!TextUtils.isEmpty(enumMap.get(cBIAPPurchaseInfo))) {
                CBIAPPurchaseInfo cBIAPPurchaseInfo2 = CBIAPPurchaseInfo.PRODUCT_TITLE;
                if (!TextUtils.isEmpty(enumMap.get(cBIAPPurchaseInfo2))) {
                    CBIAPPurchaseInfo cBIAPPurchaseInfo3 = CBIAPPurchaseInfo.PRODUCT_DESCRIPTION;
                    if (!TextUtils.isEmpty(enumMap.get(cBIAPPurchaseInfo3))) {
                        CBIAPPurchaseInfo cBIAPPurchaseInfo4 = CBIAPPurchaseInfo.PRODUCT_PRICE;
                        if (!TextUtils.isEmpty(enumMap.get(cBIAPPurchaseInfo4))) {
                            CBIAPPurchaseInfo cBIAPPurchaseInfo5 = CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE;
                            if (!TextUtils.isEmpty(enumMap.get(cBIAPPurchaseInfo5))) {
                                m3126a(enumMap.get(cBIAPPurchaseInfo), enumMap.get(cBIAPPurchaseInfo2), enumMap.get(cBIAPPurchaseInfo3), enumMap.get(cBIAPPurchaseInfo4), enumMap.get(cBIAPPurchaseInfo5), enumMap.get(CBIAPPurchaseInfo.GOOGLE_PURCHASE_DATA), enumMap.get(CBIAPPurchaseInfo.GOOGLE_PURCHASE_SIGNATURE), enumMap.get(CBIAPPurchaseInfo.AMAZON_USER_ID), enumMap.get(CBIAPPurchaseInfo.AMAZON_PURCHASE_TOKEN), cBIAPType);
                                return;
                            }
                        }
                    }
                }
            }
        }
        CBLogging.m2905b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
    }

    public static synchronized void trackLevelInfo(String str, CBLevelType cBLevelType, int i, int i2, String str2) {
        synchronized (CBAnalytics.class) {
            C1414j b = C1414j.m3867b();
            if (b == null) {
                CBLogging.m2905b("CBPostInstallTracker", "trackLevelInfo: SDK is not initialized");
            } else if (TextUtils.isEmpty(str)) {
                CBLogging.m2905b("CBPostInstallTracker", "Invalid value: event label cannot be empty or null");
            } else if (cBLevelType == null) {
                CBLogging.m2905b("CBPostInstallTracker", "Invalid value: level type cannot be empty or null, please choose from one of the CBLevelType enum values");
            } else if (i < 0 || i2 < 0) {
                CBLogging.m2905b("CBPostInstallTracker", "Invalid value: Level number should be > 0");
            } else if (str2.isEmpty()) {
                CBLogging.m2905b("CBPostInstallTracker", "Invalid value: description cannot be empty or null");
            } else {
                Context d = b.mo10711d();
                if (d != null) {
                    C1414j.m3860a(d);
                }
                JSONObject a = C1217e.m2937a(C1217e.m2935a("event_label", (Object) str), C1217e.m2935a("event_field", (Object) Integer.valueOf(cBLevelType.getLevelType())), C1217e.m2935a("main_level", (Object) Integer.valueOf(i)), C1217e.m2935a("sub_level", (Object) Integer.valueOf(i2)), C1217e.m2935a("description", (Object) str2), C1217e.m2935a("timestamp", (Object) Long.valueOf(System.currentTimeMillis())), C1217e.m2935a("data_type", (Object) "level_info"));
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a);
                m3124a(b.f3520w, b.f3521x, jSONArray, "tracking");
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m3125a(C1247g gVar, C1234g gVar2, JSONObject jSONObject, String str, CBIAPType cBIAPType) {
        synchronized (CBAnalytics.class) {
            C1357p0 p0Var = new C1357p0("https://live.chartboost.com", String.format(Locale.US, "%s%s", new Object[]{"/post-install-event/", str}), gVar2, 2, (C1357p0.C1358a) null);
            p0Var.mo10562a(str, (Object) jSONObject);
            p0Var.f3342m = true;
            p0Var.mo10561a(str);
            gVar.mo10147a(p0Var);
        }
    }

    /* renamed from: a */
    private static synchronized void m3124a(C1247g gVar, C1234g gVar2, JSONArray jSONArray, String str) {
        synchronized (CBAnalytics.class) {
            C1357p0 p0Var = new C1357p0("https://live.chartboost.com", "/post-install-event/".concat("tracking"), gVar2, 2, (C1357p0.C1358a) null);
            p0Var.mo10562a("track_info", (Object) jSONArray);
            p0Var.f3342m = true;
            p0Var.mo10561a(str);
            gVar.mo10147a(p0Var);
        }
    }
}
