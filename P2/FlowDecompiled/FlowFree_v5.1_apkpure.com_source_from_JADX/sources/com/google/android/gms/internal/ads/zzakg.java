package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzakg implements zzakp<zzbgf> {
    zzakg() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        if (zzbgf.zzay() != null) {
            zzbgf.zzay().zza();
        }
        zzm zzN = zzbgf.zzN();
        if (zzN != null) {
            zzN.zzb();
            return;
        }
        zzm zzO = zzbgf.zzO();
        if (zzO != null) {
            zzO.zzb();
        } else {
            zzbbk.zzi("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
