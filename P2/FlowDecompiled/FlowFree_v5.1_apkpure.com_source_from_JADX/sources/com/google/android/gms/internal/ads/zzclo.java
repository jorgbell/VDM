package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzclo implements zzuf {
    private final zzuq zza;
    private final String zzb;
    private final zzxk zzc;
    private final String zzd;

    zzclo(zzuq zzuq, String str, zzxk zzxk, String str2) {
        this.zza = zzuq;
        this.zzb = str;
        this.zzc = zzxk;
        this.zzd = str2;
    }

    public final void zza(zzvz zzvz) {
        zzuq zzuq = this.zza;
        String str = this.zzb;
        zzxk zzxk = this.zzc;
        String str2 = this.zzd;
        zzur zzur = (zzur) zzvz.zzg().zzau();
        zzur.zza(zzuq);
        zzvz.zzh(zzur);
        zzvp zzvp = (zzvp) zzvz.zze().zzau();
        zzvp.zza(str);
        zzvp.zzb(zzxk);
        zzvz.zzf(zzvp);
        zzvz.zzb(str2);
    }
}
