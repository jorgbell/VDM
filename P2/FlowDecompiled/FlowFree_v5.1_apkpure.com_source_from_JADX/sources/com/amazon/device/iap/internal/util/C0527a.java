package com.amazon.device.iap.internal.util;

import com.amazon.android.Kiwi;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.p008b.C0480a;
import com.amazon.device.iap.internal.p008b.C0496d;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import com.applovin.sdk.AppLovinEventParameters;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amazon.device.iap.internal.util.a */
/* compiled from: ReceiptHelper */
public class C0527a {

    /* renamed from: a */
    private static final String f114a = "a";

    /* renamed from: a */
    public static Receipt m173a(JSONObject jSONObject, String str, String str2) throws C0480a, C0496d, IllegalArgumentException {
        int i = C05281.f115a[m175b(jSONObject).ordinal()];
        if (i == 1) {
            return m178c(jSONObject, str, str2);
        }
        if (i != 2) {
            return m179d(jSONObject, str, str2);
        }
        return m176b(jSONObject, str, str2);
    }

    /* renamed from: com.amazon.device.iap.internal.util.a$1 */
    /* compiled from: ReceiptHelper */
    static /* synthetic */ class C05281 {

        /* renamed from: a */
        static final /* synthetic */ int[] f115a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.amazon.device.iap.internal.util.c[] r0 = com.amazon.device.iap.internal.util.C0530c.m182a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f115a = r0
                com.amazon.device.iap.internal.util.c r1 = com.amazon.device.iap.internal.util.C0530c.V1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f115a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazon.device.iap.internal.util.c r1 = com.amazon.device.iap.internal.util.C0530c.LEGACY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f115a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazon.device.iap.internal.util.c r1 = com.amazon.device.iap.internal.util.C0530c.V2     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.iap.internal.util.C0527a.C05281.<clinit>():void");
        }
    }

    /* renamed from: b */
    private static Receipt m176b(JSONObject jSONObject, String str, String str2) throws C0480a, C0496d {
        String optString = jSONObject.optString(InAppPurchaseMetaData.KEY_SIGNATURE);
        if (!C0531d.m186a(optString)) {
            try {
                Receipt a = m172a(jSONObject);
                String str3 = str + "-" + a.getReceiptId();
                boolean isSignedByKiwi = Kiwi.isSignedByKiwi(str3, optString);
                C0532e.m187a(f114a, "stringToVerify/legacy:\n" + str3 + "\nsignature:\n" + optString);
                if (isSignedByKiwi) {
                    return a;
                }
                MetricsHelper.submitReceiptVerificationFailureMetrics(str2, str3, optString);
                throw new C0496d(str2, str3, optString);
            } catch (JSONException e) {
                throw new C0480a(str2, jSONObject.toString(), e);
            }
        } else {
            C0532e.m189b(f114a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString);
            throw new C0496d(str2, (String) null, optString);
        }
    }

    /* renamed from: a */
    private static Receipt m172a(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString("token");
        String string = jSONObject.getString(AppLovinEventParameters.PRODUCT_IDENTIFIER);
        ProductType valueOf = ProductType.valueOf(jSONObject.getString("itemType").toUpperCase());
        String optString2 = jSONObject.optString("startDate");
        Date date = null;
        Date b = m174a(optString2) ? null : m177b(optString2);
        String optString3 = jSONObject.optString("endDate");
        if (!m174a(optString3)) {
            date = m177b(optString3);
        }
        return new ReceiptBuilder().setReceiptId(optString).setSku(string).setProductType(valueOf).setPurchaseDate(b).setCancelDate(date).build();
    }

    /* renamed from: c */
    private static Receipt m178c(JSONObject jSONObject, String str, String str2) throws C0480a, C0496d {
        String optString = jSONObject.optString("DeviceId");
        String optString2 = jSONObject.optString(InAppPurchaseMetaData.KEY_SIGNATURE);
        Date date = null;
        if (!C0531d.m186a(optString2)) {
            try {
                Receipt a = m172a(jSONObject);
                Object[] objArr = new Object[9];
                objArr[0] = PurchasingService.SDK_VERSION;
                objArr[1] = str;
                objArr[2] = optString;
                objArr[3] = a.getProductType();
                objArr[4] = a.getSku();
                objArr[5] = a.getReceiptId();
                objArr[6] = str2;
                ProductType productType = ProductType.SUBSCRIPTION;
                objArr[7] = productType == a.getProductType() ? a.getPurchaseDate() : null;
                if (productType == a.getProductType()) {
                    date = a.getCancelDate();
                }
                objArr[8] = date;
                String format = String.format("%s|%s|%s|%s|%s|%s|%s|%tQ|%tQ", objArr);
                String str3 = f114a;
                C0532e.m187a(str3, "stringToVerify/v1:\n" + format + "\nsignature:\n" + optString2);
                if (Kiwi.isSignedByKiwi(format, optString2)) {
                    return a;
                }
                MetricsHelper.submitReceiptVerificationFailureMetrics(str2, format, optString2);
                throw new C0496d(str2, format, optString2);
            } catch (JSONException e) {
                throw new C0480a(str2, jSONObject.toString(), e);
            }
        } else {
            String str4 = f114a;
            C0532e.m189b(str4, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString2);
            throw new C0496d(str2, (String) null, optString2);
        }
    }

    /* renamed from: d */
    private static Receipt m179d(JSONObject jSONObject, String str, String str2) throws C0480a, C0496d {
        String optString = jSONObject.optString("DeviceId");
        String optString2 = jSONObject.optString(InAppPurchaseMetaData.KEY_SIGNATURE);
        Date date = null;
        if (!C0531d.m186a(optString2)) {
            try {
                String string = jSONObject.getString("receiptId");
                String string2 = jSONObject.getString(AppLovinEventParameters.PRODUCT_IDENTIFIER);
                ProductType valueOf = ProductType.valueOf(jSONObject.getString("itemType").toUpperCase());
                String optString3 = jSONObject.optString("purchaseDate");
                Date b = m174a(optString3) ? null : m177b(optString3);
                String optString4 = jSONObject.optString("cancelDate");
                if (!m174a(optString4)) {
                    date = m177b(optString4);
                }
                Receipt build = new ReceiptBuilder().setReceiptId(string).setSku(string2).setProductType(valueOf).setPurchaseDate(b).setCancelDate(date).build();
                String format = String.format("%s|%s|%s|%s|%s|%tQ|%tQ", new Object[]{str, optString, build.getProductType(), build.getSku(), build.getReceiptId(), build.getPurchaseDate(), build.getCancelDate()});
                String str3 = f114a;
                C0532e.m187a(str3, "stringToVerify/v2:\n" + format + "\nsignature:\n" + optString2);
                if (Kiwi.isSignedByKiwi(format, optString2)) {
                    return build;
                }
                MetricsHelper.submitReceiptVerificationFailureMetrics(str2, format, optString2);
                throw new C0496d(str2, format, optString2);
            } catch (JSONException e) {
                throw new C0480a(str2, jSONObject.toString(), e);
            }
        } else {
            String str4 = f114a;
            C0532e.m189b(str4, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString2);
            throw new C0496d(str2, (String) null, optString2);
        }
    }

    /* renamed from: a */
    protected static boolean m174a(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: b */
    protected static Date m177b(String str) throws JSONException {
        try {
            Date parse = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(str);
            if (0 == parse.getTime()) {
                return null;
            }
            return parse;
        } catch (ParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    /* renamed from: b */
    private static C0530c m175b(JSONObject jSONObject) {
        String optString = jSONObject.optString("DeviceId");
        if (!C0531d.m186a(jSONObject.optString("receiptId"))) {
            return C0530c.V2;
        }
        if (C0531d.m186a(optString)) {
            return C0530c.LEGACY;
        }
        return C0530c.V1;
    }
}
