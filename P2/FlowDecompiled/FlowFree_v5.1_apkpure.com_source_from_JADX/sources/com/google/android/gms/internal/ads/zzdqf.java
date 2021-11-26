package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdqf extends zzaxk {
    private final zzdqb zza;
    private final zzdps zzb;
    private final String zzc;
    private final zzdrb zzd;
    private final Context zze;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzcjw zzf;
    @GuardedBy("this")
    private boolean zzg = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzat)).booleanValue();

    public zzdqf(String str, zzdqb zzdqb, Context context, zzdps zzdps, zzdrb zzdrb) {
        this.zzc = str;
        this.zza = zzdqb;
        this.zzb = zzdps;
        this.zzd = zzdrb;
        this.zze = context;
    }

    private final synchronized void zzt(zzys zzys, zzaxs zzaxs, int i) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzb(zzaxs);
        zzs.zzc();
        if (zzr.zzJ(this.zze)) {
            if (zzys.zzs == null) {
                zzbbk.zzf("Failed to load the ad because app ID is missing.");
                this.zzb.zzbC(zzdsb.zzd(4, (String) null, (zzym) null));
                return;
            }
        }
        if (this.zzf == null) {
            zzdpu zzdpu = new zzdpu((String) null);
            this.zza.zzi(i);
            this.zza.zza(zzys, this.zzc, zzdpu, new zzdqe(this));
        }
    }

    public final synchronized void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzk(iObjectWrapper, this.zzg);
    }

    public final synchronized void zzc(zzys zzys, zzaxs zzaxs) throws RemoteException {
        zzt(zzys, zzaxs, 2);
    }

    public final synchronized void zzd(zzys zzys, zzaxs zzaxs) throws RemoteException {
        zzt(zzys, zzaxs, 3);
    }

    public final void zze(zzaxo zzaxo) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzaxo);
    }

    public final void zzf(zzaca zzaca) {
        if (zzaca == null) {
            this.zzb.zzm((zzdyp) null);
        } else {
            this.zzb.zzm(new zzdqd(this, zzaca));
        }
    }

    public final Bundle zzg() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcjw zzcjw = this.zzf;
        return zzcjw != null ? zzcjw.zzg() : new Bundle();
    }

    public final synchronized void zzh(zzaxz zzaxz) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdrb zzdrb = this.zzd;
        zzdrb.zza = zzaxz.zza;
        zzdrb.zzb = zzaxz.zzb;
    }

    public final boolean zzi() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcjw zzcjw = this.zzf;
        return zzcjw != null && !zzcjw.zzb();
    }

    public final synchronized String zzj() throws RemoteException {
        zzcjw zzcjw = this.zzf;
        if (zzcjw == null || zzcjw.zzm() == null) {
            return null;
        }
        return this.zzf.zzm().zze();
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzf == null) {
            zzbbk.zzi("Rewarded can not be shown before loaded");
            this.zzb.zzi(zzdsb.zzd(9, (String) null, (zzym) null));
            return;
        }
        this.zzf.zza(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final zzaxi zzl() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcjw zzcjw = this.zzf;
        if (zzcjw != null) {
            return zzcjw.zzc();
        }
        return null;
    }

    public final zzacg zzm() {
        zzcjw zzcjw;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeP)).booleanValue() && (zzcjw = this.zzf) != null) {
            return zzcjw.zzm();
        }
        return null;
    }

    public final void zzn(zzacd zzacd) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzb.zzn(zzacd);
    }

    public final synchronized void zzo(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzg = z;
    }

    public final void zzp(zzaxt zzaxt) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzq(zzaxt);
    }
}
