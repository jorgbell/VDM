package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzaei<T> {
    private final int zza;
    private final String zzb;
    private final T zzc;

    /* synthetic */ zzaei(int i, String str, Object obj, zzaed zzaed) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        zzaaa.zzb().zza(this);
    }

    public static zzaei<Boolean> zzg(int i, String str, Boolean bool) {
        return new zzaed(i, str, bool);
    }

    public static zzaei<Integer> zzh(int i, String str, int i2) {
        return new zzaee(1, str, Integer.valueOf(i2));
    }

    public static zzaei<Long> zzi(int i, String str, long j) {
        return new zzaef(1, str, Long.valueOf(j));
    }

    public static zzaei<Float> zzj(int i, String str, float f) {
        return new zzaeg(1, str, Float.valueOf(f));
    }

    public static zzaei<String> zzk(int i, String str, String str2) {
        return new zzaeh(1, str, str2);
    }

    public static zzaei<String> zzl(int i, String str) {
        zzaei<String> zzk = zzk(1, "gads:sdk_core_constants:experiment_id", (String) null);
        zzaaa.zzb().zzb(zzk);
        return zzk;
    }

    public abstract T zza(Bundle bundle);

    public abstract void zzb(SharedPreferences.Editor editor, T t);

    /* access modifiers changed from: protected */
    public abstract T zzc(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract T zzd(SharedPreferences sharedPreferences);

    public final String zze() {
        return this.zzb;
    }

    public final T zzf() {
        return this.zzc;
    }

    public final int zzm() {
        return this.zza;
    }
}
