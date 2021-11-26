package com.google.android.play.core.missingsplits;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
public class MissingSplitsManagerFactory {

    /* renamed from: a */
    private static final AtomicReference<Boolean> f5223a = new AtomicReference<>((Object) null);

    @Deprecated
    public static MissingSplitsManager create(Context context) {
        return new C2125b(context, Runtime.getRuntime(), new C2124a(context, context.getPackageManager()), f5223a);
    }
}
