package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzciz extends zzajc {
    private final String zza;
    private final zzces zzb;
    private final zzcex zzc;

    public zzciz(String str, zzces zzces, zzcex zzcex) {
        this.zza = str;
        this.zzb = zzces;
        this.zzc = zzcex;
    }

    public final boolean zzA() throws RemoteException {
        return !this.zzc.zzA().isEmpty() && this.zzc.zzB() != null;
    }

    public final void zzB(zzabt zzabt) throws RemoteException {
        this.zzb.zzu(zzabt);
    }

    public final void zzC(zzabp zzabp) throws RemoteException {
        this.zzb.zzv(zzabp);
    }

    public final void zzD() {
        this.zzb.zzw();
    }

    public final void zzE() {
        this.zzb.zzx();
    }

    public final zzahh zzF() throws RemoteException {
        return this.zzb.zzF().zza();
    }

    public final boolean zzG() {
        return this.zzb.zzy();
    }

    public final zzacg zzH() throws RemoteException {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeP)).booleanValue()) {
            return null;
        }
        return this.zzb.zzm();
    }

    public final void zzI(zzacd zzacd) throws RemoteException {
        this.zzb.zzG(zzacd);
    }

    public final String zze() throws RemoteException {
        return this.zzc.zzx();
    }

    public final List<?> zzf() throws RemoteException {
        return this.zzc.zzy();
    }

    public final String zzg() throws RemoteException {
        return this.zzc.zzC();
    }

    public final zzahk zzh() throws RemoteException {
        return this.zzc.zzK();
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzE();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzL();
    }

    public final double zzk() throws RemoteException {
        return this.zzc.zzJ();
    }

    public final String zzl() throws RemoteException {
        return this.zzc.zzH();
    }

    public final String zzm() throws RemoteException {
        return this.zzc.zzI();
    }

    public final zzacj zzn() throws RemoteException {
        return this.zzc.zzu();
    }

    public final String zzo() throws RemoteException {
        return this.zza;
    }

    public final void zzp() throws RemoteException {
        this.zzb.zzR();
    }

    public final zzahc zzq() throws RemoteException {
        return this.zzc.zzv();
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzc(bundle);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zze(bundle);
    }

    public final void zzt(Bundle bundle) throws RemoteException {
        this.zzb.zzf(bundle);
    }

    public final IObjectWrapper zzu() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final IObjectWrapper zzv() throws RemoteException {
        return this.zzc.zzG();
    }

    public final Bundle zzw() throws RemoteException {
        return this.zzc.zzD();
    }

    public final void zzx(zzaja zzaja) throws RemoteException {
        this.zzb.zzs(zzaja);
    }

    public final void zzy() throws RemoteException {
        this.zzb.zzt();
    }

    public final List<?> zzz() throws RemoteException {
        if (zzA()) {
            return this.zzc.zzA();
        }
        return Collections.emptyList();
    }
}
