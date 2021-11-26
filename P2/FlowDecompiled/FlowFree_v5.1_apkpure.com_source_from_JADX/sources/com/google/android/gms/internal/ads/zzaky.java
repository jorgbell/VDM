package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzaky implements zzu {
    boolean zza = false;
    final /* synthetic */ Map zzb;
    final /* synthetic */ Map zzc;
    final /* synthetic */ zzyi zzd;

    zzaky(zzala zzala, Map map, Map map2, zzyi zzyi) {
        this.zzb = map;
        this.zzc = map2;
        this.zzd = zzyi;
    }

    public final void zza(boolean z) {
        if (!this.zza) {
            this.zza = true;
            this.zzb.put((String) this.zzc.get("event_id"), Boolean.valueOf(z));
            ((zzang) this.zzd).zze("openIntentAsync", this.zzb);
        }
    }

    public final void zzb(int i) {
    }
}
