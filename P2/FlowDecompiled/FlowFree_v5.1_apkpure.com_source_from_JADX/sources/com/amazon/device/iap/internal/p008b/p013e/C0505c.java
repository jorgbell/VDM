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

/* renamed from: com.amazon.device.iap.internal.b.e.c */
/* compiled from: GetUserIdCommandV2 */
public final class C0505c extends C0504b {

    /* renamed from: b */
    private static final String f62b = C0505c.class.getSimpleName();

    public C0505c(C0501e eVar) {
        super(eVar, "2.0");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7442a(SuccessResult successResult) throws RemoteException, KiwiException {
        String str = f62b;
        C0532e.m187a(str, "onResult: result = " + successResult);
        Map data = successResult.getData();
        C0532e.m187a(str, "data: " + data);
        String str2 = (String) data.get("userId");
        String str3 = (String) data.get("marketplace");
        C0501e b = mo7469b();
        if (C0531d.m186a(str2) || C0531d.m186a(str3)) {
            b.mo7457d().mo7463a((Object) new UserDataResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
            return false;
        }
        UserData build = new UserDataBuilder().setUserId(str2).setMarketplace(str3).build();
        UserDataResponse build2 = new UserDataResponseBuilder().setRequestId(b.mo7456c()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(build).build();
        b.mo7457d().mo7464a("userId", build.getUserId());
        b.mo7457d().mo7463a((Object) build2);
        return true;
    }
}
