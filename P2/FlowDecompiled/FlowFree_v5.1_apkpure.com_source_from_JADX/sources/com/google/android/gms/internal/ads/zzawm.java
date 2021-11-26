package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzawm extends zzawn {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzaou<JSONObject, JSONObject> zzd;

    public zzawm(Context context, zzaou<JSONObject, JSONObject> zzaou) {
        this.zzb = context.getApplicationContext();
        this.zzd = zzaou;
    }

    public static JSONObject zzb(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbbq.zza().zza);
            jSONObject.put("mf", zzagd.zza.zze());
            jSONObject.put("cl", "367272508");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final zzefw<Void> zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzs.zzj().currentTimeMillis() - this.zzc.getLong("js_last_update", 0) < zzagd.zzb.zze().longValue()) {
            return zzefo.zza(null);
        }
        return zzefo.zzi(this.zzd.zzb(zzb(this.zzb)), new zzawl(this), zzbbw.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzc(JSONObject jSONObject) {
        zzaeq.zzb(this.zzb, 1, jSONObject);
        this.zzc.edit().putLong("js_last_update", zzs.zzj().currentTimeMillis()).apply();
        return null;
    }
}
