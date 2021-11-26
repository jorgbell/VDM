package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzs extends zzzx<zzabl> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzzw zzb;

    zzzs(zzzw zzzw, Context context) {
        this.zzb = zzzw;
        this.zza = context;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzzw.zzl(this.zza, "mobile_ads_settings");
        return new zzadl();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zzb.zzc.zza(this.zza);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zzh(ObjectWrapper.wrap(this.zza), 210890000);
    }
}
