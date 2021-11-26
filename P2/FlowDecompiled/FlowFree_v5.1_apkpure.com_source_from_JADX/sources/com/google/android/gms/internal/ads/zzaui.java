package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaui extends RemoteCreator<zzaum> {
    public zzaui() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzaum) {
            return (zzaum) queryLocalInterface;
        }
        return new zzaum(iBinder);
    }

    public final zzaul zza(Activity activity) {
        zzaul zzauj;
        try {
            IBinder zze = ((zzaum) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.wrap(activity));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzaul) {
                zzauj = (zzaul) queryLocalInterface;
            } else {
                zzauj = new zzauj(zze);
            }
            return zzauj;
        } catch (RemoteException e) {
            zzbbk.zzj("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            zzbbk.zzj("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
