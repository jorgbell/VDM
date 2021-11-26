package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzafx;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzsh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzj implements zzg {
    private final Object zza = new Object();
    private boolean zzb;
    private final List<Runnable> zzc = new ArrayList();
    private zzefw<?> zzd;
    @GuardedBy("lock")
    private zzsh zze = null;
    @GuardedBy("lock")
    private SharedPreferences zzf;
    @GuardedBy("lock")
    private SharedPreferences.Editor zzg;
    @GuardedBy("lock")
    private boolean zzh = true;
    @GuardedBy("lock")
    private String zzi;
    @GuardedBy("lock")
    private String zzj;
    @GuardedBy("lock")
    private boolean zzk = true;
    @GuardedBy("lock")
    private zzbar zzl = new zzbar("", 0);
    @GuardedBy("lock")
    private long zzm = 0;
    @GuardedBy("lock")
    private long zzn = 0;
    @GuardedBy("lock")
    private int zzo = -1;
    @GuardedBy("lock")
    private int zzp = 0;
    @GuardedBy("lock")
    private Set<String> zzq = Collections.emptySet();
    @GuardedBy("lock")
    private JSONObject zzr = new JSONObject();
    @GuardedBy("lock")
    private boolean zzs = true;
    @GuardedBy("lock")
    private boolean zzt = true;
    @GuardedBy("lock")
    private String zzu = null;
    @GuardedBy("lock")
    private String zzv = "";
    @GuardedBy("lock")
    private int zzw = -1;
    @GuardedBy("lock")
    private int zzx = -1;
    @GuardedBy("lock")
    private long zzy = 0;

    private final void zzI() {
        zzefw<?> zzefw = this.zzd;
        if (zzefw != null && !zzefw.isDone()) {
            try {
                this.zzd.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzbbk.zzj("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzbbk.zzg("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final void zzJ() {
        zzbbw.zza.execute(new zzi(this));
    }

    public final void zzA(boolean z) {
        zzI();
        synchronized (this.zza) {
            if (z != this.zzk) {
                this.zzk = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final boolean zzB() {
        boolean z;
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzao)).booleanValue()) {
            return false;
        }
        zzI();
        synchronized (this.zza) {
            z = this.zzk;
        }
        return z;
    }

    public final void zzC(int i) {
        zzI();
        synchronized (this.zza) {
            if (this.zzx != i) {
                this.zzx = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final long zzD() {
        long j;
        zzI();
        synchronized (this.zza) {
            j = this.zzy;
        }
        return j;
    }

    public final void zzE(long j) {
        zzI();
        synchronized (this.zza) {
            if (this.zzy != j) {
                this.zzy = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final String zzF() {
        String str;
        zzI();
        synchronized (this.zza) {
            str = this.zzv;
        }
        return str;
    }

    public final void zzG(String str) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue()) {
            zzI();
            synchronized (this.zza) {
                if (!this.zzv.equals(str)) {
                    this.zzv = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_info", str);
                        this.zzg.apply();
                    }
                    zzJ();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppLovinMediationProvider.ADMOB, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.zza) {
            this.zzf = sharedPreferences;
            this.zzg = edit;
            if (PlatformVersion.isAtLeastM()) {
                NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            this.zzh = this.zzf.getBoolean("use_https", this.zzh);
            this.zzs = this.zzf.getBoolean("content_url_opted_out", this.zzs);
            this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
            this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
            this.zzt = this.zzf.getBoolean("content_vertical_opted_out", this.zzt);
            this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
            this.zzp = this.zzf.getInt("version_code", this.zzp);
            this.zzl = new zzbar(this.zzf.getString("app_settings_json", this.zzl.zzd()), this.zzf.getLong("app_settings_last_update_ms", this.zzl.zzb()));
            this.zzm = this.zzf.getLong("app_last_background_time_ms", this.zzm);
            this.zzo = this.zzf.getInt("request_in_session_count", this.zzo);
            this.zzn = this.zzf.getLong("first_ad_req_time_ms", this.zzn);
            this.zzq = this.zzf.getStringSet("never_pool_slots", this.zzq);
            this.zzu = this.zzf.getString("display_cutout", this.zzu);
            this.zzw = this.zzf.getInt("app_measurement_npa", this.zzw);
            this.zzx = this.zzf.getInt("sd_app_measure_npa", this.zzx);
            this.zzy = this.zzf.getLong("sd_app_measure_npa_ts", this.zzy);
            this.zzv = this.zzf.getString("inspector_info", this.zzv);
            try {
                this.zzr = new JSONObject(this.zzf.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzbbk.zzj("Could not convert native advanced settings to json object", e);
            }
            zzJ();
        }
    }

    public final void zza(Context context) {
        synchronized (this.zza) {
            if (this.zzf == null) {
                this.zzd = zzbbw.zza.zza(new zzh(this, context, AppLovinMediationProvider.ADMOB));
                this.zzb = true;
            }
        }
    }

    public final zzsh zzb() {
        if (!this.zzb) {
            return null;
        }
        if ((zzd() && zzh()) || !zzafx.zzb.zze().booleanValue()) {
            return null;
        }
        synchronized (this.zza) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zze == null) {
                this.zze = new zzsh();
            }
            this.zze.zza();
            zzbbk.zzh("start fetching content...");
            zzsh zzsh = this.zze;
            return zzsh;
        }
    }

    public final void zzc(boolean z) {
        zzI();
        synchronized (this.zza) {
            if (this.zzs != z) {
                this.zzs = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final boolean zzd() {
        boolean z;
        zzI();
        synchronized (this.zza) {
            z = this.zzs;
        }
        return z;
    }

    public final void zze(String str) {
        zzI();
        synchronized (this.zza) {
            if (!str.equals(this.zzi)) {
                this.zzi = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_url_hashes", str);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final String zzf() {
        String str;
        zzI();
        synchronized (this.zza) {
            str = this.zzi;
        }
        return str;
    }

    public final void zzg(boolean z) {
        zzI();
        synchronized (this.zza) {
            if (this.zzt != z) {
                this.zzt = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final boolean zzh() {
        boolean z;
        zzI();
        synchronized (this.zza) {
            z = this.zzt;
        }
        return z;
    }

    public final void zzi(String str) {
        zzI();
        synchronized (this.zza) {
            if (!str.equals(this.zzj)) {
                this.zzj = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_vertical_hashes", str);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final String zzj() {
        String str;
        zzI();
        synchronized (this.zza) {
            str = this.zzj;
        }
        return str;
    }

    public final void zzk(int i) {
        zzI();
        synchronized (this.zza) {
            if (this.zzp != i) {
                this.zzp = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("version_code", i);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final int zzl() {
        int i;
        zzI();
        synchronized (this.zza) {
            i = this.zzp;
        }
        return i;
    }

    public final void zzm(String str) {
        zzI();
        synchronized (this.zza) {
            long currentTimeMillis = zzs.zzj().currentTimeMillis();
            if (str != null) {
                if (!str.equals(this.zzl.zzd())) {
                    this.zzl = new zzbar(str, currentTimeMillis);
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.zzg.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzg.apply();
                    }
                    zzJ();
                    for (Runnable run : this.zzc) {
                        run.run();
                    }
                    return;
                }
            }
            this.zzl.zza(currentTimeMillis);
        }
    }

    public final zzbar zzn() {
        zzbar zzbar;
        zzI();
        synchronized (this.zza) {
            zzbar = this.zzl;
        }
        return zzbar;
    }

    public final void zzo(Runnable runnable) {
        this.zzc.add(runnable);
    }

    public final void zzp(long j) {
        zzI();
        synchronized (this.zza) {
            if (this.zzm != j) {
                this.zzm = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final long zzq() {
        long j;
        zzI();
        synchronized (this.zza) {
            j = this.zzm;
        }
        return j;
    }

    public final void zzr(int i) {
        zzI();
        synchronized (this.zza) {
            if (this.zzo != i) {
                this.zzo = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final int zzs() {
        int i;
        zzI();
        synchronized (this.zza) {
            i = this.zzo;
        }
        return i;
    }

    public final void zzt(long j) {
        zzI();
        synchronized (this.zza) {
            if (this.zzn != j) {
                this.zzn = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }

    public final long zzu() {
        long j;
        zzI();
        synchronized (this.zza) {
            j = this.zzn;
        }
        return j;
    }

    public final void zzv(String str, String str2, boolean z) {
        zzI();
        synchronized (this.zza) {
            JSONArray optJSONArray = this.zzr.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (str2.equals(optJSONObject.optString("template_id"))) {
                            if (z) {
                                if (optJSONObject.optBoolean("uses_media_view", false)) {
                                    return;
                                }
                            }
                            length = i;
                        } else {
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzs.zzj().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzr.put(str, optJSONArray);
            } catch (JSONException e) {
                zzbbk.zzj("Could not update native advanced settings", e);
            }
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.zzr.toString());
                this.zzg.apply();
            }
            zzJ();
        }
    }

    public final JSONObject zzw() {
        JSONObject jSONObject;
        zzI();
        synchronized (this.zza) {
            jSONObject = this.zzr;
        }
        return jSONObject;
    }

    public final void zzx() {
        zzI();
        synchronized (this.zza) {
            this.zzr = new JSONObject();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.zzg.apply();
            }
            zzJ();
        }
    }

    public final String zzy() {
        String str;
        zzI();
        synchronized (this.zza) {
            str = this.zzu;
        }
        return str;
    }

    public final void zzz(String str) {
        zzI();
        synchronized (this.zza) {
            if (!TextUtils.equals(this.zzu, str)) {
                this.zzu = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzg.apply();
                }
                zzJ();
            }
        }
    }
}
