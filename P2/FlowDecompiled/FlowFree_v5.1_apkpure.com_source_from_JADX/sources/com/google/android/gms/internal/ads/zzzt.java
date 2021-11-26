package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzt extends zzzx<zzaho> {
    final /* synthetic */ FrameLayout zza;
    final /* synthetic */ FrameLayout zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ zzzw zzd;

    zzzt(zzzw zzzw, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzd = zzzw;
        this.zza = frameLayout;
        this.zzb = frameLayout2;
        this.zzc = context;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzzw.zzl(this.zzc, "native_ad_view_delegate");
        return new zzadm();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zzd.zzd.zza(this.zzc, this.zza, this.zzb);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zze(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb));
    }
}
