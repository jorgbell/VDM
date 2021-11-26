package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zze implements Callable {
    private final zzp zza;
    private final Uri zzb;
    private final IObjectWrapper zzc;

    zze(zzp zzp, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zza = zzp;
        this.zzb = uri;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzm(this.zzb, this.zzc);
    }
}
