package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzp extends zzzx<zzaau> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzyx zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzzw zzd;

    zzzp(zzzw zzzw, Context context, zzyx zzyx, String str) {
        this.zzd = zzzw;
        this.zza = context;
        this.zzb = zzyx;
        this.zzc = str;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzzw.zzl(this.zza, AppLovinEventTypes.USER_EXECUTED_SEARCH);
        return new zzadj();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zzd.zza.zza(this.zza, this.zzb, this.zzc, (zzaqb) null, 3);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zzi(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 210890000);
    }
}
