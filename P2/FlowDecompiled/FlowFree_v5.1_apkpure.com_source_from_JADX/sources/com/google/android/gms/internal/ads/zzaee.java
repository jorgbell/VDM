package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzaee extends zzaei<Integer> {
    zzaee(int i, String str, Integer num) {
        super(1, str, num, (zzaed) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        String zze = zze();
        if (!bundle.containsKey(zze.length() != 0 ? "com.google.android.gms.ads.flag.".concat(zze) : new String("com.google.android.gms.ads.flag."))) {
            return (Integer) zzf();
        }
        String zze2 = zze();
        return Integer.valueOf(bundle.getInt(zze2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(zze2) : new String("com.google.android.gms.ads.flag.")));
    }

    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putInt(zze(), ((Integer) obj).intValue());
    }

    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(zze(), ((Integer) zzf()).intValue()));
    }

    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(zze(), ((Integer) zzf()).intValue()));
    }
}
