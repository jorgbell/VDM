package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzebq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzk implements Callable {
    private final Uri zza;

    zzk(Uri uri) {
        this.zza = uri;
    }

    public final Object call() {
        Uri uri = this.zza;
        zzebq zzebq = zzr.zza;
        zzs.zzc();
        return zzr.zzP(uri);
    }
}
