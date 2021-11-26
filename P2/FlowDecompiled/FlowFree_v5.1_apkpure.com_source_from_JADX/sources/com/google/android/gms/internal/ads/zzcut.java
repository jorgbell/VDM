package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcut implements zzdui {
    private final zzcuu zza;
    private final boolean zzb;
    private final ArrayList zzc;
    private final zzwo zzd;
    private final zzwx zze;

    zzcut(zzcuu zzcuu, boolean z, ArrayList arrayList, zzwo zzwo, zzwx zzwx) {
        this.zza = zzcuu;
        this.zzb = z;
        this.zzc = arrayList;
        this.zzd = zzwo;
        this.zze = zzwx;
    }

    public final Object zza(Object obj) {
        zzcuu zzcuu = this.zza;
        boolean z = this.zzb;
        ArrayList arrayList = this.zzc;
        zzwo zzwo = this.zzd;
        zzwx zzwx = this.zze;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (!zzcuu.zzb.zzf.zzB()) {
            byte[] zzf = zzcuv.zzf(zzcuu.zzb, z, arrayList, zzwo, zzwx);
            ContentValues contentValues = new ContentValues();
            contentValues.put("timestamp", Long.valueOf(zzs.zzj().currentTimeMillis()));
            contentValues.put("serialized_proto_data", zzf);
            sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
            if (!z) {
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
            }
        }
        return null;
    }
}
