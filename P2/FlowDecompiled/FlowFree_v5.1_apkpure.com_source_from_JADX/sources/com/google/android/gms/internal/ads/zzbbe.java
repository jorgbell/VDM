package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzbbe implements zzbbi {
    private final String zza;
    private final String zzb;
    private final Map zzc;
    private final byte[] zzd;

    zzbbe(String str, String str2, Map map, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = map;
        this.zzd = bArr;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzbbj.zzm(this.zza, this.zzb, this.zzc, this.zzd, jsonWriter);
    }
}
