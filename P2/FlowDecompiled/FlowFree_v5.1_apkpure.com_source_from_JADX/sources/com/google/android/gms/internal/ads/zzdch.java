package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdch implements zzddp<zzbom> {
    final /* synthetic */ zzdci zza;

    zzdch(zzdci zzdci) {
        this.zza = zzdci;
    }

    public final void zza() {
        synchronized (this.zza) {
            zzbom unused = this.zza.zzg = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbom zzbom = (zzbom) obj;
        synchronized (this.zza) {
            if (this.zza.zzg != null) {
                this.zza.zzg.zzR();
            }
            zzbom unused = this.zza.zzg = zzbom;
            this.zza.zzg.zzQ();
        }
    }
}
