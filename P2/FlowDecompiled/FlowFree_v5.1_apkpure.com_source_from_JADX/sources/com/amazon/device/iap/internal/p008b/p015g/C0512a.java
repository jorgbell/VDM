package com.amazon.device.iap.internal.p008b.p015g;

import android.os.RemoteException;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.model.C0526a;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.venezia.command.SuccessResult;
import java.util.Set;

/* renamed from: com.amazon.device.iap.internal.b.g.a */
/* compiled from: PurchaseFulfilledCommandV2 */
public final class C0512a extends C0516i {

    /* renamed from: a */
    protected final Set<String> f66a;

    /* renamed from: b */
    protected final String f67b;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws RemoteException, KiwiException {
        return true;
    }

    public C0512a(C0501e eVar, Set<String> set, String str) {
        super(eVar, "purchase_fulfilled", "2.0");
        this.f66a = set;
        this.f67b = str;
        mo7471b(false);
        mo7468a("receiptIds", set);
        mo7468a("fulfillmentStatus", str);
    }

    /* renamed from: a_ */
    public void mo7460a_() {
        Object a = mo7469b().mo7457d().mo7462a("notifyListenerResult");
        if (a != null && Boolean.FALSE.equals(a)) {
            mo7468a("fulfillmentStatus", C0526a.DELIVERY_ATTEMPTED.toString());
        }
        super.mo7460a_();
    }
}
