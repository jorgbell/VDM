package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcis extends zzahu {
    private final String zza;
    private final zzces zzb;
    private final zzcex zzc;

    public zzcis(String str, zzces zzces, zzcex zzcex) {
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
        return this.zzc.zzK();
    }

    public final String zzg() throws RemoteException {
        return this.zzc.zzE();
    }

    public final double zzh() throws RemoteException {
        return this.zzc.zzJ();
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzH();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzI();
    }

    public final Bundle zzk() throws RemoteException {
        return this.zzc.zzD();
    }

    public final void zzl() throws RemoteException {
        this.zzb.zzR();
    }

    public final zzacj zzm() throws RemoteException {
        return this.zzc.zzu();
    }

    public final void zzn(Bundle bundle) throws RemoteException {
        this.zzb.zzc(bundle);
    }

    public final boolean zzo(Bundle bundle) throws RemoteException {
        return this.zzb.zze(bundle);
    }

    public final void zzp(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    public final zzahc zzq() throws RemoteException {
        return this.zzc.zzv();
    }

    public final IObjectWrapper zzr() throws RemoteException {
        return this.zzc.zzG();
    }

    public final String zzs() throws RemoteException {
        return this.zza;
    }
}
