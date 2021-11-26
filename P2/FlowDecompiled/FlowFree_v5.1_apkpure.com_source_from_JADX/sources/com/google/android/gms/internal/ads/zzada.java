package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzada extends zzabs {
    private final String zza;
    private final String zzb;

    public zzada(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final String zze() throws RemoteException {
        return this.zza;
    }

    public final String zzf() throws RemoteException {
        return this.zzb;
    }
}
