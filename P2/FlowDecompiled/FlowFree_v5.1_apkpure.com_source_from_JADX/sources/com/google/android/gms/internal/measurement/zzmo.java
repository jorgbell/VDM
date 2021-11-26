package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzmo implements zzmn {
    public static final zzfh<Boolean> zzb;
    public static final zzfh<Boolean> zzd;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zzff.zza("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zzff.zzb("measurement.lifecycle.app_backgrounded_engagement", false);
        zzff.zzb("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzff.zzb("measurement.lifecycle.app_in_background_parameter", false);
        zzff.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean zza() {
        return zzb.zze().booleanValue();
    }

    public final boolean zzb() {
        return zzd.zze().booleanValue();
    }
}
