package com.amazon.device.iap.internal.p008b.p011c;

import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

/* renamed from: com.amazon.device.iap.internal.b.c.d */
/* compiled from: GetProductDataRequest */
public final class C0495d extends C0501e {
    public C0495d(RequestId requestId, Set<String> set) {
        super(requestId);
        C0492a aVar = new C0492a(this, set);
        aVar.mo7470b((C0516i) new C0493b(this, set));
        mo7453a((C0516i) aVar);
    }

    /* renamed from: a */
    public void mo7444a() {
        mo7454a((Object) (ProductDataResponse) mo7457d().mo7461a());
    }

    /* renamed from: b */
    public void mo7445b() {
        ProductDataResponse productDataResponse = (ProductDataResponse) mo7457d().mo7461a();
        if (productDataResponse == null) {
            productDataResponse = new ProductDataResponseBuilder().setRequestId(mo7456c()).setRequestStatus(ProductDataResponse.RequestStatus.FAILED).build();
        }
        mo7454a((Object) productDataResponse);
    }
}
