package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdaw implements zzbvm {
    boolean zza = false;
    final /* synthetic */ zzcvz zzb;
    final /* synthetic */ zzbcb zzc;

    zzdaw(zzdax zzdax, zzcvz zzcvz, zzbcb zzbcb) {
        this.zzb = zzcvz;
        this.zzc = zzbcb;
    }

    private final void zze(zzym zzym) {
        int i = 1;
        if (true == ((Boolean) zzaaa.zzc().zzb(zzaeq.zzdE)).booleanValue()) {
            i = 3;
        }
        this.zzc.zzd(new zzcwa(i, zzym));
    }

    public final synchronized void zza() {
        this.zzc.zzc(null);
    }

    public final void zzb(int i) {
        if (!this.zza) {
            zze(new zzym(i, zzdax.zze(this.zzb.zza, i), "undefined", (zzym) null, (IBinder) null));
        }
    }

    public final synchronized void zzc(int i, String str) {
        if (!this.zza) {
            this.zza = true;
            if (str == null) {
                str = zzdax.zze(this.zzb.zza, i);
            }
            zze(new zzym(i, str, "undefined", (zzym) null, (IBinder) null));
        }
    }

    public final synchronized void zzd(zzym zzym) {
        this.zza = true;
        zze(zzym);
    }
}
