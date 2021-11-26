package com.amazon.device.iap.internal.p008b.p014f;

import com.amazon.device.iap.internal.p008b.C0501e;

/* renamed from: com.amazon.device.iap.internal.b.f.c */
/* compiled from: ResponseReceivedCommandV2 */
public final class C0510c extends C0508a {
    public C0510c(C0501e eVar, boolean z) {
        super(eVar, "2.0");
        mo7468a("receiptDelivered", Boolean.valueOf(z));
    }

    /* renamed from: a_ */
    public void mo7460a_() {
        Object a = mo7469b().mo7457d().mo7462a("notifyListenerResult");
        if (a != null) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(a)) {
                mo7468a("notifyListenerSucceeded", bool);
                super.mo7460a_();
            }
        }
        mo7468a("notifyListenerSucceeded", Boolean.FALSE);
        super.mo7460a_();
    }
}
