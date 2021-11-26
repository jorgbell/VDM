package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzadl extends zzabk {
    private zzamq zza;

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        zzamq zzamq = this.zza;
        if (zzamq != null) {
            try {
                zzamq.zzb(Collections.emptyList());
            } catch (RemoteException e) {
                zzbbk.zzj("Could not notify onComplete event.", e);
            }
        }
    }

    public final void zze() throws RemoteException {
        zzbbk.zzf("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzbbd.zza.post(new zzadk(this));
    }

    public final void zzf(float f) throws RemoteException {
    }

    public final void zzg(String str) throws RemoteException {
    }

    public final void zzh(boolean z) throws RemoteException {
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzj(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final float zzk() throws RemoteException {
        return 1.0f;
    }

    public final boolean zzl() throws RemoteException {
        return false;
    }

    public final String zzm() {
        return "";
    }

    public final void zzn(String str) throws RemoteException {
    }

    public final void zzo(zzaqb zzaqb) throws RemoteException {
    }

    public final void zzp(zzamq zzamq) throws RemoteException {
        this.zza = zzamq;
    }

    public final List<zzamj> zzq() throws RemoteException {
        return Collections.emptyList();
    }

    public final void zzr(zzads zzads) throws RemoteException {
    }

    public final void zzs() {
    }

    public final void zzt(zzabx zzabx) {
    }
}
