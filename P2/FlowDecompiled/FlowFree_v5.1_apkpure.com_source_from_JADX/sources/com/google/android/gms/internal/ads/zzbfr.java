package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbfr extends zzbfn {
    public zzbfr(zzbdp zzbdp) {
        super(zzbdp);
    }

    public final boolean zza(String str) {
        String zzd = zzbbd.zzd(str);
        zzbdp zzbdp = (zzbdp) this.zzc.get();
        if (!(zzbdp == null || zzd == null)) {
            zzbdp.zzu(zzd, this);
        }
        zzbbk.zzi("VideoStreamNoopCache is doing nothing.");
        zzn(str, zzd, "noop", "Noop cache is a noop.");
        return false;
    }

    public final void zzg() {
    }
}
