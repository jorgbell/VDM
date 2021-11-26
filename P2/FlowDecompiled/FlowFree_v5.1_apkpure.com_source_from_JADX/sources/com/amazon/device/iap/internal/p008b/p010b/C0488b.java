package com.amazon.device.iap.internal.p008b.p010b;

import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p017c.C0520b;

/* renamed from: com.amazon.device.iap.internal.b.b.b */
/* compiled from: PurchaseItemCommandV1 */
public final class C0488b extends C0486a {
    public C0488b(C0501e eVar, String str) {
        super(eVar, "1.0", str);
    }

    /* access modifiers changed from: protected */
    public void preExecution() throws KiwiException {
        super.preExecution();
        C0520b.m145a().mo7486b(mo7472c());
    }
}
