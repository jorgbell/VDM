package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcgk implements zzakp {
    private final zzcgp zza;
    private final WindowManager zzb;
    private final View zzc;

    zzcgk(zzcgp zzcgp, WindowManager windowManager, View view) {
        this.zza = zzcgp;
        this.zzb = windowManager;
        this.zzc = view;
    }

    public final void zza(Object obj, Map map) {
        this.zza.zzd(this.zzb, this.zzc, (zzbgf) obj, map);
    }
}
