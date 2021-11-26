package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdci extends zzaat implements zzbws {
    private final Context zza;
    private final zzdna zzb;
    private final String zzc;
    private final zzdda zzd;
    private zzyx zze;
    @GuardedBy("this")
    private final zzdrf zzf;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzbom zzg;

    public zzdci(Context context, zzyx zzyx, String str, zzdna zzdna, zzdda zzdda) {
        this.zza = context;
        this.zzb = zzdna;
        this.zze = zzyx;
        this.zzc = str;
        this.zzd = zzdda;
        this.zzf = zzdna.zzf();
        zzdna.zzh(this);
    }

    private final synchronized void zzM(zzyx zzyx) {
        this.zzf.zzc(zzyx);
        this.zzf.zzd(this.zze.zzn);
    }

    private final synchronized boolean zzN(zzys zzys) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzs.zzc();
        if (!zzr.zzJ(this.zza) || zzys.zzs != null) {
            zzdrw.zzb(this.zza, zzys.zzf);
            return this.zzb.zza(zzys, this.zzc, (zzddo) null, new zzdch(this));
        }
        zzbbk.zzf("Failed to load the ad because app ID is missing.");
        zzdda zzdda = this.zzd;
        if (zzdda != null) {
            zzdda.zzbC(zzdsb.zzd(4, (String) null, (zzym) null));
        }
        return false;
    }

    public final synchronized boolean zzA() {
        return this.zzb.zzb();
    }

    public final void zzB(zzawy zzawy) {
    }

    public final void zzC(String str) {
    }

    public final void zzD(String str) {
    }

    public final synchronized zzacj zzE() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzbom zzbom = this.zzg;
        if (zzbom == null) {
            return null;
        }
        return zzbom.zzc();
    }

    public final synchronized void zzF(zzady zzady) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzf.zzh(zzady);
    }

    public final void zzG(zzacn zzacn) {
    }

    public final void zzH(zzzd zzzd) {
    }

    public final void zzI(zzte zzte) {
    }

    public final void zzJ(boolean z) {
    }

    public final void zzO(zzacd zzacd) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzd.zzp(zzacd);
    }

    public final void zzP(zzys zzys, zzaak zzaak) {
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzR(zzabi zzabi) {
    }

    public final synchronized void zza() {
        if (this.zzb.zzg()) {
            zzyx zze2 = this.zzf.zze();
            zzbom zzbom = this.zzg;
            if (!(zzbom == null || zzbom.zzf() == null || !this.zzf.zzv())) {
                zze2 = zzdrk.zzb(this.zza, Collections.singletonList(this.zzg.zzf()));
            }
            zzM(zze2);
            try {
                zzN(this.zzf.zzb());
            } catch (RemoteException unused) {
                zzbbk.zzi("Failed to refresh the banner ad.");
            }
        } else {
            this.zzb.zzi();
        }
    }

    public final synchronized void zzab(zzabf zzabf) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzN(zzabf);
    }

    public final IObjectWrapper zzb() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzb.zzc());
    }

    public final boolean zzbI() {
        return false;
    }

    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbom zzbom = this.zzg;
        if (zzbom != null) {
            zzbom.zzR();
        }
    }

    public final synchronized boolean zze(zzys zzys) throws RemoteException {
        zzM(this.zze);
        return zzN(zzys);
    }

    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzbom zzbom = this.zzg;
        if (zzbom != null) {
            zzbom.zzl().zza((Context) null);
        }
    }

    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzbom zzbom = this.zzg;
        if (zzbom != null) {
            zzbom.zzl().zzb((Context) null);
        }
    }

    public final void zzh(zzaah zzaah) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzd.zzn(zzaah);
    }

    public final void zzi(zzabb zzabb) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzd.zzo(zzabb);
    }

    public final void zzj(zzaay zzaay) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle zzk() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final void zzl() {
    }

    public final synchronized void zzm() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzbom zzbom = this.zzg;
        if (zzbom != null) {
            zzbom.zzh();
        }
    }

    public final synchronized zzyx zzn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzbom zzbom = this.zzg;
        if (zzbom != null) {
            return zzdrk.zzb(this.zza, Collections.singletonList(zzbom.zze()));
        }
        return this.zzf.zze();
    }

    public final synchronized void zzo(zzyx zzyx) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzf.zzc(zzyx);
        this.zze = zzyx;
        zzbom zzbom = this.zzg;
        if (zzbom != null) {
            zzbom.zzb(this.zzb.zzc(), zzyx);
        }
    }

    public final void zzp(zzaus zzaus) {
    }

    public final void zzq(zzauv zzauv, String str) {
    }

    public final synchronized String zzr() {
        zzbom zzbom = this.zzg;
        if (zzbom == null || zzbom.zzm() == null) {
            return null;
        }
        return this.zzg.zzm().zze();
    }

    public final synchronized String zzs() {
        zzbom zzbom = this.zzg;
        if (zzbom == null || zzbom.zzm() == null) {
            return null;
        }
        return this.zzg.zzm().zze();
    }

    public final synchronized zzacg zzt() {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeP)).booleanValue()) {
            return null;
        }
        zzbom zzbom = this.zzg;
        if (zzbom == null) {
            return null;
        }
        return zzbom.zzm();
    }

    public final synchronized String zzu() {
        return this.zzc;
    }

    public final zzabb zzv() {
        return this.zzd.zzm();
    }

    public final zzaah zzw() {
        return this.zzd.zzl();
    }

    public final synchronized void zzx(zzafl zzafl) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzd(zzafl);
    }

    public final void zzy(zzaae zzaae) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzb.zze(zzaae);
    }

    public final synchronized void zzz(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzf.zzj(z);
    }
}
