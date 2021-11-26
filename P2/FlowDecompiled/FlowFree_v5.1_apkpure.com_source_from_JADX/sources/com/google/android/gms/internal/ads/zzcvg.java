package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcvg implements zzdui {
    private final zzcvk zza;
    private final zzbbp zzb;
    private final String zzc;

    zzcvg(zzcvk zzcvk, zzbbp zzbbp, String str) {
        this.zza = zzcvk;
        this.zzb = zzbbp;
        this.zzc = str;
    }

    public final Object zza(Object obj) {
        this.zza.zzb((SQLiteDatabase) obj, this.zzb, this.zzc);
        return null;
    }
}
