package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzv extends zzzx<zzaxl> {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzaqb zzc;

    zzzv(zzzw zzzw, Context context, String str, zzaqb zzaqb) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzaqb;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzzw.zzl(this.zza, "rewarded");
        return new zzadp();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return zzaxx.zza(this.zza, this.zzb, this.zzc);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zzk(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 210890000);
    }
}
