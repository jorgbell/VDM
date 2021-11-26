package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzajf extends RemoteCreator<zzahp> {
    public zzajf() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzahp) {
            return (zzahp) queryLocalInterface;
        }
        return new zzahp(iBinder);
    }

    public final zzaho zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzaho zzahm;
        try {
            IBinder zze = ((zzahp) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(frameLayout), ObjectWrapper.wrap(frameLayout2), 210890000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzaho) {
                zzahm = (zzaho) queryLocalInterface;
            } else {
                zzahm = new zzahm(zze);
            }
            return zzahm;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbk.zzj("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }
}
