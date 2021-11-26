package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzciu extends zzahw {
    private final String zza;
    private final zzces zzb;
    private final zzcex zzc;

    public zzciu(String str, zzces zzces, zzcex zzcex) {
        this.zza = str;
        this.zzb = zzces;
        this.zzc = zzcex;
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzc() throws RemoteException {
        return this.zzc.zzx();
    }

    public final List<?> zzd() throws RemoteException {
        return this.zzc.zzy();
    }

    public final String zze() throws RemoteException {
        return this.zzc.zzC();
    }

    public final zzahk zzf() throws RemoteException {
        return this.zzc.zzM();
    }

    public final String zzg() throws RemoteException {
        return this.zzc.zzE();
    }

    public final String zzh() throws RemoteException {
        return this.zzc.zzL();
    }

    public final Bundle zzi() throws RemoteException {
        return this.zzc.zzD();
    }

    public final void zzj() throws RemoteException {
        this.zzb.zzR();
    }

    public final zzacj zzk() throws RemoteException {
        return this.zzc.zzu();
    }

    public final void zzl(Bundle bundle) throws RemoteException {
        this.zzb.zzc(bundle);
    }

    public final boolean zzm(Bundle bundle) throws RemoteException {
        return this.zzb.zze(bundle);
    }

    public final void zzn(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    public final zzahc zzo() throws RemoteException {
        return this.zzc.zzv();
    }

    public final IObjectWrapper zzp() throws RemoteException {
        return this.zzc.zzG();
    }

    public final String zzq() throws RemoteException {
        return this.zza;
    }
}
