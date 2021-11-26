package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzawk {
    /* access modifiers changed from: private */
    public final WeakHashMap<Context, zzawj> zza = new WeakHashMap<>();

    public final Future<zzawh> zza(Context context) {
        return zzbbw.zza.zzb(new zzawi(this, context));
    }
}
