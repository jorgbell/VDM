package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcpz implements zzcqj, zzcpm {
    private final zzcqi zza;
    private final zzcqk zzb;
    private final zzcpn zzc;
    private final zzcpv zzd;
    private final zzcpl zze;
    private final String zzf;
    private final Map<String, List<zzcpp>> zzg;
    private String zzh = "{}";
    private long zzi = Long.MAX_VALUE;
    private zzcpw zzj = zzcpw.NONE;
    private boolean zzk;
    private int zzl;
    private boolean zzm;

    zzcpz(zzcqi zzcqi, zzcqk zzcqk, zzcpn zzcpn, Context context, zzbbq zzbbq, zzcpv zzcpv) {
        this.zza = zzcqi;
        this.zzb = zzcqk;
        this.zzc = zzcpn;
        this.zzg = new HashMap();
        this.zze = new zzcpl(context);
        this.zzf = zzbbq.zza;
        this.zzd = zzcpv;
    }

    private final synchronized void zzj(boolean z, boolean z2) {
        if (this.zzk != z) {
            this.zzk = z;
            if (z) {
                zzn();
            } else {
                zzo();
            }
            if (z2) {
                zzp();
            }
        }
    }

    private final synchronized void zzk(zzcpw zzcpw, boolean z) {
        if (this.zzj != zzcpw) {
            if (this.zzk) {
                zzo();
            }
            this.zzj = zzcpw;
            if (this.zzk) {
                zzn();
            }
            if (z) {
                zzp();
            }
        }
    }

    private final synchronized JSONObject zzl() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry next : this.zzg.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzcpp zzcpp : (List) next.getValue()) {
                if (zzcpp.zzb()) {
                    jSONArray.put(zzcpp.zzc());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) next.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzm() {
        this.zzm = true;
        this.zzd.zza();
        this.zza.zzf(this);
        this.zzb.zza(this);
        this.zzc.zza(this);
        zzq(zzs.zzg().zzl().zzF());
    }

    private final synchronized void zzn() {
        zzcpw zzcpw = zzcpw.NONE;
        int ordinal = this.zzj.ordinal();
        if (ordinal == 1) {
            this.zzb.zzb();
        } else if (ordinal == 2) {
            this.zzc.zzb();
        }
    }

    private final synchronized void zzo() {
        zzcpw zzcpw = zzcpw.NONE;
        int ordinal = this.zzj.ordinal();
        if (ordinal == 1) {
            this.zzb.zzc();
        } else if (ordinal == 2) {
            this.zzc.zzc();
        }
    }

    private final void zzp() {
        zzs.zzg().zzl().zzG(zze());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzq(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            java.lang.String r4 = "isTestMode"
            r1 = 0
            boolean r4 = r0.optBoolean(r4, r1)     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            r3.zzj(r4, r1)     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            java.lang.String r4 = "gesture"
            java.lang.String r2 = "NONE"
            java.lang.String r4 = r0.optString(r4, r2)     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            com.google.android.gms.internal.ads.zzcpw r4 = com.google.android.gms.internal.ads.zzcpw.zza(r4)     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            r3.zzk(r4, r1)     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            java.lang.String r4 = "networkExtras"
            java.lang.String r1 = "{}"
            java.lang.String r4 = r0.optString(r4, r1)     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            r3.zzh = r4     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            java.lang.String r4 = "networkExtrasExpirationSecs"
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            r3.zzi = r0     // Catch:{ JSONException -> 0x003b, all -> 0x0038 }
            monitor-exit(r3)
            return
        L_0x0038:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x003b:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpz.zzq(java.lang.String):void");
    }

    public final void zza() {
        String zzF;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue() && (zzF = zzs.zzg().zzl().zzF()) != null) {
            try {
                if (new JSONObject(zzF).optBoolean("isTestMode", false)) {
                    zzm();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final void zzb(boolean z) {
        if (!this.zzm && z) {
            zzm();
        }
        zzj(z, true);
    }

    public final void zzc(zzcpw zzcpw) {
        zzk(zzcpw, true);
    }

    public final synchronized String zzd() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue()) {
            if (this.zzk) {
                if (this.zzi < zzs.zzj().currentThreadTimeMillis() / 1000) {
                    this.zzh = "{}";
                    return "";
                } else if (this.zzh.equals("{}")) {
                    return "";
                } else {
                    return this.zzh;
                }
            }
        }
        return "";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|(1:7)|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zze() {
        /*
            r7 = this;
            monitor-enter(r7)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0039 }
            r0.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "isTestMode"
            boolean r2 = r7.zzk     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r1 = "gesture"
            com.google.android.gms.internal.ads.zzcpw r2 = r7.zzj     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            long r1 = r7.zzi     // Catch:{ JSONException -> 0x0033 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ JSONException -> 0x0033 }
            long r3 = r3.currentThreadTimeMillis()     // Catch:{ JSONException -> 0x0033 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0033
            java.lang.String r1 = "networkExtras"
            java.lang.String r2 = r7.zzh     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
            java.lang.String r1 = "networkExtrasExpirationSecs"
            long r2 = r7.zzi     // Catch:{ JSONException -> 0x0033 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0033 }
        L_0x0033:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0039 }
            monitor-exit(r7)
            return r0
        L_0x0039:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpz.zze():java.lang.String");
    }

    public final synchronized void zzf(String str, long j) {
        this.zzh = str;
        this.zzi = j;
        zzp();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg(java.lang.String r4, com.google.android.gms.internal.ads.zzcpp r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzfP     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x005a }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x005a }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0058
            boolean r0 = r3.zzk     // Catch:{ all -> 0x005a }
            if (r0 != 0) goto L_0x0018
            goto L_0x0058
        L_0x0018:
            int r0 = r3.zzl     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzaeq.zzfR     // Catch:{ all -> 0x005a }
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x005a }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x005a }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x005a }
            int r1 = r1.intValue()     // Catch:{ all -> 0x005a }
            if (r0 < r1) goto L_0x0033
            java.lang.String r4 = "Maximum number of ad requests stored reached. Dropping the current request."
            com.google.android.gms.internal.ads.zzbbk.zzi(r4)     // Catch:{ all -> 0x005a }
            monitor-exit(r3)
            return
        L_0x0033:
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzcpp>> r0 = r3.zzg     // Catch:{ all -> 0x005a }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x005a }
            if (r0 != 0) goto L_0x0045
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzcpp>> r0 = r3.zzg     // Catch:{ all -> 0x005a }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x005a }
            r1.<init>()     // Catch:{ all -> 0x005a }
            r0.put(r4, r1)     // Catch:{ all -> 0x005a }
        L_0x0045:
            int r0 = r3.zzl     // Catch:{ all -> 0x005a }
            int r0 = r0 + 1
            r3.zzl = r0     // Catch:{ all -> 0x005a }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzcpp>> r0 = r3.zzg     // Catch:{ all -> 0x005a }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x005a }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x005a }
            r4.add(r5)     // Catch:{ all -> 0x005a }
            monitor-exit(r3)
            return
        L_0x0058:
            monitor-exit(r3)
            return
        L_0x005a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpz.zzg(java.lang.String, com.google.android.gms.internal.ads.zzcpp):void");
    }

    public final synchronized void zzh(zzabx zzabx) {
        if (!this.zzk) {
            try {
                zzabx.zze(zzdsb.zzd(17, (String) null, (zzym) null));
            } catch (RemoteException unused) {
                zzbbk.zzi("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
            }
        } else {
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue()) {
                try {
                    zzabx.zze(zzdsb.zzd(1, (String) null, (zzym) null));
                } catch (RemoteException unused2) {
                    zzbbk.zzi("Ad inspector had an internal error.");
                }
            } else {
                this.zza.zzg(zzabx, new zzakq(this));
            }
        }
    }

    public final JSONObject zzi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "ANDROID");
            jSONObject.put("internalSdkVersion", this.zzf);
            jSONObject.put("adapters", this.zzd.zzb());
            if (this.zzi < zzs.zzj().currentThreadTimeMillis() / 1000) {
                this.zzh = "{}";
            }
            jSONObject.put("networkExtras", this.zzh);
            jSONObject.put("adSlots", zzl());
            jSONObject.put("appInfo", this.zze.zza());
            jSONObject.put("cld", new JSONObject(zzs.zzg().zzl().zzn().zzd()));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
