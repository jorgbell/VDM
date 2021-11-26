package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcvk extends SQLiteOpenHelper {
    private final Context zza;
    private final zzefx zzb;

    public zzcvk(Context context, zzefx zzefx) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzaaa.zzc().zzb(zzaeq.zzfz)).intValue());
        this.zza = context;
        this.zzb = zzefx;
    }

    static final /* synthetic */ void zzg(SQLiteDatabase sQLiteDatabase, String str, zzbbp zzbbp) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, zzbbp);
    }

    static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    /* access modifiers changed from: private */
    public static void zzj(SQLiteDatabase sQLiteDatabase, zzbbp zzbbp) {
        sQLiteDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("event_state = ");
            sb.append(1);
            String sb2 = sb.toString();
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", new String[]{"url"}, sb2, (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            int count = query.getCount();
            String[] strArr = new String[count];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("url");
                if (columnIndex != -1) {
                    strArr[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i2 = 0; i2 < count; i2++) {
                zzbbp.zza(strArr[i2]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdui<SQLiteDatabase, Void> zzdui) {
        zzefo.zzo(this.zzb.zzb(new zzcvd(this)), new zzcvj(this, zzdui), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(SQLiteDatabase sQLiteDatabase, zzbbp zzbbp, String str) {
        this.zzb.execute(new zzcvf(sQLiteDatabase, str, zzbbp));
    }

    public final void zzc(zzbbp zzbbp, String str) {
        zza(new zzcvg(this, zzbbp, str));
    }

    public final void zzd(String str) {
        zza(new zzcvh(this, str));
    }

    public final void zze(zzcvm zzcvm) {
        zza(new zzcvi(this, zzcvm));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzf(zzcvm zzcvm, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzcvm.zza));
        contentValues.put("gws_query_id", zzcvm.zzb);
        contentValues.put("url", zzcvm.zzc);
        contentValues.put("event_state", Integer.valueOf(zzcvm.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzs.zzc();
        zzbh zzC = zzr.zzC(this.zza);
        if (zzC != null) {
            try {
                zzC.zzf(ObjectWrapper.wrap(this.zza));
            } catch (RemoteException e) {
                zze.zzb("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }
}
