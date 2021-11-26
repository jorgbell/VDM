package com.amazon.device.iap.internal.p008b.p012d;

import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.p008b.C0480a;
import com.amazon.device.iap.internal.p008b.C0496d;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.util.C0527a;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.venezia.command.SuccessResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.amazon.device.iap.internal.b.d.c */
/* compiled from: PurchaseUpdatesCommandV2 */
public final class C0499c extends C0498b {

    /* renamed from: b */
    private static final String f50b = C0499c.class.getSimpleName();

    public C0499c(C0501e eVar, boolean z) {
        super(eVar, "2.0", z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws Exception {
        Map data = successResult.getData();
        String str = f50b;
        C0532e.m187a(str, "data: " + data);
        String str2 = (String) data.get("userId");
        List<Receipt> a = m84a(str2, (String) data.get("receipts"), (String) data.get("requestId"));
        boolean booleanValue = Boolean.valueOf((String) data.get("hasMore")).booleanValue();
        C0501e b = mo7469b();
        PurchaseUpdatesResponse build = new PurchaseUpdatesResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(new UserDataBuilder().setUserId(str2).setMarketplace((String) data.get("marketplace")).build()).setReceipts(a).setHasMore(booleanValue).build();
        b.mo7457d().mo7464a("newCursor", (String) data.get("cursor"));
        b.mo7457d().mo7463a((Object) build);
        return true;
    }

    /* renamed from: a */
    private List<Receipt> m84a(String str, String str2, String str3) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str2);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(C0527a.m173a(jSONArray.getJSONObject(i), str, str3));
            } catch (C0480a e) {
                String str4 = f50b;
                C0532e.m189b(str4, "fail to parse receipt, requestId:" + e.mo7441a());
            } catch (C0496d e2) {
                String str5 = f50b;
                C0532e.m189b(str5, "fail to verify receipt, requestId:" + e2.mo7451a());
            } catch (Throwable th) {
                String str6 = f50b;
                C0532e.m189b(str6, "fail to verify receipt, requestId:" + th.getMessage());
            }
        }
        return arrayList;
    }
}
