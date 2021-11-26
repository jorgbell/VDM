package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcgl implements zzakp {
    private final zzcgp zza;
    private final View zzb;
    private final WindowManager zzc;

    zzcgl(zzcgp zzcgp, View view, WindowManager windowManager) {
        this.zza = zzcgp;
        this.zzb = view;
        this.zzc = windowManager;
    }

    public final void zza(Object obj, Map map) {
        this.zza.zzb(this.zzb, this.zzc, (zzbgf) obj, map);
    }
}
