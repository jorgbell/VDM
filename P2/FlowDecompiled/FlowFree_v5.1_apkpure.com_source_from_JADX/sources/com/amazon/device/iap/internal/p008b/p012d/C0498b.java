package com.amazon.device.iap.internal.p008b.p012d;

import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.internal.util.C0529b;

/* renamed from: com.amazon.device.iap.internal.b.d.b */
/* compiled from: PurchaseUpdatesCommandBase */
abstract class C0498b extends C0516i {

    /* renamed from: a */
    protected final boolean f49a;

    C0498b(C0501e eVar, String str, boolean z) {
        super(eVar, "purchase_updates", str);
        this.f49a = z;
    }

    /* access modifiers changed from: protected */
    public void preExecution() throws KiwiException {
        super.preExecution();
        mo7468a("cursor", this.f49a ? null : C0529b.m180a((String) mo7469b().mo7457d().mo7462a("userId")));
    }
}
