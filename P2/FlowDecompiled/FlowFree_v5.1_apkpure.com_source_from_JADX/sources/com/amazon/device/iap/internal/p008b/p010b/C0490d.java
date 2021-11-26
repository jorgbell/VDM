package com.amazon.device.iap.internal.p008b.p010b;

import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.RequestId;

/* renamed from: com.amazon.device.iap.internal.b.b.d */
/* compiled from: PurchaseRequest */
public final class C0490d extends C0501e {
    /* renamed from: a */
    public void mo7444a() {
    }

    public C0490d(RequestId requestId, String str) {
        super(requestId);
        C0489c cVar = new C0489c(this, str);
        cVar.mo7470b((C0516i) new C0488b(this, str));
        mo7453a((C0516i) cVar);
    }

    /* renamed from: b */
    public void mo7445b() {
        PurchaseResponse purchaseResponse = (PurchaseResponse) mo7457d().mo7461a();
        if (purchaseResponse == null) {
            purchaseResponse = new PurchaseResponseBuilder().setRequestId(mo7456c()).setRequestStatus(PurchaseResponse.RequestStatus.FAILED).build();
        }
        mo7454a((Object) purchaseResponse);
    }
}
