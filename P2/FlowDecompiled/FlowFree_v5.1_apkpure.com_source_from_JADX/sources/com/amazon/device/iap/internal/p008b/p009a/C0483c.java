package com.amazon.device.iap.internal.p008b.p009a;

import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;

/* renamed from: com.amazon.device.iap.internal.b.a.c */
/* compiled from: PurchaseResponseCommandBase */
abstract class C0483c extends C0516i {
    C0483c(C0501e eVar, String str) {
        super(eVar, "purchase_response", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7443a(String str, String str2, String str3, PurchaseResponse.RequestStatus requestStatus) {
        C0501e b = mo7469b();
        b.mo7457d().mo7463a((Object) new PurchaseResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(requestStatus).setUserData(new UserDataBuilder().setUserId(str).setMarketplace(str2).build()).setReceipt((Receipt) null).build());
    }
}
