package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzdaz extends zzaqg {
    private final zzbud zza;
    private final zzbuv zzb;
    private final zzbvk zzc;
    private final zzbvp zzd;
    private final zzbyp zze;
    private final zzbwi zzf;
    private final zzcbp zzg;
    private final zzbyl zzh;
    private final zzbuq zzi;

    public zzdaz(zzbud zzbud, zzbuv zzbuv, zzbvk zzbvk, zzbvp zzbvp, zzbyp zzbyp, zzbwi zzbwi, zzcbp zzcbp, zzbyl zzbyl, zzbuq zzbuq) {
        this.zza = zzbud;
        this.zzb = zzbuv;
        this.zzc = zzbvk;
        this.zzd = zzbvp;
        this.zze = zzbyp;
        this.zzf = zzbwi;
        this.zzg = zzcbp;
        this.zzh = zzbyl;
        this.zzi = zzbuq;
    }

    public final void zze() {
        this.zza.onAdClicked();
    }

    public final void zzf() {
        this.zzf.zzbt(4);
    }

    public final void zzg(int i) {
    }

    public final void zzh() {
        this.zzc.zzb();
    }

    public final void zzi() {
        this.zzf.zzbo();
        this.zzh.zzb();
    }

    public final void zzj() {
        this.zzd.zzbD();
    }

    public void zzk() {
        this.zzb.zza();
        this.zzh.zza();
    }

    public final void zzl(String str, String str2) {
        this.zze.zzbB(str, str2);
    }

    public final void zzm(zzaia zzaia, String str) {
    }

    public void zzn() {
        this.zzg.zzb();
    }

    public void zzo() {
        this.zzg.zzc();
    }

    public void zzp(zzaxe zzaxe) {
    }

    public final void zzq() {
        this.zzg.zza();
    }

    public void zzr(zzaxi zzaxi) throws RemoteException {
    }

    @Deprecated
    public final void zzs(int i) throws RemoteException {
        zzy(new zzym(i, "", "undefined", (zzym) null, (IBinder) null));
    }

    public void zzt() throws RemoteException {
    }

    public final void zzu() throws RemoteException {
        this.zzg.zzd();
    }

    public final void zzv(String str) {
        zzy(new zzym(0, str, "undefined", (zzym) null, (IBinder) null));
    }

    public final void zzw(int i, String str) {
    }

    public final void zzx(zzym zzym) {
    }

    public final void zzy(zzym zzym) {
        this.zzi.zza(zzdsb.zzc(8, zzym));
    }
}
