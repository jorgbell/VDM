package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdan extends zzaxc {
    final /* synthetic */ zzbwi zza;
    final /* synthetic */ zzbud zzb;
    final /* synthetic */ zzbvk zzc;
    final /* synthetic */ zzcbh zzd;

    zzdan(zzdao zzdao, zzbwi zzbwi, zzbud zzbud, zzbvk zzbvk, zzcbh zzcbh) {
        this.zza = zzbwi;
        this.zzb = zzbud;
        this.zzc = zzbvk;
        this.zzd = zzcbh;
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    public final void zzf(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zza.zzbo();
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        this.zzd.zza();
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzbt(4);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzaxe zzaxe) {
        this.zzd.zzb(zzaxe);
    }

    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    public final void zzm(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzc.zzf();
    }
}
