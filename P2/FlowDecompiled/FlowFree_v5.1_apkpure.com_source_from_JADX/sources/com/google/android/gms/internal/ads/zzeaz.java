package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeaz {
    final /* synthetic */ zzeba zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzeaz(zzeba zzeba, byte[] bArr, zzeay zzeay) {
        this.zza = zzeba;
        this.zzb = bArr;
    }

    public final synchronized void zza() {
        try {
            zzeba zzeba = this.zza;
            if (zzeba.zza) {
                zzeba.zzb.zzg(this.zzb);
                this.zza.zzb.zzh(this.zzc);
                this.zza.zzb.zzi(this.zzd);
                this.zza.zzb.zzf((int[]) null);
                this.zza.zzb.zze();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }

    public final zzeaz zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final zzeaz zzc(int i) {
        this.zzd = i;
        return this;
    }
}
