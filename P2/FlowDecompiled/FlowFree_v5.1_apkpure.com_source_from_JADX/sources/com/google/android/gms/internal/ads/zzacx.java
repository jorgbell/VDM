package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzacx extends zzamp {
    final /* synthetic */ zzacy zza;

    /* synthetic */ zzacx(zzacy zzacy, zzacv zzacv) {
        this.zza = zzacy;
    }

    public final void zzb(List<zzamj> list) throws RemoteException {
        boolean unused = this.zza.zze = false;
        boolean unused2 = this.zza.zzf = true;
        InitializationStatus zzs = zzacy.zzx(list);
        ArrayList zzt = zzacy.zza().zza;
        int size = zzt.size();
        for (int i = 0; i < size; i++) {
            ((OnInitializationCompleteListener) zzt.get(i)).onInitializationComplete(zzs);
        }
        zzacy.zza().zza.clear();
    }
}
