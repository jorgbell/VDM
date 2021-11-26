package com.amazon.device.iap.internal.p007a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.C0517c;
import com.amazon.device.iap.internal.C0524d;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.internal.util.C0529b;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.applovin.sdk.AppLovinEventParameters;
import com.mopub.mobileads.VastIconXmlManager;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amazon.device.iap.internal.a.c */
/* compiled from: SandboxRequestHandler */
public final class C0476c implements C0517c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f24a = "c";

    /* renamed from: a */
    public void mo7433a(RequestId requestId) {
        C0532e.m187a(f24a, "sendGetUserDataRequest");
        m40a(requestId.toString(), false, false);
    }

    /* renamed from: a */
    private void m40a(String str, boolean z, boolean z2) {
        try {
            Context b = C0524d.m156d().mo7500b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", str);
            jSONObject.put("packageName", b.getPackageName());
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            jSONObject.put("isPurchaseUpdates", z);
            jSONObject.put("reset", z2);
            bundle.putString("userInput", jSONObject.toString());
            Intent a = m34a("com.amazon.testclient.iap.appUserId");
            a.addFlags(268435456);
            a.putExtras(bundle);
            b.startService(a);
        } catch (JSONException unused) {
            C0532e.m189b(f24a, "Error in sendGetUserDataRequest.");
        }
    }

    /* renamed from: a */
    public void mo7434a(RequestId requestId, String str) {
        C0532e.m187a(f24a, "sendPurchaseRequest");
        try {
            Context b = C0524d.m156d().mo7500b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AppLovinEventParameters.PRODUCT_IDENTIFIER, str);
            jSONObject.put("requestId", requestId.toString());
            jSONObject.put("packageName", b.getPackageName());
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            bundle.putString("purchaseInput", jSONObject.toString());
            Intent a = m34a("com.amazon.testclient.iap.purchase");
            a.addFlags(268435456);
            a.putExtras(bundle);
            b.startService(a);
        } catch (JSONException unused) {
            C0532e.m189b(f24a, "Error in sendPurchaseRequest.");
        }
    }

    /* renamed from: a */
    public void mo7436a(RequestId requestId, Set<String> set) {
        C0532e.m187a(f24a, "sendItemDataRequest");
        try {
            Context b = C0524d.m156d().mo7500b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray(set);
            jSONObject.put("requestId", requestId.toString());
            jSONObject.put("packageName", b.getPackageName());
            jSONObject.put("skus", jSONArray);
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            bundle.putString("itemDataInput", jSONObject.toString());
            Intent a = m34a("com.amazon.testclient.iap.itemData");
            a.addFlags(268435456);
            a.putExtras(bundle);
            b.startService(a);
        } catch (JSONException unused) {
            C0532e.m189b(f24a, "Error in sendItemDataRequest.");
        }
    }

    /* renamed from: a */
    public void mo7437a(RequestId requestId, boolean z) {
        if (requestId == null) {
            requestId = new RequestId();
        }
        String str = f24a;
        C0532e.m187a(str, "sendPurchaseUpdatesRequest/sendGetUserData first:" + requestId);
        m40a(requestId.toString(), true, z);
    }

    /* renamed from: a */
    public void mo7435a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        C0532e.m187a(f24a, "sendNotifyPurchaseFulfilled");
        try {
            Context b = C0524d.m156d().mo7500b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", requestId.toString());
            jSONObject.put("packageName", b.getPackageName());
            jSONObject.put("receiptId", str);
            jSONObject.put("fulfillmentResult", fulfillmentResult);
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            bundle.putString("purchaseFulfilledInput", jSONObject.toString());
            Intent a = m34a("com.amazon.testclient.iap.purchaseFulfilled");
            a.addFlags(268435456);
            a.putExtras(bundle);
            b.startService(a);
        } catch (JSONException unused) {
            C0532e.m189b(f24a, "Error in sendNotifyPurchaseFulfilled.");
        }
    }

    /* renamed from: a */
    public void mo7432a(Context context, Intent intent) {
        C0532e.m187a(f24a, "handleResponse");
        intent.setComponent(new ComponentName("com.amazon.sdktestclient", "com.amazon.sdktestclient.command.CommandBroker"));
        try {
            String string = intent.getExtras().getString("responseType");
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchase")) {
                m46g(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.appUserId")) {
                m44e(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.itemData")) {
                m42c(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates")) {
                m38a(intent);
            }
        } catch (Exception e) {
            Log.e(f24a, "Error handling response.", e);
        }
    }

    /* renamed from: a */
    private Intent m34a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName("com.amazon.sdktestclient", "com.amazon.sdktestclient.command.CommandBroker"));
        return intent;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7438a(final Object obj) {
        C0531d.m183a(obj, "response");
        Context b = C0524d.m156d().mo7500b();
        final PurchasingListener a = C0524d.m156d().mo7493a();
        if (b == null || a == null) {
            String str = f24a;
            C0532e.m187a(str, "PurchasingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(b.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    Object obj = obj;
                    if (obj instanceof ProductDataResponse) {
                        a.onProductDataResponse((ProductDataResponse) obj);
                    } else if (obj instanceof UserDataResponse) {
                        a.onUserDataResponse((UserDataResponse) obj);
                    } else if (obj instanceof PurchaseUpdatesResponse) {
                        a.onPurchaseUpdatesResponse((PurchaseUpdatesResponse) obj);
                    } else if (obj instanceof PurchaseResponse) {
                        a.onPurchaseResponse((PurchaseResponse) obj);
                    } else {
                        String a = C0476c.f24a;
                        C0532e.m189b(a, "Unknown response type:" + obj.getClass().getName());
                    }
                } catch (Exception e) {
                    String a2 = C0476c.f24a;
                    C0532e.m189b(a2, "Error in sendResponse: " + e);
                }
            }
        });
    }

    /* renamed from: a */
    private void m38a(Intent intent) throws JSONException {
        PurchaseUpdatesResponse b = m41b(intent);
        if (b.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            String optString = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput")).optString(VastIconXmlManager.OFFSET);
            String str = f24a;
            Log.i(str, "Offset for PurchaseUpdatesResponse:" + optString);
            C0529b.m181a(b.getUserData().getUserId(), optString);
        }
        mo7438a((Object) b);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.amazon.device.iap.model.RequestId} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: com.amazon.device.iap.model.RequestId} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: com.amazon.device.iap.model.RequestId} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r11v15, types: [com.amazon.device.iap.model.RequestId] */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:19|20|21|22|23|40|24|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0069 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amazon.device.iap.model.PurchaseUpdatesResponse m41b(android.content.Intent r11) {
        /*
            r10 = this;
            com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r0 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.FAILED
            r1 = 0
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0092 }
            java.lang.String r4 = "purchaseUpdatesOutput"
            java.lang.String r11 = r11.getStringExtra(r4)     // Catch:{ Exception -> 0x0092 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r11 = "requestId"
            java.lang.String r11 = r3.optString(r11)     // Catch:{ Exception -> 0x0092 }
            com.amazon.device.iap.model.RequestId r11 = com.amazon.device.iap.model.RequestId.fromString(r11)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r4 = "status"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ Exception -> 0x008b }
            com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r0 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.valueOf(r4)     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = "isMore"
            boolean r4 = r3.optBoolean(r4)     // Catch:{ Exception -> 0x008b }
            java.lang.String r5 = "userId"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r6 = "marketplace"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x0087 }
            com.amazon.device.iap.internal.model.UserDataBuilder r7 = new com.amazon.device.iap.internal.model.UserDataBuilder     // Catch:{ Exception -> 0x0087 }
            r7.<init>()     // Catch:{ Exception -> 0x0087 }
            com.amazon.device.iap.internal.model.UserDataBuilder r5 = r7.setUserId(r5)     // Catch:{ Exception -> 0x0087 }
            com.amazon.device.iap.internal.model.UserDataBuilder r5 = r5.setMarketplace(r6)     // Catch:{ Exception -> 0x0087 }
            com.amazon.device.iap.model.UserData r5 = r5.build()     // Catch:{ Exception -> 0x0087 }
            com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r6 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL     // Catch:{ Exception -> 0x0084 }
            if (r0 != r6) goto L_0x00a0
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0084 }
            r6.<init>()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r2 = "receipts"
            org.json.JSONArray r2 = r3.optJSONArray(r2)     // Catch:{ Exception -> 0x0082 }
            if (r2 == 0) goto L_0x009f
        L_0x0057:
            int r3 = r2.length()     // Catch:{ Exception -> 0x0082 }
            if (r1 >= r3) goto L_0x009f
            org.json.JSONObject r3 = r2.optJSONObject(r1)     // Catch:{ Exception -> 0x0082 }
            com.amazon.device.iap.model.Receipt r7 = r10.m36a((org.json.JSONObject) r3)     // Catch:{ Exception -> 0x0069 }
            r6.add(r7)     // Catch:{ Exception -> 0x0069 }
            goto L_0x007f
        L_0x0069:
            java.lang.String r7 = f24a     // Catch:{ Exception -> 0x0082 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0082 }
            r8.<init>()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r9 = "Failed to parse receipt from json:"
            r8.append(r9)     // Catch:{ Exception -> 0x0082 }
            r8.append(r3)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x0082 }
            android.util.Log.e(r7, r3)     // Catch:{ Exception -> 0x0082 }
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0057
        L_0x0082:
            r1 = move-exception
            goto L_0x0090
        L_0x0084:
            r1 = move-exception
            r6 = r2
            goto L_0x0090
        L_0x0087:
            r1 = move-exception
            r5 = r2
            r6 = r5
            goto L_0x0090
        L_0x008b:
            r3 = move-exception
            r5 = r2
            r6 = r5
            r1 = r3
            r4 = 0
        L_0x0090:
            r2 = r11
            goto L_0x0097
        L_0x0092:
            r11 = move-exception
            r1 = r11
            r5 = r2
            r6 = r5
            r4 = 0
        L_0x0097:
            java.lang.String r11 = f24a
            java.lang.String r3 = "Error parsing purchase updates output"
            android.util.Log.e(r11, r3, r1)
            r11 = r2
        L_0x009f:
            r2 = r6
        L_0x00a0:
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r1 = new com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder
            r1.<init>()
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r1.setRequestId(r11)
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r11.setRequestStatus(r0)
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r11.setUserData(r5)
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r11.setReceipts(r2)
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r11.setHasMore(r4)
            com.amazon.device.iap.model.PurchaseUpdatesResponse r11 = r11.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.iap.internal.p007a.C0476c.m41b(android.content.Intent):com.amazon.device.iap.model.PurchaseUpdatesResponse");
    }

    /* renamed from: c */
    private void m42c(Intent intent) {
        mo7438a((Object) m43d(intent));
    }

    /* renamed from: d */
    private ProductDataResponse m43d(Intent intent) {
        RequestId requestId;
        HashMap hashMap;
        ProductDataResponse.RequestStatus requestStatus;
        LinkedHashSet linkedHashSet;
        Exception e;
        LinkedHashSet linkedHashSet2;
        ProductDataResponse.RequestStatus requestStatus2 = ProductDataResponse.RequestStatus.FAILED;
        LinkedHashSet linkedHashSet3 = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("itemDataOutput"));
            requestId = RequestId.fromString(jSONObject.optString("requestId"));
            try {
                requestStatus = ProductDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatus != requestStatus2) {
                    try {
                        linkedHashSet2 = new LinkedHashSet();
                    } catch (Exception e2) {
                        linkedHashSet = null;
                        hashMap = null;
                        e = e2;
                        requestStatus2 = requestStatus;
                        Log.e(f24a, "Error parsing item data output", e);
                        requestStatus = requestStatus2;
                        linkedHashSet3 = linkedHashSet;
                        return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet3).build();
                    }
                    try {
                        hashMap = new HashMap();
                    } catch (Exception e3) {
                        hashMap = null;
                        e = e3;
                        linkedHashSet = linkedHashSet2;
                        requestStatus2 = requestStatus;
                        Log.e(f24a, "Error parsing item data output", e);
                        requestStatus = requestStatus2;
                        linkedHashSet3 = linkedHashSet;
                        return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet3).build();
                    }
                    try {
                        JSONArray optJSONArray = jSONObject.optJSONArray("unavailableSkus");
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                linkedHashSet2.add(optJSONArray.getString(i));
                            }
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("items");
                        if (optJSONObject != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(next, m35a(next, optJSONObject.optJSONObject(next)));
                            }
                        }
                        linkedHashSet3 = linkedHashSet2;
                    } catch (Exception e4) {
                        e = e4;
                        linkedHashSet = linkedHashSet2;
                        requestStatus2 = requestStatus;
                        Log.e(f24a, "Error parsing item data output", e);
                        requestStatus = requestStatus2;
                        linkedHashSet3 = linkedHashSet;
                        return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet3).build();
                    }
                } else {
                    hashMap = null;
                }
            } catch (Exception e5) {
                hashMap = null;
                e = e5;
                linkedHashSet = null;
                Log.e(f24a, "Error parsing item data output", e);
                requestStatus = requestStatus2;
                linkedHashSet3 = linkedHashSet;
                return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet3).build();
            }
        } catch (Exception e6) {
            linkedHashSet = null;
            hashMap = null;
            e = e6;
            requestId = null;
            Log.e(f24a, "Error parsing item data output", e);
            requestStatus = requestStatus2;
            linkedHashSet3 = linkedHashSet;
            return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet3).build();
        }
        return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet3).build();
    }

    /* renamed from: a */
    private Product m35a(String str, JSONObject jSONObject) throws JSONException {
        ProductType valueOf = ProductType.valueOf(jSONObject.optString("itemType"));
        JSONObject jSONObject2 = jSONObject.getJSONObject("priceJson");
        Currency instance = Currency.getInstance(jSONObject2.optString("currency"));
        String str2 = instance.getSymbol() + jSONObject2.optString("value");
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("description");
        return new ProductBuilder().setSku(str).setProductType(valueOf).setDescription(optString2).setPrice(str2).setSmallIconUrl(jSONObject.optString("smallIconUrl")).setTitle(optString).setCoinsRewardAmount(jSONObject.optInt("coinsRewardAmount", 0)).build();
    }

    /* renamed from: e */
    private void m44e(Intent intent) {
        JSONObject jSONObject;
        UserDataResponse f = m45f(intent);
        RequestId requestId = f.getRequestId();
        String stringExtra = intent.getStringExtra("userInput");
        try {
            jSONObject = new JSONObject(stringExtra);
        } catch (JSONException e) {
            String str = f24a;
            Log.e(str, "Unable to parse request data: " + stringExtra, e);
            jSONObject = null;
        }
        if (requestId == null || jSONObject == null) {
            mo7438a((Object) f);
        } else if (!jSONObject.optBoolean("isPurchaseUpdates", false)) {
            mo7438a((Object) f);
        } else if (f.getUserData() == null || C0531d.m186a(f.getUserData().getUserId())) {
            String str2 = f24a;
            Log.e(str2, "No Userid found in userDataResponse" + f);
            mo7438a((Object) new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).setUserData(f.getUserData()).setReceipts(new ArrayList()).setHasMore(false).build());
        } else {
            String str3 = f24a;
            Log.i(str3, "sendGetPurchaseUpdates with user id" + f.getUserData().getUserId());
            m39a(requestId.toString(), f.getUserData().getUserId(), jSONObject.optBoolean("reset", true));
        }
    }

    /* renamed from: a */
    private void m39a(String str, String str2, boolean z) {
        try {
            Context b = C0524d.m156d().mo7500b();
            String a = C0529b.m180a(str2);
            String str3 = f24a;
            Log.i(str3, "send PurchaseUpdates with user id:" + str2 + ";reset flag:" + z + ", local cursor:" + a + ", parsed from old requestId:" + str);
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", str.toString());
            if (z) {
                a = null;
            }
            jSONObject.put(VastIconXmlManager.OFFSET, a);
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            jSONObject.put("packageName", b.getPackageName());
            bundle.putString("purchaseUpdatesInput", jSONObject.toString());
            Intent a2 = m34a("com.amazon.testclient.iap.purchaseUpdates");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b.startService(a2);
        } catch (JSONException unused) {
            C0532e.m189b(f24a, "Error in sendPurchaseUpdatesRequest.");
        }
    }

    /* renamed from: f */
    private UserDataResponse m45f(Intent intent) {
        RequestId requestId;
        UserDataResponse.RequestStatus requestStatus = UserDataResponse.RequestStatus.FAILED;
        UserData userData = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("userOutput"));
            requestId = RequestId.fromString(jSONObject.optString("requestId"));
            try {
                requestStatus = UserDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatus == UserDataResponse.RequestStatus.SUCCESSFUL) {
                    userData = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString("marketplace")).build();
                }
            } catch (Exception e) {
                e = e;
                Log.e(f24a, "Error parsing userid output", e);
                return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
            }
        } catch (Exception e2) {
            e = e2;
            requestId = null;
            Log.e(f24a, "Error parsing userid output", e);
            return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
        }
        return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
    }

    /* renamed from: g */
    private void m46g(Intent intent) {
        mo7438a((Object) m47h(intent));
    }

    /* renamed from: h */
    private PurchaseResponse m47h(Intent intent) {
        RequestId requestId;
        UserData userData;
        PurchaseResponse.RequestStatus requestStatus = PurchaseResponse.RequestStatus.FAILED;
        Receipt receipt = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("purchaseOutput"));
            requestId = RequestId.fromString(jSONObject.optString("requestId"));
            try {
                userData = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString("marketplace")).build();
                try {
                    requestStatus = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.optString("purchaseStatus"));
                    JSONObject optJSONObject = jSONObject.optJSONObject(TransactionDetailsUtilities.RECEIPT);
                    if (optJSONObject != null) {
                        receipt = m36a(optJSONObject);
                    }
                } catch (Exception e) {
                    e = e;
                    Log.e(f24a, "Error parsing purchase output", e);
                    return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
                }
            } catch (Exception e2) {
                e = e2;
                userData = null;
                Log.e(f24a, "Error parsing purchase output", e);
                return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
            }
        } catch (Exception e3) {
            e = e3;
            requestId = null;
            userData = null;
            Log.e(f24a, "Error parsing purchase output", e);
            return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
        }
        return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
    }

    /* renamed from: a */
    private Receipt m36a(JSONObject jSONObject) throws ParseException {
        String optString = jSONObject.optString("receiptId");
        String optString2 = jSONObject.optString(AppLovinEventParameters.PRODUCT_IDENTIFIER);
        ProductType valueOf = ProductType.valueOf(jSONObject.optString("itemType"));
        String optString3 = jSONObject.optString("purchaseDate");
        DateFormat dateFormat = C0475b.f23a;
        Date parse = dateFormat.parse(optString3);
        String optString4 = jSONObject.optString("cancelDate");
        return new ReceiptBuilder().setReceiptId(optString).setSku(optString2).setProductType(valueOf).setPurchaseDate(parse).setCancelDate((optString4 == null || optString4.length() == 0) ? null : dateFormat.parse(optString4)).build();
    }
}
