package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.ab */
public abstract class C2054ab extends C2111k implements C2055ac {
    /* renamed from: b */
    public static C2055ac m5139b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof C2055ac ? (C2055ac) queryLocalInterface : new C2053aa(iBinder);
    }
}
