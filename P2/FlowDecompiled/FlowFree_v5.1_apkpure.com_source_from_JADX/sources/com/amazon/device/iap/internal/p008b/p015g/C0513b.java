package com.amazon.device.iap.internal.p008b.p015g;

import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.internal.p008b.p014f.C0509b;
import com.amazon.device.iap.internal.p017c.C0518a;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.HashSet;

/* renamed from: com.amazon.device.iap.internal.b.g.b */
/* compiled from: NotifyFulfillmentRequest */
public final class C0513b extends C0501e {

    /* renamed from: a */
    private final String f68a;

    /* renamed from: b */
    private final FulfillmentResult f69b;

    /* renamed from: a */
    public void mo7444a() {
    }

    public C0513b(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        super(requestId);
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        this.f68a = str;
        this.f69b = fulfillmentResult;
        mo7453a((C0516i) new C0512a(this, hashSet, fulfillmentResult.toString()));
    }

    /* renamed from: b */
    public void mo7445b() {
        String c;
        FulfillmentResult fulfillmentResult = FulfillmentResult.FULFILLED;
        FulfillmentResult fulfillmentResult2 = this.f69b;
        if ((fulfillmentResult == fulfillmentResult2 || FulfillmentResult.UNAVAILABLE == fulfillmentResult2) && (c = C0518a.m134a().mo7483c(this.f68a)) != null) {
            new C0509b(this, c).mo7460a_();
            C0518a.m134a().mo7480a(this.f68a);
        }
    }
}
