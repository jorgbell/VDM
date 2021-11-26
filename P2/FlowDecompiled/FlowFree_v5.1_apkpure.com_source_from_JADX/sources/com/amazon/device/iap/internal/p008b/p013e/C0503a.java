package com.amazon.device.iap.internal.p008b.p013e;

import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.p008b.C0516i;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* renamed from: com.amazon.device.iap.internal.b.e.a */
/* compiled from: GetUserDataRequest */
public final class C0503a extends C0501e {
    public C0503a(RequestId requestId) {
        super(requestId);
        C0505c cVar = new C0505c(this);
        cVar.mo7470b((C0516i) new C0506d(this));
        mo7453a((C0516i) cVar);
    }

    /* renamed from: a */
    public void mo7444a() {
        mo7454a((Object) (UserDataResponse) mo7457d().mo7461a());
    }

    /* renamed from: b */
    public void mo7445b() {
        UserDataResponse userDataResponse = (UserDataResponse) mo7457d().mo7461a();
        if (userDataResponse == null) {
            userDataResponse = new UserDataResponseBuilder().setRequestId(mo7456c()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build();
        }
        mo7454a((Object) userDataResponse);
    }
}
