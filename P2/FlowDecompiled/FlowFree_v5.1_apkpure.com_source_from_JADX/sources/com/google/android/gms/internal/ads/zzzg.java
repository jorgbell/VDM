package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzg extends zzzx<zzaul> {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzzw zzb;

    zzzg(zzzw zzzw, Activity activity) {
        this.zzb = zzzw;
        this.zza = activity;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzzw.zzl(this.zza, "ad_overlay");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zzb.zzf.zza(this.zza);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zzg(ObjectWrapper.wrap(this.zza));
    }
}
