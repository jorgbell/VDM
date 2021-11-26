package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcuj implements zzefk<SQLiteDatabase> {
    final /* synthetic */ zzdui zza;

    zzcuj(zzcuk zzcuk, zzdui zzdui) {
        this.zza = zzdui;
    }

    public final void zza(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzbbk.zzf(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbbk.zzf(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }
}
