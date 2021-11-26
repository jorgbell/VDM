package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzlt implements zzls {
    public static final zzfh<Boolean> zzb;
    public static final zzfh<Boolean> zzc;
    public static final zzfh<Boolean> zzd;

    static {
        zzff zzff = new zzff(zzey.zza("com.google.android.gms.measurement"));
        zzff.zzb("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzff.zzb("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzff.zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzff.zzb("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zzb.zze().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zze().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zze().booleanValue();
    }
}
