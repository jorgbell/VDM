package com.flurry.sdk;

import android.content.Intent;
import android.os.SystemClock;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.C1591bt;
import com.flurry.sdk.C1804gn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gm */
public final class C1802gm extends C1892jn {

    /* renamed from: a */
    private static final AtomicInteger f4508a = new AtomicInteger(0);

    private C1802gm(C1894jp jpVar) {
        super(jpVar);
    }

    /* renamed from: a */
    public static FlurryEventRecordStatus m4656a(String str, Map<String, String> map, boolean z, boolean z2, long j, long j2) {
        HashMap hashMap;
        if (map.size() > 10) {
            hashMap = new HashMap();
            hashMap.put("fl.parameter.limit.exceeded", String.valueOf(map.size()));
            map.clear();
        } else {
            hashMap = null;
        }
        Map<String, String> map2 = map;
        C1735fb.m4502a().mo11504a(new C1802gm(new C1804gn(C1698dz.m4440a(str), f4508a.incrementAndGet(), C1804gn.C1805a.CUSTOM_EVENT, map2, hashMap, new ArrayList(), z, z2, j, j2)));
        return FlurryEventRecordStatus.kFlurryEventRecorded;
    }

    /* renamed from: a */
    public static void m4659a(int i, Intent intent, Map<String, String> map, long j, long j2) {
        int i2 = i;
        Intent intent2 = intent;
        if (intent2 != null && intent.getExtras() != null) {
            Object obj = intent.getExtras().get("RESPONSE_CODE");
            int i3 = 0;
            if (obj == null) {
                C1648cy.m4325b("StreamingEventFrame", "Intent with no response code, assuming OK (known issue)");
            } else if (obj instanceof Integer) {
                i3 = ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                i3 = (int) ((Long) obj).longValue();
            }
            final String stringExtra = intent2.getStringExtra("INAPP_PURCHASE_DATA");
            final String stringExtra2 = intent2.getStringExtra("INAPP_DATA_SIGNATURE");
            JSONObject jSONObject = new JSONObject();
            if (stringExtra != null) {
                try {
                    jSONObject = new JSONObject(stringExtra);
                } catch (Throwable th) {
                    C1648cy.m4320a("StreamingEventFrame", "Failed to log event: Flurry.purchase", th);
                    return;
                }
            }
            String optString = jSONObject.optString("productId");
            final String optString2 = jSONObject.optString("orderId");
            if (i2 == -1 && i3 == 0) {
                final Map<String, String> map2 = map;
                final String str = optString;
                final long j3 = j;
                final long j4 = j2;
                C1591bt.m4152a(C1536b.m4057a(), optString, new C1591bt.C1594a() {
                    /* renamed from: a */
                    public final void mo11345a(int i, C1591bt.C1597c cVar) {
                        if (cVar != null) {
                            double d = (double) cVar.f4014b;
                            Double.isNaN(d);
                            double d2 = d / 1000000.0d;
                            HashMap hashMap = new HashMap();
                            if (map2.size() > 10) {
                                hashMap.put("fl.parameter.limit.exceeded", String.valueOf(map2.size()));
                                map2.clear();
                            }
                            hashMap.put("fl.Quantity", "1");
                            hashMap.put("fl.ProductID", str);
                            hashMap.put("fl.Price", String.format(Locale.ENGLISH, "%1$.2f", new Object[]{Double.valueOf(d2)}));
                            hashMap.put("fl.Currency", cVar.f4015c);
                            hashMap.put("fl.ProductName", cVar.f4016d);
                            hashMap.put("fl.ProductType", cVar.f4013a);
                            hashMap.put("fl.TransactionIdentifier", optString2);
                            hashMap.put("fl.OrderJSON", stringExtra);
                            hashMap.put("fl.OrderJSONSignature", stringExtra2);
                            hashMap.put("fl.StoreId", "2");
                            hashMap.put("fl.Receipt", stringExtra2 + "\n" + stringExtra);
                            FlurryEventRecordStatus unused = C1802gm.m4660b(map2, hashMap, j3, j4, new ArrayList());
                            return;
                        }
                        C1648cy.m4325b("StreamingEventFrame", "Failed to load SKU Details from Google for '" + str + "'. Result: " + i);
                    }
                });
                return;
            }
            C1648cy.m4325b("StreamingEventFrame", "Invalid logPayment call. resultCode:" + i + ", responseCode:" + i3 + ", purchaseData:" + stringExtra + ", dataSignature:" + stringExtra2);
        }
    }

    /* renamed from: a */
    public static FlurryEventRecordStatus m4655a(String str, String str2, int i, double d, String str3, String str4, Map<String, String> map, long j, long j2) {
        HashMap hashMap = new HashMap();
        if (map.size() > 10) {
            hashMap.put("fl.parameter.limit.exceeded", String.valueOf(map.size()));
            map.clear();
        }
        try {
            hashMap.put("fl.ProductName", str);
            hashMap.put("fl.ProductID", str2);
            hashMap.put("fl.Quantity", String.valueOf(i));
            hashMap.put("fl.Price", String.format(Locale.ENGLISH, "%1$.2f", new Object[]{Double.valueOf(d)}));
            hashMap.put("fl.Currency", str3);
            hashMap.put("fl.TransactionIdentifier", str4);
            return m4660b(map, hashMap, j, j2, new ArrayList());
        } catch (Throwable th) {
            C1648cy.m4320a("StreamingEventFrame", "Failed to log event: Flurry.purchase", th);
            return FlurryEventRecordStatus.kFlurryEventRecorded;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static FlurryEventRecordStatus m4660b(Map<String, String> map, Map<String, String> map2, long j, long j2, List<String> list) {
        C1735fb.m4502a().mo11504a(new C1802gm(new C1804gn("Flurry.purchase", f4508a.incrementAndGet(), C1804gn.C1805a.PURCHASE_EVENT, map, map2, list, false, false, j, j2)));
        return FlurryEventRecordStatus.kFlurryEventRecorded;
    }

    /* renamed from: a */
    public final C1893jo mo11542a() {
        return C1893jo.ANALYTICS_EVENT;
    }

    /* renamed from: a */
    public static C1802gm m4658a(String str, int i, Map<String, String> map, Map<String, String> map2, long j, long j2) {
        return new C1802gm(new C1804gn(str, i, map, map2, j, SystemClock.elapsedRealtime(), j2));
    }
}
