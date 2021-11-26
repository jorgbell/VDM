package com.amazon.device.iap.internal.p008b.p009a;

import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.util.C0527a;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.venezia.command.SuccessResult;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amazon.device.iap.internal.b.a.a */
/* compiled from: PurchaseResponseCommandV2 */
public final class C0481a extends C0483c {

    /* renamed from: a */
    private static final String f31a = C0481a.class.getSimpleName();

    public C0481a(C0501e eVar) {
        super(eVar, "2.0");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws Exception {
        Map data = successResult.getData();
        String str = f31a;
        C0532e.m187a(str, "data: " + data);
        String str2 = (String) getCommandData().get("requestId");
        String str3 = (String) data.get("userId");
        String str4 = (String) data.get("marketplace");
        String str5 = (String) data.get(TransactionDetailsUtilities.RECEIPT);
        if (C0531d.m186a(str5)) {
            mo7443a(str3, str4, str2, PurchaseResponse.RequestStatus.FAILED);
            return false;
        }
        Receipt receipt = null;
        JSONObject jSONObject = new JSONObject(str5);
        PurchaseResponse.RequestStatus safeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString("orderStatus"));
        if (safeValueOf == PurchaseResponse.RequestStatus.SUCCESSFUL) {
            try {
                receipt = C0527a.m173a(jSONObject, str3, str2);
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
