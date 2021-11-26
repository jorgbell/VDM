package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaib implements NativeCustomTemplateAd {
    private final zzaia zza;

    public zzaib(zzaia zzaia) {
        Context context;
        new VideoController();
        this.zza = zzaia;
        try {
            context = (Context) ObjectWrapper.unwrap(zzaia.zzm());
        } catch (RemoteException | NullPointerException e) {
            zzbbk.zzg("", e);
            context = null;
        }
        if (context != null) {
            try {
                boolean zzn = this.zza.zzn(ObjectWrapper.wrap(new MediaView(context)));
            } catch (RemoteException e2) {
                zzbbk.zzg("", e2);
            }
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final zzaia zza() {
        return this.zza;
    }
}
