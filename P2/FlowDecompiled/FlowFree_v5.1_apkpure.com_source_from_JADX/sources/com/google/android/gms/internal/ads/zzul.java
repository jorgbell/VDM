package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzul {
    final /* synthetic */ zzum zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzul(zzum zzum, byte[] bArr, zzuk zzuk) {
        this.zza = zzum;
        this.zzb = bArr;
    }

    public final synchronized void zza() {
        try {
            zzum zzum = this.zza;
            if (zzum.zzb) {
                zzum.zza.zzh(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzj(this.zzc);
                this.zza.zza.zzg((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            zzbbk.zze("Clearcut log failed", e);
        }
    }

    public final zzul zzb(int i) {
        this.zzc = i;
        return this;
    }
}
