package com.amazon.device.iap.internal.p008b;

import android.content.Context;
import android.os.Handler;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.internal.C0524d;
import com.amazon.device.iap.internal.util.C0529b;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* renamed from: com.amazon.device.iap.internal.b.e */
/* compiled from: KiwiRequest */
public class C0501e {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f53a = "e";

    /* renamed from: b */
    private final RequestId f54b;

    /* renamed from: c */
    private final C0514h f55c = new C0514h();

    /* renamed from: d */
    private C0516i f56d = null;

    /* renamed from: a */
    public void mo7444a() {
    }

    /* renamed from: b */
    public void mo7445b() {
    }

    public C0501e(RequestId requestId) {
        this.f54b = requestId;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7453a(C0516i iVar) {
        this.f56d = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7454a(Object obj) {
        mo7455a(obj, (C0516i) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7455a(final Object obj, final C0516i iVar) {
        C0531d.m183a(obj, "response");
        Context b = C0524d.m156d().mo7500b();
        final PurchasingListener a = C0524d.m156d().mo7493a();
        if (b == null || a == null) {
            String str = f53a;
            C0532e.m187a(str, "PurchasingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(b.getMainLooper()).post(new Runnable() {
            public void run() {
                C0501e.this.mo7457d().mo7464a("notifyListenerResult", Boolean.FALSE);
                try {
                    Object obj = obj;
                    if (obj instanceof ProductDataResponse) {
                        a.onProductDataResponse((ProductDataResponse) obj);
                    } else if (obj instanceof UserDataResponse) {
                        a.onUserDataResponse((UserDataResponse) obj);
                    } else if (obj instanceof PurchaseUpdatesResponse) {
                        PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) obj;
                        a.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
                        Object a = C0501e.this.mo7457d().mo7462a("newCursor");
                        if (a != null && (a instanceof String)) {
                            C0529b.m181a(purchaseUpdatesResponse.getUserData().getUserId(), a.toString());
                        }
                    } else if (obj instanceof PurchaseResponse) {
                        a.onPurchaseResponse((PurchaseResponse) obj);
                    } else {
                        String f = C0501e.f53a;
                        C0532e.m189b(f, "Unknown response type:" + obj.getClass().getName());
                    }
                    C0501e.this.mo7457d().mo7464a("notifyListenerResult", Boolean.TRUE);
                } catch (Throwable th) {
                    String f2 = C0501e.f53a;
                    C0532e.m189b(f2, "Error in sendResponse: " + th);
                }
                C0516i iVar = iVar;
                if (iVar != null) {
                    iVar.mo7466a(true);
                    iVar.mo7460a_();
                }
            }
        });
    }

    /* renamed from: c */
    public RequestId mo7456c() {
        return this.f54b;
    }

    /* renamed from: d */
    public C0514h mo7457d() {
        return this.f55c;
    }

    /* renamed from: e */
    public void mo7458e() {
        C0516i iVar = this.f56d;
        if (iVar != null) {
            iVar.mo7460a_();
        } else {
            mo7444a();
        }
    }
}
