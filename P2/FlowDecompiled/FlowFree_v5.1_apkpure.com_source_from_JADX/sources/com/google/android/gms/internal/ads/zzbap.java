package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbap {
    final /* synthetic */ zzbaq zza;
    private long zzb = -1;
    private long zzc = -1;

    public zzbap(zzbaq zzbaq) {
        this.zza = zzbaq;
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb() {
        this.zzc = this.zza.zza.elapsedRealtime();
    }

    public final void zzc() {
        this.zzb = this.zza.zza.elapsedRealtime();
    }

    public final Bundle zzd() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzb);
        bundle.putLong("tclose", this.zzc);
        return bundle;
    }
}
