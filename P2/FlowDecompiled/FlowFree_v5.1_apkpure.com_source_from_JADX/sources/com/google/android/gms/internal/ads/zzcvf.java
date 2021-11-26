package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcvf implements Runnable {
    private final SQLiteDatabase zza;
    private final String zzb;
    private final zzbbp zzc;

    zzcvf(SQLiteDatabase sQLiteDatabase, String str, zzbbp zzbbp) {
        this.zza = sQLiteDatabase;
        this.zzb = str;
        this.zzc = zzbbp;
    }

    public final void run() {
        zzcvk.zzg(this.zza, this.zzb, this.zzc);
    }
}
