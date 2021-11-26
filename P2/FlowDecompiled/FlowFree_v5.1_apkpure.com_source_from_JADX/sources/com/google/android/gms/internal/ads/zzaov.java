package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaov {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    @GuardedBy("lockClient")
    private zzape zzc;
    @GuardedBy("lockService")
    private zzape zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzape zza(Context context, zzbbq zzbbq) {
        zzape zzape;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzape(zzc(context), zzbbq, zzagk.zzb.zze());
            }
            zzape = this.zzd;
        }
        return zzape;
    }

    public final zzape zzb(Context context, zzbbq zzbbq) {
        zzape zzape;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzape(zzc(context), zzbbq, (String) zzaaa.zzc().zzb(zzaeq.zza));
            }
            zzape = this.zzc;
        }
        return zzape;
    }
}
