package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.r */
public final class C2113r extends C2110j implements C2115t {
    C2113r(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    /* renamed from: d */
    public final void mo22097d(String str, List<Bundle> list, Bundle bundle, C2117v vVar) throws RemoteException {
        Parcel a = mo22092a();
        a.writeString(str);
        a.writeTypedList(list);
        C2112l.m5294b(a, bundle);
        C2112l.m5295c(a, vVar);
        mo22094b(14, a);
    }

    /* renamed from: e */
    public final void mo22098e(String str, Bundle bundle, C2117v vVar) throws RemoteException {
        Parcel a = mo22092a();
        a.writeString(str);
        C2112l.m5294b(a, bundle);
        C2112l.m5295c(a, vVar);
        mo22094b(5, a);
    }

    /* renamed from: f */
    public final void mo22099f(String str, Bundle bundle, Bundle bundle2, C2117v vVar) throws RemoteException {
        Parcel a = mo22092a();
        a.writeString(str);
        C2112l.m5294b(a, bundle);
        C2112l.m5294b(a, bundle2);
        C2112l.m5295c(a, vVar);
        mo22094b(6, a);
    }

    /* renamed from: g */
    public final void mo22100g(String str, Bundle bundle, Bundle bundle2, C2117v vVar) throws RemoteException {
        Parcel a = mo22092a();
        a.writeString(str);
        C2112l.m5294b(a, bundle);
        C2112l.m5294b(a, bundle2);
        C2112l.m5295c(a, vVar);
        mo22094b(7, a);
    }

    /* renamed from: h */
    public final void mo22101h(String str, Bundle bundle, Bundle bundle2, C2117v vVar) throws RemoteException {
        Parcel a = mo22092a();
        a.writeString(str);
        C2112l.m5294b(a, bundle);
        C2112l.m5294b(a, bundle2);
        C2112l.m5295c(a, vVar);
        mo22094b(9, a);
    }

    /* renamed from: i */
    public final void mo22102i(String str, Bundle bundle, C2117v vVar) throws RemoteException {
        Parcel a = mo22092a();
        a.writeString(str);
        C2112l.m5294b(a, bundle);
        C2112l.m5295c(a, vVar);
        mo22094b(10, a);
    }

    /* renamed from: j */
    public final void mo22103j(String str, Bundle bundle, Bundle bundle2, C2117v vVar) throws RemoteException {
        Parcel a = mo22092a();
        a.writeString(str);
        C2112l.m5294b(a, bundle);
        C2112l.m5294b(a, bundle2);
        C2112l.m5295c(a, vVar);
        mo22094b(11, a);
    }
}
