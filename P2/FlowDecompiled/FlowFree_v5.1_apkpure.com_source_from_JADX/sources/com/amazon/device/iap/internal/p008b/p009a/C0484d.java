package com.amazon.device.iap.internal.p008b.p009a;

import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.internal.p008b.p014f.C0509b;
import com.amazon.device.iap.internal.p008b.p014f.C0510c;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;

/* renamed from: com.amazon.device.iap.internal.b.a.d */
/* compiled from: PurchaseResponseRequest */
public final class C0484d extends C0501e {
    public C0484d(RequestId requestId) {
        super(requestId);
        C0481a aVar = new C0481a(this);
        aVar.mo7470b((C0516i) new C0482b(this));
        mo7453a((C0516i) aVar);
    }

    /* renamed from: a */
    public void mo7444a() {
        PurchaseResponse purchaseResponse = (PurchaseResponse) mo7457d().mo7461a();
        if (purchaseResponse != null) {
            Receipt receipt = purchaseResponse.getReceipt();
            boolean z = receipt != null;
            C0510c cVar = new C0510c(this, z);
            if (z && (ProductType.ENTITLED == receipt.getProductType() || ProductType.SUBSCRIPTION == receipt.getProductType())) {
                cVar.mo7470b((C0516i) new C0509b(this, mo7456c().toString()));
            }
            mo7455a(purchaseResponse, cVar);
        }
    }

    /* renamed from: b */
    public void mo7445b() {
        PurchaseResponse purchaseResponse = (PurchaseResponse) mo7457d().mo7461a();
        if (purchaseResponse == null) {
            purchaseResponse = new PurchaseResponseBuilder().setRequestId(mo7456c()).setRequestStatus(PurchaseResponse.RequestStatus.FAILED).build();
        }
        mo7455a(purchaseResponse, new C0510c(this, false));
    }
}
