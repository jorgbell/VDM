package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzyq extends RemoteCreator<zzaar> {
    public zzyq() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzaar) {
            return (zzaar) queryLocalInterface;
        }
        return new zzaar(iBinder);
    }

    public final zzaaq zza(Context context, String str, zzaqb zzaqb) {
        zzaaq zzaao;
        try {
            IBinder zze = ((zzaar) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), str, zzaqb, 210890000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzaaq) {
                zzaao = (zzaaq) queryLocalInterface;
            } else {
                zzaao = new zzaao(zze);
            }
            return zzaao;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbk.zzj("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }
}
