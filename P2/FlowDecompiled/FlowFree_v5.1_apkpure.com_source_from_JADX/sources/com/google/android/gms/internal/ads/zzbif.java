package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbif {
    /* access modifiers changed from: private */
    public zzbbq zza;
    /* access modifiers changed from: private */
    public Context zzb;
    /* access modifiers changed from: private */
    public WeakReference<Context> zzc;

    public final zzbif zza(zzbbq zzbbq) {
        this.zza = zzbbq;
        return this;
    }

    public final zzbif zzb(Context context) {
        this.zzc = new WeakReference<>(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzb = context;
        return this;
    }
}
