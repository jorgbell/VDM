package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdcd extends zzaat {
    private final Context zza;
    private final zzaah zzb;
    private final zzdrg zzc;
    private final zzbom zzd;
    private final ViewGroup zze;

    public zzdcd(Context context, zzaah zzaah, zzdrg zzdrg, zzbom zzbom) {
        this.zza = context;
        this.zzb = zzaah;
        this.zzc = zzdrg;
        this.zzd = zzbom;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        frameLayout.addView(zzbom.zza(), zzs.zze().zzj());
        frameLayout.setMinimumHeight(zzn().zzc);
        frameLayout.setMinimumWidth(zzn().zzf);
        this.zze = frameLayout;
    }

    public final boolean zzA() throws RemoteException {
        return false;
    }

    public final void zzB(zzawy zzawy) throws RemoteException {
    }

    public final void zzC(String str) throws RemoteException {
    }

    public final void zzD(String str) throws RemoteException {
    }

    public final zzacj zzE() throws RemoteException {
        return this.zzd.zzc();
    }

    public final void zzF(zzady zzady) throws RemoteException {
        zzbbk.zzh("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzG(zzacn zzacn) throws RemoteException {
    }

    public final void zzH(zzzd zzzd) throws RemoteException {
    }

    public final void zzI(zzte zzte) throws RemoteException {
    }

    public final void zzJ(boolean z) throws RemoteException {
    }

    public final void zzO(zzacd zzacd) {
        zzbbk.zzh("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzP(zzys zzys, zzaak zzaak) {
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzR(zzabi zzabi) {
    }

    public final void zzab(zzabf zzabf) throws RemoteException {
        zzbbk.zzh("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap(this.zze);
    }

    public final boolean zzbI() throws RemoteException {
        return false;
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzR();
    }

    public final boolean zze(zzys zzys) throws RemoteException {
        zzbbk.zzh("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    public final void zzf() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzl().zza((Context) null);
    }

    public final void zzg() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzl().zzb((Context) null);
    }

    public final void zzh(zzaah zzaah) throws RemoteException {
        zzbbk.zzh("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzi(zzabb zzabb) throws RemoteException {
        zzdda zzdda = this.zzc.zzc;
        if (zzdda != null) {
            zzdda.zzo(zzabb);
        }
    }

    public final void zzj(zzaay zzaay) throws RemoteException {
        zzbbk.zzh("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final Bundle zzk() throws RemoteException {
        zzbbk.zzh("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    public final void zzl() throws RemoteException {
    }

    public final void zzm() throws RemoteException {
        this.zzd.zzh();
    }

    public final zzyx zzn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzdrk.zzb(this.zza, Collections.singletonList(this.zzd.zze()));
    }

    public final void zzo(zzyx zzyx) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbom zzbom = this.zzd;
        if (zzbom != null) {
            zzbom.zzb(this.zze, zzyx);
        }
    }

    public final void zzp(zzaus zzaus) throws RemoteException {
    }

    public final void zzq(zzauv zzauv, String str) throws RemoteException {
    }

    public final String zzr() throws RemoteException {
        if (this.zzd.zzm() != null) {
            return this.zzd.zzm().zze();
        }
        return null;
    }

    public final String zzs() throws RemoteException {
        if (this.zzd.zzm() != null) {
            return this.zzd.zzm().zze();
        }
        return null;
    }

    public final zzacg zzt() {
        return this.zzd.zzm();
    }

    public final String zzu() throws RemoteException {
        return this.zzc.zzf;
    }

    public final zzabb zzv() throws RemoteException {
        return this.zzc.zzn;
    }

    public final zzaah zzw() throws RemoteException {
        return this.zzb;
    }

    public final void zzx(zzafl zzafl) throws RemoteException {
        zzbbk.zzh("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzy(zzaae zzaae) throws RemoteException {
        zzbbk.zzh("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzz(boolean z) throws RemoteException {
        zzbbk.zzh("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }
}
