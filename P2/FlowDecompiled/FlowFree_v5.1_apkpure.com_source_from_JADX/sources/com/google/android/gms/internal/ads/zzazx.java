package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzazx implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzazz zza;
    private final String zzb;

    public zzazx(zzazz zzazz, String str) {
        this.zza = zzazz;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzazy zza2 : this.zza.zzb) {
                zza2.zza(sharedPreferences, this.zzb, str);
            }
        }
    }
}
