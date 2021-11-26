package com.amazon.device.iap.internal.p008b.p013e;

import android.os.RemoteException;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.internal.p008b.C0501e;
import com.amazon.device.iap.internal.util.C0531d;
import com.amazon.device.iap.internal.util.C0532e;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;

/* renamed from: com.amazon.device.iap.internal.b.e.d */
/* compiled from: GetUserIdCommandV1 */
public final class C0506d extends C0504b {

    /* renamed from: b */
    private static final String f63b = C0506d.class.getSimpleName();

    public C0506d(C0501e eVar) {
        super(eVar, "1.0");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws RemoteException, KiwiException {
        String str = f63b;
        C0532e.m187a(str, "onSuccessInternal: result = " + successResult);
        Map data = successResult.getData();
        C0532e.m187a(str, "data: " + data);
        String str2 = (String) data.get("userId");
        C0501e b = mo7469b();
        if (C0531d.m186a(str2)) {
            b.mo7457d().mo7463a((Object) new UserDataResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
            return false;
        }
        UserData build = new UserDataBuilder().setUserId(str2).setMarketplace(C0504b.f61a).build();
        UserDataResponse build2 = new UserDataResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(build).build();
        b.mo7457d().mo7464a("userId", build.getUserId());
        b.mo7457d().mo7463a((Object) build2);
        return true;
    }
}
