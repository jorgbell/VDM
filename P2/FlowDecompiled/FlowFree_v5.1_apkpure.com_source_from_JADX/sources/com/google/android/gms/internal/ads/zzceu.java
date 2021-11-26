package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzceu {
    private zzahh zza;

    public zzceu(zzcej zzcej) {
        this.zza = zzcej;
    }

    public final synchronized zzahh zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzahh zzahh) {
        this.zza = zzahh;
    }
}
