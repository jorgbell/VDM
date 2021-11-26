package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzk extends zzzx<zzatz> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzaqb zzb;

    zzzk(zzzw zzzw, Context context, zzaqb zzaqb) {
        this.zza = context;
        this.zzb = zzaqb;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        try {
            return ((zzauc) zzbbo.zza(this.zza, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzzj.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 210890000);
        } catch (RemoteException | zzbbn | NullPointerException unused) {
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zzn(ObjectWrapper.wrap(this.zza), this.zzb, 210890000);
    }
}
