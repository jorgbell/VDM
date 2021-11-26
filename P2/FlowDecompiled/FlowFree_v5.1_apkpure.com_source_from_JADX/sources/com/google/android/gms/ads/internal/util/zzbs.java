package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbs implements Callable<String> {
    final /* synthetic */ Context zza;

    zzbs(zzbu zzbu, Context context) {
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences = this.zza.getSharedPreferences("admob_user_agent", 0);
        String string = sharedPreferences.getString("user_agent", "");
        if (!TextUtils.isEmpty(string)) {
            zze.zza("User agent is already initialized on Google Play Services.");
            return string;
        }
        zze.zza("User agent is not initialized on Google Play Services. Initializing.");
        SharedPreferencesUtils.publishWorldReadableSharedPreferences(this.zza, sharedPreferences.edit().putString("user_agent", WebSettings.getDefaultUserAgent(this.zza)), "admob_user_agent");
        throw null;
    }
}
