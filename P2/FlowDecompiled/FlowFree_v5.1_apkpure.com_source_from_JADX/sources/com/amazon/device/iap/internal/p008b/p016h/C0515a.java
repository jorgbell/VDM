package com.amazon.device.iap.internal.p008b.p016h;

import android.os.RemoteException;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.venezia.command.SuccessResult;

/* renamed from: com.amazon.device.iap.internal.b.h.a */
/* compiled from: SubmitMetricCommand */
public class C0515a extends C0516i {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws RemoteException, KiwiException {
        return true;
    }

    public C0515a(C0501e eVar, String str, String str2) {
        super(eVar, "submit_metric", "1.0");
        mo7468a("metricName", str);
        mo7468a("metricAttributes", str2);
        mo7471b(false);
    }
}
