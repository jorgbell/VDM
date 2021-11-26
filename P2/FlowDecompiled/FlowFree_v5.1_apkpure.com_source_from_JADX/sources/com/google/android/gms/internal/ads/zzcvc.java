package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcvc {
    private final zzug zza;
    private final Context zzb;
    private final zzcuk zzc;
    private final zzbbq zzd;
    private final String zze;
    private final zzdvo zzf;
    private final zzg zzg = zzs.zzg().zzl();

    public zzcvc(Context context, zzbbq zzbbq, zzug zzug, zzcuk zzcuk, String str, zzdvo zzdvo) {
        this.zzb = context;
        this.zzd = zzbbq;
        this.zza = zzug;
        this.zzc = zzcuk;
        this.zze = str;
        this.zzf = zzdvo;
    }

    private static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList<zzwt> arrayList) {
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            zzwt zzwt = arrayList.get(i);
            if (zzwt.zzc() == zzvy.ENUM_TRUE && zzwt.zza() > j) {
                j = zzwt.zza();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
        }
    }

    public final void zza(boolean z) {
        try {
            this.zzc.zza(new zzcuy(this, z));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzbbk.zzf(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        String str;
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            int i = 2;
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
                zzdvn zza2 = zzdvn.zza("oa_upload");
                zza2.zzc("oa_failed_reqs", String.valueOf(zzcux.zzb(sQLiteDatabase, 0)));
                zza2.zzc("oa_total_reqs", String.valueOf(zzcux.zzb(sQLiteDatabase, 1)));
                zza2.zzc("oa_upload_time", String.valueOf(zzs.zzj().currentTimeMillis()));
                zza2.zzc("oa_last_successful_time", String.valueOf(zzcux.zzc(sQLiteDatabase, 2)));
                zza2.zzc("oa_session_id", this.zzg.zzB() ? "" : this.zze);
                this.zzf.zza(zza2);
                ArrayList<zzwt> zza3 = zzcux.zza(sQLiteDatabase);
                zzc(sQLiteDatabase, zza3);
                int size = zza3.size();
                for (int i2 = 0; i2 < size; i2++) {
                    zzwt zzwt = zza3.get(i2);
                    zzdvn zza4 = zzdvn.zza("oa_signals");
                    if (this.zzg.zzB()) {
                        str = "";
                    } else {
                        str = this.zze;
                    }
                    zza4.zzc("oa_session_id", str);
                    zzwo zzg2 = zzwt.zzg();
                    String valueOf = zzg2.zza() ? String.valueOf(zzg2.zzc().zza()) : "-1";
                    String obj = zzedm.zzb(zzwt.zzf(), zzcvb.zza).toString();
                    zza4.zzc("oa_sig_ts", String.valueOf(zzwt.zza()));
                    zza4.zzc("oa_sig_status", String.valueOf(zzwt.zzc().zza()));
                    zza4.zzc("oa_sig_resp_lat", String.valueOf(zzwt.zzd()));
                    zza4.zzc("oa_sig_render_lat", String.valueOf(zzwt.zze()));
                    zza4.zzc("oa_sig_formats", obj);
                    zza4.zzc("oa_sig_nw_type", valueOf);
                    zza4.zzc("oa_sig_wifi", String.valueOf(zzwt.zzh().zza()));
                    zza4.zzc("oa_sig_airplane", String.valueOf(zzwt.zzi().zza()));
                    zza4.zzc("oa_sig_data", String.valueOf(zzwt.zzj().zza()));
                    zza4.zzc("oa_sig_nw_resp", String.valueOf(zzwt.zzk()));
                    zza4.zzc("oa_sig_offline", String.valueOf(zzwt.zzl().zza()));
                    zza4.zzc("oa_sig_nw_state", String.valueOf(zzwt.zzm().zza()));
                    if (zzg2.zzd() && zzg2.zza() && zzg2.zzc().equals(zzwn.CELL)) {
                        zza4.zzc("oa_sig_cell_type", String.valueOf(zzg2.zze().zza()));
                    }
                    this.zzf.zza(zza4);
                }
            } else {
                ArrayList<zzwt> zza5 = zzcux.zza(sQLiteDatabase);
                zzwu zza6 = zzwy.zza();
                zza6.zze(this.zzb.getPackageName());
                zza6.zzf(Build.MODEL);
                zza6.zzb(zzcux.zzb(sQLiteDatabase, 0));
                zza6.zza(zza5);
                zza6.zzc(zzcux.zzb(sQLiteDatabase, 1));
                zza6.zzd(zzs.zzj().currentTimeMillis());
                zza6.zzg(zzcux.zzc(sQLiteDatabase, 2));
                zzc(sQLiteDatabase, zza5);
                this.zza.zzc(new zzcuz((zzwy) zza6.zzah()));
                zzxj zza7 = zzxk.zza();
                zza7.zza(this.zzd.zzb);
                zza7.zzb(this.zzd.zzc);
                if (true == this.zzd.zzd) {
                    i = 0;
                }
                zza7.zzc(i);
                this.zza.zzc(new zzcva((zzxk) zza7.zzah()));
                this.zza.zzb(zzui.OFFLINE_UPLOAD);
            }
            sQLiteDatabase.delete("offline_signal_contents", (String) null, (String[]) null);
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", 0);
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{"failed_requests"});
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("value", 0);
            sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"total_requests"});
        }
        return null;
    }
}
