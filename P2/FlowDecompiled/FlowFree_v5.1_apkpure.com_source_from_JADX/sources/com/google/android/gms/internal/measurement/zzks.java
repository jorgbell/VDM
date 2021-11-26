package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzks implements zzkr {
    public static final zzfh<Boolean> zza;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zzb("measurement.androidId.delete_feature", true);
        zzff.zzb("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }
}
