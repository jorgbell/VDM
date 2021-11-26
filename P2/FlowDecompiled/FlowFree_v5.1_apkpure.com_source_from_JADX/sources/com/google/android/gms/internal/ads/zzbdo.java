package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbdo {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;
    public final boolean zzl;

    public zzbdo(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzaeq.zzD);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzaeq.zzj);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzaeq.zzs);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzaeq.zzf);
        zzaei zzaei = zzaeq.zze;
        if (jSONObject != null) {
            try {
                jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
            this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzaeq.zzg);
            this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzaeq.zzh);
            this.zzh = zzb(jSONObject, "player_precache_limit", zzaeq.zzi);
            this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzaeq.zzk);
            this.zzj = zza(jSONObject, "use_cache_data_source", zzaeq.zzcw);
            this.zzk = zzb(jSONObject, "min_retry_count", zzaeq.zzm);
            this.zzl = zza(jSONObject, "treat_load_exception_as_non_fatal", zzaeq.zzp);
        }
        String str2 = (String) zzaaa.zzc().zzb(zzaei);
        this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzaeq.zzg);
        this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzaeq.zzh);
        this.zzh = zzb(jSONObject, "player_precache_limit", zzaeq.zzi);
        this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzaeq.zzk);
        this.zzj = zza(jSONObject, "use_cache_data_source", zzaeq.zzcw);
        this.zzk = zzb(jSONObject, "min_retry_count", zzaeq.zzm);
        this.zzl = zza(jSONObject, "treat_load_exception_as_non_fatal", zzaeq.zzp);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzaei<java.lang.Boolean>, com.google.android.gms.internal.ads.zzaei] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean zza(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3) {
        /*
            com.google.android.gms.internal.ads.zzaeo r0 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r3 = r0.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r1 == 0) goto L_0x0014
            boolean r3 = r1.getBoolean(r2)     // Catch:{ JSONException -> 0x0014 }
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdo.zza(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzaei):boolean");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzaei, com.google.android.gms.internal.ads.zzaei<java.lang.Integer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int zzb(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            int r0 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzaeo r0 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r0.zzb(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdo.zzb(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzaei):int");
    }
}
