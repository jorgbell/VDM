package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdsg implements zzbui {
    @GuardedBy("this")
    private final HashSet<zzbaq> zza = new HashSet<>();
    private final Context zzb;
    private final zzbaz zzc;

    public zzdsg(Context context, zzbaz zzbaz) {
        this.zzb = context;
        this.zzc = zzbaz;
    }

    public final synchronized void zzb(HashSet<zzbaq> hashSet) {
        this.zza.clear();
        this.zza.addAll(hashSet);
    }

    public final synchronized void zzbC(zzym zzym) {
        if (zzym.zza != 3) {
            this.zzc.zzc(this.zza);
        }
    }

    public final Bundle zzc() {
        return this.zzc.zzj(this.zzb, this);
    }
}
