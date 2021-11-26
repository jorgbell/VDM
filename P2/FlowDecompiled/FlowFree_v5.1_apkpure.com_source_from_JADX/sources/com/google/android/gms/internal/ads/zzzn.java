package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzn extends zzzx<zzaau> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzyx zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzaqb zzd;
    final /* synthetic */ zzzw zze;

    zzzn(zzzw zzzw, Context context, zzyx zzyx, String str, zzaqb zzaqb) {
        this.zze = zzzw;
        this.zza = context;
        this.zzb = zzyx;
        this.zzc = str;
        this.zzd = zzaqb;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzzw.zzl(this.zza, "banner");
        return new zzadj();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zze.zza.zza(this.zza, this.zzb, this.zzc, this.zzd, 1);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzd, 210890000);
    }
}
