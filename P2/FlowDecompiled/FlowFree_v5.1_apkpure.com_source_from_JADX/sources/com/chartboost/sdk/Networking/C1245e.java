package com.chartboost.sdk.Networking;

import com.chartboost.sdk.Model.CBError;

/* renamed from: com.chartboost.sdk.Networking.e */
public class C1245e<T> {

    /* renamed from: a */
    public final T f2859a;

    /* renamed from: b */
    public final CBError f2860b;

    private C1245e(T t, CBError cBError) {
        this.f2859a = t;
        this.f2860b = cBError;
    }

    /* renamed from: a */
    public static <T> C1245e<T> m3093a(T t) {
        return new C1245e<>(t, (CBError) null);
    }

    /* renamed from: a */
    public static <T> C1245e<T> m3092a(CBError cBError) {
        return new C1245e<>((Object) null, cBError);
    }
}
