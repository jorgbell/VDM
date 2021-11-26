package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdgg implements zzdiz<zzdgf> {
    private final Context zza;
    private final zzefx zzb;

    zzdgg(Context context, zzefx zzefx) {
        this.zza = context;
        this.zzb = zzefx;
    }

    public final zzefw<zzdgf> zza() {
        return this.zzb.zzb(new zzdgd(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdgf zzb() throws Exception {
        String str;
        Bundle bundle;
        zzs.zzc();
        Context context = this.zza;
        String str2 = "";
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzeh)).booleanValue()) {
            str = str2;
        } else {
            str = context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", str2);
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzej)).booleanValue()) {
            str2 = this.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str2);
        }
        zzs.zzc();
        Context context2 = this.zza;
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzei)).booleanValue()) {
            bundle = null;
        } else {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str3 = strArr[i];
                if (defaultSharedPreferences.contains(str3)) {
                    bundle.putString(str3, defaultSharedPreferences.getString(str3, (String) null));
                }
            }
        }
        return new zzdgf(str, str2, bundle, (zzdge) null);
    }
}
