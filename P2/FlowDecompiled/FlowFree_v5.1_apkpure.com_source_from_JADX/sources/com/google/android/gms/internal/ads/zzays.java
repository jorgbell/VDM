package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzays implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final zzg zzc;
    private final zzazt zzd;
    private String zze = "";

    zzays(Context context, zzg zzg, zzazt zzazt) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzg;
        this.zza = context;
        this.zzd = zzazt;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Context context;
        if ("IABTCF_PurposeConsents".equals(str)) {
            String string = sharedPreferences.getString("IABTCF_PurposeConsents", "");
            if (!string.isEmpty() && !this.zze.equals(string)) {
                this.zze = string;
                boolean z = false;
                if (string.charAt(0) != '1') {
                    z = true;
                }
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzao)).booleanValue()) {
                    this.zzc.zzA(z);
                    if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue() && z && (context = this.zza) != null) {
                        context.deleteDatabase("OfflineUpload.db");
                    }
                }
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaj)).booleanValue()) {
                    this.zzd.zza();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
    }
}
