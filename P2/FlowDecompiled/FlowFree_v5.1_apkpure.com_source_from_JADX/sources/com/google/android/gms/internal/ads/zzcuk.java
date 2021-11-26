package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcuk {
    private final zzcug zza;
    private final zzefx zzb;

    public zzcuk(zzcug zzcug, zzefx zzefx) {
        this.zza = zzcug;
        this.zzb = zzefx;
    }

    public final void zza(zzdui<SQLiteDatabase, Void> zzdui) {
        zzefo.zzo(this.zzb.zzb(zzcui.zza(this.zza)), new zzcuj(this, zzdui), this.zzb);
    }
}
