package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxx {
    public static final zzaxl zza(Context context, String str, zzaqb zzaqb) {
        zzaxl zzaxj;
        try {
            IBinder zze = ((zzaxp) zzbbo.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzaxw.zza)).zze(ObjectWrapper.wrap(context), str, zzaqb, 210890000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzaxl) {
                zzaxj = (zzaxl) queryLocalInterface;
            } else {
                zzaxj = new zzaxj(zze);
            }
            return zzaxj;
        } catch (RemoteException | zzbbn e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}
