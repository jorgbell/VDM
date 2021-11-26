package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdwn {
    private boolean zza;

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Context context) {
        zzdxw.zza(context, "Application Context cannot be null");
        if (!this.zza) {
            this.zza = true;
            zzdxk.zza().zzb(context);
            zzdxf.zza().zzb(context);
            zzdxu.zza(context);
            zzdxh.zza().zzc(context);
        }
    }
}
