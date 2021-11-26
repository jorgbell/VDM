package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzadd extends RemoteCreator<zzabm> {
    public zzadd() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzabm) {
            return (zzabm) queryLocalInterface;
        }
        return new zzabm(iBinder);
    }

    public final zzabl zza(Context context) {
        zzabl zzabj;
        try {
            IBinder zze = ((zzabm) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), 210890000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzabl) {
                zzabj = (zzabl) queryLocalInterface;
            } else {
                zzabj = new zzabj(zze);
            }
            return zzabj;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbk.zzj("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }
}
