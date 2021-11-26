package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcyc implements zzccx {
    private final zzdqo zza;
    private final zzasi zzb;
    private final boolean zzc;
    private zzbuv zzd = null;

    zzcyc(zzdqo zzdqo, zzasi zzasi, boolean z) {
        this.zza = zzdqo;
        this.zzb = zzasi;
        this.zzc = z;
    }

    public final void zza(boolean z, Context context) throws zzccw {
        boolean z2;
        try {
            if (this.zzc) {
                z2 = this.zzb.zzm(ObjectWrapper.wrap(context));
            } else {
                z2 = this.zzb.zzk(ObjectWrapper.wrap(context));
            }
            if (!z2) {
                throw new zzccw("Adapter failed to show.");
            } else if (this.zzd != null) {
                if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzba)).booleanValue() && this.zza.zzS == 2) {
                    this.zzd.zza();
                }
            }
        } catch (Throwable th) {
            throw new zzccw(th);
        }
    }

    public final void zzb(zzbuv zzbuv) {
        this.zzd = zzbuv;
    }
}
