package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzyr extends RemoteCreator<zzaav> {
    public zzyr() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzaav) {
            return (zzaav) queryLocalInterface;
        }
        return new zzaav(iBinder);
    }

    public final zzaau zza(Context context, zzyx zzyx, String str, zzaqb zzaqb, int i) {
        zzaau zzaas;
        try {
            IBinder zze = ((zzaav) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzyx, str, zzaqb, 210890000, i);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzaau) {
                zzaas = (zzaau) queryLocalInterface;
            } else {
                zzaas = new zzaas(zze);
            }
            return zzaas;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbk.zze("Could not create remote AdManager.", e);
            return null;
        }
    }
}
