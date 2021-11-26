package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzazl implements zzazs {
    private final Context zza;
    private final String zzb;

    zzazl(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final void zza(zzbhx zzbhx) {
        Context context = this.zza;
        zzbhx.zzq(ObjectWrapper.wrap(context), this.zzb, context.getPackageName());
    }
}
