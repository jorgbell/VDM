package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzmx implements zzmw {
    public static final zzfh<Boolean> zza;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zza = zzff.zzb("measurement.validation.internal_limits_internal_event_params", false);
        zzff.zza("measurement.id.validation.internal_limits_internal_event_params", 0);
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }
}
