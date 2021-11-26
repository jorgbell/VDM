package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzkv implements zzku {
    public static final zzfh<Boolean> zza;
    public static final zzfh<Boolean> zzb;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zzb("measurement.frontend.directly_maybe_log_error_events", false);
        zzb = zzff.zzb("measurement.upload.directly_maybe_log_error_events", true);
        zzff.zza("measurement.id.frontend.directly_maybe_log_error_events", 0);
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zze().booleanValue();
    }
}
