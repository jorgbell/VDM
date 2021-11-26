package com.amazon.device.iap.internal.p008b.p009a;

import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p017c.C0518a;
import com.amazon.device.iap.internal.p017c.C0520b;
import com.amazon.device.iap.internal.util.C0527a;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.venezia.command.SuccessResult;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amazon.device.iap.internal.b.a.b */
/* compiled from: PurchaseResponseCommandV1 */
public final class C0482b extends C0483c {

    /* renamed from: a */
    private static final String f32a = C0482b.class.getSimpleName();

    public C0482b(C0501e eVar) {
        super(eVar, "1.0");
    }

    /* renamed from: a */
    private void m59a(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString("orderStatus")) == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                    C0518a.m134a().mo7481a(str, str2, C0527a.m173a(jSONObject, str2, str).getReceiptId(), str3);
                }
            } catch (Throwable th) {
                String str4 = f32a;
                C0532e.m189b(str4, "Error in savePendingReceipt: " + th);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws Exception {
        Map data = successResult.getData();
        String str = f32a;
        C0532e.m187a(str, "data: " + data);
        String str2 = (String) getCommandData().get("requestId");
        String str3 = (String) data.get("userId");
        String str4 = (String) data.get("marketplace");
        String str5 = (String) data.get(TransactionDetailsUtilities.RECEIPT);
        if (str2 == null || !C0520b.m145a().mo7485a(str2)) {
            mo7469b().mo7457d().mo7465b();
            return true;
        } else if (C0531d.m186a(str5)) {
            mo7443a(str3, str4, str2, PurchaseResponse.RequestStatus.FAILED);
            return false;
        } else {
            Receipt receipt = null;
            JSONObject jSONObject = new JSONObject(str5);
            PurchaseResponse.RequestStatus safeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString("orderStatus"));
            if (safeValueOf == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                try {
                    receipt = C0527a.m173a(jSONObject, str3, str2);
                    if (ProductType.CONSUMABLE == receipt.getProductType()) {
                        m59a(str2, str3, str5);
                    }
                } catch (Throwable unused) {
                    mo7443a(str3, str4, str2, PurchaseResponse.RequestStatus.FAILED);
                    return false;
                }
            }
            C0501e b = mo7469b();
            b.mo7457d().mo7463a((Object) new PurchaseResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(safeValueOf).setUserData(new UserDataBuilder().setUserId(str3).setMarketplace(str4).build()).setReceipt(receipt).build());
            return true;
        }
    }
}
