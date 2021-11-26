package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzakr implements zzakp<zzbgf> {
    private final zzaks zza;

    public zzakr(zzaks zzaks, byte[] bArr) {
        this.zza = zzaks;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zzbbk.zzg("Fail to parse float", e);
        }
        this.zza.zza(equals);
        this.zza.zzb(equals2, f);
        zzbgf.zzaD(equals);
    }
}
