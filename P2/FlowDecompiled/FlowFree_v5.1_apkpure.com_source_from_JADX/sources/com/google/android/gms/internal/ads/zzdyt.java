package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdyt implements Continuation {
    private final zzbv zza;
    private final int zzb;

    zzdyt(zzbv zzbv, int i) {
        this.zza = zzbv;
        this.zzb = i;
    }

    public final Object then(Task task) {
        zzbv zzbv = this.zza;
        int i = this.zzb;
        int i2 = zzdyu.zza;
        if (!task.isSuccessful()) {
            return Boolean.FALSE;
        }
        zzeaz zza2 = ((zzeba) task.getResult()).zza(((zzcb) zzbv.zzah()).zzao());
        zza2.zzc(i);
        zza2.zza();
        return Boolean.TRUE;
    }
}
