package com.amazon.device.iap.internal.p008b.p012d;

import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.p008b.C0480a;
import com.amazon.device.iap.internal.p008b.C0496d;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p017c.C0518a;
import com.amazon.device.iap.internal.p017c.C0521c;
import com.amazon.device.iap.internal.util.C0527a;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.venezia.command.SuccessResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.amazon.device.iap.internal.b.d.d */
/* compiled from: PurchaseUpdatesCommandV1 */
public final class C0500d extends C0498b {

    /* renamed from: b */
    private static final String f51b = C0500d.class.getSimpleName();

    /* renamed from: c */
    private static final Date f52c = new Date(0);

    public C0500d(C0501e eVar, boolean z) {
        super(eVar, "1.0", z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws Exception {
        Map data = successResult.getData();
        String str = f51b;
        C0532e.m187a(str, "data: " + data);
        String str2 = (String) data.get("userId");
        String str3 = (String) data.get("requestId");
        String str4 = (String) data.get("marketplace");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray((String) data.get("receipts"));
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Receipt a = C0527a.m173a(jSONArray.getJSONObject(i), str2, (String) null);
                arrayList.add(a);
                if (ProductType.ENTITLED == a.getProductType()) {
                    C0521c.m148a().mo7488a(str2, a.getReceiptId(), a.getSku());
                }
            } catch (C0480a e) {
                String str5 = f51b;
                C0532e.m189b(str5, "fail to parse receipt, requestId:" + e.mo7441a());
            } catch (C0496d e2) {
                String str6 = f51b;
                C0532e.m189b(str6, "fail to verify receipt, requestId:" + e2.mo7451a());
            } catch (Throwable th) {
                String str7 = f51b;
                C0532e.m189b(str7, "fail to verify receipt, requestId:" + th.getMessage());
            }
        }
        JSONArray jSONArray2 = new JSONArray((String) data.get("revocations"));
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                String string = jSONArray2.getString(i2);
                arrayList.add(new ReceiptBuilder().setSku(string).setProductType(ProductType.ENTITLED).setPurchaseDate((Date) null).setCancelDate(f52c).setReceiptId(C0521c.m148a().mo7487a(str2, string)).build());
            } catch (JSONException unused) {
                String str8 = f51b;
                C0532e.m189b(str8, "fail to parse JSON[" + i2 + "] in \"" + jSONArray2 + "\"");
            }
        }
        boolean equalsIgnoreCase = "true".equalsIgnoreCase((String) data.get("hasMore"));
        C0501e b = mo7469b();
        PurchaseUpdatesResponse build = new PurchaseUpdatesResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(new UserDataBuilder().setUserId(str2).setMarketplace(str4).build()).setReceipts(arrayList).setHasMore(equalsIgnoreCase).build();
        build.getReceipts().addAll(C0518a.m134a().mo7482b(build.getUserData().getUserId()));
        b.mo7457d().mo7463a((Object) build);
        b.mo7457d().mo7464a("newCursor", (String) data.get("cursor"));
        return true;
    }
}
