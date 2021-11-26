package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.s */
public abstract class C2114s extends C2111k implements C2115t {
    /* renamed from: b */
    public static C2115t m5303b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof C2115t ? (C2115t) queryLocalInterface : new C2113r(iBinder);
    }
}
