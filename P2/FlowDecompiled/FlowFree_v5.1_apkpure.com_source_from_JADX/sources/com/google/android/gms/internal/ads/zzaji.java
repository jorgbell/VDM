package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzaji extends zzaij {
    final /* synthetic */ zzajk zza;

    /* synthetic */ zzaji(zzajk zzajk, zzajh zzajh) {
        this.zza = zzajk;
    }

    public final void zze(zzaia zzaia, String str) {
        if (this.zza.zzb != null) {
            this.zza.zzb.onCustomClick(this.zza.zzf(zzaia), str);
        }
    }
}
