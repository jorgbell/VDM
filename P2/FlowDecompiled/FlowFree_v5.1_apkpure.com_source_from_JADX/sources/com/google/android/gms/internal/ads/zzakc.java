package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzakc implements zzakp {
    static final zzakp zza = new zzakc();

    private zzakc() {
    }

    public final void zza(Object obj, Map map) {
        zzbho zzbho = (zzbho) obj;
        zzakp<zzbgf> zzakp = zzako.zza;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzfh zzU = zzbho.zzU();
            if (zzU != null) {
                zzU.zzb().zzg(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzbbk.zzi("Could not parse touch parameters from gmsg.");
        }
    }
}
