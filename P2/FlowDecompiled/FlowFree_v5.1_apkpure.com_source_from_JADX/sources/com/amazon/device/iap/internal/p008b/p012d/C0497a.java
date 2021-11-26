package com.amazon.device.iap.internal.p008b.p012d;

import com.amazon.device.iap.internal.model.C0526a;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.internal.p008b.p013e.C0505c;
import com.amazon.device.iap.internal.p008b.p013e.C0506d;
import com.amazon.device.iap.internal.p008b.p015g.C0512a;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import java.util.HashSet;

/* renamed from: com.amazon.device.iap.internal.b.d.a */
/* compiled from: GetPurchaseUpdatesRequest */
public final class C0497a extends C0501e {
    public C0497a(RequestId requestId, boolean z) {
        super(requestId);
        C0505c cVar = new C0505c(this);
        cVar.mo7467a((C0516i) new C0499c(this, z));
        C0506d dVar = new C0506d(this);
        dVar.mo7467a((C0516i) new C0500d(this, z));
        cVar.mo7470b((C0516i) dVar);
        mo7453a((C0516i) cVar);
    }

    /* renamed from: a */
    public void mo7444a() {
        C0512a aVar;
        PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) mo7457d().mo7461a();
        if (purchaseUpdatesResponse.getReceipts() == null || purchaseUpdatesResponse.getReceipts().size() <= 0) {
            aVar = null;
        } else {
            HashSet hashSet = new HashSet();
            for (Receipt next : purchaseUpdatesResponse.getReceipts()) {
                if (!C0531d.m186a(next.getReceiptId())) {
                    hashSet.add(next.getReceiptId());
                }
            }
            aVar = new C0512a(this, hashSet, C0526a.DELIVERED.toString());
        }
        mo7455a(purchaseUpdatesResponse, aVar);
    }

    /* renamed from: b */
    public void mo7445b() {
        PurchaseUpdatesResponse purchaseUpdatesResponse;
        Object a = mo7457d().mo7461a();
        if (a == null || !(a instanceof PurchaseUpdatesResponse)) {
            purchaseUpdatesResponse = new PurchaseUpdatesResponseBuilder().setRequestId(mo7456c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).build();
        } else {
            purchaseUpdatesResponse = (PurchaseUpdatesResponse) a;
        }
        mo7454a((Object) purchaseUpdatesResponse);
    }
}
