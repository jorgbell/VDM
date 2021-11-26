package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzava {
    @GuardedBy("InternalQueryInfoGenerator.class")
    private static zzbag zzd;
    private final Context zza;
    private final AdFormat zzb;
    private final zzacq zzc;

    public zzava(Context context, AdFormat adFormat, zzacq zzacq) {
        this.zza = context;
        this.zzb = adFormat;
        this.zzc = zzacq;
    }

    public static zzbag zza(Context context) {
        zzbag zzbag;
        synchronized (zzava.class) {
            if (zzd == null) {
                zzd = zzzy.zzb().zzh(context, new zzapy());
            }
            zzbag = zzd;
        }
        return zzbag;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzys zzys;
        zzbag zza2 = zza(this.zza);
        if (zza2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zza);
        zzacq zzacq = this.zzc;
        if (zzacq == null) {
            zzys = new zzyt().zza();
        } else {
            zzys = zzyw.zza.zza(this.zza, zzacq);
        }
        try {
            zza2.zze(wrap, new zzbak((String) null, this.zzb.name(), (zzyx) null, zzys), new zzauz(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
